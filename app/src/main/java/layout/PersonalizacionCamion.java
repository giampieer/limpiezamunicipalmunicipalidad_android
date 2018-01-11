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

/**
 * Created by Home on 08/07/2017.
 */

public class PersonalizacionCamion extends BaseAdapter

{


    private static ArrayList<camionbean> lista;
    private LayoutInflater minflater;


    static class ViewHolder {
        TextView LBLCODCAMION;
        TextView LBLMARCA;
        TextView LBLMODELO;
        TextView LBLMATRICULA;


    }


    public PersonalizacionCamion(Context context, ArrayList<camionbean> lista) {

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


        PersonalizacionCamion.ViewHolder holder;
        if (convertView == null) {

            convertView = minflater.inflate(R.layout.grillacamiones, null);
            holder = new PersonalizacionCamion.ViewHolder();
            holder.LBLCODCAMION = (TextView) convertView.findViewById(R.id.LBLCODCAMION);
            holder.LBLMARCA= (TextView) convertView.findViewById(R.id.LBLMARCA);
            holder.LBLMODELO= (TextView) convertView.findViewById(R.id.LBLMODELO);
            holder.LBLMATRICULA= (TextView) convertView.findViewById(R.id.LBLMATRICULA);


            convertView.setTag(holder);


        } else {
            holder = (PersonalizacionCamion.ViewHolder) convertView.getTag();


        }

        holder.LBLCODCAMION.setText("NUMERO DEL CAMION : " + lista.get(position).getIdcamiones());
        holder.LBLMARCA.setText("MARCA: " + lista.get(position).getMarca());
        holder.LBLMODELO.setText("MODELO: " + lista.get(position).getModelo());
        holder.LBLMATRICULA.setText("MATRICULA: " + lista.get(position).getMatricula());

        return convertView;

    }

}
