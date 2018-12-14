package com.zalego2018dec.exercise.network;

import android.support.annotation.Nullable;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;

import java.util.List;

/**
 * Created by folio on 7/13/2018.
 */

public class UrlBuilder {

    public String build(String url, @Nullable List<NameValuePair> paramaters){
        return url+"?"+URLEncodedUtils.format(paramaters,"UTF-8");
    }
}
