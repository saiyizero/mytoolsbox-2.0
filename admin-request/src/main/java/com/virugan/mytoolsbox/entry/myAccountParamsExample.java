package com.virugan.mytoolsbox.entry;

import java.util.ArrayList;
import java.util.List;

public class myAccountParamsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public myAccountParamsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andColsNumbIsNull() {
            addCriterion("cols_numb is null");
            return (Criteria) this;
        }

        public Criteria andColsNumbIsNotNull() {
            addCriterion("cols_numb is not null");
            return (Criteria) this;
        }

        public Criteria andColsNumbEqualTo(Integer value) {
            addCriterion("cols_numb =", value, "colsNumb");
            return (Criteria) this;
        }

        public Criteria andColsNumbNotEqualTo(Integer value) {
            addCriterion("cols_numb <>", value, "colsNumb");
            return (Criteria) this;
        }

        public Criteria andColsNumbGreaterThan(Integer value) {
            addCriterion("cols_numb >", value, "colsNumb");
            return (Criteria) this;
        }

        public Criteria andColsNumbGreaterThanOrEqualTo(Integer value) {
            addCriterion("cols_numb >=", value, "colsNumb");
            return (Criteria) this;
        }

        public Criteria andColsNumbLessThan(Integer value) {
            addCriterion("cols_numb <", value, "colsNumb");
            return (Criteria) this;
        }

        public Criteria andColsNumbLessThanOrEqualTo(Integer value) {
            addCriterion("cols_numb <=", value, "colsNumb");
            return (Criteria) this;
        }

        public Criteria andColsNumbIn(List<Integer> values) {
            addCriterion("cols_numb in", values, "colsNumb");
            return (Criteria) this;
        }

        public Criteria andColsNumbNotIn(List<Integer> values) {
            addCriterion("cols_numb not in", values, "colsNumb");
            return (Criteria) this;
        }

        public Criteria andColsNumbBetween(Integer value1, Integer value2) {
            addCriterion("cols_numb between", value1, value2, "colsNumb");
            return (Criteria) this;
        }

        public Criteria andColsNumbNotBetween(Integer value1, Integer value2) {
            addCriterion("cols_numb not between", value1, value2, "colsNumb");
            return (Criteria) this;
        }

        public Criteria andParaTypeIsNull() {
            addCriterion("para_type is null");
            return (Criteria) this;
        }

        public Criteria andParaTypeIsNotNull() {
            addCriterion("para_type is not null");
            return (Criteria) this;
        }

        public Criteria andParaTypeEqualTo(String value) {
            addCriterion("para_type =", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeNotEqualTo(String value) {
            addCriterion("para_type <>", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeGreaterThan(String value) {
            addCriterion("para_type >", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeGreaterThanOrEqualTo(String value) {
            addCriterion("para_type >=", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeLessThan(String value) {
            addCriterion("para_type <", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeLessThanOrEqualTo(String value) {
            addCriterion("para_type <=", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeLike(String value) {
            addCriterion("para_type like", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeNotLike(String value) {
            addCriterion("para_type not like", value, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeIn(List<String> values) {
            addCriterion("para_type in", values, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeNotIn(List<String> values) {
            addCriterion("para_type not in", values, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeBetween(String value1, String value2) {
            addCriterion("para_type between", value1, value2, "paraType");
            return (Criteria) this;
        }

        public Criteria andParaTypeNotBetween(String value1, String value2) {
            addCriterion("para_type not between", value1, value2, "paraType");
            return (Criteria) this;
        }

        public Criteria andSqlsNameIsNull() {
            addCriterion("sqls_name is null");
            return (Criteria) this;
        }

        public Criteria andSqlsNameIsNotNull() {
            addCriterion("sqls_name is not null");
            return (Criteria) this;
        }

        public Criteria andSqlsNameEqualTo(String value) {
            addCriterion("sqls_name =", value, "sqlsName");
            return (Criteria) this;
        }

        public Criteria andSqlsNameNotEqualTo(String value) {
            addCriterion("sqls_name <>", value, "sqlsName");
            return (Criteria) this;
        }

        public Criteria andSqlsNameGreaterThan(String value) {
            addCriterion("sqls_name >", value, "sqlsName");
            return (Criteria) this;
        }

        public Criteria andSqlsNameGreaterThanOrEqualTo(String value) {
            addCriterion("sqls_name >=", value, "sqlsName");
            return (Criteria) this;
        }

        public Criteria andSqlsNameLessThan(String value) {
            addCriterion("sqls_name <", value, "sqlsName");
            return (Criteria) this;
        }

        public Criteria andSqlsNameLessThanOrEqualTo(String value) {
            addCriterion("sqls_name <=", value, "sqlsName");
            return (Criteria) this;
        }

        public Criteria andSqlsNameLike(String value) {
            addCriterion("sqls_name like", value, "sqlsName");
            return (Criteria) this;
        }

        public Criteria andSqlsNameNotLike(String value) {
            addCriterion("sqls_name not like", value, "sqlsName");
            return (Criteria) this;
        }

        public Criteria andSqlsNameIn(List<String> values) {
            addCriterion("sqls_name in", values, "sqlsName");
            return (Criteria) this;
        }

        public Criteria andSqlsNameNotIn(List<String> values) {
            addCriterion("sqls_name not in", values, "sqlsName");
            return (Criteria) this;
        }

        public Criteria andSqlsNameBetween(String value1, String value2) {
            addCriterion("sqls_name between", value1, value2, "sqlsName");
            return (Criteria) this;
        }

        public Criteria andSqlsNameNotBetween(String value1, String value2) {
            addCriterion("sqls_name not between", value1, value2, "sqlsName");
            return (Criteria) this;
        }

        public Criteria andSqlsValuIsNull() {
            addCriterion("sqls_valu is null");
            return (Criteria) this;
        }

        public Criteria andSqlsValuIsNotNull() {
            addCriterion("sqls_valu is not null");
            return (Criteria) this;
        }

        public Criteria andSqlsValuEqualTo(String value) {
            addCriterion("sqls_valu =", value, "sqlsValu");
            return (Criteria) this;
        }

        public Criteria andSqlsValuNotEqualTo(String value) {
            addCriterion("sqls_valu <>", value, "sqlsValu");
            return (Criteria) this;
        }

        public Criteria andSqlsValuGreaterThan(String value) {
            addCriterion("sqls_valu >", value, "sqlsValu");
            return (Criteria) this;
        }

        public Criteria andSqlsValuGreaterThanOrEqualTo(String value) {
            addCriterion("sqls_valu >=", value, "sqlsValu");
            return (Criteria) this;
        }

        public Criteria andSqlsValuLessThan(String value) {
            addCriterion("sqls_valu <", value, "sqlsValu");
            return (Criteria) this;
        }

        public Criteria andSqlsValuLessThanOrEqualTo(String value) {
            addCriterion("sqls_valu <=", value, "sqlsValu");
            return (Criteria) this;
        }

        public Criteria andSqlsValuLike(String value) {
            addCriterion("sqls_valu like", value, "sqlsValu");
            return (Criteria) this;
        }

        public Criteria andSqlsValuNotLike(String value) {
            addCriterion("sqls_valu not like", value, "sqlsValu");
            return (Criteria) this;
        }

        public Criteria andSqlsValuIn(List<String> values) {
            addCriterion("sqls_valu in", values, "sqlsValu");
            return (Criteria) this;
        }

        public Criteria andSqlsValuNotIn(List<String> values) {
            addCriterion("sqls_valu not in", values, "sqlsValu");
            return (Criteria) this;
        }

        public Criteria andSqlsValuBetween(String value1, String value2) {
            addCriterion("sqls_valu between", value1, value2, "sqlsValu");
            return (Criteria) this;
        }

        public Criteria andSqlsValuNotBetween(String value1, String value2) {
            addCriterion("sqls_valu not between", value1, value2, "sqlsValu");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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