package com.isaias.lavendimia.Modules.Login.views;

public interface LoginView {

    void cerrarTeclado();

    void mostrarDialogo( String mensaje );

    void ocultarDialogo();

    void usuarioNoExistente( String error );
}
