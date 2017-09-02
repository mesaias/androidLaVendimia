package com.isaias.lavendimia.Modules.Login.Activities;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Scroller;

import com.isaias.lavendimia.Modules.Login.Presenters.ILoginPresenter;
import com.isaias.lavendimia.R;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @NotEmpty( message = "El campo 'nombre de usuario' no debe ser vacio'" )
    @BindView(R.id.etxtUsername)
    EditText mTxtUsername;

    @NotEmpty( message = "El campo 'contraseña' no debe ser vacio'" )
    @BindView( R.id.eTxtPassword )
    EditText mTxtPassword;

    @BindView( R.id.frmLogin )
    ScrollView mfrmLogin;

    @BindView( R.id.btnLogin )
    Button mbtnLogin;

    ProgressDialog mProgressDialogLogin;

    private ILoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mTxtUsername.setText("Te la shupo");
    }

    @OnClick(R.id.btnLogin)
    public void validarUsuarioYPassword() {

        mLoginPresenter.validarUsuarioYPassword(
                mTxtUsername.getText().toString(), mTxtPassword.getText().toString() );
    }
}
