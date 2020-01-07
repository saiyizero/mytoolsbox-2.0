package com.virugan.mytoolsbox.entry;

import java.util.ArrayList;
import java.util.List;

public class myflbatchNmelstExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public myflbatchNmelstExample() {
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

        public Criteria andGropNameIsNull() {
            addCriterion("grop_name is null");
            return (Criteria) this;
        }

        public Criteria andGropNameIsNotNull() {
            addCriterion("grop_name is not null");
            return (Criteria) this;
        }

        public Criteria andGropNameEqualTo(String value) {
            addCriterion("grop_name =", value, "gropName");
            return (Criteria) this;
        }

        public Criteria andGropNameNotEqualTo(String value) {
            addCriterion("grop_name <>", value, "gropName");
            return (Criteria) this;
        }

        public Criteria andGropNameGreaterThan(String value) {
            addCriterion("grop_name >", value, "gropName");
            return (Criteria) this;
        }

        public Criteria andGropNameGreaterThanOrEqualTo(String value) {
            addCriterion("grop_name >=", value, "gropName");
            return (Criteria) this;
        }

        public Criteria andGropNameLessThan(String value) {
            addCriterion("grop_name <", value, "gropName");
            return (Criteria) this;
        }

        public Criteria andGropNameLessThanOrEqualTo(String value) {
            addCriterion("grop_name <=", value, "gropName");
            return (Criteria) this;
        }

        public Criteria andGropNameLike(String value) {
            addCriterion("grop_name like", value, "gropName");
            return (Criteria) this;
        }

        public Criteria andGropNameNotLike(String value) {
            addCriterion("grop_name not like", value, "gropName");
            return (Criteria) this;
        }

        public Criteria andGropNameIn(List<String> values) {
            addCriterion("grop_name in", values, "gropName");
            return (Criteria) this;
        }

        public Criteria andGropNameNotIn(List<String> values) {
            addCriterion("grop_name not in", values, "gropName");
            return (Criteria) this;
        }

        public Criteria andGropNameBetween(String value1, String value2) {
            addCriterion("grop_name between", value1, value2, "gropName");
            return (Criteria) this;
        }

        public Criteria andGropNameNotBetween(String value1, String value2) {
            addCriterion("grop_name not between", value1, value2, "gropName");
            return (Criteria) this;
        }

        public Criteria andSuffNameIsNull() {
            addCriterion("suff_name is null");
            return (Criteria) this;
        }

        public Criteria andSuffNameIsNotNull() {
            addCriterion("suff_name is not null");
            return (Criteria) this;
        }

        public Criteria andSuffNameEqualTo(String value) {
            addCriterion("suff_name =", value, "suffName");
            return (Criteria) this;
        }

        public Criteria andSuffNameNotEqualTo(String value) {
            addCriterion("suff_name <>", value, "suffName");
            return (Criteria) this;
        }

        public Criteria andSuffNameGreaterThan(String value) {
            addCriterion("suff_name >", value, "suffName");
            return (Criteria) this;
        }

        public Criteria andSuffNameGreaterThanOrEqualTo(String value) {
            addCriterion("suff_name >=", value, "suffName");
            return (Criteria) this;
        }

        public Criteria andSuffNameLessThan(String value) {
            addCriterion("suff_name <", value, "suffName");
            return (Criteria) this;
        }

        public Criteria andSuffNameLessThanOrEqualTo(String value) {
            addCriterion("suff_name <=", value, "suffName");
            return (Criteria) this;
        }

        public Criteria andSuffNameLike(String value) {
            addCriterion("suff_name like", value, "suffName");
            return (Criteria) this;
        }

        public Criteria andSuffNameNotLike(String value) {
            addCriterion("suff_name not like", value, "suffName");
            return (Criteria) this;
        }

        public Criteria andSuffNameIn(List<String> values) {
            addCriterion("suff_name in", values, "suffName");
            return (Criteria) this;
        }

        public Criteria andSuffNameNotIn(List<String> values) {
            addCriterion("suff_name not in", values, "suffName");
            return (Criteria) this;
        }

        public Criteria andSuffNameBetween(String value1, String value2) {
            addCriterion("suff_name between", value1, value2, "suffName");
            return (Criteria) this;
        }

        public Criteria andSuffNameNotBetween(String value1, String value2) {
            addCriterion("suff_name not between", value1, value2, "suffName");
            return (Criteria) this;
        }

        public Criteria andGropTypeIsNull() {
            addCriterion("grop_type is null");
            return (Criteria) this;
        }

        public Criteria andGropTypeIsNotNull() {
            addCriterion("grop_type is not null");
            return (Criteria) this;
        }

        public Criteria andGropTypeEqualTo(String value) {
            addCriterion("grop_type =", value, "gropType");
            return (Criteria) this;
        }

        public Criteria andGropTypeNotEqualTo(String value) {
            addCriterion("grop_type <>", value, "gropType");
            return (Criteria) this;
        }

        public Criteria andGropTypeGreaterThan(String value) {
            addCriterion("grop_type >", value, "gropType");
            return (Criteria) this;
        }

        public Criteria andGropTypeGreaterThanOrEqualTo(String value) {
            addCriterion("grop_type >=", value, "gropType");
            return (Criteria) this;
        }

        public Criteria andGropTypeLessThan(String value) {
            addCriterion("grop_type <", value, "gropType");
            return (Criteria) this;
        }

        public Criteria andGropTypeLessThanOrEqualTo(String value) {
            addCriterion("grop_type <=", value, "gropType");
            return (Criteria) this;
        }

        public Criteria andGropTypeLike(String value) {
            addCriterion("grop_type like", value, "gropType");
            return (Criteria) this;
        }

        public Criteria andGropTypeNotLike(String value) {
            addCriterion("grop_type not like", value, "gropType");
            return (Criteria) this;
        }

        public Criteria andGropTypeIn(List<String> values) {
            addCriterion("grop_type in", values, "gropType");
            return (Criteria) this;
        }

        public Criteria andGropTypeNotIn(List<String> values) {
            addCriterion("grop_type not in", values, "gropType");
            return (Criteria) this;
        }

        public Criteria andGropTypeBetween(String value1, String value2) {
            addCriterion("grop_type between", value1, value2, "gropType");
            return (Criteria) this;
        }

        public Criteria andGropTypeNotBetween(String value1, String value2) {
            addCriterion("grop_type not between", value1, value2, "gropType");
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