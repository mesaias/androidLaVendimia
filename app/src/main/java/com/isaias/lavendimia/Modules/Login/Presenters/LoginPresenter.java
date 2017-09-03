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

        loginView.cerrarTeclado();
        loginView.mostrarDialogo( "Verificando los datos, por favor espere" );
        this.iLoginInteractor.login( username, password,  mContext, this);
    }

    @Override
    public void onFailure( String error ) {
        loginView.ocultarDialogo();
        loginView.mostrarError( error );
    }

    @Override
    public void onSuccess( String response ){
        loginView.ocultarDialogo();
        loginView.mostrarError( response );
    }

    @Override
    public void validarTeclado() {

    }

}
