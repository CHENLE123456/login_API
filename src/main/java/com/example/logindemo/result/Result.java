package com.example.logindemo.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private String code;
    private String errorMsg;
    private Object data;

    public static Result ok() {
        return new Result("200", null, null);
    }

    public static Result ok(Object data) {
        return new Result("200", null, data);
    }
    public static Result fail(String errorMsg) {
        return new Result("500", errorMsg, null);
    }
}
