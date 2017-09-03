package com.isaias.lavendimia.Modules.Login.Interactors;


import android.content.Context;

import com.google.gson.Gson;
import com.isaias.lavendimia.Modules.Login.Models.Usuario;
import com.isaias.lavendimia.Modules.Login.Presenters.LoginPresenter;
import com.isaias.lavendimia.Utils.*;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

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
                System.out.println( statusCode );
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println( statusCode);
                listener.onFailure( String.valueOf( statusCode ) );
            }
        });

    }

}
