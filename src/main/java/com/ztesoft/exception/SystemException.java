package com.ztesoft.exception;

/**
 * Created by 研发二科 王永梅 .
 */
public class SystemException extends RuntimeException {

    private static final long serialVersionUID = -4555331337009026323L;

    public SystemException() {
        super();
    }

    public SystemException(String msg, Throwable throwable) {
        super(msg, throwable);
    }

    public SystemException(String msg) {
        super(msg);
    }

    public SystemException(Throwable throwable) {
        super(throwable);
    }
}