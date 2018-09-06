package com.example.reico_000.prescriptionreadernfc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class NewReportSymptoms extends Fragment implements View.OnClickListener {

    public String symptoms;
    public MainActivity mainActivity;

    private RadioButton symptom1;
    private RadioButton symptom2;
    private RadioButton symptom3;
    private RadioButton severity1;
    private RadioButton severity2;
    private RadioButton severity3;
    private RadioButton severity4;

    private EditText comment;

    private Button button;




    Communicator comm;
    private Inventory.OnFragmentInteractionListener mListener;


    public NewReportSymptoms() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ReportedSymptoms", "NewReportedSymptomsList Fragment was created");
        setHasOptionsMenu(true);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.reportsymptoms, container, false);
        // Inflate the layout for this fragment

        button = (Button) view.findViewById(R.id.button_submit);
        symptom1 = (RadioButton) view.findViewById(R.id.symptom1);
        symptom2 = (RadioButton) view.findViewById(R.id.symptom2);
        symptom3 = (RadioButton) view.findViewById(R.id.symptom3);
        severity1 = (RadioButton) view.findViewById(R.id.severity1);
        severity2 = (RadioButton) view.findViewById(R.id.severity2);
        severity3 = (RadioButton) view.findViewById(R.id.severity3);
        severity4 = (RadioButton) view.findViewById(R.id.severity4);
        comment = (EditText) view.findViewById(R.id.edittext2);



        button.setOnClickListener(this);

        return view;
    }

//                Intent intent = new Intent(NewReportSymptoms.this.getActivity(), MainActivity.class);
//                intent.putExtra("symptoms", symptoms);
//                startActivity(intent);


    @Override
    public void onPrepareOptionsMenu(Menu menu) {

        menu.findItem(R.id.action_legends).setVisible(false);
        menu.findItem(R.id.action_legends2).setVisible(true);
//        menu.findItem(R.id.action_report).setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_NEVER);
        super.onPrepareOptionsMenu(menu);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mListener = (Inventory.OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        comm = (Communicator) getActivity();

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        final String string1 = getResources().getString(R.string.symptom1);
        final String string2 = getResources().getString(R.string.symptom2);
        final String string3 = getResources().getString(R.string.symptom3);
        final String string4 = getResources().getString(R.string.severitylevel1);
        final String string5 = getResources().getString(R.string.severitylevel2);
        final String string6 = getResources().getString(R.string.severitylevel3);
        final String string7 = getResources().getString(R.string.severitylevel4);
        final String string8 = comment.getText().toString();
        final String string9 = "";
        final String string10 = getResources().getString(R.string.comment);

        if (id == R.id.button_submit) {
            Log.d("Button clicked", "Submit");

            symptoms = "";

            if (severity1.isChecked()) {
                symptoms = symptoms + string4 + " ";
                Log.d("ReportedSymptoms", "severity1 detected");
            }
            if (severity2.isChecked()) {
                symptoms = symptoms + string5 + " ";
                Log.d("ReportedSymptoms", "severity2 detected");
            }
            if (severity3.isChecked()) {
                symptoms = symptoms + string6 + " ";
                Log.d("ReportedSymptoms", "severity3 detected");
            }
            if (severity4.isChecked()) {
                symptoms = symptoms + string7 + " ";
                Log.d("ReportedSymptoms", "severity4 detected");

            }

            if (symptom1.isChecked()) {
                symptoms = symptoms + string1;
                Log.d("ReportedSymptoms", "symptom1 detected");

            }
            if (symptom2.isChecked()) {
                symptoms = symptoms + string2;
                Log.d("ReportedSymptoms", "symptom2 detected");
            }
            if (symptom3.isChecked()) {
                symptoms = symptoms + string3;
                Log.d("ReportedSymptoms", "symptom3 detected");
            }


            if (!string8.equals(string9)) {
                Log.d("ReportedSymptoms", "edittext input detected");
                if (symptoms.equals(string9)) {

                    symptoms = symptoms + string10 + " " + string8;
                } else {
                    symptoms = symptoms + ". " + string10 + " " + string8;
                }
            }

            Log.d("ReportedSymptoms", symptoms);

            ((MainActivity) getActivity()).report(symptoms);
        }


    }

}


