package com.lottery.lotteryweb.common.constants;

public class Auth {

    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String AUTH_PATH = "/api/auth/**";
    public static final String SECURED_PATH = "/api/*/secured/**";
    public static final String REG_CONFIRMATION_PATH = "/registrationConfirmation";
    public static final int REG_TOKEN_EXPIRATION_HRS = 24;
    public static final int RESET_PASSWORD_TOKEN_EXPIRATION_HRS = 24;
    public static final int CHANGE_EMAIL_TOKEN_EXPIRATION_HRS = 1;
    public static final int SOCIAL_LOGIN_TOKEN_EXPIRATION_MIN = 10;
    public static final String CHANGE_EMAIL_PATH = "/changeEmail";
    public static final String OPENREC_REQUEST_PARAM_QUES = "?";
    public static final String OPENREC_REQUEST_PARAM_AND = "&";
    public static final String OPENREC_REQUEST_PARAM_UUID = "uuid=";
    public static final String OPENREC_REQUEST_PARAM_ACCESS_TOKEN = "&access_token=";
    public static final int SOCIAL_LOGIN_API_ERROR_CODE = 1;
}
