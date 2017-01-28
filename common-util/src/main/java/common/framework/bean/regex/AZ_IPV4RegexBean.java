package common.framework.bean.regex;

import common.framework.abstracted.AZ_AbtructSelfDefineAZRegexBean;

/**
 * IPV4正则表达式
 * @author Fuzhong.Yan
 *
 */
public class AZ_IPV4RegexBean extends AZ_AbtructSelfDefineAZRegexBean {
    @Override
    public AZ_RegexBean productRegexBean() {
        return new AZ_RegexBean("((25[0-5]|2[0-4]\\d|[01]?\\d\\d?)\\.){3}(25[0-5]|2[0-4]\\d|[01]?\\d\\d?)");
    }
}