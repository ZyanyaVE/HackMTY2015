package itesm.mx.hackmty2015;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    // Declaracion de Variables
    private static final int REQUEST_CODE = 1;          // Code usado para response de signup
    ArrayList usuarios = new ArrayList<String>();       // Lista de usuarios
    EditText userET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a objetos de interface
        userET = (EditText) findViewById(R.id.nombreUsuarioET);

        // Usuarios preestablecidos
        usuarios.add("Jose123");
        usuarios.add("ILoveTec95");
    }

    // Revisa si el usuario existe antes de irse a home page
    public void onClickSignIn(View v){

        // Si el usuario existe, lleva a HomeActivity si no, despliega mensaje
        if (usuarios.contains(userET.getText().toString())){
            Intent signInIntent = new Intent(MainActivity.this, HomeActivity.class);
            signInIntent.putExtra("usuario", userET.getText().toString());

            startActivity(signInIntent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Usuario inexistente", Toast.LENGTH_SHORT).show();
        }
    }

    // Cuando se tiene que realizar un signup
    public void onClickSignUp(View v){
        Intent signUpIntent = new Intent(MainActivity.this, SignUpActivity.class);
        signUpIntent.putExtra("usuarios", usuarios);  // Se envia la lista para saber si ya existe el usuario

        startActivityForResult(signUpIntent, REQUEST_CODE);
    }

    // Recibe los argumentos de retorno del SignUpActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            usuarios.add(data.getExtras().get("nombreUsuario".toString()));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
