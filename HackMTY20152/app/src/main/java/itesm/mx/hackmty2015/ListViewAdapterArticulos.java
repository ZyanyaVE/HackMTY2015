package itesm.mx.hackmty2015;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZyanyaVE on 3/21/15.
 */
public class ListViewAdapterArticulos extends ArrayAdapter<Articulo> {
    private Context context;
    int layoutResourceId;
    List<Articulo> listaarticulos;


    public ListViewAdapterArticulos(Context context, int idResource, List<Articulo> articulos){
        super(context, idResource, articulos);
        this.context = context;
        this.layoutResourceId = idResource;
        this.listaarticulos = articulos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;

        // convertView --> vista a reusar, si es nulo se crea
        if (row == null){
            LayoutInflater inflater =
                    (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layoutResourceId, parent, false);
        }

        // Obtiene las referencias a los objetos de renglon
        TextView nombre = (TextView) row.findViewById(R.id.nombreTV);
        TextView id = (TextView) row.findViewById(R.id.idTV);
        TextView cantidad = (TextView) row.findViewById(R.id.cantidadTV);

        // Obtiene el articulo que se encuentra en position y modifica los valores de los objetos de la vista

        System.out.println(listaarticulos.size());
        Articulo art = listaarticulos.get(position);
        nombre.setText(art.getNombre());
        //cantidad.setText(art.getCantidad());
        //id.setText(art.getId());


        // Regresa renglon con los datos actualizados
        return row;
    }

}
