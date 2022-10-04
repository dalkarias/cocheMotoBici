package danielpl.ejerciciodevolucioninformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import danielpl.ejerciciodevolucioninformacion.Modelos.Moto;

public class MotoActivity extends AppCompatActivity {

    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtCC;
    private Button btnCerrar;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moto);

        inicializarVariablesVisuales();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Moto mo1 = new Moto(txtMarca.getText().toString(),
                                    txtModelo.getText().toString(),
                                    Integer.parseInt(txtCC.getText().toString()));
                //precaucion petara si no metes un numero pues no podra cambiarlo a string
                Bundle mochila = new Bundle();
                mochila.putSerializable("MOTO",mo1);

                Intent intentVacio = new Intent();
                intentVacio.putExtras(mochila);
                setResult(RESULT_OK,intentVacio);
                finish();
            }
        });

        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    private void inicializarVariablesVisuales() {
        txtMarca = findViewById(R.id.txt_marca_moto);
        txtModelo = findViewById(R.id.txt_modelo_moto);
        txtCC = findViewById(R.id.txt_moto_cc);
        btnCerrar = findViewById(R.id.btn_moto_cerrar);
        btnAdd = findViewById(R.id.btn_moto_add);
    }
}