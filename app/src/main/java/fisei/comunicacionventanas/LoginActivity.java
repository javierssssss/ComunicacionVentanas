package fisei.comunicacionventanas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private TextView tv_Nombre;
    private TextView tv_Apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv_Nombre = findViewById(R.id.tv_Nombre);
        tv_Apellido = findViewById(R.id.tv_Apellido);
    }


    public void clic_Ingresar(View view){
        String nombre =tv_Nombre.getText().toString();
        String apellido =tv_Apellido.getText().toString();
       if (!nombre.equals("") && !apellido.equals("")){

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("extra_Nombre",nombre);
            intent.putExtra("extra_Apellido",apellido);
            startActivity(intent);

        }else{
            Toast.makeText(this,"Llenar campos por favor",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean isFinishing() {
        return super.isFinishing();
    }
}