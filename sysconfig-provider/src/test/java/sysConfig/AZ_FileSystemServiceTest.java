package sysConfig;

import common.framework.exception.AZ_BusinessException;
import common.framework.util.IOUtils;
import common.framework.util.JsonUtil;
import common.framework.util.ListUtils;
import constant.AZ_Constant;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import vo.AZ_File;
import vo.AZ_FileBytes;
import vo.AZ_FileIn;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fuzhong.Yan on 16/12/22.
 */
public class AZ_FileSystemServiceTest {
    private AZ_FileSystemApi azFileSystemApi;
    @Before
    public void setUp() throws Exception {
        ClassPathXmlApplicationContext act = new ClassPathXmlApplicationContext("classpath:META-INF/spring/spring.xml");
        String[] a = act.getBeanDefinitionNames();
        azFileSystemApi = (AZ_FileSystemApi) act.getBean("AZ_FileSystemService");
    }

    @Test
    public void writeFileOut() throws Exception {
        java.io.File file = new java.io.File("/Users/Fuzhong.Yan/Downloads/2233");
        FileOutputStream outputStream = new FileOutputStream(file);
        azFileSystemApi.writeFileOut(128,outputStream);
        outputStream.close();
    }

    @Test
    public void getFileBytes() throws Exception {
        List<AZ_FileBytes> res = azFileSystemApi.getFileBytes("123", (short) 1);
        System.out.println(res.size());
    }

    @Test
    public void getFileByID() throws Exception {
        AZ_File a = azFileSystemApi.getFileByID(128);
        System.out.println(JsonUtil.toJson(a));
    }

    @Test
    public void getFileByBusinessIDAndType() throws Exception {
        List<AZ_File> t = azFileSystemApi.getFile("123", (short) 1);
        if (ListUtils.isNotEmpty(t)){
            for (AZ_File temp : t){
                System.out.println(JsonUtil.toJson(temp));
            }
        }
    }

    @Test
    public void uploadFileIn() throws Exception {
        azFileSystemApi.deleteFile("123", (short) 1);
        java.io.File file = new java.io.File("/Users/Fuzhong.Yan/Downloads/metronic4.5.6.rar");
        FileInputStream i = new FileInputStream(file);
        List<AZ_FileIn> files = new ArrayList<AZ_FileIn>();
        AZ_FileIn vo = new AZ_FileIn();
        vo.setInputStream(i);
        vo.setBusinessID("123");
        vo.setBusinessType((short) 1);
        vo.setFileOriginalName(file.getName());
        vo.setFileType("mp4");
        files.add(vo);
        List<AZ_File> r = azFileSystemApi.uploadFileIn(files);
        i.close();
        if (ListUtils.isNotEmpty(r)){
            for (AZ_File t : r){
                OutputStream out = new FileOutputStream(new java.io.File("/Users/Fuzhong.Yan/Downloads/223"));
                azFileSystemApi.writeFileOut(t.getId(),out);
                out.close();
                }
            }
    }

    @Test
    public void uploadFileBytes() throws Exception {
        java.io.File file = new java.io.File("/Users/Fuzhong.Yan/Downloads/components-ion-sliders.min.js");
        FileInputStream i = new FileInputStream(file);
        AZ_FileBytes vo = new AZ_FileBytes();
        byte[] bytes = IOUtils.copy2Bytes(i,0,1024*1024*5,true);
        vo.setBytes(bytes);
        vo.setBusinessID("123");
        vo.setBusinessType((short) 1);
        vo.setFileOriginalName(file.getName());
        vo.setFileType("mp4");
        azFileSystemApi.uploadFileBytes(vo);
        OutputStream out = new FileOutputStream(new java.io.File("/Users/Fuzhong.Yan/Downloads/123"));
        azFileSystemApi.writeFileOut(vo.getId(),out);
        out.close();
    }

    @Test
    public void uploadFile() throws Exception {
        AZ_FileIn file = new AZ_FileIn();
        file.setBusinessID("123");
        file.setBusinessType((short) 1);
        file.setFileOriginalName(file.getName());
        file.setFileType("mp4");
        java.io.File file_1 = new java.io.File("/Users/Fuzhong.Yan/Downloads/metronic4.5.6.rar");
        file.setInputStream(new FileInputStream(file_1));
        azFileSystemApi.uploadFile(file);
        OutputStream out = new FileOutputStream(new java.io.File("/Users/Fuzhong.Yan/Downloads/234.rar"));
        azFileSystemApi.writeFileOut(file.getId(),out);
        out.close();

    }
    @Test
    public void copy() throws IOException, AZ_BusinessException {
        OutputStream out = new FileOutputStream(new java.io.File("/Users/Fuzhong.Yan/Downloads/223"));
        byte[] bytes= null;
        long skip = 0;
        while ((bytes = azFileSystemApi.copy2Bytes(112,skip,AZ_Constant.FILE_BLOCK_UNIT_M))!=null){
            IOUtils.write2outputStream(bytes,out);
            skip+=bytes.length;
        }
        out.close();
    }
    @Test
    public void uploadFilesBytes() throws Exception {
        java.io.File file = new java.io.File("/Users/Fuzhong.Yan/Downloads/components-ion-sliders.min.js");
        FileInputStream i = new FileInputStream(file);
        List<AZ_FileBytes> files = new ArrayList<AZ_FileBytes>();
        AZ_FileBytes vo = new AZ_FileBytes();
        byte[] bytes = IOUtils.copy2Bytes(i,0,1024*1024,true);
        vo.setBytes(bytes);
        vo.setBusinessID("123");
        vo.setBusinessType((short) 1);
        vo.setFileOriginalName(file.getName());
        vo.setFileType("mp4");
        files.add(vo);
        List<AZ_File> r = azFileSystemApi.uploadFileBytes(files);
        if (ListUtils.isNotEmpty(r)){
            for (AZ_File t : r){
                OutputStream outputStream = new FileOutputStream(new java.io.File("/Users/Fuzhong.Yan/Downloads/123.txt"));
                azFileSystemApi.writeFileOut(t.getId(),outputStream);
                outputStream.close();
            }
        }
    }

    @Test
    public void deleteFile() throws Exception {
        azFileSystemApi.deleteFile("123", (short) 1);
    }

    @Test
    public void add() throws Exception {
        azFileSystemApi.add(null);
    }

    @Test
    public void getFilePathPrefix() throws Exception {
    }

}