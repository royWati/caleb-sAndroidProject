package com.zalego2018dec.exercise.network;

import android.support.annotation.Nullable;

import org.apache.http.NameValuePair;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.List;

public class JSONParser {
    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    public JSONObject makeHttpRequest(String url, @Nullable List<NameValuePair> params) {
         JSONObject jsonObject=new OkJsonRequest().makeRequest(new UrlBuilder().build(url,params));
        return jsonObject;

    }
    public JSONObject makeHttpRequest(String url) {
        JSONObject jsonObject=new OkJsonRequest().makeRequest(url);
        return jsonObject;

    }
}
