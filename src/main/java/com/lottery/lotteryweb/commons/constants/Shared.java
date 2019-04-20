package com.lottery.lotteryweb.commons.constants;

public class Shared {

    private Shared() { }

    /* ############################# VALIDATION ############################## */
    public static final String ID_REGEX = "[0-9]+";
    public static final String KEY_REGEX = "[a-zA-Z0-9_-]+";

    public static final int BATCH_SIZE = 5000;
    public static final int API_TIMEOUT = 60 * 1000;

    /* ############################# API STATUS ############################## */
    public static final String SUCCESS_STATUS = "success";
    public static final String FAILURE_STATUS = "failure";
    public static final String ERROR_STATUS = "error";

    /* ################################ PATH ################################# */
    public static final String CHANGE_EMAIL_PATH = "/changeEmail";
    public static final String RESET_PASSWORD_CONFIRMATION_PATH = "/resetPasswordConfirmation";
    public static final String RESET_PASSWORD_PATH = "/users/password/reset";
    public static final String OPENREC_REDIRECT_PATH = "/auth/openrec";
    public static final String OPENREC_USER_THUMBNAIL_PATH_START = "https://hayabusa.io/";
    public static final String TWITTER_USER_THUMBNAIL_PATH_START_1 = "http://pbs.twimg.com/";
    public static final String TWITTER_USER_THUMBNAIL_PATH_START_2 = "http://abs.twimg.com/";
    public static final String TWITTER_REDIRECT_PATH = "/auth/twitter";

    /* ################################# WORDS ################################## */
    public static final String TMP_DIR = "tmp";
    public static final String DEFAULT_USER_THUMBNAIL = "user_default.jpg";
    public static final String ADMIN_CLUB_KEY = "memma";
    public static final String ADMIN_USER_KEY = "memma";
    public static final String REGISTRATION_WORD = "registration";
    public static final String CHANGE_EMAIL_WORD = "changeEmail";
    public static final String GHOST_NAME = "neko_";

    /* ################################# CAMPAIGN ################################## */
    public static final String CAMPAIGN_END_DATE = "20190517";

    /* ################################# MAIL ################################## */
    public static final String RELEASE_ONE = "release_one.png";
    public static final String RELEASE_TWO = "release_two.png";
    public static final String RELEASE_THREE = "release_three.png";
    public static final String RELEASE_PROCEDURE = "release_procedure.png";
}
