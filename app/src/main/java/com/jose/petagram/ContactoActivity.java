package com.jose.petagram;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.jose.petagram.datos.DatosContactoCorreo;
import com.jose.petagram.datos.EnviarCorreo;

public class ContactoActivity extends AppCompatActivity {

    TextInputEditText txtNombre;
    TextInputEditText txtCorreo;
    TextInputEditText txtMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        Button btnEnviar = (Button) findViewById(R.id.btnEnviar);
        txtNombre = (TextInputEditText) findViewById(R.id.txtNombre);
        txtCorreo = (TextInputEditText) findViewById(R.id.txtCorreo);
        txtMensaje = (TextInputEditText) findViewById(R.id.txtMensaje);


        Toolbar actionBarMascota = (Toolbar) findViewById(R.id.actionBarMascota);
        setSupportActionBar(actionBarMascota);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatosContactoCorreo dcc = new DatosContactoCorreo(txtNombre.getText().toString(), txtCorreo.getText().toString(), txtMensaje.getText().toString());

                EnviarCorreo ec = new EnviarCorreo(dcc.getsNombreCorreo(),dcc.getsCorreoElectronico(), dcc.getsMensajeCorreo());
                ec.enviar();
            }
        });


    }

}
