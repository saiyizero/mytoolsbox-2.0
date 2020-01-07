package com.virugan.mytoolsbox.entry;

import java.util.ArrayList;
import java.util.List;

public class myAccountAnalysExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public myAccountAnalysExample() {
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

        public Criteria andTranDateIsNull() {
            addCriterion("tran_date is null");
            return (Criteria) this;
        }

        public Criteria andTranDateIsNotNull() {
            addCriterion("tran_date is not null");
            return (Criteria) this;
        }

        public Criteria andTranDateEqualTo(String value) {
            addCriterion("tran_date =", value, "tranDate");
            return (Criteria) this;
        }

        public Criteria andTranDateNotEqualTo(String value) {
            addCriterion("tran_date <>", value, "tranDate");
            return (Criteria) this;
        }

        public Criteria andTranDateGreaterThan(String value) {
            addCriterion("tran_date >", value, "tranDate");
            return (Criteria) this;
        }

        public Criteria andTranDateGreaterThanOrEqualTo(String value) {
            addCriterion("tran_date >=", value, "tranDate");
            return (Criteria) this;
        }

        public Criteria andTranDateLessThan(String value) {
            addCriterion("tran_date <", value, "tranDate");
            return (Criteria) this;
        }

        public Criteria andTranDateLessThanOrEqualTo(String value) {
            addCriterion("tran_date <=", value, "tranDate");
            return (Criteria) this;
        }

        public Criteria andTranDateLike(String value) {
            addCriterion("tran_date like", value, "tranDate");
            return (Criteria) this;
        }

        public Criteria andTranDateNotLike(String value) {
            addCriterion("tran_date not like", value, "tranDate");
            return (Criteria) this;
        }

        public Criteria andTranDateIn(List<String> values) {
            addCriterion("tran_date in", values, "tranDate");
            return (Criteria) this;
        }

        public Criteria andTranDateNotIn(List<String> values) {
            addCriterion("tran_date not in", values, "tranDate");
            return (Criteria) this;
        }

        public Criteria andTranDateBetween(String value1, String value2) {
            addCriterion("tran_date between", value1, value2, "tranDate");
            return (Criteria) this;
        }

        public Criteria andTranDateNotBetween(String value1, String value2) {
            addCriterion("tran_date not between", value1, value2, "tranDate");
            return (Criteria) this;
        }

        public Criteria andSumsGetsIsNull() {
            addCriterion("sums_gets is null");
            return (Criteria) this;
        }

        public Criteria andSumsGetsIsNotNull() {
            addCriterion("sums_gets is not null");
            return (Criteria) this;
        }

        public Criteria andSumsGetsEqualTo(String value) {
            addCriterion("sums_gets =", value, "sumsGets");
            return (Criteria) this;
        }

        public Criteria andSumsGetsNotEqualTo(String value) {
            addCriterion("sums_gets <>", value, "sumsGets");
            return (Criteria) this;
        }

        public Criteria andSumsGetsGreaterThan(String value) {
            addCriterion("sums_gets >", value, "sumsGets");
            return (Criteria) this;
        }

        public Criteria andSumsGetsGreaterThanOrEqualTo(String value) {
            addCriterion("sums_gets >=", value, "sumsGets");
            return (Criteria) this;
        }

        public Criteria andSumsGetsLessThan(String value) {
            addCriterion("sums_gets <", value, "sumsGets");
            return (Criteria) this;
        }

        public Criteria andSumsGetsLessThanOrEqualTo(String value) {
            addCriterion("sums_gets <=", value, "sumsGets");
            return (Criteria) this;
        }

        public Criteria andSumsGetsLike(String value) {
            addCriterion("sums_gets like", value, "sumsGets");
            return (Criteria) this;
        }

        public Criteria andSumsGetsNotLike(String value) {
            addCriterion("sums_gets not like", value, "sumsGets");
            return (Criteria) this;
        }

        public Criteria andSumsGetsIn(List<String> values) {
            addCriterion("sums_gets in", values, "sumsGets");
            return (Criteria) this;
        }

        public Criteria andSumsGetsNotIn(List<String> values) {
            addCriterion("sums_gets not in", values, "sumsGets");
            return (Criteria) this;
        }

        public Criteria andSumsGetsBetween(String value1, String value2) {
            addCriterion("sums_gets between", value1, value2, "sumsGets");
            return (Criteria) this;
        }

