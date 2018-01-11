package principal.android.empresa.prototipo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

import org.json.JSONObject;

import layout.grabar_loginpersonas;

/**
 * Created by Home on 08/07/2017.
 */

public class login extends AppCompatActivity implements View.OnClickListener {

    Spinner cbotipousu;
    ArrayAdapter<CharSequence> adapter;
    EditText txtusuario,txtclave;
    Button btnentrar,btnregistrar;
    int estado=0;
    private VideoView mVideoView;
    String nomb,contra;
    String correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));

        }


        cbotipousu=(Spinner)findViewById(R.id.cbotipousu);
        btnentrar=(Button)findViewById(R.id.btnentrar);

        btnregistrar=(Button)findViewById(R.id.btnregistro);
        txtusuario=(EditText)findViewById(R.id.txtusuario);
        txtclave=(EditText)findViewById(R.id.txtclave);
        btnentrar.setOnClickListener(this);
        btnregistrar.setOnClickListener(this);
        adapter=ArrayAdapter.createFromResource(this, R.array.tipousu_array,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cbotipousu.setAdapter(adapter);
//video  fondo
        mVideoView = (VideoView) findViewById(R.id.bgVideoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.logincamion);
        mVideoView.setVideoURI(uri);
        mVideoView.start();
        //repeticion video
        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
    }



    public void Entrar()
    {

        String usuario,clave;
        usuario = txtusuario.getText().toString();
        clave = txtclave.getText().toString();
        String parametros[]=new String[2];
        parametros[0]=usuario;
        parametros[1]=clave;
        try
        {
            String estado2="6";
            if(cbotipousu.getSelectedItemId()==0)
            {
                Toast.makeText(getApplicationContext(),"No selecciono ninguna opcion",Toast.LENGTH_LONG).show();
                cbotipousu.requestFocus();
            }else if (txtusuario.length() == 0) {
                txtusuario.setError("INGRESE POR FAVOR EL USUARIO!");
                txtusuario.requestFocus();
            } else if (txtclave.length() == 0) {
                txtclave.setError("INGRESE POR FAVOR LA CONTRASEÑA!");
                txtclave.requestFocus();
            }else
            if(cbotipousu.getSelectedItemId()==1)
            {

                new async_login_municipalidad().execute(parametros);

            }
            else

            if(cbotipousu.getSelectedItemId()==2) {
              new async_login_personas().execute(parametros);


            }


        }catch (Exception e)
        {

        }
    }



public void registropersona(){
    //cambikarde activity
    Intent objIntent = new Intent(login.this, grabar_loginpersonas.class);

    startActivity(objIntent);
    finish();
}
    @Override
    public void onClick(View v) {
        if(v==btnentrar)
        {
            Entrar();
        }
        if(v==btnregistrar)
        {
registropersona();        }
    }
    class async_login_municipalidad extends AsyncTask<String, Void, String> {
        private ProgressDialog progressDialog;
        JSONObject objeto;


        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(login.this, "Login....", "Espere unos segundos!", true);

        }

        @Override
        protected String doInBackground(String... params) {

            String mensaje="";

            nomb=params[0];
            contra=params[1];



            return mensaje;
        }
        protected void onPostExecute(String result) {


            if (nomb.equals("municipalidad")&& contra.equals("1111")) {

                //cambikarde activity
                Intent objIntent = new Intent(login.this, Principal.class);

                startActivity(objIntent);


                //no se pueda retroceder
                finish();
                Toast.makeText(getApplicationContext(), "BIENVENIDO  :" + nomb.toUpperCase() + "", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(getApplicationContext(), "Usuario y clave Incorrectos, por favor Ingrese Nuevamente", Toast.LENGTH_LONG).show();


            }


            progressDialog.dismiss();

        }

    }
    class async_login_personas extends AsyncTask<String, Void, String> {
        private ProgressDialog progressDialog;
        JSONObject objeto;


        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(login.this, "Login....", "Espere unos segundos!", true);

        }

        @Override
        protected String doInBackground(String... params) {

            String mensaje="";

            nomb=params[0];
            contra=params[1];



            return mensaje;
        }
        protected void onPostExecute(String result) {


            if (nomb.equals("giampieer24")&& contra.equals("1111")) {

                //cambikarde activity
                Intent objIntent = new Intent(login.this, Principal1.class);

                startActivity(objIntent);


                //no se pueda retroceder
                finish();
                Toast.makeText(getApplicationContext(), "BIENVENIDO  :" + nomb.toUpperCase() + "", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(getApplicationContext(), "Usuario y clave Incorrectos, por favor Ingrese Nuevamente", Toast.LENGTH_LONG).show();


            }


            progressDialog.dismiss();

        }

    }


}
