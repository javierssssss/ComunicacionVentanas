package fisei.comunicacionventanas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class DatosActivity extends AppCompatActivity {
    private ListView lvDatos;
    private int codigo=1; //Para comprobar que ;a ventana se cerró completamente
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        lvDatos = findViewById(R.id.ListViewItems);
        //Crear datos
        ArrayAdapter<String> lista = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mostrarDatosListView());
        //Asociar adaptador con los datos
        lvDatos.setAdapter(lista);



        //Crear un listener
        lvDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String opcion = lvDatos.getAdapter().getItem(position).toString();

                Intent intent = new Intent();
                intent.setData(Uri.parse(opcion));
                //REGRESAR DATO
                setResult(Activity.RESULT_OK,intent);
                finish();

            }
        });

    }

    private List<String> mostrarDatosListView() {
    List<String> listaDatos = new ArrayList<>();
        for (int i = 0; i <=25; i++) {
            listaDatos.add("Buenardo: "+String.valueOf(i));
        }
    return listaDatos;
    }
}