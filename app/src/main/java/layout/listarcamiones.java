package layout;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.AdapterView;
import android.widget.ListView;

import org.json.JSONObject;

import java.util.ArrayList;

import principal.android.empresa.prototipo.R;
import principal.android.empresa.prototipo.bean.camionbean;
import principal.android.empresa.prototipo.dao.prototipodao;

import static android.support.v4.view.ViewCompat.animate;

/**
 * A simple {@link Fragment} subclass.
 */
public class listarcamiones extends Fragment {


    public listarcamiones() {
        // Required empty public constructor
    }
    ListView LSTRELACION;
    SwipeRefreshLayout swipeContainer;
    int estado;
    FloatingActionButton fab;
    private static final int DURATION = 150;

prototipodao objdao=null;
    ArrayList<camionbean> listado;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View obj=inflater.inflate(R.layout.fragment_listarcamiones, container, false);
        //swipeContainer = (SwipeRefreshLayout) obj.findViewById(R.id.swipe_proy);
        //swipeContainer.setOnRefreshListener(this);
        LSTRELACION=(ListView)obj.findViewById(R.id.LISTACAMIONES);


        LSTRELACION.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                               @Override
                                               public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                                                   //fragment al cual enviar los datos
                                                   DialogFragment fragment = new mostrarproy();


                                                   fragment.show(getActivity().getSupportFragmentManager(), "etiqueta");

                                               }

                                           }
        );

        LSTRELACION.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView parent, View view, final int position, long id) {


                final CharSequence[] items = {"Ruta del Camion"};
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Opciones:");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        if(items[item]=="Ruta del Camion"){
                            //cambiar de fragments
                            listarhorario fragment = new listarhorario();

                            //cambiar de fragments
                            final FragmentTransaction ft = getFragmentManager()
                                    .beginTransaction();
                            ft.replace(R.id.contenedor_fragments, fragment);

                            //APARESCA BLANKFRAGMENT AL RETROCER
                            ft.addToBackStack("null");
                            ft.commit();
                        }
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();

                return true;
            }
        });
listar();

        return obj;

}
    public void listar(){
        new async_listar_camiones().execute();
    }





    class async_listar_camiones extends AsyncTask<Void, Void, String> {

        private ProgressDialog progressDialog;
        JSONObject objeto;

        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(getActivity(), "", "Cargando Camiones ", true);

        }

        @Override
        protected String doInBackground(Void... obj) {
            String mensaje="";

            objdao=new prototipodao();
            listado=objdao.listarcamiones();

            return mensaje;
        }
        protected void onPostExecute(String result) {

            LSTRELACION.setAdapter(new PersonalizacionCamion(getActivity(), listado));
            progressDialog.dismiss();
        }

    }}
