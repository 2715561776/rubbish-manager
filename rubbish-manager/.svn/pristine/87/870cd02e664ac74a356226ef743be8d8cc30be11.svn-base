package com.richeninfo.rubbish.service.util;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by xuliangjun on 15/12/23.
 */
public class AppResponse {
    public static final String STATUS_ERROR = "99";  //服务器异常
    public static final String STATUS_ERROR_98 = "98";  //参数异常
    public static final String STATUS_ERROR_97 = "97";  //验签错误
    public static final String STATUS_SUCCESS = "1"; //调用成功

    private Object data;
    private String status;
    private String msg;
    private Integer total;  //统计多少条

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        try {
//            this.msg = DESUtil.encode(msg);
            this.msg = msg;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AppResponse newError(String msg){
        AppResponse rsp = new AppResponse();
        rsp.setStatus(AppResponse.STATUS_ERROR);
        rsp.setMsg(msg);
        return rsp;
    }

    public static AppResponse newSuccess(String msg){
        AppResponse rsp = new AppResponse();
        rsp.setStatus(AppResponse.STATUS_SUCCESS);
        rsp.setMsg(msg);
        return rsp;
    }

    public static AppResponse newResponse(String status, String msg){
        AppResponse rsp = new AppResponse();
        rsp.setStatus(status);
        rsp.setMsg(msg);
        return rsp;
    }

    public String toJSONString() {
        return JSONObject.toJSONString(this,false);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this,false);
    }
}
