package com.zalego2018dec.exercise.network;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.TlsVersion;

/**
 * Created by folio on 7/12/2018.
 */

public class OkJsonRequest  {

    OkHttpClient client;
    JSONObject jsonObject;
    public JSONObject makeRequest(String url){
        Log.d("request made to server",url);


        okhttp3.Request request = new okhttp3.Request.Builder().url(url).build();
        String json_data=null;

        try {

            SSLContext sc = SSLContext.getInstance("TLSv1.2");
            sc.init(null, null, null);

            ConnectionSpec cs = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                    .tlsVersions(TlsVersion.TLS_1_2)
                    .build();

            List<ConnectionSpec> specs = new ArrayList<>();
            specs.add(cs);
            specs.add(ConnectionSpec.COMPATIBLE_TLS);
            specs.add(ConnectionSpec.CLEARTEXT);

            client=new OkHttpClient.Builder().
                    connectionSpecs(specs).

                    sslSocketFactory(new TLS12SocketFactory(sc.getSocketFactory())).
                    build();

            okhttp3.Response response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                Headers responseHeaders = response.headers();
                for (int i = 0; i < responseHeaders.size(); i++) {
                    System.out.println(responseHeaders.name(i) + ": " +
                            responseHeaders.value(i));
                }

                json_data=response.body().string();
                Log.d("response from server",json_data);
                System.out.println(json_data);


            }
            else{
                json_data="error in fetching data";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            jsonObject=new JSONObject(json_data);
        } catch (JSONException e) {
            try {
                jsonObject = new JSONObject("{\"success\":0,\"message\":\"error in netwok\"}");
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        }

        return jsonObject;
    }
}