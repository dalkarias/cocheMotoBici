package danielpl.ejerciciodevolucioninformacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
    }

    private void inicializarVariablesVisuales() {
        txtMarca = findViewById(R.id.txt_marca_bici);
        txtPulgadas = findViewById(R.id.txt_pulgadas_bici);
        btnCerrar = findViewById(R.id.btn_bici_cerrar);
        btnAdd = findViewById(R.id.btn_bici_add);
    }
}