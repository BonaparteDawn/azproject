package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FileExample {
    /**
     * file
     */
    protected String orderByClause;

    /**
     * file
     */
    protected boolean distinct;

    /**
     * file
     */
    protected List<Criteria> oredCriteria;

    /**
     *
     * @mbg.generated 2017-01-19
     */
    public FileExample() {
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
     * file 2017-01-19
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameIsNull() {
            addCriterion("fileOriginalName is null");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameIsNotNull() {
            addCriterion("fileOriginalName is not null");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameEqualTo(String value) {
            addCriterion("fileOriginalName =", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameNotEqualTo(String value) {
            addCriterion("fileOriginalName <>", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameGreaterThan(String value) {
            addCriterion("fileOriginalName >", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameGreaterThanOrEqualTo(String value) {
            addCriterion("fileOriginalName >=", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameLessThan(String value) {
            addCriterion("fileOriginalName <", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameLessThanOrEqualTo(String value) {
            addCriterion("fileOriginalName <=", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameLike(String value) {
            addCriterion("fileOriginalName like", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameNotLike(String value) {
            addCriterion("fileOriginalName not like", value, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameIn(List<String> values) {
            addCriterion("fileOriginalName in", values, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameNotIn(List<String> values) {
            addCriterion("fileOriginalName not in", values, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameBetween(String value1, String value2) {
            addCriterion("fileOriginalName between", value1, value2, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileOriginalNameNotBetween(String value1, String value2) {
            addCriterion("fileOriginalName not between", value1, value2, "fileOriginalName");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNull() {
            addCriterion("fileType is null");
            return (Criteria) this;
        }

        public Criteria andFileTypeIsNotNull() {
            addCriterion("fileType is not null");
            return (Criteria) this;
        }

        public Criteria andFileTypeEqualTo(String value) {
            addCriterion("fileType =", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotEqualTo(String value) {
            addCriterion("fileType <>", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThan(String value) {
            addCriterion("fileType >", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeGreaterThanOrEqualTo(String value) {
            addCriterion("fileType >=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThan(String value) {
            addCriterion("fileType <", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLessThanOrEqualTo(String value) {
            addCriterion("fileType <=", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeLike(String value) {
            addCriterion("fileType like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotLike(String value) {
            addCriterion("fileType not like", value, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeIn(List<String> values) {
            addCriterion("fileType in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotIn(List<String> values) {
            addCriterion("fileType not in", values, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeBetween(String value1, String value2) {
            addCriterion("fileType between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFileTypeNotBetween(String value1, String value2) {
            addCriterion("fileType not between", value1, value2, "fileType");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("filePath is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("filePath is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("filePath =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("filePath <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("filePath >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("filePath >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("filePath <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("filePath <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("filePath like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("filePath not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("filePath in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("filePath not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("filePath between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("filePath not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andBusinessIDIsNull() {
            addCriterion("businessID is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIDIsNotNull() {
            addCriterion("businessID is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessIDEqualTo(String value) {
            addCriterion("businessID =", value, "businessID");
            return (Criteria) this;
        }

        public Criteria andBusinessIDNotEqualTo(String value) {
            addCriterion("businessID <>", value, "businessID");
            return (Criteria) this;
        }

        public Criteria andBusinessIDGreaterThan(String value) {
            addCriterion("businessID >", value, "businessID");
            return (Criteria) this;
        }

        public Criteria andBusinessIDGreaterThanOrEqualTo(String value) {
            addCriterion("businessID >=", value, "businessID");
            return (Criteria) this;
        }

        public Criteria andBusinessIDLessThan(String value) {
            addCriterion("businessID <", value, "businessID");
            return (Criteria) this;
        }

        public Criteria andBusinessIDLessThanOrEqualTo(String value) {
            addCriterion("businessID <=", value, "businessID");
            return (Criteria) this;
        }

        public Criteria andBusinessIDLike(String value) {
            addCriterion("businessID like", value, "businessID");
            return (Criteria) this;
        }

        public Criteria andBusinessIDNotLike(String value) {
            addCriterion("businessID not like", value, "businessID");
            return (Criteria) this;
        }

        public Criteria andBusinessIDIn(List<String> values) {
            addCriterion("businessID in", values, "businessID");
            return (Criteria) this;
        }

        public Criteria andBusinessIDNotIn(List<String> values) {
            addCriterion("businessID not in", values, "businessID");
            return (Criteria) this;
        }

        public Criteria andBusinessIDBetween(String value1, String value2) {
            addCriterion("businessID between", value1, value2, "businessID");
            return (Criteria) this;
        }

        public Criteria andBusinessIDNotBetween(String value1, String value2) {
            addCriterion("businessID not between", value1, value2, "businessID");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNull() {
            addCriterion("businessType is null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIsNotNull() {
            addCriterion("businessType is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeEqualTo(Short value) {
            addCriterion("businessType =", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotEqualTo(Short value) {
            addCriterion("businessType <>", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThan(Short value) {
            addCriterion("businessType >", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("businessType >=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThan(Short value) {
            addCriterion("businessType <", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeLessThanOrEqualTo(Short value) {
            addCriterion("businessType <=", value, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeIn(List<Short> values) {
            addCriterion("businessType in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotIn(List<Short> values) {
            addCriterion("businessType not in", values, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeBetween(Short value1, Short value2) {
            addCriterion("businessType between", value1, value2, "businessType");
            return (Criteria) this;
        }

        public Criteria andBusinessTypeNotBetween(Short value1, Short value2) {
            addCriterion("businessType not between", value1, value2, "businessType");
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
     * file
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * file 2017-01-19
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