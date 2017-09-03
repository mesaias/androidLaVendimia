package com.isaias.lavendimia.Modules.Login.Presenters;

public interface ILoginPresenter {

    void onFailure( String error );

    void validarUsuarioYPassword( String username, String password );

    void validarTeclado();

}
