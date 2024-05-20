package com.kardia.volunteersystem.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class BeanArrayUtil {
    public static Gson newAGson(){
        return new Gson();
    }

    public static String arrToJson_1(String[] arr){
        Gson gson = newAGson();
        return gson.toJson(arr);
    }

    public static String arrToJson_2(String[][] arr){
        Gson gson = newAGson();
        return gson.toJson(arr);
    }

    public static String[] jsonToArr_1(String json){
        Gson gson = newAGson();
        Type type = new TypeToken<String[]>() {}.getType();
        return gson.fromJson(json, type);
    }

    public static String[][] jsonToArr_2(String json){
        Gson gson = newAGson();
        Type type = new TypeToken<String[][]>() {}.getType();
        return gson.fromJson(json, type);
    }
}
