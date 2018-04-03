package org.salud.materialdesign.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import org.salud.materialdesign.MainActivity;
import org.salud.materialdesign.R;

/**
 * Created by jalfaro on 4/2/18.
 */

public class Option1Fragment extends Fragment implements View.OnClickListener {
    private EditText sumando1, sumando2;
    private Button sumar;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.option1_fragment_layout, null);
        sumando1 = v.findViewById(R.id.sumando1);
        sumando2 = v.findViewById(R.id.sumando2);
        sumar = v.findViewById(R.id.btnSumar);
        sumar.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        int total = Integer.parseInt(sumando1.getText().toString()) + Integer.parseInt(sumando2.getText().toString());
        ((MainActivity)getActivity()).setAlertText(total + "");

    }
}
