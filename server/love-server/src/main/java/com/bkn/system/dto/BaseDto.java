package com.bkn.system.dto;

/**
 * 数据传输基础对象，所有返回至前端的数据格式
* @author 张进军
* @date Aug 4, 2015 9:33:10 AM
 */
public class BaseDto {
	/**	返回码  */
	public Integer code;
	/**	返回值  */
	public Object msg;
	
	public BaseDto() {
        // TODO Auto-generated constructor stub
    }
	
	public BaseDto(Integer code, Object msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Object getMsg() {
		return msg;
	}
	public void setMsg(Object msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "BaseDto [code=" + code + ", msg=" + msg + "]";
	}
}