        public Criteria andSumsGetsNotBetween(String value1, String value2) {
            addCriterion("sums_gets not between", value1, value2, "sumsGets");
            return (Criteria) this;
        }

        public Criteria andSumsPaysIsNull() {
            addCriterion("sums_pays is null");
            return (Criteria) this;
        }

        public Criteria andSumsPaysIsNotNull() {
            addCriterion("sums_pays is not null");
            return (Criteria) this;
        }

        public Criteria andSumsPaysEqualTo(String value) {
            addCriterion("sums_pays =", value, "sumsPays");
            return (Criteria) this;
        }

        public Criteria andSumsPaysNotEqualTo(String value) {
            addCriterion("sums_pays <>", value, "sumsPays");
            return (Criteria) this;
        }

        public Criteria andSumsPaysGreaterThan(String value) {
            addCriterion("sums_pays >", value, "sumsPays");
            return (Criteria) this;
        }

        public Criteria andSumsPaysGreaterThanOrEqualTo(String value) {
            addCriterion("sums_pays >=", value, "sumsPays");
            return (Criteria) this;
        }

        public Criteria andSumsPaysLessThan(String value) {
            addCriterion("sums_pays <", value, "sumsPays");
            return (Criteria) this;
        }

        public Criteria andSumsPaysLessThanOrEqualTo(String value) {
            addCriterion("sums_pays <=", value, "sumsPays");
            return (Criteria) this;
        }

        public Criteria andSumsPaysLike(String value) {
            addCriterion("sums_pays like", value, "sumsPays");
            return (Criteria) this;
        }

        public Criteria andSumsPaysNotLike(String value) {
            addCriterion("sums_pays not like", value, "sumsPays");
            return (Criteria) this;
        }

        public Criteria andSumsPaysIn(List<String> values) {
            addCriterion("sums_pays in", values, "sumsPays");
            return (Criteria) this;
        }

        public Criteria andSumsPaysNotIn(List<String> values) {
            addCriterion("sums_pays not in", values, "sumsPays");
            return (Criteria) this;
        }

        public Criteria andSumsPaysBetween(String value1, String value2) {
            addCriterion("sums_pays between", value1, value2, "sumsPays");
            return (Criteria) this;
        }

        public Criteria andSumsPaysNotBetween(String value1, String value2) {
            addCriterion("sums_pays not between", value1, value2, "sumsPays");
            return (Criteria) this;
        }

        public Criteria andCritPaysIsNull() {
            addCriterion("crit_pays is null");
            return (Criteria) this;
        }

        public Criteria andCritPaysIsNotNull() {
            addCriterion("crit_pays is not null");
            return (Criteria) this;
        }

        public Criteria andCritPaysEqualTo(String value) {
            addCriterion("crit_pays =", value, "critPays");
            return (Criteria) this;
        }

        public Criteria andCritPaysNotEqualTo(String value) {
            addCriterion("crit_pays <>", value, "critPays");
            return (Criteria) this;
        }

        public Criteria andCritPaysGreaterThan(String value) {
            addCriterion("crit_pays >", value, "critPays");
            return (Criteria) this;
        }

        public Criteria andCritPaysGreaterThanOrEqualTo(String value) {
            addCriterion("crit_pays >=", value, "critPays");
            return (Criteria) this;
        }

        public Criteria andCritPaysLessThan(String value) {
            addCriterion("crit_pays <", value, "critPays");
            return (Criteria) this;
        }

        public Criteria andCritPaysLessThanOrEqualTo(String value) {
            addCriterion("crit_pays <=", value, "critPays");
            return (Criteria) this;
        }

        public Criteria andCritPaysLike(String value) {
            addCriterion("crit_pays like", value, "critPays");
            return (Criteria) this;
        }

        public Criteria andCritPaysNotLike(String value) {
            addCriterion("crit_pays not like", value, "critPays");
            return (Criteria) this;
        }

        public Criteria andCritPaysIn(List<String> values) {
            addCriterion("crit_pays in", values, "critPays");
            return (Criteria) this;
        }

        public Criteria andCritPaysNotIn(List<String> values) {
            addCriterion("crit_pays not in", values, "critPays");
            return (Criteria) this;
        }

        public Criteria andCritPaysBetween(String value1, String value2) {
            addCriterion("crit_pays between", value1, value2, "critPays");
            return (Criteria) this;
        }

