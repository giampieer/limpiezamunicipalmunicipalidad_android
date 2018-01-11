package principal.android.empresa.prototipo.dao;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import principal.android.empresa.prototipo.Conexion.conexion_webservice;
import principal.android.empresa.prototipo.bean.camionbean;
import principal.android.empresa.prototipo.bean.horariobean;

/**
 * Created by Home on 08/07/2017.
 */

public class prototipodao {
    public ArrayList<camionbean> listarcamiones(){
        ArrayList<camionbean> lista=new ArrayList<camionbean>();

        //String ruta = "http://mariscal.j.facilcloud.com/mariscal1/ProyectoServlet?op=8";
        String ruta = "http://proye.jl.serv.net.mx/ev/EstuServlet?op=18";

        try {
            conexion_webservice conexion=new conexion_webservice();
            JSONObject obj = conexion.InvocarHttpClient(ruta);
            JSONArray arreglo=obj.getJSONArray("camion");
            for(int i=0;i<arreglo.length();i++){
                JSONObject objeto=arreglo.getJSONObject(i);
                camionbean relacion=new camionbean();
                relacion.setIdcamiones(objeto.getInt("codcamion") );
                relacion.setMarca(objeto.getString("marca")); ;
                relacion.setModelo(objeto.getString("modelo"));
                relacion.setMatricula(objeto.getString("matricula"));
                lista.add(relacion);

            }

        }catch (Exception e){
        }
        return lista;
    }

    public ArrayList<horariobean> listarhorario(){
        ArrayList<horariobean> lista=new ArrayList<horariobean>();

        //String ruta = "http://mariscal.j.facilcloud.com/mariscal1/ProyectoServlet?op=8";
        String ruta = "http://proye.jl.serv.net.mx/ev/EstuServlet?op=19";

        try {
            conexion_webservice conexion=new conexion_webservice();
            JSONObject obj = conexion.InvocarHttpClient(ruta);
            JSONArray arreglo=obj.getJSONArray("horario");
            for(int i=0;i<arreglo.length();i++){
                JSONObject objeto=arreglo.getJSONObject(i);
                horariobean relacion=new horariobean();
                relacion.setCodhorario(objeto.getInt("codhorario") );
                relacion.setFecha(objeto.getString("fecha"));
                relacion.setLugar(objeto.getString("lugar"));

                lista.add(relacion);

            }

        }catch (Exception e){
        }
        return lista;
    }
}
