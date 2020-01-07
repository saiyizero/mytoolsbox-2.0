package com.virugan.mytoolsbox.entry;

import java.util.ArrayList;
import java.util.List;

public class myaccountAuodilExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public myaccountAuodilExample() {
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

        public Criteria andStarDateIsNull() {
            addCriterion("star_date is null");
            return (Criteria) this;
        }

        public Criteria andStarDateIsNotNull() {
            addCriterion("star_date is not null");
            return (Criteria) this;
        }

        public Criteria andStarDateEqualTo(String value) {
            addCriterion("star_date =", value, "starDate");
            return (Criteria) this;
        }

        public Criteria andStarDateNotEqualTo(String value) {
            addCriterion("star_date <>", value, "starDate");
            return (Criteria) this;
        }

        public Criteria andStarDateGreaterThan(String value) {
            addCriterion("star_date >", value, "starDate");
            return (Criteria) this;
        }

        public Criteria andStarDateGreaterThanOrEqualTo(String value) {
            addCriterion("star_date >=", value, "starDate");
            return (Criteria) this;
        }

        public Criteria andStarDateLessThan(String value) {
            addCriterion("star_date <", value, "starDate");
            return (Criteria) this;
        }

        public Criteria andStarDateLessThanOrEqualTo(String value) {
            addCriterion("star_date <=", value, "starDate");
            return (Criteria) this;
        }

        public Criteria andStarDateLike(String value) {
            addCriterion("star_date like", value, "starDate");
            return (Criteria) this;
        }

        public Criteria andStarDateNotLike(String value) {
            addCriterion("star_date not like", value, "starDate");
            return (Criteria) this;
        }

        public Criteria andStarDateIn(List<String> values) {
            addCriterion("star_date in", values, "starDate");
            return (Criteria) this;
        }

        public Criteria andStarDateNotIn(List<String> values) {
            addCriterion("star_date not in", values, "starDate");
            return (Criteria) this;
        }

        public Criteria andStarDateBetween(String value1, String value2) {
            addCriterion("star_date between", value1, value2, "starDate");
            return (Criteria) this;
        }

        public Criteria andStarDateNotBetween(String value1, String value2) {
            addCriterion("star_date not between", value1, value2, "starDate");
            return (Criteria) this;
        }

        public Criteria andTendDateIsNull() {
            addCriterion("tend_date is null");
            return (Criteria) this;
        }

        public Criteria andTendDateIsNotNull() {
            addCriterion("tend_date is not null");
            return (Criteria) this;
        }

        public Criteria andTendDateEqualTo(String value) {
            addCriterion("tend_date =", value, "tendDate");
            return (Criteria) this;
        }

        public Criteria andTendDateNotEqualTo(String value) {
            addCriterion("tend_date <>", value, "tendDate");
            return (Criteria) this;
        }

        public Criteria andTendDateGreaterThan(String value) {
            addCriterion("tend_date >", value, "tendDate");
            return (Criteria) this;
        }

        public Criteria andTendDateGreaterThanOrEqualTo(String value) {
            addCriterion("tend_date >=", value, "tendDate");
            return (Criteria) this;
        }

        public Criteria andTendDateLessThan(String value) {
            addCriterion("tend_date <", value, "tendDate");
            return (Criteria) this;
        }

        public Criteria andTendDateLessThanOrEqualTo(String value) {
            addCriterion("tend_date <=", value, "tendDate");
            return (Criteria) this;
        }

        public Criteria andTendDateLike(String value) {
            addCriterion("tend_date like", value, "tendDate");
            return (Criteria) this;
        }

        public Criteria andTendDateNotLike(String value) {
            addCriterion("tend_date not like", value, "tendDate");
            return (Criteria) this;
        }

        public Criteria andTendDateIn(List<String> values) {
            addCriterion("tend_date in", values, "tendDate");
            return (Criteria) this;
        }

        public Criteria andTendDateNotIn(List<String> values) {
            addCriterion("tend_date not in", values, "tendDate");
            return (Criteria) this;
        }

        public Criteria andTendDateBetween(String value1, String value2) {
            addCriterion("tend_date between", value1, value2, "tendDate");
            return (Criteria) this;
        }

        public Criteria andTendDateNotBetween(String value1, String value2) {
            addCriterion("tend_date not between", value1, value2, "tendDate");
            return (Criteria) this;
        }

        public Criteria andTranGoodIsNull() {
            addCriterion("tran_good is null");
            return (Criteria) this;
        }

        public Criteria andTranGoodIsNotNull() {
            addCriterion("tran_good is not null");
            return (Criteria) this;
        }

        public Criteria andTranGoodEqualTo(String value) {
            addCriterion("tran_good =", value, "tranGood");
            return (Criteria) this;
        }

        public Criteria andTranGoodNotEqualTo(String value) {
            addCriterion("tran_good <>", value, "tranGood");
            return (Criteria) this;
        }

        public Criteria andTranGoodGreaterThan(String value) {
            addCriterion("tran_good >", value, "tranGood");
            return (Criteria) this;
        }

        public Criteria andTranGoodGreaterThanOrEqualTo(String value) {
            addCriterion("tran_good >=", value, "tranGood");
            return (Criteria) this;
        }

        public Criteria andTranGoodLessThan(String value) {
            addCriterion("tran_good <", value, "tranGood");
            return (Criteria) this;
        }

        public Criteria andTranGoodLessThanOrEqualTo(String value) {
            addCriterion("tran_good <=", value, "tranGood");
            return (Criteria) this;
        }