        public Criteria andCritPaysNotBetween(String value1, String value2) {
            addCriterion("crit_pays not between", value1, value2, "critPays");
            return (Criteria) this;
        }

        public Criteria andSavePaysIsNull() {
            addCriterion("save_pays is null");
            return (Criteria) this;
        }

        public Criteria andSavePaysIsNotNull() {
            addCriterion("save_pays is not null");
            return (Criteria) this;
        }

        public Criteria andSavePaysEqualTo(String value) {
            addCriterion("save_pays =", value, "savePays");
            return (Criteria) this;
        }

        public Criteria andSavePaysNotEqualTo(String value) {
            addCriterion("save_pays <>", value, "savePays");
            return (Criteria) this;
        }

        public Criteria andSavePaysGreaterThan(String value) {
            addCriterion("save_pays >", value, "savePays");
            return (Criteria) this;
        }

        public Criteria andSavePaysGreaterThanOrEqualTo(String value) {
            addCriterion("save_pays >=", value, "savePays");
            return (Criteria) this;
        }

        public Criteria andSavePaysLessThan(String value) {
            addCriterion("save_pays <", value, "savePays");
            return (Criteria) this;
        }

        public Criteria andSavePaysLessThanOrEqualTo(String value) {
            addCriterion("save_pays <=", value, "savePays");
            return (Criteria) this;
        }

        public Criteria andSavePaysLike(String value) {
            addCriterion("save_pays like", value, "savePays");
            return (Criteria) this;
        }

        public Criteria andSavePaysNotLike(String value) {
            addCriterion("save_pays not like", value, "savePays");
            return (Criteria) this;
        }

        public Criteria andSavePaysIn(List<String> values) {
            addCriterion("save_pays in", values, "savePays");
            return (Criteria) this;
        }

        public Criteria andSavePaysNotIn(List<String> values) {
            addCriterion("save_pays not in", values, "savePays");
            return (Criteria) this;
        }

        public Criteria andSavePaysBetween(String value1, String value2) {
            addCriterion("save_pays between", value1, value2, "savePays");
            return (Criteria) this;
        }

        public Criteria andSavePaysNotBetween(String value1, String value2) {
            addCriterion("save_pays not between", value1, value2, "savePays");
            return (Criteria) this;
        }

        public Criteria andFoodPaysIsNull() {
            addCriterion("food_pays is null");
            return (Criteria) this;
        }

        public Criteria andFoodPaysIsNotNull() {
            addCriterion("food_pays is not null");
            return (Criteria) this;
        }

        public Criteria andFoodPaysEqualTo(String value) {
            addCriterion("food_pays =", value, "foodPays");
            return (Criteria) this;
        }

        public Criteria andFoodPaysNotEqualTo(String value) {
            addCriterion("food_pays <>", value, "foodPays");
            return (Criteria) this;
        }

        public Criteria andFoodPaysGreaterThan(String value) {
            addCriterion("food_pays >", value, "foodPays");
            return (Criteria) this;
        }

        public Criteria andFoodPaysGreaterThanOrEqualTo(String value) {
            addCriterion("food_pays >=", value, "foodPays");
            return (Criteria) this;
        }

        public Criteria andFoodPaysLessThan(String value) {
            addCriterion("food_pays <", value, "foodPays");
            return (Criteria) this;
        }

        public Criteria andFoodPaysLessThanOrEqualTo(String value) {
            addCriterion("food_pays <=", value, "foodPays");
            return (Criteria) this;
        }

        public Criteria andFoodPaysLike(String value) {
            addCriterion("food_pays like", value, "foodPays");
            return (Criteria) this;
        }

        public Criteria andFoodPaysNotLike(String value) {
            addCriterion("food_pays not like", value, "foodPays");
            return (Criteria) this;
        }

        public Criteria andFoodPaysIn(List<String> values) {
            addCriterion("food_pays in", values, "foodPays");
            return (Criteria) this;
        }

        public Criteria andFoodPaysNotIn(List<String> values) {
            addCriterion("food_pays not in", values, "foodPays");
            return (Criteria) this;
        }

        public Criteria andFoodPaysBetween(String value1, String value2) {
            addCriterion("food_pays between", value1, value2, "foodPays");
            return (Criteria) this;
        }

        public Criteria andFoodPaysNotBetween(String value1, String value2) {
            addCriterion("food_pays not between", value1, value2, "foodPays");
            return (Criteria) this;
        }

