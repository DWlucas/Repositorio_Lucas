package lucas.davila.conceitosintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static int REQUEST_CODE = 5;
    private Button btnPergunta;
    private TextView tvExibirResposta;
    private EditText edtResposta;
    private ImageButton imgbLimparPergunta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPergunta         = findViewById(R.id.btnPergunta);
        tvExibirResposta    = findViewById(R.id.tvExibirResposta);
        edtResposta         = findViewById(R.id.edtResposta);
        imgbLimparPergunta  = findViewById(R.id.imgbLimparPergunta);

        Bundle extras = getIntent().getExtras();
        String pergunta = "";
        if (extras != null) {
            pergunta = extras.getString("Pergunta");
            tvExibirResposta.setText(pergunta);
        }

        btnPergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edtResposta.getText().toString().isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, RespostaActivity.class);

                    String myString = edtResposta.getText().toString();
                    intent.putExtra("pergunta", myString);

                    startActivityForResult(intent, REQUEST_CODE);
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, digite a pergunta", Toast.LENGTH_SHORT).show();


                }

            }
        });
        imgbLimparPergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtResposta.setText("");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == REQUEST_CODE) && (resultCode == RESULT_OK)) {

            String returnString = data.getExtras().getString("returnData");

            if (returnString != null){
                if(!returnString.isEmpty());
                    tvExibirResposta.setVisibility(View.VISIBLE);
                    tvExibirResposta.setText(returnString);
            }
        }
    }

    public void openActivityResult(){
        Intent intent = new Intent(MainActivity.this, RespostaActivity.class);

        String myString = edtResposta.getText().toString();
        intent.putExtra("Pergunta", myString);

        //ActivityResultLauncher.launch(intent);
    }
}
