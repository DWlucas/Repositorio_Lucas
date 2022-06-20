package davila.lucas.uno.calcular;

import static java.lang.Integer.parseInt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import davila.lucas.uno.calcular.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView tvOpcao, tvResultado;
    private ImageView imgvOperacao, imgvIgual;
    private EditText edtOperando1, edtOperando2, edtResultado;
    private Spinner spiOpcoes;
    private Button btnCalcular;
    private int empty;
    public static final String SOMA          = "Soma";
    public static final String SUBTRACAO     = "Subtração";
    public static final String MULTIPLICACAO = "Multiplicação";
    public static final String DIVISAO       = "Divisão";
    public static final String RAIZ          = "Raiz";
    public static final String POTENCIA      = "Potencia";
    private static final String TAG          = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Calcular");
        }

        tvOpcao      = findViewById(R.id.tvOpcao);
        tvResultado  = findViewById(R.id.tvResultado);
        imgvOperacao = findViewById(R.id.imgvOperacao);
        imgvIgual    = findViewById(R.id.imgvIgual);
        edtOperando1 = findViewById(R.id.edtOperando1);
        edtOperando2 = findViewById(R.id.edtOperando2);
        spiOpcoes    = findViewById(R.id.spiOpcoes);
        btnCalcular  = findViewById(R.id.btnCalcular);

        imgvOperacao.setVisibility(View.INVISIBLE);

        ArrayAdapter<String> adapterOperacoesMatematicas = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.operacoes_matematicas));
        adapterOperacoesMatematicas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //adapter - fazer com que o conteúdo seja exibido na spinner
        //AlertDialog.Builder spinner;

        spiOpcoes.setAdapter(adapterOperacoesMatematicas);
        spiOpcoes.setOnItemSelectedListener(this);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String opcaoSelecionada = spiOpcoes.getSelectedItem().toString();

                if (opcaoSelecionada.equals(SOMA)) {
                    tvResultado.setText(somar());

                    //System.out.println(edtInserirNumero1 + edtInserirNumero2.getText().toString());
                } else if (opcaoSelecionada.equals(SUBTRACAO)) {
                    tvResultado.setText(subtrair());

                } else if (opcaoSelecionada.equals(MULTIPLICACAO)) {
                    tvResultado.setText(multiplicar());

                } else if (opcaoSelecionada.equals(DIVISAO)) {
                    tvResultado.setText(dividir());

                } else if (opcaoSelecionada.equals(RAIZ)) {
                    tvResultado.setText(radicar());

                } else if (opcaoSelecionada.equals(POTENCIA)) {
                    tvResultado.setText(potenciar());

                } else {

                    Toast.makeText(MainActivity.this, "Selecione uma operação matemática válida!", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, "Insira um número!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //Toast.makeText(MainActivity.this, adapterView.getItemIdAtPosition(i).toString(), Toast.LENGTH_SHORT).show();
        imgvOperacao.setVisibility(View.VISIBLE);

        if (adapterView.getItemAtPosition(i).toString().equals(DIVISAO)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_divisao_1, getTheme()));
            edtOperando1.setHint("dividendo");
            edtOperando2.setHint("divisor");
            tvResultado.setHint("quociente");

        } else if (adapterView.getItemAtPosition(i).toString().equals(MULTIPLICACAO)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_multiplica, getTheme()));
            edtOperando1.setHint("fator");
            edtOperando2.setHint("fator");
            tvResultado.setHint("produto");

        } else if (adapterView.getItemAtPosition(i).toString().equals(SOMA)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_soma, getTheme()));
            edtOperando1.setHint("parcela");
            edtOperando2.setHint("parcela");
            tvResultado.setHint("total");

        } else if (adapterView.getItemAtPosition(i).toString().equals(SUBTRACAO)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_subtracao, getTheme()));
            edtOperando1.setHint("minuendo");
            edtOperando2.setHint("subtraendo");
            tvResultado.setHint("diferença");

        } else if (adapterView.getItemAtPosition(i).toString().equals(RAIZ)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_rq, getTheme()));
            edtOperando1.setHint("radicando");
            edtOperando2.setHint("radicando");
            tvResultado.setHint("total");

        } else if (adapterView.getItemAtPosition(i).toString().equals(POTENCIA)) {
            imgvOperacao.setImageDrawable(getResources().getDrawable(R.drawable.ic_potencia, getTheme()));
            edtOperando1.setHint("potenciando");
            edtOperando2.setHint("potenciando");
            tvResultado.setHint("total");



        } else {
            Log.d(TAG, "Nenhuma opção foi selecionada");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private boolean validarOperacoes() {
        int n1 = Integer.valueOf(edtOperando1.getText().toString());
        int n2 = Integer.valueOf(edtOperando2.getText().toString());

        if (n1 != empty) {
            return true;
        } else {
            return false;
        }

    }

    private String somar() {
        int n1 = parseInt(edtOperando1.getText().toString());
        int n2 = parseInt(edtOperando2.getText().toString());
        int resultado = n1 + n2;
        return "O resultado da soma é: " + resultado;
    }

    private String subtrair() {
        int n1 = parseInt(edtOperando1.getText().toString());
        int n2 = parseInt(edtOperando2.getText().toString());
        int resultado = n1 - n2;
        return "O resultado da subtração é: " + resultado;
    }

    private String multiplicar() {
        int n1 = parseInt(edtOperando1.getText().toString());
        int n2 = parseInt(edtOperando2.getText().toString());
        int resultado = n1 * n2;
        return "O resultado da multiplicação é: " + resultado;
    }

    private String dividir() {
        int n1 = parseInt(edtOperando1.getText().toString());
        int n2 = parseInt(edtOperando2.getText().toString());
        int resultado = n1 / n2;
        return "O resultado da divisão é: " + resultado;
    }

    private String radicar() {
        /*int resultado = 0;
        try {
            int n1 = Integer.valueOf(edtOperando1.getText().toString());
            resultado = (int) Math.sqrt(n1);
        } catch (NumberFormatException e){
            Log.d(TAG, "radicar: " + e.getMessage());
            e.printStackTrace();
        }*/
        int resultado = (int) Math.s

        return "O resultado da radiação é: " + resultado;
    }

    private String potenciar() {
        int n1 = parseInt(edtOperando1.getText().toString());
        int n2 = parseInt(edtOperando2.getText().toString());
        int resultado = n1 / n2;
        return "O resultado da potenciação é: " + resultado;
    }

    private boolean validarTermoVazio(EditText editText) {
        return editText.getText().toString().isEmpty();
    }
}