        public Criteria andTrafPaysIsNull() {
            addCriterion("traf_pays is null");
            return (Criteria) this;
        }

        public Criteria andTrafPaysIsNotNull() {
            addCriterion("traf_pays is not null");
            return (Criteria) this;
        }

        public Criteria andTrafPaysEqualTo(String value) {
            addCriterion("traf_pays =", value, "trafPays");
            return (Criteria) this;
        }

        public Criteria andTrafPaysNotEqualTo(String value) {
            addCriterion("traf_pays <>", value, "trafPays");
            return (Criteria) this;
        }

        public Criteria andTrafPaysGreaterThan(String value) {
            addCriterion("traf_pays >", value, "trafPays");
            return (Criteria) this;
        }

        public Criteria andTrafPaysGreaterThanOrEqualTo(String value) {
            addCriterion("traf_pays >=", value, "trafPays");
            return (Criteria) this;
        }

        public Criteria andTrafPaysLessThan(String value) {
            addCriterion("traf_pays <", value, "trafPays");
            return (Criteria) this;
        }

        public Criteria andTrafPaysLessThanOrEqualTo(String value) {
            addCriterion("traf_pays <=", value, "trafPays");
            return (Criteria) this;
        }

        public Criteria andTrafPaysLike(String value) {
            addCriterion("traf_pays like", value, "trafPays");
            return (Criteria) this;
        }

        public Criteria andTrafPaysNotLike(String value) {
            addCriterion("traf_pays not like", value, "trafPays");
            return (Criteria) this;
        }

        public Criteria andTrafPaysIn(List<String> values) {
            addCriterion("traf_pays in", values, "trafPays");
            return (Criteria) this;
        }

        public Criteria andTrafPaysNotIn(List<String> values) {
            addCriterion("traf_pays not in", values, "trafPays");
            return (Criteria) this;
        }

        public Criteria andTrafPaysBetween(String value1, String value2) {
            addCriterion("traf_pays between", value1, value2, "trafPays");
            return (Criteria) this;
        }

        public Criteria andTrafPaysNotBetween(String value1, String value2) {
            addCriterion("traf_pays not between", value1, value2, "trafPays");
            return (Criteria) this;
        }

        public Criteria andTbigPaysIsNull() {
            addCriterion("tbig_pays is null");
            return (Criteria) this;
        }

        public Criteria andTbigPaysIsNotNull() {
            addCriterion("tbig_pays is not null");
            return (Criteria) this;
        }

        public Criteria andTbigPaysEqualTo(String value) {
            addCriterion("tbig_pays =", value, "tbigPays");
            return (Criteria) this;
        }

        public Criteria andTbigPaysNotEqualTo(String value) {
            addCriterion("tbig_pays <>", value, "tbigPays");
            return (Criteria) this;
        }

        public Criteria andTbigPaysGreaterThan(String value) {
            addCriterion("tbig_pays >", value, "tbigPays");
            return (Criteria) this;
        }

        public Criteria andTbigPaysGreaterThanOrEqualTo(String value) {
            addCriterion("tbig_pays >=", value, "tbigPays");
            return (Criteria) this;
        }

        public Criteria andTbigPaysLessThan(String value) {
            addCriterion("tbig_pays <", value, "tbigPays");
            return (Criteria) this;
        }

        public Criteria andTbigPaysLessThanOrEqualTo(String value) {
            addCriterion("tbig_pays <=", value, "tbigPays");
            return (Criteria) this;
        }

        public Criteria andTbigPaysLike(String value) {
            addCriterion("tbig_pays like", value, "tbigPays");
            return (Criteria) this;
        }

        public Criteria andTbigPaysNotLike(String value) {
            addCriterion("tbig_pays not like", value, "tbigPays");
            return (Criteria) this;
        }

        public Criteria andTbigPaysIn(List<String> values) {
            addCriterion("tbig_pays in", values, "tbigPays");
            return (Criteria) this;
        }

        public Criteria andTbigPaysNotIn(List<String> values) {
            addCriterion("tbig_pays not in", values, "tbigPays");
            return (Criteria) this;
        }

        public Criteria andTbigPaysBetween(String value1, String value2) {
            addCriterion("tbig_pays between", value1, value2, "tbigPays");
            return (Criteria) this;
        }

