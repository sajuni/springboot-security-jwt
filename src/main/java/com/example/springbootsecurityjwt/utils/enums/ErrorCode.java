package com.example.springbootsecurityjwt.utils.enums;

import lombok.Getter;

@Getter
public enum ErrorCode {
    UNKNOWN_ERROR(1001, "토큰이 존재하지 않습니다."),
    WRONG_TYPE_TOKEN(1002, "토큰이 유효하지 않습니다."),
    EXPIRED_TOKEN(1003, "만료된 토큰입니다."),
    ACCESS_DENIED(1004, "권한이 없습니다."),
    UNSUPPORTED_TOKEN(1005, "지원하지 않는 토큰입니다.");

    private final int code;
    private final String message;

    ErrorCode(int status, String message) {
        this.code = status;
        this.message = message;
    }
}
