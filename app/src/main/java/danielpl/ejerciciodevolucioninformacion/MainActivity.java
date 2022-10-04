package danielpl.ejerciciodevolucioninformacion;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import danielpl.ejerciciodevolucioninformacion.Modelos.Bici;
import danielpl.ejerciciodevolucioninformacion.Modelos.Coche;
import danielpl.ejerciciodevolucioninformacion.Modelos.Moto;

public class MainActivity extends AppCompatActivity {
    
    private TextView txtcoches;
    private TextView txtmotos;
    private TextView txtbicis;
    private Button btnAddCoches;
    private Button btnAddMotos;
    private Button btnAddBicis;

    private ActivityResultLauncher<Intent> launcherCoches;
    private ActivityResultLauncher<Intent> launcherMotos;
    private ActivityResultLauncher<Intent> launcherBicis;

    private String coches = "Cantidad coches: ";
    private String motos = "Cantidad motos: ";
    private String bicis = "Cantidad bicis: ";

    private ArrayList <Coche> listaCoche = new ArrayList<>();
    private ArrayList <Moto> listaMoto = new ArrayList<>();
    private ArrayList <Bici> listaBici = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        inicializarVisuales();
        inicializarLunchers();

        //ACCION DE BOTONES
        //estos botones deben redireccionarnos a las pantallas correspondientes
        btnAddCoches.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CocheActivity.class);
                launcherCoches.launch(intent);
            }
        });
        btnAddMotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MotoActivity.class);
                launcherMotos.launch(intent);
            }
        });
        btnAddBicis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BiciActivity.class);
                launcherBicis.launch(intent);
            }
        });




    }

    //private void direccionar() {}

    private void inicializarVisuales() {
        txtcoches = findViewById(R.id.txt_coches_main);
        txtmotos = findViewById(R.id.txt_motos_main);
        txtbicis = findViewById(R.id.txt_bicis_main);
        btnAddCoches = findViewById(R.id.btn_add_coches_main);
        btnAddMotos = findViewById(R.id.btn_add_motos_main);
        btnAddBicis = findViewById(R.id.btn_add_bicis_main);
        
    }

    // Inicializamos las direcciones a las distintas pantallas
    private void inicializarLunchers() {

        launcherCoches = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()==RESULT_OK){
                            if(result.getData() != null){
                                Bundle bundle = result.getData().getExtras();
                                Coche co1 = (Coche) bundle.getSerializable("COCHE");
                                listaCoche.add(co1);
                                txtcoches.setText(coches + listaCoche.size());
                            }
                        }
                    }
                }
        );
        launcherMotos = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()==RESULT_OK){
                            if(result.getData() != null){
                                Bundle bundle = result.getData().getExtras();
                                Moto mo1 = (Moto) bundle.getSerializable("MOTO");
                                listaMoto.add(mo1);
                                txtmotos.setText(motos + listaMoto.size());
                            }
                        }
                    }
                }
        );
        launcherBicis = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode()==RESULT_OK){
                            if(result.getData() != null){
                                Bundle bundle = result.getData().getExtras();
                                Bici bi1 = (Bici) bundle.getSerializable("BICI");
                                listaBici.add(bi1);
                                txtbicis.setText(bicis+listaBici.size());
                            }
                        }
                    }
                }
        );
    }


}