        public Criteria andTbigPaysNotBetween(String value1, String value2) {
            addCriterion("tbig_pays not between", value1, value2, "tbigPays");
            return (Criteria) this;
        }

        public Criteria andTnetProfIsNull() {
            addCriterion("tnet_prof is null");
            return (Criteria) this;
        }

        public Criteria andTnetProfIsNotNull() {
            addCriterion("tnet_prof is not null");
            return (Criteria) this;
        }

        public Criteria andTnetProfEqualTo(String value) {
            addCriterion("tnet_prof =", value, "tnetProf");
            return (Criteria) this;
        }

        public Criteria andTnetProfNotEqualTo(String value) {
            addCriterion("tnet_prof <>", value, "tnetProf");
            return (Criteria) this;
        }

        public Criteria andTnetProfGreaterThan(String value) {
            addCriterion("tnet_prof >", value, "tnetProf");
            return (Criteria) this;
        }

        public Criteria andTnetProfGreaterThanOrEqualTo(String value) {
            addCriterion("tnet_prof >=", value, "tnetProf");
            return (Criteria) this;
        }

        public Criteria andTnetProfLessThan(String value) {
            addCriterion("tnet_prof <", value, "tnetProf");
            return (Criteria) this;
        }

        public Criteria andTnetProfLessThanOrEqualTo(String value) {
            addCriterion("tnet_prof <=", value, "tnetProf");
            return (Criteria) this;
        }

        public Criteria andTnetProfLike(String value) {
            addCriterion("tnet_prof like", value, "tnetProf");
            return (Criteria) this;
        }

        public Criteria andTnetProfNotLike(String value) {
            addCriterion("tnet_prof not like", value, "tnetProf");
            return (Criteria) this;
        }

        public Criteria andTnetProfIn(List<String> values) {
            addCriterion("tnet_prof in", values, "tnetProf");
            return (Criteria) this;
        }

        public Criteria andTnetProfNotIn(List<String> values) {
            addCriterion("tnet_prof not in", values, "tnetProf");
            return (Criteria) this;
        }

        public Criteria andTnetProfBetween(String value1, String value2) {
            addCriterion("tnet_prof between", value1, value2, "tnetProf");
            return (Criteria) this;
        }

        public Criteria andTnetProfNotBetween(String value1, String value2) {
            addCriterion("tnet_prof not between", value1, value2, "tnetProf");
            return (Criteria) this;
        }

        public Criteria andHousPaysIsNull() {
            addCriterion("hous_pays is null");
            return (Criteria) this;
        }

        public Criteria andHousPaysIsNotNull() {
            addCriterion("hous_pays is not null");
            return (Criteria) this;
        }

        public Criteria andHousPaysEqualTo(String value) {
            addCriterion("hous_pays =", value, "housPays");
            return (Criteria) this;
        }

        public Criteria andHousPaysNotEqualTo(String value) {
            addCriterion("hous_pays <>", value, "housPays");
            return (Criteria) this;
        }

        public Criteria andHousPaysGreaterThan(String value) {
            addCriterion("hous_pays >", value, "housPays");
            return (Criteria) this;
        }

        public Criteria andHousPaysGreaterThanOrEqualTo(String value) {
            addCriterion("hous_pays >=", value, "housPays");
            return (Criteria) this;
        }

        public Criteria andHousPaysLessThan(String value) {
            addCriterion("hous_pays <", value, "housPays");
            return (Criteria) this;
        }

        public Criteria andHousPaysLessThanOrEqualTo(String value) {
            addCriterion("hous_pays <=", value, "housPays");
            return (Criteria) this;
        }

        public Criteria andHousPaysLike(String value) {
            addCriterion("hous_pays like", value, "housPays");
            return (Criteria) this;
        }

        public Criteria andHousPaysNotLike(String value) {
            addCriterion("hous_pays not like", value, "housPays");
            return (Criteria) this;
        }

        public Criteria andHousPaysIn(List<String> values) {
            addCriterion("hous_pays in", values, "housPays");
            return (Criteria) this;
        }

        public Criteria andHousPaysNotIn(List<String> values) {
            addCriterion("hous_pays not in", values, "housPays");
            return (Criteria) this;
        }

        public Criteria andHousPaysBetween(String value1, String value2) {
            addCriterion("hous_pays between", value1, value2, "housPays");
            return (Criteria) this;
        }

