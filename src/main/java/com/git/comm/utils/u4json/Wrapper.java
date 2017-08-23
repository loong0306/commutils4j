package com.git.comm.utils.u4json;

import com.github.pagehelper.Page;
import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;

@JsonSerialize(
        include = Inclusion.NON_NULL
)
public class Wrapper<T> implements Serializable {
    public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MESSAGE = "操作成功";
    public static final int CAPTCHA_CODE_ERROR = 600;
    public static final int ERROR_CODE = 500;
    public static final String ERROR_MESSAGE = "内部异常";
    public static final int ILLEGAL_ARGUMENT_CODE_ = 100;
    public static final String ILLEGAL_ARGUMENT_MESSAGE = "参数非法";
    private int code;
    private String message;
    private T result;

    public Wrapper() {
        this(200, "操作成功");
    }

    public Wrapper(int code, String message) {
        this.code(code).message(message);
    }

    public Wrapper(int code, String message, T result) {
        this.code(code).message(message).result(result);
    }

    public Wrapper(int code, String message, T result, Page<T> page) {
        this.code(code).message(message).result(result);
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Wrapper<T> code(int code) {
        this.setCode(code);
        return this;
    }

    public Wrapper<T> message(String message) {
        this.setMessage(message);
        return this;
    }

    public Wrapper<T> result(T result) {
        this.setResult(result);
        return this;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return 200 == this.code;
    }

    @JsonIgnore
    public boolean isFail() {
        return 200 != this.code;
    }

    public String toString() {
        return "Wrapper{code=" + this.code + ", message=\'" + this.message + '\'' + ", result=" + this.result + '}';
    }
}
