package layout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import principal.android.empresa.prototipo.R;
import principal.android.empresa.prototipo.bean.camionbean;
import principal.android.empresa.prototipo.bean.horariobean;

/**
 * Created by Home on 08/07/2017.
 */

public class PersonalizacionHorario extends BaseAdapter

{


    private static ArrayList<horariobean> lista;
    private LayoutInflater minflater;


    static class ViewHolder {
        TextView LBLCODHORARIO;
        TextView LBLFECHA;
        TextView LBLLUGAR;



    }


    public PersonalizacionHorario(Context context, ArrayList<horariobean> lista) {

        this.minflater = minflater.from(context);
        this.lista = lista;


    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int i) {
        return lista.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        PersonalizacionHorario.ViewHolder holder;
        if (convertView == null) {

            convertView = minflater.inflate(R.layout.grillahorario, null);
            holder = new PersonalizacionHorario.ViewHolder();
            holder.LBLCODHORARIO = (TextView) convertView.findViewById(R.id.LBLCODHORARIO);
            holder.LBLFECHA= (TextView) convertView.findViewById(R.id.LBLFECHA);
            holder.LBLLUGAR= (TextView) convertView.findViewById(R.id.LBLLUGAR);


            convertView.setTag(holder);


        } else {
            holder = (PersonalizacionHorario.ViewHolder) convertView.getTag();


        }

        holder.LBLCODHORARIO.setText("NUMERO DEL CAMION : " + lista.get(position).getCodhorario());
        holder.LBLFECHA.setText("MARCA: " + lista.get(position).getFecha());
        holder.LBLLUGAR.setText("MODELO: " + lista.get(position).getLugar());

        return convertView;

    }

}
