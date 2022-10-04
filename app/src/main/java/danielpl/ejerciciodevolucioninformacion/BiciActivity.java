package danielpl.ejerciciodevolucioninformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import danielpl.ejerciciodevolucioninformacion.Modelos.Bici;

public class BiciActivity extends AppCompatActivity {

    private EditText txtMarca;
    private EditText txtPulgadas;
    private Button btnCerrar;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bici);

        inicializarVariablesVisuales();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bici bi1 = new Bici(txtMarca.getText().toString(),
                                    Integer.parseInt(txtPulgadas.getText().toString()));
                //precaucion petara si no metes un numero pues no podra cambiarlo a string

                Bundle mochila = new Bundle();
                mochila.putSerializable("BICI",bi1);

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
        txtMarca = findViewById(R.id.txt_marca_bici);
        txtPulgadas = findViewById(R.id.txt_pulgadas_bici);
        btnCerrar = findViewById(R.id.btn_bici_cerrar);
        btnAdd = findViewById(R.id.btn_bici_add);
    }
}