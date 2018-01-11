package layout;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import principal.android.empresa.prototipo.R;

/**
 * Created by Home on 08/07/2017.
 */

public class mostrarproy extends DialogFragment {


    public mostrarproy() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mostrar_proy, container, false);
    }
}
