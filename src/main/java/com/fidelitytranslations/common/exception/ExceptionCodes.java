package com.fidelitytranslations.common.exception;

public enum ExceptionCodes {
    NOT_EXCEPTION(0),
    UNKNOWN_EXCEPTION(1),

    DBCONNECTION_EXCEPTION(200);

    private final Integer code;

    ExceptionCodes(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code.toString();
    }

}
