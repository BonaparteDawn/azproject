package common.framework.bean.regex;

import common.framework.abstracted.AZ_AbstrucRegexSize;
import org.springframework.util.Assert;

/**
 * Created by Fuzhong.Yan on 17/1/28.
 */
public class AZ_RegexBean extends AZ_AbstrucRegexSize {
    /**正则表达式*/
    private String regex = null;

    public AZ_RegexBean() {
        regex = "";
    }
    public AZ_RegexBean(String regex) {
        Assert.hasLength("regex_len0");
        this.regex = regex;
    }

    @Override
    public String toString() {
        return getRegex();
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
    @Override
    public String getCurrentRegex() {
        return getRegex();
    }
}
