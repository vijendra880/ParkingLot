package com.design.utils;

import com.google.gson.Gson;

public class JsonUtility<T> {
  private static Gson gson = new Gson();

  public static <T> T parseJsonStringToObject(String jsonString, Class<T> classType) {
    return gson.fromJson(jsonString, classType);
  }

  public static <T> String parseJsonObjectToString(Class<T> classType) {
    return gson.toJson(classType);
  }
}
