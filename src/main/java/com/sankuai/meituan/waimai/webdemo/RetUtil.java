package com.sankuai.meituan.waimai.webdemo;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by yanxuri on 2016年11月10日
 */
public class RetUtil {

    public enum Ret {
        SUCCESS_200(200, "success"), FAILED_500(500, "failed");
        public int code;
        public String msg;

        private Ret(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }
    }

    public static JSONObject success() {
        return ret(Ret.SUCCESS_200.code, Ret.SUCCESS_200.msg, null);
    }

    public static JSONObject success(Object data) {
        return ret(Ret.SUCCESS_200.code, Ret.SUCCESS_200.msg, data);
    }

    public static JSONObject success(String msg, Object data) {
        return ret(Ret.SUCCESS_200.code, msg, data);
    }

    public static JSONObject success(Object data, Object page) {
        return ret(Ret.SUCCESS_200.code, Ret.SUCCESS_200.msg, data, page);
    }

    public static JSONObject failed() {
        return ret(Ret.FAILED_500.code, Ret.FAILED_500.msg, null);
    }

    public static JSONObject failed(String msg) {
        return ret(Ret.FAILED_500.code, msg, null);
    }

    public static JSONObject failed(String msg, Object data) {
        return ret(Ret.FAILED_500.code, msg, data);
    }


    public static JSONObject ret(int code, String msg, Object data) {
        JSONObject jo = new JSONObject();
        jo.put("code", code);
        jo.put("msg", msg);
        jo.put("data", data);
        return jo;
    }

    public static JSONObject ret(int code, String msg, Object data, Object page) {
        JSONObject jo = new JSONObject();
        jo.put("code", code);
        jo.put("msg", msg);
        jo.put("page", page);
        jo.put("data", data);
        return jo;
    }

    public static JSONObject transfer2Json(String key,Object val){
        JSONObject jo = new JSONObject();
        jo.put(key,val);
        return jo;
    }

}