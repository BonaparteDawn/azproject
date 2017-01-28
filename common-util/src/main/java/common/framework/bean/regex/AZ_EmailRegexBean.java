package common.framework.bean.regex;

import common.framework.abstracted.AZ_AbtructSelfDefineAZRegexBean;

/**
 * 电子邮件正则表达式
 * @author Fuzhong.Yan
 *
 */
public class AZ_EmailRegexBean extends AZ_AbtructSelfDefineAZRegexBean {
    @Override
    public AZ_RegexBean productRegexBean() {
        AZ_RegexBean bean = new AZ_RegexBean("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?");
        return bean;
    }
}