        public Criteria andHousPaysNotBetween(String value1, String value2) {
            addCriterion("hous_pays not between", value1, value2, "housPays");
            return (Criteria) this;
        }

        public Criteria andTpayBackIsNull() {
            addCriterion("tpay_back is null");
            return (Criteria) this;
        }

        public Criteria andTpayBackIsNotNull() {
            addCriterion("tpay_back is not null");
            return (Criteria) this;
        }

        public Criteria andTpayBackEqualTo(String value) {
            addCriterion("tpay_back =", value, "tpayBack");
            return (Criteria) this;
        }

        public Criteria andTpayBackNotEqualTo(String value) {
            addCriterion("tpay_back <>", value, "tpayBack");
            return (Criteria) this;
        }

        public Criteria andTpayBackGreaterThan(String value) {
            addCriterion("tpay_back >", value, "tpayBack");
            return (Criteria) this;
        }

        public Criteria andTpayBackGreaterThanOrEqualTo(String value) {
            addCriterion("tpay_back >=", value, "tpayBack");
            return (Criteria) this;
        }

        public Criteria andTpayBackLessThan(String value) {
            addCriterion("tpay_back <", value, "tpayBack");
            return (Criteria) this;
        }

        public Criteria andTpayBackLessThanOrEqualTo(String value) {
            addCriterion("tpay_back <=", value, "tpayBack");
            return (Criteria) this;
        }

        public Criteria andTpayBackLike(String value) {
            addCriterion("tpay_back like", value, "tpayBack");
            return (Criteria) this;
        }

        public Criteria andTpayBackNotLike(String value) {
            addCriterion("tpay_back not like", value, "tpayBack");
            return (Criteria) this;
        }

        public Criteria andTpayBackIn(List<String> values) {
            addCriterion("tpay_back in", values, "tpayBack");
            return (Criteria) this;
        }

        public Criteria andTpayBackNotIn(List<String> values) {
            addCriterion("tpay_back not in", values, "tpayBack");
            return (Criteria) this;
        }

        public Criteria andTpayBackBetween(String value1, String value2) {
            addCriterion("tpay_back between", value1, value2, "tpayBack");
            return (Criteria) this;
        }

        public Criteria andTpayBackNotBetween(String value1, String value2) {
            addCriterion("tpay_back not between", value1, value2, "tpayBack");
            return (Criteria) this;
        }

        public Criteria andPlayPaysIsNull() {
            addCriterion("play_pays is null");
            return (Criteria) this;
        }

        public Criteria andPlayPaysIsNotNull() {
            addCriterion("play_pays is not null");
            return (Criteria) this;
        }

        public Criteria andPlayPaysEqualTo(String value) {
            addCriterion("play_pays =", value, "playPays");
            return (Criteria) this;
        }

        public Criteria andPlayPaysNotEqualTo(String value) {
            addCriterion("play_pays <>", value, "playPays");
            return (Criteria) this;
        }

        public Criteria andPlayPaysGreaterThan(String value) {
            addCriterion("play_pays >", value, "playPays");
            return (Criteria) this;
        }

        public Criteria andPlayPaysGreaterThanOrEqualTo(String value) {
            addCriterion("play_pays >=", value, "playPays");
            return (Criteria) this;
        }

        public Criteria andPlayPaysLessThan(String value) {
            addCriterion("play_pays <", value, "playPays");
            return (Criteria) this;
        }

        public Criteria andPlayPaysLessThanOrEqualTo(String value) {
            addCriterion("play_pays <=", value, "playPays");
            return (Criteria) this;
        }

        public Criteria andPlayPaysLike(String value) {
            addCriterion("play_pays like", value, "playPays");
            return (Criteria) this;
        }

        public Criteria andPlayPaysNotLike(String value) {
            addCriterion("play_pays not like", value, "playPays");
            return (Criteria) this;
        }

        public Criteria andPlayPaysIn(List<String> values) {
            addCriterion("play_pays in", values, "playPays");
            return (Criteria) this;
        }

        public Criteria andPlayPaysNotIn(List<String> values) {
            addCriterion("play_pays not in", values, "playPays");
            return (Criteria) this;
        }

        public Criteria andPlayPaysBetween(String value1, String value2) {
            addCriterion("play_pays between", value1, value2, "playPays");
            return (Criteria) this;
        }

        public Criteria andPlayPaysNotBetween(String value1, String value2) {
            addCriterion("play_pays not between", value1, value2, "playPays");
            return (Criteria) this;
        }

