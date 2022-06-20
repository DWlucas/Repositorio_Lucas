package davila.lucas.uno.conceitosclassesabstrataseinterfaces.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import davila.lucas.uno.conceitosclassesabstrataseinterfaces.R;

public class MensagemFragment extends Fragment {

    public MensagemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layoutFragment = inflater.inflate(R.layout.fragment_mensagem, container, false);


        return layoutFragment;
    }
}
