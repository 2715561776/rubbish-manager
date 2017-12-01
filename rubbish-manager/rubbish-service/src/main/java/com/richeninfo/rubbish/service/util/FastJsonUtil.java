package com.richeninfo.rubbish.service.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * fastjson utils
 * @see https://github.com/alibaba/fastjson
 * 解析json很快，功能简单
 * @author  xlj
 *
 */
public final class FastJsonUtil {

    private static SerializeConfig mapping = new SerializeConfig();

    static{
        mapping.put(java.sql.Time.class, new SimpleDateFormatSerializer("HH:mm:ss"));
        mapping.put(java.util.Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        mapping.put(java.sql.Date.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
        mapping.put(java.sql.Timestamp.class, new SimpleDateFormatSerializer("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * javaBean、list、map convert to json string
     */
    public static String format(Object obj){
        return JSON.toJSONString(obj,mapping,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteMapNullValue);
    }

    /**
     * json string to javaBean
     */
    public static Object parse(String jsonStr){
        return JSON.parse(jsonStr,
                Feature.SupportArrayToBean,
                Feature.InitStringFieldAsEmpty);
    }

    /**
     * json string to JSONArray
     */
    public static JSONArray parseArray(String jsonStr){
        return JSON.parseArray(jsonStr);
    }

    /**
     * json string to JSONObject
     */
    public static JSONObject parseObject(String jsonStr){
        return JSON.parseObject(jsonStr,
                Feature.SupportArrayToBean,
                Feature.InitStringFieldAsEmpty);
    }

    /**
     * json string convert to javaBean、map
     */
    public static <T> T parseBean(String jsonStr, Class<T> clazz){
        return JSON.parseObject(jsonStr,clazz);
    }

    /**
     * json array string convert to list with javaBean
     */
    public static <T> List<T> parseList(String jsonArrayStr, Class<T> clazz){
        return JSON.parseArray(jsonArrayStr, clazz);
    }

    /**
     * json string convert to map
     */
    public static Map<String,Object> parseMap(String jsonStr){
        return parseBean(jsonStr, Map.class);
    }

    /**
     * json string convert to map with javaBean
     */
    public static <T> Map<String,T> parseMap(String jsonStr, Class<T> clazz){
        Map<String,T> map = JSON.parseObject(jsonStr, new TypeReference<Map<String, T>>() {});
        for (Entry<String, T> entry : map.entrySet()) {
            JSONObject obj = (JSONObject) entry.getValue();
            map.put(entry.getKey(), JSONObject.toJavaObject(obj, clazz));
        }
        return map;
    }
}