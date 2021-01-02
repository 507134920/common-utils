package com.utils.file.jsonUtil;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.List;
import java.util.Map;

/**
 * Description:基于fastjson封装的json转换工具类
 * @author lj
 */
public class FastJsonUtil {


    /**
     * 功能描述：把JSON数据转换成指定的java对象
     *
     * @param jsonData JSON数据
     * @param clazz    指定的java对象
     * @return 指定的java对象
     */
    public static <T> T getJsonToBean(String jsonData, Class<T> clazz) {
        return JSON.parseObject(jsonData, clazz);
    }

    /**
     * 功能描述：把java对象转换成JSON数据
     *
     * @param object java对象
     * @return JSON数据
     */
    public static String getBeanToJson(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 功能描述：把JSON数据转换成指定的java对象列表
     *
     * @param jsonData JSON数据
     * @param clazz    指定的java对象
     * @return List<T>
     */
    public static <T> List<T> getJsonToList(String jsonData, Class<T> clazz) {
        return JSON.parseArray(jsonData, clazz);
    }

    /**
     * 功能描述：把JSONArray数据转换成较为复杂的List<Map<String, Object>>
     *
     * @param jsonData SONArray数据
     * @return List<Map<String,Object>>
     */
    public static List<Map<String, Object>> getJsonToListMap(String jsonData) {
        return JSON.parseObject(jsonData, new TypeReference<List<Map<String, Object>>>() {
        });
    }

    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.fluentPut("name","zngsan").fluentPut("age",10);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        String str = jsonArray.toJSONString();
        List<Map<String, Object>> jsonToListMap = getJsonToListMap(str);
        for (Map<String, Object> stringObjectMap : jsonToListMap) {

        }

    }
}
