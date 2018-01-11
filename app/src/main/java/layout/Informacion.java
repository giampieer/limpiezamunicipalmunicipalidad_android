package layout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import principal.android.empresa.prototipo.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Informacion extends Fragment {

TextView informacion;
    public Informacion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View obj=inflater.inflate(R.layout.fragment_informacion, container, false);
        //swipeContainer = (SwipeRefreshLayout) obj.findViewById(R.id.swipe_proy);
        //swipeContainer.setOnRefreshListener(this);
        informacion=(TextView) obj.findViewById(R.id.TXTINFO);
        String texto="\n\n\n\n Nuestra plataforma móvil sirve para la localización del camión de basura distribuido por las municipalidades mediante el GPS. \n" +
                "La aplicación esta desarrollada para todas las municipalidades y para el publico indirectamente.\nDEVELOPERS:\n -MARISCAL POMACAJA GIAMPIEER \n -MOZOMBITE DELGADO LUIS \n -ALVAREZ MENDOZA CRISTHOPER \n -VILCHEZ LUCANA JHON ";

        informacion.setText(texto);

        return obj;
    }

}
