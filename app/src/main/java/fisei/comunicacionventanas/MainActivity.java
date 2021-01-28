package fisei.comunicacionventanas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText etWelcome2;
    public int  codigoReq=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.etWelcome);
        etWelcome2 = findViewById(R.id.etWelcome);

        //Recuperar datos
        Bundle data = getIntent().getExtras();
        String nombre = data.getString("extra_Nombre");
        String apellido = data.getString("extra_Apellido");
        etWelcome2.setText("Bienvenido: " + nombre + " "+ apellido);
        Toast.makeText(this,nombre+"  "+apellido,Toast.LENGTH_LONG).show();
    }
    public void MostrarActivity(View view){
        Intent intent = new Intent(this,DatosActivity.class);
       // startActivity(intent);
        //Para regresar se usa
        startActivityForResult(intent,codigoReq);
    }
    //Cuando hija se cierre


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

            if (requestCode==codigoReq && resultCode==RESULT_OK){
                etWelcome2.setText("El valor es"+data.getDataString());
            }
    }
}