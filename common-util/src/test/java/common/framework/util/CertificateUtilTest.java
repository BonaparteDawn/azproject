package common.framework.util;

import common.framework.bean.AZ_MyCertificateInfo;
import common.framework.bean.AZ_MyX500Name;
import constant.AZ_Constant;
import org.junit.Test;
import sun.security.x509.CertAndKeyGen;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Fuzhong.Yan on 17/2/8.
 */
public class CertificateUtilTest {
    @Test
    public void main() throws Exception {
        String tempBase ="certificate";
        String rootPfxPath = FileUtil.path(AZ_Constant.TEST_BASE_PATH_OUT,tempBase,"ROOTCA.pfx");
        String rootCrtPath = FileUtil.path(AZ_Constant.TEST_BASE_PATH_OUT,tempBase,"ROOTCA.crt");
        String subjectPfxPath = FileUtil.path(AZ_Constant.TEST_BASE_PATH_OUT,tempBase,"ISSUE.pfx");
        String subjectCrtPath = FileUtil.path(AZ_Constant.TEST_BASE_PATH_OUT,tempBase,"ISSUE.crt");
        AZ_MyX500Name rootX500Name = new AZ_MyX500Name("CN=RootCA,OU=ISI,O=BenZeph,L=CD,ST=SC,C=CN");
        AZ_MyX500Name subjectX500Name = new AZ_MyX500Name("CN=subject,OU=ISI,O=BenZeph,L=CD,ST=SC,C=CN");
        String rootAlias = "RootCA";
        String subjectAlias = "subject";
        String rootPassword = "12345abc";
        String subjectPassword = "1234567";
        try {
            //生成根文件========================================================================
            AZ_MyCertificateInfo rootCertificateInfo = new AZ_MyCertificateInfo();
            rootCertificateInfo.setSubjectAlias(rootAlias);
            rootCertificateInfo.setSubjectName(rootX500Name);
            CertificateUtil.createX509RootCertFile(rootCertificateInfo,rootPfxPath,rootPassword,rootCrtPath);
            //读取根文件========================================================================
            //--------读取pfx根文件里面的私钥
            PrivateKey rootPrivateKey = (PrivateKey) CertificateUtil.readKeyStore(rootAlias, rootPfxPath, rootPassword).getKey(rootAlias, rootPassword.toCharArray());
            //--------读取根文件crt证书
            X509Certificate rooX509Certificate = (X509Certificate) CertificateUtil.readCertificate(rootCrtPath,null);
            //发证书========================================================================
            CertAndKeyGen certAndKeyGen = CertificateUtil.newCertAndKeyGen(null, null);
            AZ_MyCertificateInfo certificateInfo = new AZ_MyCertificateInfo();
            Date date = TimeUtil.currentTime();
            certificateInfo.setStartTime(date);
            certificateInfo.setEndTime(TimeUtil.addYear(date,30));
            certificateInfo.setSubjectAlias(subjectAlias);
            certificateInfo.setIssuerName(rootX500Name);
            certificateInfo.setSubjectName(subjectX500Name);
            certificateInfo.setSubjectPublicKey(certAndKeyGen.getPublicKey());
            certificateInfo.setSubjectPrivateKey(certAndKeyGen.getPrivateKey());
            certificateInfo.setIssuerPrivateKey(rootPrivateKey);
            CertificateUtil.createX509SubjectCertFile(certificateInfo,new X509Certificate[]{rooX509Certificate},subjectPfxPath,subjectPassword,subjectCrtPath);
            //验证证书链========================================================================
            List<X509Certificate> list = new ArrayList<X509Certificate>();
            list.add((X509Certificate) CertificateUtil.readCertificate(rootCrtPath,null));
            list.add((X509Certificate) CertificateUtil.readCertificate(subjectCrtPath,null));
            System.out.println(CertificateUtil.verifyCertificateChain((X509Certificate) CertificateUtil.readCertificate(rootCrtPath,null), list, null, subjectX500Name));
            //========================================================================
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}