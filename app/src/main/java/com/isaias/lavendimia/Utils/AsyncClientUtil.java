package com.isaias.lavendimia.Utils;

import android.content.Context;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.ResponseHandlerInterface;

import cz.msebera.android.httpclient.HttpEntity;

public class AsyncClientUtil {

    private static final String BASE_URL = "http://192.168.0.8:8085/credex/api/";

    private static AsyncHttpClient client = new AsyncHttpClient();

    public void post( String url, RequestParams params, AsyncHttpResponseHandler responseHandler ) {
        this.client.post( getAbsoluteUrl( url ), params, responseHandler );
    }

    public void post( Context context, String url, HttpEntity entity, String contentType, ResponseHandlerInterface responseHandler ){
        this.client.post( context, getAbsoluteUrl( url ), entity, contentType, responseHandler );
    }

    private static String getAbsoluteUrl( String relativeUrl ) {
        return BASE_URL + relativeUrl;
    }
}
