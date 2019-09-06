package com.bkn.browser.exception;

/**
 * 
* @author 李志伟
* @date 2015年8月11日 下午2:49:25
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
    * @author 李志伟
    * @date 2015年8月11日 下午2:49:32
     */
    public ResourceNotFoundException() {
        super();
    }

    /**
     * 
    * @author 李志伟
    * @date 2015年8月11日 下午2:49:34
    * @param message msg
    * @param cause c
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * 
    * @author 李志伟
    * @date 2015年8月11日 下午2:49:37
    * @param message msg
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * 
    * @author 李志伟
    * @date 2015年8月11日 下午2:49:39
    * @param cause c
     */
    public ResourceNotFoundException(Throwable cause) {
        super(cause);
    }
}
