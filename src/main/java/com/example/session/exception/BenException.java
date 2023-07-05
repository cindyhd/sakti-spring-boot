package com.example.session.exception;


public class BenException extends RuntimeException {
    private static final long serialVersionUID = -7404623468016783161L;

    public static final String BEN_DB_ERROR_E00 = "BEN_DB_ERROR_E00";
    public static final String BEN_DB_ERROR_B01 = "BEN_DB_ERROR_B01";
    public static final String BEN_DB_ERROR_B02 = "BEN_DB_ERROR_B02";
    public static final String BEN_DB_ERROR_B03 = "BEN_DB_ERROR_B03";
    public static final String BEN_DB_ERROR_B04 = "BEN_DB_ERROR_B04";
    public static final String BEN_DB_ERROR_B05 = "BEN_DB_ERROR_B05";

    public BenException() {
        super();
    }

    public BenException(String s) {
        super(s);
    }

    public BenException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public BenException(Throwable throwable) {
        super(throwable);
    }

}
