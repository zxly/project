package com.gl.club.common.tools;

import org.apache.shiro.authc.AccountException;

public class FreezeAccountException extends AccountException{

	/** serialVersionUID */
	
	private static final long serialVersionUID = 1L;
	
	/**
     * Creates a new UnknownAccountException.
     */
    public FreezeAccountException() {
        super();
    }

    /**
     * Constructs a new FreezeAccountException.
     *
     * @param message the reason for the exception
     */
    public FreezeAccountException(String message) {
        super(message);
    }

    /**
     * Constructs a new FreezeAccountException.
     *
     * @param cause the underlying Throwable that caused this exception to be thrown.
     */
    public FreezeAccountException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new FreezeAccountException.
     *
     * @param message the reason for the exception
     * @param cause   the underlying Throwable that caused this exception to be thrown.
     */
    public FreezeAccountException(String message, Throwable cause) {
        super(message, cause);
    }

}
