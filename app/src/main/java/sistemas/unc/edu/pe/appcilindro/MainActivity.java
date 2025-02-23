package sistemas.unc.edu.pe.appcilindro;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import Models.Cilindro;

public class MainActivity extends AppCompatActivity {

    EditText txtRadio,txtAltura;
    TextView lbVolumen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtRadio=findViewById(R.id.txtRadio);
        txtAltura=findViewById(R.id.txtAltura);
        lbVolumen=findViewById(R.id.lbVolumen);
        lbVolumen.setText("");

    }

    public  void CalcularVolumen(View Boton) {// EVENTO VIEW
        //validar
        if(validar())//si valida retorna true entonces el metodo calcular termina
            return;
        // ver los datos
        double radio = Double.valueOf(txtRadio.getText().toString());
        double altura = Double.valueOf(txtAltura.getText().toString());
        Cilindro oC =new Cilindro(radio,altura);
        lbVolumen.setText(oC.toString());

    }
    private boolean validar(){
        if(txtRadio.getText().toString().trim().isEmpty()){//trim suprime espacios
            txtRadio.setError("Campo obligatorio para radio de la base");
            txtRadio.requestFocus();
            return true;
        }
        if(txtAltura.getText().toString().trim().isEmpty()){//trim suprime espacios
            txtAltura.setError("Campo obligatorio para altura");
            txtAltura.requestFocus();
            return true;
        }
        return false;
    }

}