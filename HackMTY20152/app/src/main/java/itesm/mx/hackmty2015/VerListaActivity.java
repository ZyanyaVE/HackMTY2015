package itesm.mx.hackmty2015;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.TextureView;
import android.widget.TextView;

import java.util.ArrayList;


public class VerListaActivity extends ActionBarActivity {

    // Declaracion de Variables
    TextView helloWorld;
    TextView productPrice;
    ArrayList<String> aux = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_lista);

        helloWorld = (TextView) findViewById(R.id.HelloWorld);
        productPrice = (TextView) findViewById(R.id.Price);

        Bundle extras = getIntent().getExtras();

        aux = extras.getStringArrayList("articulos");
        helloWorld.setText(aux.get(0));

       // aux = extras.getIntegerArrayList("articulosPrecios");


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
