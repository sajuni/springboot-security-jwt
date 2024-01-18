package com.example.springbootsecurityjwt.security;

import com.example.springbootsecurityjwt.utils.enums.ErrorCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        Integer exception = (Integer)request.getAttribute("exception");

        if(exception == null) {
            setResponse(response, ErrorCode.UNKNOWN_ERROR);
        }
        //잘못된 타입의 토큰인 경우
        else if(exception == 1004) {
            setResponse(response, ErrorCode.WRONG_TYPE_TOKEN);
        }
        //토큰 만료된 경우
        else if(exception == 1005) {
            setResponse(response, ErrorCode.EXPIRED_TOKEN);
        }
        //지원되지 않는 토큰인 경우
        else if(exception == 1006) {
            setResponse(response, ErrorCode.UNSUPPORTED_TOKEN);
        }
        else {
            setResponse(response, ErrorCode.ACCESS_DENIED);
        }
    }
    //한글 출력을 위해 getWriter() 사용
    private void setResponse(HttpServletResponse response, ErrorCode exceptionCode) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        JSONObject responseJson = new JSONObject();
        responseJson.put("message", exceptionCode.getMessage());
        responseJson.put("code", exceptionCode.getCode());

        response.getWriter().print(responseJson);
    }
}
