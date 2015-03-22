package itesm.mx.hackmty2015;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//asdasdasdas//asdasdasdas//asdasdasdas//asdasdasdas//asdasdasdas//asdasdasdas//asdasdasdas



public class HomeActivity extends ActionBarActivity {

    // Declaración de Variables
    ListView eventLV;
    ArrayList eventos = new ArrayList<Articulo>(), fiesta = new ArrayList<Articulo>(), despensa = new ArrayList<Articulo>(), laredo = new ArrayList<Articulo>();
    HashMap<String, ArrayList<Articulo>> evento = new HashMap();
    Articulo art;
    ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Referencias a objetos de interface
        eventLV = (ListView) findViewById(R.id.eventLV);

        // Cuando se hace click a un elemento de la listView se va a la pantalla de VerLista
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                // El String de la row que clickeaste
                String aux = (String) adapter.getItem(position).toString();


                ArrayList<String> listanombres = new ArrayList<String>();
                ArrayList<Integer> listaCantidad = new ArrayList<Integer>();

                for (int i = 0; i < evento.get(aux).size(); i++){
                    // Regresa el arraylist guardado en el id _ del hashmap
                    ArrayList<Articulo> art = evento.get(aux);
                    listanombres.add(art.get(i).getNombre());

                }
                ArrayList<Integer> listacantidad = new ArrayList<Integer>();
                for (int i = 0; i < evento.get(aux).size(); i++){
                    // Regresa el arraylist guardado en el id _ del hashmap
                    ArrayList<Articulo> art = evento.get(aux);
                    listaCantidad.add((art.get(i).getCantidad()));
                }

                Intent verListaIntent = new Intent(HomeActivity.this, VerListaActivity.class);

                verListaIntent.putExtra("articulos", listanombres);
                verListaIntent.putExtra("cantidades",listaCantidad);

                startActivity(verListaIntent);
            }
        };
        eventLV.setOnItemClickListener(itemListener);

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
    }

    public void onClickAddList(View v){
        Intent addListIntent = new Intent();


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
