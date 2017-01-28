package common.framework.bean.regex;

import common.framework.abstracted.AZ_AbtructSelfDefineAZRegexBean;
import common.framework.service.AZ_RegexFactory;
import common.framework.util.RegextUtil;

/**
 * 浮点数正则表达式（包括整数）
 * @author Fuzhong.Yan
 *
 */
public class AZ_DoubleRegexBean extends AZ_AbtructSelfDefineAZRegexBean {
    @Override
    public AZ_RegexBean productRegexBean() {
        //符号
        AZ_RegexBean symbol = AZ_RegexFactory.selfdefine("[+-]").LEOne();
        //小于1的浮点数
        AZ_RegexBean lessThan1 = RegextUtil.operation().append("0").append("[.]").append(AZ_RegexFactory.NUMBER.GEOne()).toBean();
        //大于1的浮点数
        AZ_RegexBean greatThan1 = RegextUtil.operation().appendAnyChar("1-9").append(AZ_RegexFactory.NUMBER.GEZero()).appendAnyChar(".").append(AZ_RegexFactory.NUMBER.GEOne()).toBean();
        //整数非0
        AZ_RegexBean inteter = RegextUtil.operation().appendAnyChar("1-9").append(AZ_RegexFactory.NUMBER.GEZero()).toBean();
        //整数0
        AZ_RegexBean zero = AZ_RegexFactory.selfdefine("0");
        //组合生成
        return RegextUtil.operation().append(symbol).appendOr(greatThan1,lessThan1,inteter,zero).toBean();
    }
}