        public Criteria andShopPaysIsNull() {
            addCriterion("shop_pays is null");
            return (Criteria) this;
        }

        public Criteria andShopPaysIsNotNull() {
            addCriterion("shop_pays is not null");
            return (Criteria) this;
        }

        public Criteria andShopPaysEqualTo(String value) {
            addCriterion("shop_pays =", value, "shopPays");
            return (Criteria) this;
        }

        public Criteria andShopPaysNotEqualTo(String value) {
            addCriterion("shop_pays <>", value, "shopPays");
            return (Criteria) this;
        }

        public Criteria andShopPaysGreaterThan(String value) {
            addCriterion("shop_pays >", value, "shopPays");
            return (Criteria) this;
        }

        public Criteria andShopPaysGreaterThanOrEqualTo(String value) {
            addCriterion("shop_pays >=", value, "shopPays");
            return (Criteria) this;
        }

        public Criteria andShopPaysLessThan(String value) {
            addCriterion("shop_pays <", value, "shopPays");
            return (Criteria) this;
        }

        public Criteria andShopPaysLessThanOrEqualTo(String value) {
            addCriterion("shop_pays <=", value, "shopPays");
            return (Criteria) this;
        }

        public Criteria andShopPaysLike(String value) {
            addCriterion("shop_pays like", value, "shopPays");
            return (Criteria) this;
        }

        public Criteria andShopPaysNotLike(String value) {
            addCriterion("shop_pays not like", value, "shopPays");
            return (Criteria) this;
        }

        public Criteria andShopPaysIn(List<String> values) {
            addCriterion("shop_pays in", values, "shopPays");
            return (Criteria) this;
        }

        public Criteria andShopPaysNotIn(List<String> values) {
            addCriterion("shop_pays not in", values, "shopPays");
            return (Criteria) this;
        }

        public Criteria andShopPaysBetween(String value1, String value2) {
            addCriterion("shop_pays between", value1, value2, "shopPays");
            return (Criteria) this;
        }

        public Criteria andShopPaysNotBetween(String value1, String value2) {
            addCriterion("shop_pays not between", value1, value2, "shopPays");
            return (Criteria) this;
        }

        public Criteria andLiftPaysIsNull() {
            addCriterion("lift_pays is null");
            return (Criteria) this;
        }

        public Criteria andLiftPaysIsNotNull() {
            addCriterion("lift_pays is not null");
            return (Criteria) this;
        }

        public Criteria andLiftPaysEqualTo(String value) {
            addCriterion("lift_pays =", value, "liftPays");
            return (Criteria) this;
        }

        public Criteria andLiftPaysNotEqualTo(String value) {
            addCriterion("lift_pays <>", value, "liftPays");
            return (Criteria) this;
        }

        public Criteria andLiftPaysGreaterThan(String value) {
            addCriterion("lift_pays >", value, "liftPays");
            return (Criteria) this;
        }

        public Criteria andLiftPaysGreaterThanOrEqualTo(String value) {
            addCriterion("lift_pays >=", value, "liftPays");
            return (Criteria) this;
        }

        public Criteria andLiftPaysLessThan(String value) {
            addCriterion("lift_pays <", value, "liftPays");
            return (Criteria) this;
        }

        public Criteria andLiftPaysLessThanOrEqualTo(String value) {
            addCriterion("lift_pays <=", value, "liftPays");
            return (Criteria) this;
        }

        public Criteria andLiftPaysLike(String value) {
            addCriterion("lift_pays like", value, "liftPays");
            return (Criteria) this;
        }

        public Criteria andLiftPaysNotLike(String value) {
            addCriterion("lift_pays not like", value, "liftPays");
            return (Criteria) this;
        }

        public Criteria andLiftPaysIn(List<String> values) {
            addCriterion("lift_pays in", values, "liftPays");
            return (Criteria) this;
        }

        public Criteria andLiftPaysNotIn(List<String> values) {
            addCriterion("lift_pays not in", values, "liftPays");
            return (Criteria) this;
        }

        public Criteria andLiftPaysBetween(String value1, String value2) {
            addCriterion("lift_pays between", value1, value2, "liftPays");
            return (Criteria) this;
        }

        public Criteria andLiftPaysNotBetween(String value1, String value2) {
            addCriterion("lift_pays not between", value1, value2, "liftPays");
            return (Criteria) this;
        }

