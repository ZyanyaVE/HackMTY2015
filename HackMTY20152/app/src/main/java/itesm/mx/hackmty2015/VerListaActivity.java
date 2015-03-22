package itesm.mx.hackmty2015;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class VerListaActivity extends ActionBarActivity {

/*
    // Articulos por evento
    art = new Articulo(0, "Cerveza", 20);
    fiesta.add(art);
    art = new Articulo(1, "Papas", 10);
    fiesta.add(art);
    art = new Articulo(2, "Chocolates", 2);
    fiesta.add(art);
    art = new Articulo(3, "Coca", 5);
    fiesta.add(art);
    art = new Articulo(0, "Coca", 5);
    despensa.add(art);
    art = new Articulo(1, "Coca", 5);
    despensa.add(art);
    art = new Articulo(2, "Coca", 5);
    despensa.add(art);
    art = new Articulo(0, "XBox", 1);
    laredo.add(art);
    art = new Articulo(1, "Mac", 10);
    laredo.add(art);




    // Inicializacion Lista de Eventos
    eventos.add("Fiesta"); eventos.add("Despensa Familia") ; eventos.add("Ida a Laredo");

    // Hashmap que guarda los arraylists de articulos segun el evento en el que deben ir
    evento.put("Fiesta", fiesta);
    evento.put("Despensa Familia", despensa);
    evento.put("Ida a Laredo", laredo);


    adapter = new ArrayAdapter<String>(this, R.layout.evento_row,R.id.rowTV,eventos);

    eventLV.setAdapter(adapter);
  */
    // Declaracion de Variables
    ArrayList<String> articulos = new ArrayList<String>();
    ArrayList<Integer> cantidades = new ArrayList<Integer>();
    ListView articulosLV;
    ListViewAdapterArticulos adapter;
    List<Articulo> art = new ArrayList<Articulo>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_lista);

        // Referencias a articulos de interface
        articulosLV = (ListView) findViewById(R.id.articulosLV);

        // Se coloca el arreglo de dispositivos en la lista
        adapter = new ListViewAdapterArticulos(getApplicationContext(), R.layout.listaarticulos_row, getDataForListView());
        articulosLV.setAdapter(adapter);

        getDataForListView();

    }

    public List<Articulo> getDataForListView(){
        Articulo auxArticulos;

        // Se recupera de bundle extras el ArrayList articulos del evento presionado en HomeActivity
        Bundle extras = getIntent().getExtras();

        articulos = extras.getStringArrayList("articulos");
        cantidades = extras.getIntegerArrayList("cantidades");

        for (int i = 0; i < articulos.size(); i++){
            auxArticulos = new Articulo(i, articulos.get(i).toString(), cantidades.get(i));
            art.add(auxArticulos);
        }
        return art;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ver_lista, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}