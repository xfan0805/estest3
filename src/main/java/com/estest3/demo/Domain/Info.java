package com.estest3.demo.Domain;


public class Info {

    private int code;
    private String message;
    private Object data;

    public static Info createOk(Object data) {
        return createWithCodeAndData(2000, "success", data);
    }

    public static Info createOKMessage(String message) {
        Info result = new Info();
        result.setCode(2000);
        result.setMessage(message);
        return result;
    }

    public static Info createNg(String message) {
        return createWithCodeAndData(404, message, null);
    }

    private static Info createWithCodeAndData(int code, String message, Object data) {
        Info result = new Info();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


}
