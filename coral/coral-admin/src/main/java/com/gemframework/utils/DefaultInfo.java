package com.gemframework.utils;

import org.thymeleaf.standard.expression.Fragment;

import java.util.HashMap;
import java.util.Map;

public class  DefaultInfo {
    public static final String NO_ONE = "01";
    public static final String NO_TWO = "02";
    public static final String NO_THREE = "03";
    public static final String NO_FOUR = "04";
    public static final String NO_FIVE = "05";

    //合同状态
    public final static Map<String, String> CONTRACT_STATUS = new HashMap<String, String>() {
        {
            put(NO_ONE, "新签");
            put(NO_TWO, "续签");
            put(NO_THREE, "停止服务");
            put(NO_FOUR, "注销合同");
        }
    };

    //收费标准
    public final static Map<String, String> CHARGING_STANDARD = new HashMap<String, String>() {
        {
            put(NO_ONE, "月");
            put(NO_TWO, "季");
            put(NO_THREE, "年");
        }
    };

    //合同性质
    public final static Map<String, String> CONTRACT_NATURE = new HashMap<String, String>() {
        {
            put(NO_ONE, "小规模");
            put(NO_TWO, "一般纳税人");
            put(NO_THREE, "个体户");
            put(NO_FOUR, "个体一般纳税人");
        }
    };

    //合同性质
    public final static Map<String, String> IS_BILL = new HashMap<String, String>() {
        {
            put(NO_ONE, "是");
            put(NO_TWO, "否");
        }
    };


}
