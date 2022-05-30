package davila.lucas.uno.conceitofragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

public class ToolbarFragment extends Fragment implements SeekBar.OnSeekBarChangeListener {
    private EditText edtInformarTexto;
    private SeekBar skbFormatarTexto;
    private Button btnTexto;
    private ToolbarListener toolbarListener;
    private static int TEXT_SIZE = 10;

    public interface ToolbarListener{
        public void onButtonClick(int position, String texto);

    }

    public ToolbarFragment(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tooBarLayoutInflated = inflater.inflate(R.layout.fragment_toolbar, container, false);

        edtInformarTexto = tooBarLayoutInflated.findViewById(R.id.edtInformarTexto);
        skbFormatarTexto = tooBarLayoutInflated.findViewById(R.id.skbFormatarTexto);
        btnTexto         = tooBarLayoutInflated.findViewById(R.id.btnTexto);


        btnTexto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClicked(view);
            }
        });

        skbFormatarTexto.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)this);

        return tooBarLayoutInflated;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            toolbarListener = (ToolbarListener) context;

        }
        catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
            + "Obrigatório implementar a interface Toolbarlistener");
        }
    }
    private void buttonClicked(View view){
        toolbarListener.onButtonClick(TEXT_SIZE, edtInformarTexto.getText().toString());

    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}