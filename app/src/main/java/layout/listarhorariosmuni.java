package layout;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.ArrayList;

import principal.android.empresa.prototipo.R;
import principal.android.empresa.prototipo.bean.horariobean;
import principal.android.empresa.prototipo.dao.prototipodao;

/**
 * Created by Home on 08/07/2017.
 */

public class listarhorariosmuni extends Fragment {


    public listarhorariosmuni() {
        // Required empty public constructor
    }
    ListView LSTRELACION;
    SwipeRefreshLayout swipeContainer;
    int estado;
    FloatingActionButton fab;
    private static final int DURATION = 150;

    prototipodao objdao=null;
    ArrayList<horariobean> listado;
    @SuppressLint("InlinedApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View obj=inflater.inflate(R.layout.fragments_listarhorariomunicipalidad, container, false);
        //swipeContainer = (SwipeRefreshLayout) obj.findViewById(R.id.swipe_proy);
        //swipeContainer.setOnRefreshListener(this);
        LSTRELACION=(ListView)obj.findViewById(R.id.LISTACAMIONES);

        listar();
        //BOTON AGREGAR PROYECTO
        fab = (FloatingActionButton) obj.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager = getFragmentManager();
                //cambiar de fragments
                //addToBackStack=null para que  se guarde en fila
                grabarhorario container1Fragment = new grabarhorario();
                fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container1Fragment).addToBackStack(null).commit();
            }
        });
        return obj;

    }
    public void listar(){
        new listarhorariosmuni.async_listar_horario().execute();
    }





    class async_listar_horario extends AsyncTask<Void, Void, String> {

        private ProgressDialog progressDialog;
        JSONObject objeto;

        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(getActivity(), "", "Cargando Horario ", true);

        }

        @Override
        protected String doInBackground(Void... obj) {
            String mensaje="";

            objdao=new prototipodao();
            listado=objdao.listarhorario();

            return mensaje;
        }
        protected void onPostExecute(String result) {

            LSTRELACION.setAdapter(new PersonalizacionHorario(getActivity(), listado));
            progressDialog.dismiss();
        }

    }}
