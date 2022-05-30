package lucas.davila.conceitosintent;

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
    private static int REQUEST_CODE = 2;
    private TextView tvOutroTexto;
    private Button btnResposta;
    private EditText edtDigiteOutraPergunta;
    private ImageButton imgbClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        tvOutroTexto           = findViewById(R.id.tvOutroTexto);
        btnResposta            = findViewById(R.id.btnResposta);
        edtDigiteOutraPergunta = findViewById(R.id.edtDigiteOutraPergunta);
        imgbClear              = findViewById(R.id.imgbClear);

        Bundle extras = getIntent().getExtras();

        /*String pergunta = "";
        if(extras != null) {
            pergunta = extras.getString("Pergunta");

            String resposta = extras.getString("Resposta");
            if (extras != null) {
            if(!resposta.isEmpty()){
                edtDigiteOutraPergunta.setText(resposta);
            }
        }*/

        btnResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { finish();}
                /*if (!edtDigiteOutraPergunta.getText().toString().isEmpty()) {
                } else {
                    Toast.makeText(RespostaActivity.this, "Por favor, digite a pergunta", Toast.LENGTH_SHORT).show();
                    Intent irParaOutraActivity = new Intent(RespostaActivity.this, MainActivity.class);
                    startActivity(irParaOutraActivity);
                }
            }*/
        });

        imgbClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtDigiteOutraPergunta.setText("");
            }
        });
    }

    @Override
    public void finish(){
        Intent resposta = new Intent();

        String returnString = edtDigiteOutraPergunta.getText().toString();
        resposta.putExtra("Resposta", returnString);

        setResult(RESULT_OK, resposta);
        super.finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:{
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent pergunta) {
        super.onActivityResult(requestCode, resultCode, pergunta);

        if ((requestCode == REQUEST_CODE) && (resultCode == RESULT_OK)) {

            String returnString = pergunta.getExtras().getString("Pergunta");
            String resposta     = pergunta.getExtras().getString("Resposta");

            if(resposta != null) {
                if (!resposta.isEmpty()) {
                    edtDigiteOutraPergunta.setText(resposta);
                }
            }
            tvOutroTexto.setText(returnString);

            /*btnResposta.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) { finish();}
            });*/
        }
    }
}