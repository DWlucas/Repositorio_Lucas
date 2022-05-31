package katia.nienow.projetoconceitosintent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class RespostaActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 5;
    private Button btnResposta;
    private TextView tvOutroTexto, tvTitulo;
    private EditText edtDigiteOutraResposta;
    private ImageButton imgbLimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        btnResposta             = findViewById(R.id.btnResposta);
        tvTitulo                = findViewById(R.id.tvTitulo);
        tvOutroTexto            = findViewById(R.id.tvOutroTexto);
        edtDigiteOutraResposta  = findViewById(R.id.edtDigiteResposta);
        imgbLimpar              = findViewById(R.id.imgbLimpar);

        Bundle extras = getIntent().getExtras();

        String pergunta = "";
        if (extras != null) {
            pergunta = extras.getString("Pergunta");
            tvOutroTexto.setText(pergunta);

        }


        btnResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        imgbLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtDigiteOutraResposta.setText("");
                tvOutroTexto.setText("");
            }
        });
    }

    @Override
    public void finish() {
        Intent data = new Intent();

        String returnSring = edtDigiteOutraResposta.getText().toString();
        data.putExtra("returnData", returnSring);

        setResult(RESULT_OK, data);
        super.finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home: {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);

    }

    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //expressão booleana (o que está dentro do parênteses)
        if ((requestCode == REQUEST_CODE) && (resultCode == RESULT_OK)) {

            String perguntaRetornadaDaActivityResposta = data.getExtras().getString("Pergunta");
            String resposta = data.getExtras().getString("RecuperarResposta");

            String pergunta = tvOutroTexto.getText().toString();
            data.putExtra("PerguntaRecuperada", pergunta);

            if (resposta != null) {
                if (!resposta.isEmpty()) {
                    edtDigiteOutraResposta.setText(resposta);
                }
                    tvOutroTexto.setText(perguntaRetornadaDaActivityResposta);
                }

                if (pergunta != null) {
                    if (pergunta.isEmpty()) {
                        edtDigiteOutraResposta.setText(pergunta);
                    }
                }

            }
        }*/
    }