        public Criteria andOthrPaysIsNull() {
            addCriterion("othr_pays is null");
            return (Criteria) this;
        }

        public Criteria andOthrPaysIsNotNull() {
            addCriterion("othr_pays is not null");
            return (Criteria) this;
        }

        public Criteria andOthrPaysEqualTo(String value) {
            addCriterion("othr_pays =", value, "othrPays");
            return (Criteria) this;
        }

        public Criteria andOthrPaysNotEqualTo(String value) {
            addCriterion("othr_pays <>", value, "othrPays");
            return (Criteria) this;
        }

        public Criteria andOthrPaysGreaterThan(String value) {
            addCriterion("othr_pays >", value, "othrPays");
            return (Criteria) this;
        }

        public Criteria andOthrPaysGreaterThanOrEqualTo(String value) {
            addCriterion("othr_pays >=", value, "othrPays");
            return (Criteria) this;
        }

        public Criteria andOthrPaysLessThan(String value) {
            addCriterion("othr_pays <", value, "othrPays");
            return (Criteria) this;
        }

        public Criteria andOthrPaysLessThanOrEqualTo(String value) {
            addCriterion("othr_pays <=", value, "othrPays");
            return (Criteria) this;
        }

        public Criteria andOthrPaysLike(String value) {
            addCriterion("othr_pays like", value, "othrPays");
            return (Criteria) this;
        }

        public Criteria andOthrPaysNotLike(String value) {
            addCriterion("othr_pays not like", value, "othrPays");
            return (Criteria) this;
        }

        public Criteria andOthrPaysIn(List<String> values) {
            addCriterion("othr_pays in", values, "othrPays");
            return (Criteria) this;
        }

        public Criteria andOthrPaysNotIn(List<String> values) {
            addCriterion("othr_pays not in", values, "othrPays");
            return (Criteria) this;
        }

        public Criteria andOthrPaysBetween(String value1, String value2) {
            addCriterion("othr_pays between", value1, value2, "othrPays");
            return (Criteria) this;
        }

        public Criteria andOthrPaysNotBetween(String value1, String value2) {
            addCriterion("othr_pays not between", value1, value2, "othrPays");
            return (Criteria) this;
        }

        public Criteria andChckFlagIsNull() {
            addCriterion("chck_flag is null");
            return (Criteria) this;
        }

        public Criteria andChckFlagIsNotNull() {
            addCriterion("chck_flag is not null");
            return (Criteria) this;
        }

        public Criteria andChckFlagEqualTo(String value) {
            addCriterion("chck_flag =", value, "chckFlag");
            return (Criteria) this;
        }

        public Criteria andChckFlagNotEqualTo(String value) {
            addCriterion("chck_flag <>", value, "chckFlag");
            return (Criteria) this;
        }

        public Criteria andChckFlagGreaterThan(String value) {
            addCriterion("chck_flag >", value, "chckFlag");
            return (Criteria) this;
        }

        public Criteria andChckFlagGreaterThanOrEqualTo(String value) {
            addCriterion("chck_flag >=", value, "chckFlag");
            return (Criteria) this;
        }

        public Criteria andChckFlagLessThan(String value) {
            addCriterion("chck_flag <", value, "chckFlag");
            return (Criteria) this;
        }

        public Criteria andChckFlagLessThanOrEqualTo(String value) {
            addCriterion("chck_flag <=", value, "chckFlag");
            return (Criteria) this;
        }

        public Criteria andChckFlagLike(String value) {
            addCriterion("chck_flag like", value, "chckFlag");
            return (Criteria) this;
        }

        public Criteria andChckFlagNotLike(String value) {
            addCriterion("chck_flag not like", value, "chckFlag");
            return (Criteria) this;
        }

        public Criteria andChckFlagIn(List<String> values) {
            addCriterion("chck_flag in", values, "chckFlag");
            return (Criteria) this;
        }

        public Criteria andChckFlagNotIn(List<String> values) {
            addCriterion("chck_flag not in", values, "chckFlag");
            return (Criteria) this;
        }

        public Criteria andChckFlagBetween(String value1, String value2) {
            addCriterion("chck_flag between", value1, value2, "chckFlag");
            return (Criteria) this;
        }

        public Criteria andChckFlagNotBetween(String value1, String value2) {
            addCriterion("chck_flag not between", value1, value2, "chckFlag");
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