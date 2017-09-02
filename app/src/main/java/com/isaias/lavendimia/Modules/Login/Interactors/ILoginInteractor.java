package com.isaias.lavendimia.Modules.Login.Interactors;

import android.content.Context;

public interface ILoginInteractor {

    interface OnLoginFinishedListener {

        void onUsernameError();

        void onPasswordError();

        void onSuccess();

        void onFailure(String error);

        void onRestablecerPassword(String message);
    }

        void login( String username, String password,  Context context );
    }

