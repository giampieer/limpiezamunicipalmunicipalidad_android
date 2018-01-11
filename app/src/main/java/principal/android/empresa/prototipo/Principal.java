package principal.android.empresa.prototipo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import layout.Ajustes;
import layout.LISTARCAMIONESMUNI;
import layout.Servicios;
import layout.iniciomunicipalidad;
import layout.iniciopersona;
import layout.listarhorario;
import layout.listarhorariosmuni;
import layout.membresiacancelada;

public class Principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inicio();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public void inicio(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        iniciomunicipalidad container1Fragment = new iniciomunicipalidad();
        //animacion adelantar R.anim.enter_from_right, R.anim.exit_to_left
        fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container1Fragment).commit();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Servicios) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Servicios container1Fragment = new Servicios();
            //animacion adelantar R.anim.enter_from_right, R.anim.exit_to_left
            fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container1Fragment).addToBackStack(null).commit();        }
        if (id == R.id.Ajustes) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Ajustes container1Fragment = new Ajustes();
            //animacion adelantar R.anim.enter_from_right, R.anim.exit_to_left
            fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container1Fragment).addToBackStack(null).commit();
        }
        if (id == R.id.CERRARSESION) {

            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(Principal.this);
            dialogo1.setTitle("Importante");
            dialogo1.setMessage("¿Deseas cerrar sesion ?");
            dialogo1.setCancelable(false);
            dialogo1.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    cerrar_sesion();                }
            });
            dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {

                }
            });
            dialogo1.show();
        }
        if (id == R.id.membresia) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            membresiacancelada container1Fragment = new membresiacancelada();
            //animacion adelantar R.anim.enter_from_right, R.anim.exit_to_left
            fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container1Fragment).addToBackStack(null).commit();
        }

        return super.onOptionsItemSelected(item);
    }
    public void cerrar_sesion(){
        //limpiar los datos almacenados para inicar sesion
        SharedPreferences prefs = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();
        Intent intent=new Intent(Principal.this,login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.camionesregistrado) {

            FragmentManager fragmentManager = getSupportFragmentManager();
            LISTARCAMIONESMUNI container1Fragment = new LISTARCAMIONESMUNI();
            //animacion adelantar R.anim.enter_from_right, R.anim.exit_to_left
            fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container1Fragment).commit();        }



        else if (id == R.id.horariomunipalidad) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            listarhorariosmuni container1Fragment = new listarhorariosmuni();
            //animacion adelantar R.anim.enter_from_right, R.anim.exit_to_left
            fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container1Fragment).commit();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
