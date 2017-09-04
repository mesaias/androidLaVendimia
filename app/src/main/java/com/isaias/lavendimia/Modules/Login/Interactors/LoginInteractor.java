package com.isaias.lavendimia.Modules.Login.Interactors;


import android.content.Context;

import com.google.gson.Gson;
import com.isaias.lavendimia.Modules.Login.Models.Usuario;
import com.isaias.lavendimia.Modules.Login.Presenters.LoginPresenter;
import com.isaias.lavendimia.Utils.*;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.entity.StringEntity;

public class LoginInteractor implements ILoginInteractor {

    AsyncClientUtil asyncClientUtil  = new AsyncClientUtil();

    private static final String PETICION_TIPO_JSON = "application/json";

    private static AsyncHttpClient client = new AsyncHttpClient();

    @Override
    public void login( final String username,
                      final String password,
                      final Context context,
                      final LoginPresenter listener ) {

        Usuario usuario = new Usuario();
        usuario.setUsername( username );
        usuario.setPassword( password );

        Gson gson = new Gson();
        String url = "fin-util/login-canje";
        String json = gson.toJson( usuario );

        StringEntity entity = new StringEntity( json, "UTF-8") ;

        this.asyncClientUtil.post( context, url, entity, PETICION_TIPO_JSON, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                JSONObject jsonResponse = null;
                try {
                    jsonResponse = new JSONObject( new String( responseBody ) );
                    listener.onSuccess( jsonResponse.toString() );

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                try {
                    if ( statusCode >= 500 ){
                        listener.onFailure( "Ocurrió un error interno, intente más tarde" );
                    }
                    else {
                        JSONObject jsonResponse = new JSONObject( new String( responseBody ) );
                        listener.onFailure( jsonResponse.getString( "message" ) );
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
