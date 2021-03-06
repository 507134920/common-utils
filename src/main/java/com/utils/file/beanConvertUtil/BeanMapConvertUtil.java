package com.utils.file.beanConvertUtil;

import com.utils.file.bean.Student;
import org.springframework.context.annotation.Bean;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Bean与Map的转换
 *
 * @author lj
 */
public class BeanMapConvertUtil {
    /**
     * Bean转换为Map
     *
     * @param object
     * @return String-Object的HashMap
     *
     * @since v1.0.0
     */
    public static Map<String,Object> bean2MapObject(Object object){
        if(object == null){
            return null;
        }

        Map<String, Object> map = new HashMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 过滤class属性
                if (!"class".equals(key)) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(object);

                    map.put(key, value);
                }
            }
        } catch (Exception e) {
           e.printStackTrace();
        }

        return map;
    }

    /**
     * Map转换为Java Bean
     *
     * @param map
     *              待转换的Map
     * @param object
     *              Java Bean
     * @return java.lang.Object
     *
     * @since v1.0.0
     */
    public static Object map2Bean(Map map,Object object){
        if(map == null || object == null){
            return null;
        }
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(object.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                if (map.containsKey(key)) {
                    Object value = map.get(key);
                    // 得到property对应的setter方法
                    Method setter = property.getWriteMethod();
                    setter.invoke(object, value);
                }
            }
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return object;
    }

    public static void main(String[] args) {
        Student student = new Student("zhangsan",20,"nan");
        Map<String, Object> stringObjectMap = bean2MapObject(student);
        System.out.println(stringObjectMap);

        Map<String,Object> map = new HashMap<>();
        map.put("name","lisi");
        map.put("age",20);
        Student stu = new Student();
        Student o = (Student) map2Bean(map, stu);
        System.out.println(o);
    }
}
