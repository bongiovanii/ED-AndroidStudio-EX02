package com.example.aplicacaexercio02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
        EditText inputConsumoMedio;
        EditText inputLitros;
        Button buttonCalcular;
        TextView resultado;
    public float calcularKmRodados(float consumoMedio, float litros){
        /*
            Eu tenho que pegar o consumo do carro "por exemplo: 30km por litro - ou seja
            o carro roda 30km e gasta um litro de combustivel "

            Depois, eu pego esse consumo e multiplico pela quantidade de litros que foram
            abastecidos, o resultado sera dado em km e eu devo converter para metros.


         */

        float resultadoEmQuilometro = consumoMedio * litros;
        return resultadoEmQuilometro * 1000;
    }
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

        inputConsumoMedio = findViewById(R.id.editTextConsumoMedio);
        inputLitros = findViewById(R.id.editTextLitros);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        resultado = findViewById(R.id.textViewResultado);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strConsumoMedio =  inputConsumoMedio.getText().toString();
                String strLitros = inputLitros.getText().toString();

                float floConsumoMedio = Float.parseFloat(strConsumoMedio);
                float floLitros =  Float.parseFloat(strLitros);

                if(strConsumoMedio.isEmpty() || strLitros.isEmpty()){
                    resultado.setText("Por favor preencha os campos necessarios!");
                }

                float autonomia = calcularKmRodados(floConsumoMedio,floLitros);
                String metrosRodados = "O carro poderá rodar " + autonomia + " metros antes de acabar a gasolina";
                resultado.setText(metrosRodados);
            }
        });



    }
}