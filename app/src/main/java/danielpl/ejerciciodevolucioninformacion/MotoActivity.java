package danielpl.ejerciciodevolucioninformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
    }

    private void inicializarVariablesVisuales() {
        txtMarca = findViewById(R.id.txt_marca_moto);
        txtModelo = findViewById(R.id.txt_modelo_moto);
        txtCC = findViewById(R.id.txt_moto_cc);
        btnCerrar = findViewById(R.id.btn_moto_cerrar);
        btnAdd = findViewById(R.id.btn_moto_add);
    }
}