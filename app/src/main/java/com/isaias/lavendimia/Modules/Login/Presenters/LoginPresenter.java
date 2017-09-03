package com.isaias.lavendimia.Modules.Login.Presenters;

import android.content.Context;

import com.isaias.lavendimia.Modules.Login.Interactors.ILoginInteractor;
import com.isaias.lavendimia.Modules.Login.Interactors.LoginInteractor;
import com.isaias.lavendimia.Modules.Login.views.LoginView;

public class LoginPresenter
        implements ILoginPresenter{

    private Context mContext;
    private ILoginInteractor iLoginInteractor;
    private LoginView loginView;

    public LoginPresenter( LoginView loginView, Context context ){
        this.mContext = context;
        this.loginView = loginView;
        iLoginInteractor = new LoginInteractor();

    }

    @Override
    public void validarUsuarioYPassword( String username, String password ) {

        loginView.mostrarDialogo( "Verificando los datos, por favor espere" );
        this.iLoginInteractor.login( username, password,  mContext, this);
    }

    @Override
    public void onFailure( String error ) {
        loginView.ocultarDialogo();
        loginView.usuarioNoExistente( error );
    }

    @Override
    public void validarTeclado() {

    }

}
