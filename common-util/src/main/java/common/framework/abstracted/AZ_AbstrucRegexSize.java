package common.framework.abstracted;

import common.framework.bean.regex.AZ_RegexBean;
import org.springframework.util.Assert;

/**
 * Created by Fuzhong.Yan on 17/1/28.
 */
public abstract class AZ_AbstrucRegexSize {
    /**
     * 数量等于
     * @param length
     * @return
     */
    public AZ_RegexBean EQ(int length){
        Assert.hasLength(getCurrentRegex(), "regex_len0");
        if (length < 1) {
            length = 1;
        }
        String temp = "("+getCurrentRegex()+")"+"{"+length+"}";
        return new AZ_RegexBean(temp);
    }
    /**
     * 数量大于等于
     * @param length
     * @return
     */
    public AZ_RegexBean GE(int length){
        Assert.hasLength(getCurrentRegex(), "regex_len0");
        if (length < 1) {
            length = 1;
        }
        String temp = "("+getCurrentRegex()+")"+"{"+length+",}";
        return new AZ_RegexBean(temp);
    }
    /**
     * 数量介于之间(且包括)
     * @return
     */
    public AZ_RegexBean between(int minLengh, int maxLength){
        Assert.hasLength(getCurrentRegex(), "regex_len0");
        if (minLengh < 1) {
            minLengh = 1;
        }
        if (maxLength < 1) {
            maxLength = 1;
        }
        if (maxLength < minLengh) {
            int temp = minLengh;
            minLengh = maxLength;
            maxLength = temp;
        }
        String temp = "("+getCurrentRegex()+")"+"{"+minLengh+","+maxLength+"}";
        return new AZ_RegexBean(temp);
    }
    /**
     * 数量小于等于1
     * @return
     */
    public AZ_RegexBean LEOne(){
        Assert.hasLength(getCurrentRegex(), "regex_len0");
        String temp ="("+getCurrentRegex()+")"+"?";
        return new AZ_RegexBean(temp);
    }
    /**
     * 数量大于等于1
     * @return
     */
    public AZ_RegexBean GEOne(){
        Assert.hasLength(getCurrentRegex(), "regex_len0");
        String temp ="("+getCurrentRegex()+")"+"+";
        return new AZ_RegexBean(temp);
    }
    /**
     * 数量大于等于0
     * @return
     */
    public AZ_RegexBean GEZero(){
        Assert.hasLength(getCurrentRegex(), "regex_len0");
        String temp ="("+getCurrentRegex()+")"+"*";
        return new AZ_RegexBean(temp);
    }
    public abstract String getCurrentRegex();
}
