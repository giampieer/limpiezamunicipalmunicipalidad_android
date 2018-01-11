package layout;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.os.CancellationSignal;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import principal.android.empresa.prototipo.R;
import principal.android.empresa.prototipo.login;

/**
 * Created by Home on 08/07/2017.
 */

public class grabar_loginpersonas extends AppCompatActivity implements View.OnClickListener {

    Button btnretroceder;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.grabar_login_personas);



    }

    @Override
    public void onClick(View view) {
        if(view==btnretroceder)
        {
            Intent objIntent = new Intent(grabar_loginpersonas.this, login.class);

            startActivity(objIntent);
        finish();}
     }
    @Override
    public void onBackPressed() {
        Intent objIntent = new Intent(grabar_loginpersonas.this, login.class);

        startActivity(objIntent);
        finish();
    }

}

