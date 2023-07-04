package com.qf.ran.entity.vo;

import io.swagger.annotations.ApiModelProperty;

/*
 * @author:Ran
 * @since:JDK 1.8
 * @Date:2023/6/12
 *      PO：Persistent Object        持久对象        与数据库一致的对象
 *      BO：Business Object          业务对象        业务逻辑层需要的属性封装的对象
 *      VO：View/Value Object        视图/值对象     前端需要展示数据的对象
 *      DTO:Data Transfer Object     数据传输对象    进行跨域或者远程传输时使用的对象
 */
public class RespResult {
    //响应码
    @ApiModelProperty("响应码")
    private int status;
    //提示语句
    @ApiModelProperty("提示语句")
    private String msg;
    //数据
    @ApiModelProperty("数据")
    private Object data;

    private RespResult(){
    }
    private RespResult(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    //业务成功，携带提示语句和数据
    public static RespResult respSuccess(String msg, Object data){
        return new RespResult(200,msg,data);
    }
    //业务失败，携带提示语句和数据
    public static RespResult respError(String msg, Object data){
        return new RespResult(500,msg,data);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
