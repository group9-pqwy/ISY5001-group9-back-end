package nus.iss.ais.carquest.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SearchHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SearchHistoryExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andSearchIdIsNull() {
            addCriterion("search_id is null");
            return (Criteria) this;
        }

        public Criteria andSearchIdIsNotNull() {
            addCriterion("search_id is not null");
            return (Criteria) this;
        }

        public Criteria andSearchIdEqualTo(Integer value) {
            addCriterion("search_id =", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdNotEqualTo(Integer value) {
            addCriterion("search_id <>", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdGreaterThan(Integer value) {
            addCriterion("search_id >", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("search_id >=", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdLessThan(Integer value) {
            addCriterion("search_id <", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdLessThanOrEqualTo(Integer value) {
            addCriterion("search_id <=", value, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdIn(List<Integer> values) {
            addCriterion("search_id in", values, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdNotIn(List<Integer> values) {
            addCriterion("search_id not in", values, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdBetween(Integer value1, Integer value2) {
            addCriterion("search_id between", value1, value2, "searchId");
            return (Criteria) this;
        }

        public Criteria andSearchIdNotBetween(Integer value1, Integer value2) {
            addCriterion("search_id not between", value1, value2, "searchId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andMakeIsNull() {
            addCriterion("make is null");
            return (Criteria) this;
        }

        public Criteria andMakeIsNotNull() {
            addCriterion("make is not null");
            return (Criteria) this;
        }

        public Criteria andMakeEqualTo(String value) {
            addCriterion("make =", value, "make");
            return (Criteria) this;
        }

        public Criteria andMakeNotEqualTo(String value) {
            addCriterion("make <>", value, "make");
            return (Criteria) this;
        }

        public Criteria andMakeGreaterThan(String value) {
            addCriterion("make >", value, "make");
            return (Criteria) this;
        }

        public Criteria andMakeGreaterThanOrEqualTo(String value) {
            addCriterion("make >=", value, "make");
            return (Criteria) this;
        }

        public Criteria andMakeLessThan(String value) {
            addCriterion("make <", value, "make");
            return (Criteria) this;
        }

        public Criteria andMakeLessThanOrEqualTo(String value) {
            addCriterion("make <=", value, "make");
            return (Criteria) this;
        }

        public Criteria andMakeLike(String value) {
            addCriterion("make like", value, "make");
            return (Criteria) this;
        }

        public Criteria andMakeNotLike(String value) {
            addCriterion("make not like", value, "make");
            return (Criteria) this;
        }

        public Criteria andMakeIn(List<String> values) {
            addCriterion("make in", values, "make");
            return (Criteria) this;
        }

        public Criteria andMakeNotIn(List<String> values) {
            addCriterion("make not in", values, "make");
            return (Criteria) this;
        }

        public Criteria andMakeBetween(String value1, String value2) {
            addCriterion("make between", value1, value2, "make");
            return (Criteria) this;
        }

        public Criteria andMakeNotBetween(String value1, String value2) {
            addCriterion("make not between", value1, value2, "make");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andTrimIsNull() {
            addCriterion("trim is null");
            return (Criteria) this;
        }

        public Criteria andTrimIsNotNull() {
            addCriterion("trim is not null");
            return (Criteria) this;
        }

        public Criteria andTrimEqualTo(String value) {
            addCriterion("trim =", value, "trim");
            return (Criteria) this;
        }

        public Criteria andTrimNotEqualTo(String value) {
            addCriterion("trim <>", value, "trim");
            return (Criteria) this;
        }

        public Criteria andTrimGreaterThan(String value) {
            addCriterion("trim >", value, "trim");
            return (Criteria) this;
        }

        public Criteria andTrimGreaterThanOrEqualTo(String value) {
            addCriterion("trim >=", value, "trim");
            return (Criteria) this;
        }

        public Criteria andTrimLessThan(String value) {
            addCriterion("trim <", value, "trim");
            return (Criteria) this;
        }

        public Criteria andTrimLessThanOrEqualTo(String value) {
            addCriterion("trim <=", value, "trim");
            return (Criteria) this;
        }

        public Criteria andTrimLike(String value) {
            addCriterion("trim like", value, "trim");
            return (Criteria) this;
        }

        public Criteria andTrimNotLike(String value) {
            addCriterion("trim not like", value, "trim");
            return (Criteria) this;
        }

        public Criteria andTrimIn(List<String> values) {
            addCriterion("trim in", values, "trim");
            return (Criteria) this;
        }

        public Criteria andTrimNotIn(List<String> values) {
            addCriterion("trim not in", values, "trim");
            return (Criteria) this;
        }

        public Criteria andTrimBetween(String value1, String value2) {
            addCriterion("trim between", value1, value2, "trim");
            return (Criteria) this;
        }

        public Criteria andTrimNotBetween(String value1, String value2) {
            addCriterion("trim not between", value1, value2, "trim");
            return (Criteria) this;
        }

        public Criteria andBodyIsNull() {
            addCriterion("body is null");
            return (Criteria) this;
        }

        public Criteria andBodyIsNotNull() {
            addCriterion("body is not null");
            return (Criteria) this;
        }

        public Criteria andBodyEqualTo(String value) {
            addCriterion("body =", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotEqualTo(String value) {
            addCriterion("body <>", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThan(String value) {
            addCriterion("body >", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThanOrEqualTo(String value) {
            addCriterion("body >=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThan(String value) {
            addCriterion("body <", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThanOrEqualTo(String value) {
            addCriterion("body <=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLike(String value) {
            addCriterion("body like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotLike(String value) {
            addCriterion("body not like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyIn(List<String> values) {
            addCriterion("body in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotIn(List<String> values) {
            addCriterion("body not in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyBetween(String value1, String value2) {
            addCriterion("body between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotBetween(String value1, String value2) {
            addCriterion("body not between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andTransmissionIsNull() {
            addCriterion("transmission is null");
            return (Criteria) this;
        }

        public Criteria andTransmissionIsNotNull() {
            addCriterion("transmission is not null");
            return (Criteria) this;
        }

        public Criteria andTransmissionEqualTo(String value) {
            addCriterion("transmission =", value, "transmission");
            return (Criteria) this;
        }

        public Criteria andTransmissionNotEqualTo(String value) {
            addCriterion("transmission <>", value, "transmission");
            return (Criteria) this;
        }

        public Criteria andTransmissionGreaterThan(String value) {
            addCriterion("transmission >", value, "transmission");
            return (Criteria) this;
        }

        public Criteria andTransmissionGreaterThanOrEqualTo(String value) {
            addCriterion("transmission >=", value, "transmission");
            return (Criteria) this;
        }

        public Criteria andTransmissionLessThan(String value) {
            addCriterion("transmission <", value, "transmission");
            return (Criteria) this;
        }

        public Criteria andTransmissionLessThanOrEqualTo(String value) {
            addCriterion("transmission <=", value, "transmission");
            return (Criteria) this;
        }

        public Criteria andTransmissionLike(String value) {
            addCriterion("transmission like", value, "transmission");
            return (Criteria) this;
        }

        public Criteria andTransmissionNotLike(String value) {
            addCriterion("transmission not like", value, "transmission");
            return (Criteria) this;
        }

        public Criteria andTransmissionIn(List<String> values) {
            addCriterion("transmission in", values, "transmission");
            return (Criteria) this;
        }

        public Criteria andTransmissionNotIn(List<String> values) {
            addCriterion("transmission not in", values, "transmission");
            return (Criteria) this;
        }

        public Criteria andTransmissionBetween(String value1, String value2) {
            addCriterion("transmission between", value1, value2, "transmission");
            return (Criteria) this;
        }

        public Criteria andTransmissionNotBetween(String value1, String value2) {
            addCriterion("transmission not between", value1, value2, "transmission");
            return (Criteria) this;
        }

        public Criteria andVinIsNull() {
            addCriterion("vin is null");
            return (Criteria) this;
        }

        public Criteria andVinIsNotNull() {
            addCriterion("vin is not null");
            return (Criteria) this;
        }

        public Criteria andVinEqualTo(String value) {
            addCriterion("vin =", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotEqualTo(String value) {
            addCriterion("vin <>", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinGreaterThan(String value) {
            addCriterion("vin >", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinGreaterThanOrEqualTo(String value) {
            addCriterion("vin >=", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLessThan(String value) {
            addCriterion("vin <", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLessThanOrEqualTo(String value) {
            addCriterion("vin <=", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLike(String value) {
            addCriterion("vin like", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotLike(String value) {
            addCriterion("vin not like", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinIn(List<String> values) {
            addCriterion("vin in", values, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotIn(List<String> values) {
            addCriterion("vin not in", values, "vin");
            return (Criteria) this;
        }

        public Criteria andVinBetween(String value1, String value2) {
            addCriterion("vin between", value1, value2, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotBetween(String value1, String value2) {
            addCriterion("vin not between", value1, value2, "vin");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andConditionIsNull() {
            addCriterion("condition is null");
            return (Criteria) this;
        }

        public Criteria andConditionIsNotNull() {
            addCriterion("condition is not null");
            return (Criteria) this;
        }

        public Criteria andConditionEqualTo(String value) {
            addCriterion("condition =", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotEqualTo(String value) {
            addCriterion("condition <>", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionGreaterThan(String value) {
            addCriterion("condition >", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionGreaterThanOrEqualTo(String value) {
            addCriterion("condition >=", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLessThan(String value) {
            addCriterion("condition <", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLessThanOrEqualTo(String value) {
            addCriterion("condition <=", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionLike(String value) {
            addCriterion("condition like", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotLike(String value) {
            addCriterion("condition not like", value, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionIn(List<String> values) {
            addCriterion("condition in", values, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotIn(List<String> values) {
            addCriterion("condition not in", values, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionBetween(String value1, String value2) {
            addCriterion("condition between", value1, value2, "condition");
            return (Criteria) this;
        }

        public Criteria andConditionNotBetween(String value1, String value2) {
            addCriterion("condition not between", value1, value2, "condition");
            return (Criteria) this;
        }

        public Criteria andMinOdometerIsNull() {
            addCriterion("min_odometer is null");
            return (Criteria) this;
        }

        public Criteria andMinOdometerIsNotNull() {
            addCriterion("min_odometer is not null");
            return (Criteria) this;
        }

        public Criteria andMinOdometerEqualTo(Integer value) {
            addCriterion("min_odometer =", value, "minOdometer");
            return (Criteria) this;
        }

        public Criteria andMinOdometerNotEqualTo(Integer value) {
            addCriterion("min_odometer <>", value, "minOdometer");
            return (Criteria) this;
        }

        public Criteria andMinOdometerGreaterThan(Integer value) {
            addCriterion("min_odometer >", value, "minOdometer");
            return (Criteria) this;
        }

        public Criteria andMinOdometerGreaterThanOrEqualTo(Integer value) {
            addCriterion("min_odometer >=", value, "minOdometer");
            return (Criteria) this;
        }

        public Criteria andMinOdometerLessThan(Integer value) {
            addCriterion("min_odometer <", value, "minOdometer");
            return (Criteria) this;
        }

        public Criteria andMinOdometerLessThanOrEqualTo(Integer value) {
            addCriterion("min_odometer <=", value, "minOdometer");
            return (Criteria) this;
        }

        public Criteria andMinOdometerIn(List<Integer> values) {
            addCriterion("min_odometer in", values, "minOdometer");
            return (Criteria) this;
        }

        public Criteria andMinOdometerNotIn(List<Integer> values) {
            addCriterion("min_odometer not in", values, "minOdometer");
            return (Criteria) this;
        }

        public Criteria andMinOdometerBetween(Integer value1, Integer value2) {
            addCriterion("min_odometer between", value1, value2, "minOdometer");
            return (Criteria) this;
        }

        public Criteria andMinOdometerNotBetween(Integer value1, Integer value2) {
            addCriterion("min_odometer not between", value1, value2, "minOdometer");
            return (Criteria) this;
        }

        public Criteria andMaxOdometerIsNull() {
            addCriterion("max_odometer is null");
            return (Criteria) this;
        }

        public Criteria andMaxOdometerIsNotNull() {
            addCriterion("max_odometer is not null");
            return (Criteria) this;
        }

        public Criteria andMaxOdometerEqualTo(Integer value) {
            addCriterion("max_odometer =", value, "maxOdometer");
            return (Criteria) this;
        }

        public Criteria andMaxOdometerNotEqualTo(Integer value) {
            addCriterion("max_odometer <>", value, "maxOdometer");
            return (Criteria) this;
        }

        public Criteria andMaxOdometerGreaterThan(Integer value) {
            addCriterion("max_odometer >", value, "maxOdometer");
            return (Criteria) this;
        }

        public Criteria andMaxOdometerGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_odometer >=", value, "maxOdometer");
            return (Criteria) this;
        }

        public Criteria andMaxOdometerLessThan(Integer value) {
            addCriterion("max_odometer <", value, "maxOdometer");
            return (Criteria) this;
        }

        public Criteria andMaxOdometerLessThanOrEqualTo(Integer value) {
            addCriterion("max_odometer <=", value, "maxOdometer");
            return (Criteria) this;
        }

        public Criteria andMaxOdometerIn(List<Integer> values) {
            addCriterion("max_odometer in", values, "maxOdometer");
            return (Criteria) this;
        }

        public Criteria andMaxOdometerNotIn(List<Integer> values) {
            addCriterion("max_odometer not in", values, "maxOdometer");
            return (Criteria) this;
        }

        public Criteria andMaxOdometerBetween(Integer value1, Integer value2) {
            addCriterion("max_odometer between", value1, value2, "maxOdometer");
            return (Criteria) this;
        }

        public Criteria andMaxOdometerNotBetween(Integer value1, Integer value2) {
            addCriterion("max_odometer not between", value1, value2, "maxOdometer");
            return (Criteria) this;
        }

        public Criteria andInteriorIsNull() {
            addCriterion("interior is null");
            return (Criteria) this;
        }

        public Criteria andInteriorIsNotNull() {
            addCriterion("interior is not null");
            return (Criteria) this;
        }

        public Criteria andInteriorEqualTo(String value) {
            addCriterion("interior =", value, "interior");
            return (Criteria) this;
        }

        public Criteria andInteriorNotEqualTo(String value) {
            addCriterion("interior <>", value, "interior");
            return (Criteria) this;
        }

        public Criteria andInteriorGreaterThan(String value) {
            addCriterion("interior >", value, "interior");
            return (Criteria) this;
        }

        public Criteria andInteriorGreaterThanOrEqualTo(String value) {
            addCriterion("interior >=", value, "interior");
            return (Criteria) this;
        }

        public Criteria andInteriorLessThan(String value) {
            addCriterion("interior <", value, "interior");
            return (Criteria) this;
        }

        public Criteria andInteriorLessThanOrEqualTo(String value) {
            addCriterion("interior <=", value, "interior");
            return (Criteria) this;
        }

        public Criteria andInteriorLike(String value) {
            addCriterion("interior like", value, "interior");
            return (Criteria) this;
        }

        public Criteria andInteriorNotLike(String value) {
            addCriterion("interior not like", value, "interior");
            return (Criteria) this;
        }

        public Criteria andInteriorIn(List<String> values) {
            addCriterion("interior in", values, "interior");
            return (Criteria) this;
        }

        public Criteria andInteriorNotIn(List<String> values) {
            addCriterion("interior not in", values, "interior");
            return (Criteria) this;
        }

        public Criteria andInteriorBetween(String value1, String value2) {
            addCriterion("interior between", value1, value2, "interior");
            return (Criteria) this;
        }

        public Criteria andInteriorNotBetween(String value1, String value2) {
            addCriterion("interior not between", value1, value2, "interior");
            return (Criteria) this;
        }

        public Criteria andSellerIsNull() {
            addCriterion("seller is null");
            return (Criteria) this;
        }

        public Criteria andSellerIsNotNull() {
            addCriterion("seller is not null");
            return (Criteria) this;
        }

        public Criteria andSellerEqualTo(String value) {
            addCriterion("seller =", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotEqualTo(String value) {
            addCriterion("seller <>", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerGreaterThan(String value) {
            addCriterion("seller >", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerGreaterThanOrEqualTo(String value) {
            addCriterion("seller >=", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerLessThan(String value) {
            addCriterion("seller <", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerLessThanOrEqualTo(String value) {
            addCriterion("seller <=", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerLike(String value) {
            addCriterion("seller like", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotLike(String value) {
            addCriterion("seller not like", value, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerIn(List<String> values) {
            addCriterion("seller in", values, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotIn(List<String> values) {
            addCriterion("seller not in", values, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerBetween(String value1, String value2) {
            addCriterion("seller between", value1, value2, "seller");
            return (Criteria) this;
        }

        public Criteria andSellerNotBetween(String value1, String value2) {
            addCriterion("seller not between", value1, value2, "seller");
            return (Criteria) this;
        }

        public Criteria andMmrIsNull() {
            addCriterion("mmr is null");
            return (Criteria) this;
        }

        public Criteria andMmrIsNotNull() {
            addCriterion("mmr is not null");
            return (Criteria) this;
        }

        public Criteria andMmrEqualTo(BigDecimal value) {
            addCriterion("mmr =", value, "mmr");
            return (Criteria) this;
        }

        public Criteria andMmrNotEqualTo(BigDecimal value) {
            addCriterion("mmr <>", value, "mmr");
            return (Criteria) this;
        }

        public Criteria andMmrGreaterThan(BigDecimal value) {
            addCriterion("mmr >", value, "mmr");
            return (Criteria) this;
        }

        public Criteria andMmrGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mmr >=", value, "mmr");
            return (Criteria) this;
        }

        public Criteria andMmrLessThan(BigDecimal value) {
            addCriterion("mmr <", value, "mmr");
            return (Criteria) this;
        }

        public Criteria andMmrLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mmr <=", value, "mmr");
            return (Criteria) this;
        }

        public Criteria andMmrIn(List<BigDecimal> values) {
            addCriterion("mmr in", values, "mmr");
            return (Criteria) this;
        }

        public Criteria andMmrNotIn(List<BigDecimal> values) {
            addCriterion("mmr not in", values, "mmr");
            return (Criteria) this;
        }

        public Criteria andMmrBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mmr between", value1, value2, "mmr");
            return (Criteria) this;
        }

        public Criteria andMmrNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mmr not between", value1, value2, "mmr");
            return (Criteria) this;
        }

        public Criteria andMinPriceIsNull() {
            addCriterion("min_price is null");
            return (Criteria) this;
        }

        public Criteria andMinPriceIsNotNull() {
            addCriterion("min_price is not null");
            return (Criteria) this;
        }

        public Criteria andMinPriceEqualTo(BigDecimal value) {
            addCriterion("min_price =", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceNotEqualTo(BigDecimal value) {
            addCriterion("min_price <>", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceGreaterThan(BigDecimal value) {
            addCriterion("min_price >", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("min_price >=", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceLessThan(BigDecimal value) {
            addCriterion("min_price <", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("min_price <=", value, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceIn(List<BigDecimal> values) {
            addCriterion("min_price in", values, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceNotIn(List<BigDecimal> values) {
            addCriterion("min_price not in", values, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_price between", value1, value2, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMinPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_price not between", value1, value2, "minPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceIsNull() {
            addCriterion("max_price is null");
            return (Criteria) this;
        }

        public Criteria andMaxPriceIsNotNull() {
            addCriterion("max_price is not null");
            return (Criteria) this;
        }

        public Criteria andMaxPriceEqualTo(BigDecimal value) {
            addCriterion("max_price =", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceNotEqualTo(BigDecimal value) {
            addCriterion("max_price <>", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceGreaterThan(BigDecimal value) {
            addCriterion("max_price >", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_price >=", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceLessThan(BigDecimal value) {
            addCriterion("max_price <", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_price <=", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceIn(List<BigDecimal> values) {
            addCriterion("max_price in", values, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceNotIn(List<BigDecimal> values) {
            addCriterion("max_price not in", values, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_price between", value1, value2, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_price not between", value1, value2, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andSearchTimeIsNull() {
            addCriterion("search_time is null");
            return (Criteria) this;
        }

        public Criteria andSearchTimeIsNotNull() {
            addCriterion("search_time is not null");
            return (Criteria) this;
        }

        public Criteria andSearchTimeEqualTo(Date value) {
            addCriterion("search_time =", value, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeNotEqualTo(Date value) {
            addCriterion("search_time <>", value, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeGreaterThan(Date value) {
            addCriterion("search_time >", value, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("search_time >=", value, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeLessThan(Date value) {
            addCriterion("search_time <", value, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeLessThanOrEqualTo(Date value) {
            addCriterion("search_time <=", value, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeIn(List<Date> values) {
            addCriterion("search_time in", values, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeNotIn(List<Date> values) {
            addCriterion("search_time not in", values, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeBetween(Date value1, Date value2) {
            addCriterion("search_time between", value1, value2, "searchTime");
            return (Criteria) this;
        }

        public Criteria andSearchTimeNotBetween(Date value1, Date value2) {
            addCriterion("search_time not between", value1, value2, "searchTime");
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