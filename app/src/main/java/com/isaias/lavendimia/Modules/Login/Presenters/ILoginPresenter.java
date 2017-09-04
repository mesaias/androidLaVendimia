package com.isaias.lavendimia.Modules.Login.Presenters;

public interface ILoginPresenter {

    void onFailure( String error );

    void onSuccess( String response );

    void validarUsuarioYPassword( String username, String password );

    void validarTeclado();

}
