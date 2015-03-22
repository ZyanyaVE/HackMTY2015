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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HomeActivity extends ActionBarActivity {

    // Declaración de Variables
    ListView eventLV;
    ArrayList eventos = new ArrayList<String>();
    HashMap<int, Object> mapper = new HashMap();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Referencias a objetos de interface
        eventLV = (ListView) findViewById(R.id.eventLV);

        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){

            }
        };
        eventLV.setOnItemClickListener(itemListener);

        eventos.add("Fiesta"); eventos.add("Despensa Familia") ; eventos.add("Ida a Laredo");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.evento_row,R.id.rowTV,eventos);

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
