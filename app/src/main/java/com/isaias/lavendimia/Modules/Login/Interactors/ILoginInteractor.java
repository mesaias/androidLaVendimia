package com.isaias.lavendimia.Modules.Login.Interactors;

import android.content.Context;

import com.isaias.lavendimia.Modules.Login.Presenters.LoginPresenter;

public interface ILoginInteractor {

    interface OnLoginFinishedListener {

        //void onUsernameError();

        //void onPasswordError();

        //void onSuccess();

        void onFailure( String error );

        //void onRestablecerPassword(String message);
    }

        void login(String username, String password, Context context, LoginPresenter listener ) ;
    }

