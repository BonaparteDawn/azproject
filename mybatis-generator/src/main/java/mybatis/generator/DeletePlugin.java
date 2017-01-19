package mybatis.generator;

import common.framework.util.EnvironmentUtil;
import common.framework.util.FileUtil;
import common.framework.util.ListUtils;
import common.framework.util.ObjectUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.Assert;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fuzhong.Yan on 17/1/19.
 */
public class DeletePlugin {
    private static String GENERATOR_CONFIG_FILE_PATH = "generatorConfig.xml";
    private static Element ROOT = null;
    static {
        SAXReader reader = new SAXReader();
        try {
            InputStream inputStream = FileUtil.readClasspath(GENERATOR_CONFIG_FILE_PATH);
            Document document = reader.read(inputStream);
            Assert.notNull(document,"document_null");
            ROOT = document.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public DeletePlugin(){
    }
    public static void main(String[] args) {
        List<String> paths = findNeedDeletePathPath(findContextElements());
    }
    public static void clearPath(List<String > paths){
        Assert.notEmpty(paths,"paths_null");
        for (String path:paths){
            FileUtil.clearFiles(path);
        }
    }
    public static List<String> findNeedDeletePathPath(List<Element> elements){
        List<String> res = new ArrayList<String>();
        Assert.notEmpty(elements,"elements_empty");
        for (Element element :elements){
            List<Element> p = element.elements();
            if (ListUtils.isNotEmpty(p)){
                for (Element e : p){
                    Attribute targetProject = e.attribute("targetProject");
                    Attribute targetPackage = e.attribute("targetPackage");
                    if (ObjectUtils.isNotEmpty(targetProject,targetPackage)){
                        String targetProject_v = targetProject.getValue();
                        String targetPackage_v = targetPackage.getValue();
                        if (ObjectUtils.isNotEmpty(targetProject_v,targetPackage_v)){
                            String relativePath = targetProject.getValue().replace("..","")+"/"+targetPackage_v;
                            File file = new File(EnvironmentUtil.getUserDir()+relativePath);
                            if (file.exists()){
                                res.add(EnvironmentUtil.getUserDir()+relativePath);
                            }else {
                                throw new RuntimeException("待查找的文件不存在"+file.getAbsolutePath());
                            }
                        }

                    }
                }
            }
        }
        return res;
    }
    public static List<Element> findContextElements(){
        Assert.notNull(ROOT,"ROOT_NULL");
        List<Element> els = ROOT.elements();
        List<Element> res = new ArrayList<Element>();
        for (Element temp : els){
            if (temp.getName().equals("context")){
                res.add(temp);
            }
        }
        return res;
    }
}
