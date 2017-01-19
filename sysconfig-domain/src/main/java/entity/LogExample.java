package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogExample {
    /**
     * log
     */
    protected String orderByClause;

    /**
     * log
     */
    protected boolean distinct;

    /**
     * log
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated 2017-01-19
     */
    public LogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     *
     * @mbg.generated 2017-01-19
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     *
     * @mbg.generated 2017-01-19
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     *
     * @mbg.generated 2017-01-19
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     *
     * @mbg.generated 2017-01-19
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     *
     * @mbg.generated 2017-01-19
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     *
     * @mbg.generated 2017-01-19
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     *
     * @mbg.generated 2017-01-19
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     *
     * @mbg.generated 2017-01-19
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     *
     * @mbg.generated 2017-01-19
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     *
     * @mbg.generated 2017-01-19
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * log 2017-01-19
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAspectCodeIsNull() {
            addCriterion("aspectCode is null");
            return (Criteria) this;
        }

        public Criteria andAspectCodeIsNotNull() {
            addCriterion("aspectCode is not null");
            return (Criteria) this;
        }

        public Criteria andAspectCodeEqualTo(String value) {
            addCriterion("aspectCode =", value, "aspectCode");
            return (Criteria) this;
        }

        public Criteria andAspectCodeNotEqualTo(String value) {
            addCriterion("aspectCode <>", value, "aspectCode");
            return (Criteria) this;
        }

        public Criteria andAspectCodeGreaterThan(String value) {
            addCriterion("aspectCode >", value, "aspectCode");
            return (Criteria) this;
        }

        public Criteria andAspectCodeGreaterThanOrEqualTo(String value) {
            addCriterion("aspectCode >=", value, "aspectCode");
            return (Criteria) this;
        }

        public Criteria andAspectCodeLessThan(String value) {
            addCriterion("aspectCode <", value, "aspectCode");
            return (Criteria) this;
        }

        public Criteria andAspectCodeLessThanOrEqualTo(String value) {
            addCriterion("aspectCode <=", value, "aspectCode");
            return (Criteria) this;
        }

        public Criteria andAspectCodeLike(String value) {
            addCriterion("aspectCode like", value, "aspectCode");
            return (Criteria) this;
        }

        public Criteria andAspectCodeNotLike(String value) {
            addCriterion("aspectCode not like", value, "aspectCode");
            return (Criteria) this;
        }

        public Criteria andAspectCodeIn(List<String> values) {
            addCriterion("aspectCode in", values, "aspectCode");
            return (Criteria) this;
        }

        public Criteria andAspectCodeNotIn(List<String> values) {
            addCriterion("aspectCode not in", values, "aspectCode");
            return (Criteria) this;
        }

        public Criteria andAspectCodeBetween(String value1, String value2) {
            addCriterion("aspectCode between", value1, value2, "aspectCode");
            return (Criteria) this;
        }

        public Criteria andAspectCodeNotBetween(String value1, String value2) {
            addCriterion("aspectCode not between", value1, value2, "aspectCode");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNull() {
            addCriterion("appName is null");
            return (Criteria) this;
        }

        public Criteria andAppNameIsNotNull() {
            addCriterion("appName is not null");
            return (Criteria) this;
        }

        public Criteria andAppNameEqualTo(String value) {
            addCriterion("appName =", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotEqualTo(String value) {
            addCriterion("appName <>", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThan(String value) {
            addCriterion("appName >", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameGreaterThanOrEqualTo(String value) {
            addCriterion("appName >=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThan(String value) {
            addCriterion("appName <", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLessThanOrEqualTo(String value) {
            addCriterion("appName <=", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameLike(String value) {
            addCriterion("appName like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotLike(String value) {
            addCriterion("appName not like", value, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameIn(List<String> values) {
            addCriterion("appName in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotIn(List<String> values) {
            addCriterion("appName not in", values, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameBetween(String value1, String value2) {
            addCriterion("appName between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppNameNotBetween(String value1, String value2) {
            addCriterion("appName not between", value1, value2, "appName");
            return (Criteria) this;
        }

        public Criteria andAppDesIsNull() {
            addCriterion("appDes is null");
            return (Criteria) this;
        }

        public Criteria andAppDesIsNotNull() {
            addCriterion("appDes is not null");
            return (Criteria) this;
        }

        public Criteria andAppDesEqualTo(String value) {
            addCriterion("appDes =", value, "appDes");
            return (Criteria) this;
        }

        public Criteria andAppDesNotEqualTo(String value) {
            addCriterion("appDes <>", value, "appDes");
            return (Criteria) this;
        }

        public Criteria andAppDesGreaterThan(String value) {
            addCriterion("appDes >", value, "appDes");
            return (Criteria) this;
        }

        public Criteria andAppDesGreaterThanOrEqualTo(String value) {
            addCriterion("appDes >=", value, "appDes");
            return (Criteria) this;
        }

        public Criteria andAppDesLessThan(String value) {
            addCriterion("appDes <", value, "appDes");
            return (Criteria) this;
        }

        public Criteria andAppDesLessThanOrEqualTo(String value) {
            addCriterion("appDes <=", value, "appDes");
            return (Criteria) this;
        }

        public Criteria andAppDesLike(String value) {
            addCriterion("appDes like", value, "appDes");
            return (Criteria) this;
        }

        public Criteria andAppDesNotLike(String value) {
            addCriterion("appDes not like", value, "appDes");
            return (Criteria) this;
        }

        public Criteria andAppDesIn(List<String> values) {
            addCriterion("appDes in", values, "appDes");
            return (Criteria) this;
        }

        public Criteria andAppDesNotIn(List<String> values) {
            addCriterion("appDes not in", values, "appDes");
            return (Criteria) this;
        }

        public Criteria andAppDesBetween(String value1, String value2) {
            addCriterion("appDes between", value1, value2, "appDes");
            return (Criteria) this;
        }

        public Criteria andAppDesNotBetween(String value1, String value2) {
            addCriterion("appDes not between", value1, value2, "appDes");
            return (Criteria) this;
        }

        public Criteria andMethodIsNull() {
            addCriterion("method is null");
            return (Criteria) this;
        }

        public Criteria andMethodIsNotNull() {
            addCriterion("method is not null");
            return (Criteria) this;
        }

        public Criteria andMethodEqualTo(String value) {
            addCriterion("method =", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotEqualTo(String value) {
            addCriterion("method <>", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThan(String value) {
            addCriterion("method >", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodGreaterThanOrEqualTo(String value) {
            addCriterion("method >=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThan(String value) {
            addCriterion("method <", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLessThanOrEqualTo(String value) {
            addCriterion("method <=", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodLike(String value) {
            addCriterion("method like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotLike(String value) {
            addCriterion("method not like", value, "method");
            return (Criteria) this;
        }

        public Criteria andMethodIn(List<String> values) {
            addCriterion("method in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotIn(List<String> values) {
            addCriterion("method not in", values, "method");
            return (Criteria) this;
        }

        public Criteria andMethodBetween(String value1, String value2) {
            addCriterion("method between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andMethodNotBetween(String value1, String value2) {
            addCriterion("method not between", value1, value2, "method");
            return (Criteria) this;
        }

        public Criteria andArgsIsNull() {
            addCriterion("args is null");
            return (Criteria) this;
        }

        public Criteria andArgsIsNotNull() {
            addCriterion("args is not null");
            return (Criteria) this;
        }

        public Criteria andArgsEqualTo(String value) {
            addCriterion("args =", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsNotEqualTo(String value) {
            addCriterion("args <>", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsGreaterThan(String value) {
            addCriterion("args >", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsGreaterThanOrEqualTo(String value) {
            addCriterion("args >=", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsLessThan(String value) {
            addCriterion("args <", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsLessThanOrEqualTo(String value) {
            addCriterion("args <=", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsLike(String value) {
            addCriterion("args like", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsNotLike(String value) {
            addCriterion("args not like", value, "args");
            return (Criteria) this;
        }

        public Criteria andArgsIn(List<String> values) {
            addCriterion("args in", values, "args");
            return (Criteria) this;
        }

        public Criteria andArgsNotIn(List<String> values) {
            addCriterion("args not in", values, "args");
            return (Criteria) this;
        }

        public Criteria andArgsBetween(String value1, String value2) {
            addCriterion("args between", value1, value2, "args");
            return (Criteria) this;
        }

        public Criteria andArgsNotBetween(String value1, String value2) {
            addCriterion("args not between", value1, value2, "args");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterion("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterion("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterion("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterion("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterion("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterion("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterion("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterion("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterion("time not between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     * log
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * log 2017-01-19
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}