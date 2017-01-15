package mybatis.generator;

import org.mybatis.generator.api.*;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;
import org.mybatis.generator.codegen.mybatis3.javamapper.JavaMapperGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.AbstractJavaMapperMethodGenerator;
import org.mybatis.generator.codegen.mybatis3.javamapper.elements.SelectByPrimaryKeyMethodGenerator;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Fuzhong.Yan on 16/12/4.
 */
public class BaseMapperGeneratorPlugin extends PluginAdapter {
    public boolean validate(List<String> list) {
        return  true;
    }


}
