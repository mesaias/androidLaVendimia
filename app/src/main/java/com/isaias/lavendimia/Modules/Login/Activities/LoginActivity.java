package com.isaias.lavendimia.Modules.Login.Activities;

import android.app.ProgressDialog;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.Toast;

import com.isaias.lavendimia.Modules.Login.Presenters.ILoginPresenter;
import com.isaias.lavendimia.Modules.Login.Presenters.LoginPresenter;
import com.isaias.lavendimia.Modules.Login.views.LoginView;
import com.isaias.lavendimia.R;
import com.isaias.lavendimia.Utils.Animations;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static java.security.AccessController.getContext;

public class LoginActivity extends AppCompatActivity implements LoginView, Validator.ValidationListener {

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
    private Boolean flagValidator;
    private ILoginPresenter mLoginPresenter;
    private LoginView loginView;
    private Validator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        animations = new Animations( this );
        ButterKnife.bind(this);
        this.loginView = loginView;
        mLoginPresenter = new LoginPresenter( this, LoginActivity.this );
        this.validator = new Validator( this );
        this.validator.setValidationListener( this );

    }

    @OnClick( R.id.btnLogin )
    public void validarUsuarioYPassword() {
        validator.validate();
        if ( flagValidator ) {
            mLoginPresenter.validarUsuarioYPassword(
                    mTxtUsername.getText().toString(), mTxtPassword.getText().toString());
        }
        }

    @Override
    public void cerrarTeclado() {
        animations.cerrarTeclado();
    }

    @Override
    public void mostrarDialogo( String mensaje ) {
        progressDialogLogin = animations.getProgressDialog( mensaje );
        progressDialogLogin.show();
    }

    @Override
    public void ocultarDialogo() {
        progressDialogLogin.dismiss();
    }

    @Override
    public void mostrarError(String error) {
        animations.alertDialog( this, error, Snackbar.LENGTH_LONG );
    }


    @Override
    public void onValidationSucceeded() {
        flagValidator = true;
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        flagValidator = false;
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage( this );
            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText( this, message, Toast.LENGTH_LONG).show();
            }
        }
    }
}
