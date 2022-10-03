package danielpl.ejerciciodevolucioninformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import danielpl.ejerciciodevolucioninformacion.Modelos.Coche;

public class CocheActivity extends AppCompatActivity {

    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtColor;
    private Button btnCerrar;
    private Button btnAdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coche);

        inicializarVariablesVisuales();

        // USO DE BOTONES
        // Guardamos la informacion en un OBJETO
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Coche co1 = new Coche(txtMarca.getText().toString(),
                                    txtModelo.getText().toString(),
                                    txtColor.getText().toString());

                Bundle mochila = new Bundle();
                mochila.putSerializable("COCHE",co1);

                // TENEMOS QUE MANDAR ESA INFORMACION
                // al main activity principal
                Intent intentVacio = new Intent();
                intentVacio.putExtras(mochila);
                setResult(RESULT_OK,intentVacio);
                // cuando añadamos un objeto cerramos ventana
                finish();
            }
        });

        // CERRAR VENTANA

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void inicializarVariablesVisuales() {
        txtMarca = findViewById(R.id.txt_marca_coche);
        txtModelo = findViewById(R.id.txt_modelo_coche);
        txtColor = findViewById(R.id.txt_color_coche);
        btnCerrar = findViewById(R.id.btn_coche_cerrar);
        btnAdd = findViewById(R.id.btn_coche_add);
    }


}