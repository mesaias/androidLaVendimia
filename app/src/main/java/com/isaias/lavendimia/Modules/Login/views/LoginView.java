package com.isaias.lavendimia.Modules.Login.views;

public interface LoginView {

    void cerrarTeclado();

    void mostrarDialogo( String mensaje );

    void mostrarError(String error);

    void ocultarDialogo();
}
