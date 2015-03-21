package itesm.mx.hackmty2015;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class SignUpActivity extends ActionBarActivity {

    // Declaracion de Variables
    EditText nombreUsuarioET;
    Button signupBT;
    String [] usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // Referencias a Objetos de Interface
        nombreUsuarioET = (EditText) findViewById(R.id.nombreUsuarioET);
        signupBT = (Button) findViewById(R.id.signupBT);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
        }
    }

    public void onClickRegistrarse(View v){
        Intent registrarseIntent = new Intent (SignUpActivity.this, MainActivity.class);

        registrarseIntent.putExtra("nombreUsuario", nombreUsuarioET.getText().toString());

        startActivity(registrarseIntent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sign_up, menu);
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
