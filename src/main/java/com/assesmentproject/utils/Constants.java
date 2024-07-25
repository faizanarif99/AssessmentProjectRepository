package com.assesmentproject.utils;

public interface Constants {

    // These are regular variables without the public static final modifiers
    String SECRET_KEY = "LzJIFVn1MHI8Bt5zZ0dlgEbWKo4NQdJga09cVjREVSwYleIHdSmo0UDyPmhSH2y5QfviQb5m7UyWqd/krd4wQg==";

    String SECRET = "SecretKeyToGenJWTs";
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";
    String SIGN_UP_URL = "/users/sign-up";
    String PRIVILEGES = "privileges";
    String AUTHORIZED = "User is authorized Successfully!";
    String UNAUTHORIZED = "Unauthorized user!";

    // API Responses with status codes.
    String API_RESPONSE_CODE_OK = "200";
    String API_RESPONSE_MSG_OK = "OK";
    String API_RESPONSE_CODE_INTERNAL_SERVER_ERROR = "500";
    String API_RESPONSE_MSG_INTERNAL_SERVER_ERROR = "Internal Server Error";
    String API_RESPONSE_CODE_BAD_REQUEST_ERROR = "400";
    String API_RESPONSE_MSG_BAD_REQUEST_ERROR = "Bad Request";
    String API_RESPONSE_CODE_NO_CONTENT_ERROR = "204";
    String API_RESPONSE_MSG_NO_CONTENT_ERROR = "No Content";
    String TOKEN_NOT_VALID = "Token not found!";

    String OK_TEXT = "OK";
    String SUCCESS_TEXT = "SUCCESS";
    String FAILURE_TEXT = "FAILURE";
    String SUCCESS_CODE = "200";
    String FAILURE_CODE = "F";

    String SUCCESS_MESSAGE = "Success";
    String FAILURE_MESSAGE = "Failure";

}
