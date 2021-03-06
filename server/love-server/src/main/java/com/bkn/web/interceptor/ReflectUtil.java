package com.bkn.web.interceptor;

import java.lang.reflect.Field;

/**
 * map 辅助类
* @author 李志伟
* @date 2016年12月23日 上午10:43:15
 */
public class ReflectUtil {  

    /**
     * 利用反射获取指定对象的指定属性  
    * @author 李志伟
    * @date 2016年12月23日 上午11:00:45
    * @param obj    obj
    * @param <T>    obj
    * @param fieldName  fieldName
    * @return   static
     */
    @SuppressWarnings("unchecked")  
    public static <T> T getFieldValue(Object obj, String fieldName) {  
        Object result = null;  
        Field field = ReflectUtil.getField(obj, fieldName);  
        if (field != null) {  
            field.setAccessible(true);  
            try {  
                result = field.get(obj);  
            } 
            catch (IllegalArgumentException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            } 
            catch (IllegalAccessException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
        return (T)result;  
    }  
      
    /** 
     * 利用反射获取指定对象里面的指定属性 
     * @param obj 目标对象 
     * @param fieldName 目标属性 
     * @return 目标字段 
     */  
    private static Field getField(Object obj, String fieldName) {  
        Field field = null;  
        for (Class<?> clazz=obj.getClass(); clazz != Object.class; clazz=clazz.getSuperclass()) {  
            try {  
                field = clazz.getDeclaredField(fieldName);  
                break;  
            } 
            catch (NoSuchFieldException e) {  
                //这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。  
            }  
        }  
        return field;  
    }  
  
    /** 
     * 利用反射设置指定对象的指定属性为指定的值 
     * @param obj 目标对象 
     * @param fieldName 目标属性 
     * @param fieldValue 目标值 
     */  
    public static void setFieldValue(Object obj, String fieldName,  
            String fieldValue) {  
        Field field = ReflectUtil.getField(obj, fieldName);  
        if (field != null) {  
            try {  
                field.setAccessible(true);  
                field.set(obj, fieldValue);  
            } 
            catch (IllegalArgumentException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            } 
            catch (IllegalAccessException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }  
}  