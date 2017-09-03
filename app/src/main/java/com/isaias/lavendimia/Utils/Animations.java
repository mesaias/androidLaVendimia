package com.isaias.lavendimia.Utils;


import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.support.design.widget.Snackbar;

import com.isaias.lavendimia.R;

import static android.content.ContentValues.TAG;

public class Animations {

    private Context context;

    public Animations( Context context ){

        this.context = context;
    }

    public ProgressDialog getProgressDialog(String mensaje) {
        ProgressDialog progressDialog;

        progressDialog = new ProgressDialog(context, R.style.Base_V21_Theme_AppCompat_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage(mensaje);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);

        try {
            progressDialog
                    .getWindow()
                    .setBackgroundDrawable(new ColorDrawable(android.graphics.Color.GRAY));
        } catch (Exception e) {
            Log.e(TAG + ":getProgressDialog", e.toString());
        }

        return progressDialog;
    }

    public void snackbar( View view, String mensaje, int duracion ) {
        Snackbar.make(view, mensaje, duracion).show();
    }
}
