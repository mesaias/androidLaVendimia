package com.isaias.lavendimia.Modules.Login.Activities;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Scroller;

import com.isaias.lavendimia.Modules.Login.Presenters.ILoginPresenter;
import com.isaias.lavendimia.Modules.Login.Presenters.LoginPresenter;
import com.isaias.lavendimia.Modules.Login.views.LoginView;
import com.isaias.lavendimia.R;
import com.isaias.lavendimia.Utils.Animations;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @NotEmpty( message = "El campo 'nombre de usuario' no debe ser vacio'" )
    @BindView(R.id.etxtUsername)
    EditText mTxtUsername;

    @NotEmpty( message = "El campo 'contraseña' no debe ser vacio'" )
    @BindView( R.id.eTxtPassword )
    EditText mTxtPassword;

    @BindView( R.id.frmLogin )
    ScrollView frmLogin;

    @BindView( R.id.btnLogin )
    Button mbtnLogin;

    ProgressDialog progressDialogLogin;

    private Animations animations;
    private ILoginPresenter mLoginPresenter;
    private LoginView loginView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        animations = new Animations( this );
        this.loginView = loginView;
        ButterKnife.bind(this);

        mLoginPresenter = new LoginPresenter( this, LoginActivity.this );

    }

    @OnClick(R.id.btnLogin)
    public void validarUsuarioYPassword() {

        mLoginPresenter.validarUsuarioYPassword(
                mTxtUsername.getText().toString(), mTxtPassword.getText().toString() );
    }

    @Override
    public void cerrarTeclado() {

    }

    @Override
    public void mostrarDialogo( String mensaje ) {
        progressDialogLogin = animations.getProgressDialog( mensaje );
        progressDialogLogin.show();
    }

    @Override
    public void ocultarDialogo() {

    }

    @Override
    public void usuarioNoExistente(String error) {
        animations.snackbar( frmLogin, error, Snackbar.LENGTH_LONG );
    }

}
