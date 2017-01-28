package common.framework.service;

import common.framework.bean.regex.AZ_RegexBean;
import org.springframework.util.Assert;

/**
 * 正则表达式基本元素工厂
 * @author Fuzhong.Yan
 */
public class AZ_RegexFactory {
    /**任意*/
    public static final AZ_RegexBean ANY =new AZ_RegexBean(".");
    /**数字;[0-9]*/
    public static final AZ_RegexBean NUMBER =new AZ_RegexBean("\\d");
    /**数字除外;[^0-9]*/
    public static final AZ_RegexBean NUMBER_EXCLUDE =new AZ_RegexBean("\\D");
    /**空白字符;[\t\n\xOB\f\r]*/
    public static final AZ_RegexBean SPACE =new AZ_RegexBean("\\s");
    /**空白除外*/
    public static final AZ_RegexBean SPACE_EXCLUDE =new AZ_RegexBean("\\S");
    /**中文字符*/
    public static final AZ_RegexBean CHINESE = new AZ_RegexBean("[\u4e00-\u9fa5]");
    /**字符;[a-zA-Z0-9]*/
    public static final AZ_RegexBean CHAR = new AZ_RegexBean("\\w");
    /**字符除外*/
    public static final AZ_RegexBean CHAR_EXCLUDE = new AZ_RegexBean("\\W");
    /**小写字母;[a-z]*/
    public static final AZ_RegexBean LOWERCASE = new AZ_RegexBean("[a-z]");
    /**大写字母;[A-Z]*/
    public static final AZ_RegexBean UPPERCASE = new AZ_RegexBean("[A-Z]");
    /**换行符*/
    public static final AZ_RegexBean LINEBREAK= new AZ_RegexBean("\\n");
    /**字边界*/
    public static final AZ_RegexBean WORDBOUNDARY= new AZ_RegexBean("\\b");
    /**非字边界*/
    public static final AZ_RegexBean WORDBOUNDARY_EXCLUDE= new AZ_RegexBean("\\B");
    /**自定义正则表达式元素Bean*/
    public static final AZ_RegexBean selfdefine(String regex){
        Assert.notNull(regex, "regex_null");
        return new AZ_RegexBean(regex);
    }
}