package com.bkn.web.interceptor;

import java.util.HashMap;
import java.util.Map;

/**
 * 封装参数
* @author 李志伟
* @date 2016年12月23日 上午11:00:08
 */
public class MapParam extends HashMap<String, Object> {  

    /** 
     *  
     */  
    private static final long serialVersionUID = 1L;  

    /** 
     * 作为Key的字段对应MapParam的Key 
     */  
    public static final String  KEY_FIELD = "mapKeyField";  
    /** 
     * 作为Value的字段对应MapParam的Key 
     */  
    public static final String VALUE_FIELD = "mapValueField";  
    
    /**
     * 其他的参数我们把它分装成一个Map对象
     */
    private Map<String, Object> params = new HashMap<String, Object>();

    /**
     * wucan
    * @author 李志伟
    * @date 2016年12月23日 上午11:00:23
     */
    public MapParam() {  

    }  

    /** 
     * 指定keyField和valueField 
     * @param keyField Map中key对应的字段 
     * @param valueField Map中value对应的字段 
     */  
    public MapParam(String keyField, String valueField) {  
        this.put(KEY_FIELD, keyField);  
        this.put(VALUE_FIELD, valueField);  
    }

	public Map<String, Object> getParams() {
		return params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}  
    
    
}  