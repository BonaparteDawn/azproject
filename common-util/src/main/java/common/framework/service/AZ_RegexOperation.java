package common.framework.service;

import common.framework.abstracted.AZ_AbstrucRegexSize;
import common.framework.bean.regex.AZ_RegexBean;
import org.springframework.util.Assert;

/**
 * 正则表达式关系操作
 * @author Fuzhong.Yan
 *
 */
public class AZ_RegexOperation extends AZ_AbstrucRegexSize {

    private String tempRegex = "";
    public AZ_RegexOperation() {
    }
    public AZ_RegexOperation(String regex) {
        this.tempRegex = regex;
    }
    /**
     * 以指定的正则表达式开头
     * @param regex
     * @return
     */
    public AZ_RegexOperation startWith(String regex){
        Assert.hasLength(regex, "regex_LEN0");
        String temp = "^"+regex+tempRegex;
        return new AZ_RegexOperation(temp);
    }
    /**
     * 以指定的正则表达式开头
     * @param regex
     * @return
     */
    public AZ_RegexOperation startWith(AZ_RegexBean regex){
        Assert.notNull(regex,"regex_null");
        return startWith(regex.getRegex());
    }

    /**
     * 以指定的正则表达式结束
     * @param regex
     * @return
     */
    public AZ_RegexOperation endWith(String regex){
        Assert.hasLength(regex, "regex_LEN0");
        String temp = tempRegex+regex+"$";
        return new AZ_RegexOperation(temp);
    }
    /**
     * 以指定的正则表达式结束
     * @param regex
     * @return
     */
    public AZ_RegexOperation endWith(AZ_RegexBean regex){
        Assert.notNull(regex,"regex_null");
        return endWith(regex.getRegex());
    }
    /**
     * 与正则表达式取或
     * @param regex
     * @return
     */
    public AZ_RegexOperation or(String regex){
        Assert.hasLength(regex, "regex_LEN0");
        String temp = null;
        if (!"".equals(tempRegex)) {
            temp = "("+tempRegex+")|("+regex+")";
        }else {
            temp = "("+regex+")";
        }
        return new AZ_RegexOperation(temp);
    }
    /**
     * 与正则表达式取或
     * @param regex
     * @return
     */
    public AZ_RegexOperation or(AZ_RegexBean regex){
        Assert.notNull(regex,"regex_null");
        return or(regex.getRegex());
    }
    /**
     * 追加正则表达式，传入的参数取或关系
     * @param regexs
     * @return
     */
    public AZ_RegexOperation appendOr(String ...regexs){
        Assert.noNullElements(regexs,"regexs_null");
        String temp = "";
        for (String regex : regexs) {
            if (!"".equals(temp)) {
                temp = "("+temp+")"+"|"+"("+regex+")";
            }else {
                temp = "("+regex+")";
            }
        }
        if (!"".equals(tempRegex)) {
            temp = this.tempRegex + "("+temp+")";
        }
        return new AZ_RegexOperation("("+temp+")");
    }
    /**
     * 追加正则表达式，传入的参数取或关系
     * @param regexs
     * @return
     */
    public AZ_RegexOperation appendOr(AZ_RegexBean... regexs){
        Assert.notNull(regexs,"regex_null");
        String[] temp = new String[regexs.length];
        for (int i = 0 ; i < regexs.length ; i++) {
            temp[i] = regexs[i].getRegex();
        }
        return appendOr(temp);
    }
    /**
     * 或后者任意一个字符
     * @param chars
     * @return
     */
    public AZ_RegexOperation orAnyChar(String chars){
        Assert.hasLength(chars, "chars_LEN0");
        String temp = null;
        if (!"".equals(tempRegex)) {
            temp = "("+tempRegex+")|(["+chars+"])";
        }else {
            temp = "(["+chars+"])";
        }
        return new AZ_RegexOperation(temp);
    }
    /**
     * 或后者任意一个字符
     * @param regex
     * @return
     */
    public AZ_RegexOperation orAnyChar(AZ_RegexBean regex){
        Assert.notNull(regex,"regex_null");
        return orAnyChar(regex.getRegex());
    }
    /**
     * 紧跟一个正则表达式
     * @param regex
     * @return
     */
    public AZ_RegexOperation append(String regex){
        Assert.hasLength(regex, "regex_LEN0");
        String temp = null;
        if (!"".equals(tempRegex)) {
            temp = tempRegex+""+regex;
        }else {
            temp = regex;
        }
        return new AZ_RegexOperation(temp);
    }
    /**
     * 紧跟一个正则表达式
     * @param regex
     * @return
     */
    public AZ_RegexOperation append(AZ_RegexBean regex){
        Assert.notNull(regex,"regex_null");
        return append(regex.getRegex());
    }
    /**
     * 紧跟后者任意一个字符
     * @param chars
     * @return
     */
    public AZ_RegexOperation appendAnyChar(String chars){
        Assert.hasLength(chars, "chars_LEN0");
        String temp = null;
        if (!"".equals(tempRegex)) {
            temp = tempRegex+"["+chars+"]";
        }else {
            temp = "["+chars+"]";
        }
        return new AZ_RegexOperation(temp);
    }
    /**
     * 紧跟后者任意一个字符
     * @param regex
     * @return
     */
    public AZ_RegexOperation appendAnyChar(AZ_RegexBean regex){
        Assert.notNull(regex,"regex_null");
        return appendAnyChar(regex.getRegex());
    }
    /**
     * 追加且不包括指定字符串中的任意一个字符
     * @param chars
     * @return
     */
    public AZ_RegexOperation appendExceptAnyChar(String chars){
        Assert.hasLength(chars, "chars_LEN0");
        String temp = null;
        if (!"".equals(tempRegex)) {
            temp = tempRegex+"[^"+chars+"]";
        }else {
            temp = "[^"+chars+"]";
        }
        return new AZ_RegexOperation(temp);
    }
    /**
     * 追加且不包括指定字符串中的任意一个字符
     * @param regex
     * @return
     */
    public AZ_RegexOperation appendExceptAnyChar(AZ_RegexBean regex){
        Assert.notNull(regex,"regex_null");
        return appendExceptAnyChar(regex.getRegex());
    }
    public String toString() {
        return tempRegex;
    }
    public AZ_RegexBean toBean(){
        return new AZ_RegexBean(tempRegex);
    }
    public String getCurrentRegex() {
        return tempRegex;
    }
}