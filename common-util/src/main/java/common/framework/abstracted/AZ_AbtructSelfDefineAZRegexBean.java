package common.framework.abstracted;

import common.framework.bean.regex.AZ_RegexBean;
import org.springframework.util.Assert;

/**
 * 自定义正则表达式bean父类
 * @author Fuzhong.Yan
 */
public abstract class AZ_AbtructSelfDefineAZRegexBean extends AZ_RegexBean implements Runnable {
    /**
     * 生成正则表达式
     * @return
     */
    public abstract AZ_RegexBean productRegexBean();

    public void run() {
        AZ_RegexBean regexBean = productRegexBean();
        Assert.notNull(regexBean, "regexBean_null");
        setRegex(regexBean.getRegex());
    }
    @Override
    public String getRegex() {
        if (super.getRegex() == null || "".equals(super.getRegex())) {
            run();
        }
        return super.getRegex();
    }
}
