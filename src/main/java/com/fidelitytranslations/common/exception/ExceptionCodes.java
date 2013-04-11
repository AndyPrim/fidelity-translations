package com.fidelitytranslations.common.exception;

public enum ExceptionCodes {
    NOT_EXCEPTION(0),
    UNKNOWN_EXCEPTION(1),
    
    WRONG_INPUT_PARAMETERS_EXCEPTION(100),

    DBCONNECTION_EXCEPTION(200),
    
    FILE_NOT_FOUND_EXCEPTION(300),
    FILE_IO_EXCEPTION(301),
    FILE_CREATE_EXCEPTION(302),
    
    TIKA_EXCEPTION(400);

    private final Integer code;

    ExceptionCodes(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code.toString();
    }

}
