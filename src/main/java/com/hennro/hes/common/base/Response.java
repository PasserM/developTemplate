package com.hennro.hes.common.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by tianjianping in 2018/6/14
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private String code;
    private String msg;
    private T result;
    private T data;

    public static <T> Response<T> success(T data) {
        Response<T> response = new Response<>();
        response.setMsg("success");
        response.setCode("200");
        response.setResult(data);
        return response;
    }

    public static <T> Response<T> successReturn(T data) {
        Response<T> response = new Response<>();
        response.setMsg("success");
        response.setCode("200");
        response.setData(data);
        return response;
    }

    public static <T> Response<T> failure(T data) {
        Response response = new Response();
        response.setMsg("发生错误");
        response.setCode("500");
        response.setResult(data);
        return response;
    }

    public boolean isSuccess() {
        return "200".equals(this.getCode());
    }

}