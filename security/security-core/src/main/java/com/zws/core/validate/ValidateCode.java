package com.zws.core.validate;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author zws
 * @email 2848392861@qq.com
 * date 2018/9/29
 */
@Data
public class ValidateCode {


    private String code;

    private LocalDateTime expireTime;


    public ValidateCode(){}

    public ValidateCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }

    public ValidateCode(String code, Long expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public boolean isExpire(){
         return LocalDateTime.now().isAfter(expireTime);
    }
}
