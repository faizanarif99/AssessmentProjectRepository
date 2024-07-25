package com.assesmentproject.config;

import com.assesmentproject.dtos.ResponseDto;

public class BusinessException extends RuntimeException {

    private ResponseDto responseDto;

    // Private constructor to prevent creating instances without CommonResponseDto
    public BusinessException(ResponseDto responseDto, String message, String code) {
        super(message);
        this.responseDto = responseDto;
        this.responseDto.setMessage(message);
        this.responseDto.setCode(code);
    }

    public static BusinessException successActionResult(ResponseDto responseDto, String message, String code) {
        return new BusinessException(responseDto, message, code);
    }

    public static BusinessException errorActionResult(ResponseDto responseDto, String message, String code) {
        return new BusinessException(responseDto, message, code);
    }

    public ResponseDto getResponseDto() {
        return responseDto;
    }
}