        public Criteria andTranGoodLike(String value) {
            addCriterion("tran_good like", value, "tranGood");
            return (Criteria) this;
        }

        public Criteria andTranGoodNotLike(String value) {
            addCriterion("tran_good not like", value, "tranGood");
            return (Criteria) this;
        }

        public Criteria andTranGoodIn(List<String> values) {
            addCriterion("tran_good in", values, "tranGood");
            return (Criteria) this;
        }

        public Criteria andTranGoodNotIn(List<String> values) {
            addCriterion("tran_good not in", values, "tranGood");
            return (Criteria) this;
        }

        public Criteria andTranGoodBetween(String value1, String value2) {
            addCriterion("tran_good between", value1, value2, "tranGood");
            return (Criteria) this;
        }

        public Criteria andTranGoodNotBetween(String value1, String value2) {
            addCriterion("tran_good not between", value1, value2, "tranGood");
            return (Criteria) this;
        }

        public Criteria andTranDictIsNull() {
            addCriterion("tran_dict is null");
            return (Criteria) this;
        }

        public Criteria andTranDictIsNotNull() {
            addCriterion("tran_dict is not null");
            return (Criteria) this;
        }

        public Criteria andTranDictEqualTo(String value) {
            addCriterion("tran_dict =", value, "tranDict");
            return (Criteria) this;
        }

        public Criteria andTranDictNotEqualTo(String value) {
            addCriterion("tran_dict <>", value, "tranDict");
            return (Criteria) this;
        }

        public Criteria andTranDictGreaterThan(String value) {
            addCriterion("tran_dict >", value, "tranDict");
            return (Criteria) this;
        }

        public Criteria andTranDictGreaterThanOrEqualTo(String value) {
            addCriterion("tran_dict >=", value, "tranDict");
            return (Criteria) this;
        }

        public Criteria andTranDictLessThan(String value) {
            addCriterion("tran_dict <", value, "tranDict");
            return (Criteria) this;
        }

        public Criteria andTranDictLessThanOrEqualTo(String value) {
            addCriterion("tran_dict <=", value, "tranDict");
            return (Criteria) this;
        }

        public Criteria andTranDictLike(String value) {
            addCriterion("tran_dict like", value, "tranDict");
            return (Criteria) this;
        }

        public Criteria andTranDictNotLike(String value) {
            addCriterion("tran_dict not like", value, "tranDict");
            return (Criteria) this;
        }

        public Criteria andTranDictIn(List<String> values) {
            addCriterion("tran_dict in", values, "tranDict");
            return (Criteria) this;
        }

        public Criteria andTranDictNotIn(List<String> values) {
            addCriterion("tran_dict not in", values, "tranDict");
            return (Criteria) this;
        }

        public Criteria andTranDictBetween(String value1, String value2) {
            addCriterion("tran_dict between", value1, value2, "tranDict");
            return (Criteria) this;
        }

        public Criteria andTranDictNotBetween(String value1, String value2) {
            addCriterion("tran_dict not between", value1, value2, "tranDict");
            return (Criteria) this;
        }

        public Criteria andTranAmtsIsNull() {
            addCriterion("tran_amts is null");
            return (Criteria) this;
        }

        public Criteria andTranAmtsIsNotNull() {
            addCriterion("tran_amts is not null");
            return (Criteria) this;
        }

        public Criteria andTranAmtsEqualTo(Double value) {
            addCriterion("tran_amts =", value, "tranAmts");
            return (Criteria) this;
        }

        public Criteria andTranAmtsNotEqualTo(Double value) {
            addCriterion("tran_amts <>", value, "tranAmts");
            return (Criteria) this;
        }

        public Criteria andTranAmtsGreaterThan(Double value) {
            addCriterion("tran_amts >", value, "tranAmts");
            return (Criteria) this;
        }

        public Criteria andTranAmtsGreaterThanOrEqualTo(Double value) {
            addCriterion("tran_amts >=", value, "tranAmts");
            return (Criteria) this;
        }

        public Criteria andTranAmtsLessThan(Double value) {
            addCriterion("tran_amts <", value, "tranAmts");
            return (Criteria) this;
        }

        public Criteria andTranAmtsLessThanOrEqualTo(Double value) {
            addCriterion("tran_amts <=", value, "tranAmts");
            return (Criteria) this;
        }

        public Criteria andTranAmtsIn(List<Double> values) {
            addCriterion("tran_amts in", values, "tranAmts");
            return (Criteria) this;
        }

        public Criteria andTranAmtsNotIn(List<Double> values) {
            addCriterion("tran_amts not in", values, "tranAmts");
            return (Criteria) this;
        }

        public Criteria andTranAmtsBetween(Double value1, Double value2) {
            addCriterion("tran_amts between", value1, value2, "tranAmts");
            return (Criteria) this;
        }

        public Criteria andTranAmtsNotBetween(Double value1, Double value2) {
            addCriterion("tran_amts not between", value1, value2, "tranAmts");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNull() {
            addCriterion("item_type is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("item_type is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(String value) {
            addCriterion("item_type =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(String value) {
            addCriterion("item_type <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(String value) {
            addCriterion("item_type >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("item_type >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(String value) {
            addCriterion("item_type <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(String value) {
            addCriterion("item_type <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLike(String value) {
            addCriterion("item_type like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotLike(String value) {
            addCriterion("item_type not like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<String> values) {
            addCriterion("item_type in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<String> values) {
            addCriterion("item_type not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(String value1, String value2) {
            addCriterion("item_type between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(String value1, String value2) {
            addCriterion("item_type not between", value1, value2, "itemType");
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