package com.safetyas.sds.common.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ObjectUtil {
    public static Map convertObjectToMap(Object obj) {
        Map map = new HashMap();
        Field[] fields = obj.getClass().getDeclaredFields();
        for(int i=0; i <fields.length; i++) {
            fields[1].setAccessible(true);
            try{
                map.put(fields[i].getName(), fields[i].get(obj));
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        return map;
    }

    public static Object convertMapToObject(Map<String, Object> map, Object obj) {
        String keyAttribute = null;
        String setMethodString = "set";
        String methodString = null;
        Iterator itr = map.keySet().iterator();

        // map 의 key 만큼 루프를 돌며 key값의 첫번째 글자를 대문자로 바꿈
        // 메서드를 가져와서 필요한 메소드를 찾음
        // 메서드 실행하며 값을 넘겨준다 invoke
        while(itr.hasNext()) {
            keyAttribute = (String)itr.next();
            methodString = setMethodString+keyAttribute.substring(0, 1).toUpperCase()+keyAttribute.substring(1);

            try {
                Method[] methods = obj.getClass().getDeclaredMethods();

                for (int i = 0; i < methods.length; i++) {
                    if (methodString.equals(methods[i].getName())) {

                        methods[i].invoke(obj, map.get(keyAttribute));
                    }
                }
            }catch (SecurityException  e) {
                e.printStackTrace();
            }catch (IllegalAccessException e){
                e.printStackTrace();
            }catch (IllegalArgumentException e){
                e.printStackTrace();
            }catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    /**
     * Object type 변수가 비어있는지 체크
     *
     * @param obj
     * @return Boolean : true / false
     */
    public static Boolean empty(Object obj) {
        if (obj instanceof String) return obj == null || "".equals(obj.toString().trim());
        else if (obj instanceof List) return obj == null || ((List) obj).isEmpty();
        else if (obj instanceof Map) return obj == null || ((Map) obj).isEmpty();
        else if (obj instanceof Object[]) return obj == null || Array.getLength(obj) == 0;
        else return obj == null;
    }

    /**
     * Object type 변수가 비어있지 않은지 체크
     *
     * @param obj
     * @return Boolean : true / false
     */
    public static Boolean notEmpty(Object obj) {
        return !empty(obj);
    }
}
