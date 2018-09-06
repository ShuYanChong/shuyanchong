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
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PDFInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PDFInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PDFInfoFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Communicator comm;

    private Inventory.OnFragmentInteractionListener mListener;

    private TextView A1;
    private TextView A2;
    private TextView A3;
    private TextView A4;
    private TextView A5;
    private TextView B1;
    private TextView C1;
    private TextView C2;
    private TextView C3;
    private TextView C4;
    private TextView C5;
    private TextView D1;
    private TextView D2;
    private TextView E1;
    private TextView E2;
    private TextView E3;
    private TextView E4;
    private TextView E5;
    private TextView E6;
    private TextView E7;
    private TextView E8;
    private TextView F1;
    private TextView F2;
    private TextView F3;
    private TextView F4;
    private TextView F5;
    private TextView F6;
    private TextView G1;
    private TextView G2;
    private TextView G3;
    private TextView G4;
    private TextView H1;
    private TextView I1;
    private TextView I2;
    private TextView I3;
    private TextView I4;
    private TextView I5;
    private TextView I6;
    private TextView I7;
    private TextView L1;
    private TextView L2;
    private TextView L3;
    private TextView L4;
    private TextView L5;
    private TextView L6;
    private TextView L7;
    private TextView M1;
    private TextView M2;
    private TextView M3;
    private TextView M4;
    private TextView M5;
    private TextView M6;
    private TextView M7;
    private TextView M8;
    private TextView M9;
    private TextView M10;
    private TextView M11;
    private TextView N1;
    private TextView O1;
    private TextView O2;
    private TextView P1;
    private TextView P2;
    private TextView P3;
    private TextView P4;
    private TextView P5;
    private TextView P6;
    private TextView P7;
    private TextView P8;
    private TextView P9;
    private TextView P10;
    private TextView R1;
    private TextView R2;
    private TextView S1;
    private TextView S2;
    private TextView T1;
    private TextView T2;
    private TextView T3;
    private TextView T4;
    private TextView T5;
    private TextView T6;
    private TextView T7;
    private TextView T8;
    private TextView T9;
    private TextView T10;
    private TextView T11;
    private TextView T12;
    private TextView U1;
    private TextView U2;
    private TextView V1;
    private TextView V2;
    private TextView V3;
    private TextView V4;
    private TextView W1;

    public PDFInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PDFInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PDFInfoFragment newInstance(String param1, String param2) {
        PDFInfoFragment fragment = new PDFInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("PDF", "PDF more info Fragment was created");
        setHasOptionsMenu(true);
        }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_legends).setVisible(false);
        menu.findItem(R.id.action_legends2).setVisible(false);
//        menu.findItem(R.id.action_report).setShowAsActionFlags(MenuItem.SHOW_AS_ACTION_NEVER);
        super.onPrepareOptionsMenu(menu);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pdfinfo, container, false);

        A1 = (TextView) view.findViewById(R.id.medicine_A1);
        A2 = (TextView) view.findViewById(R.id.medicine_A2);
        A3 = (TextView) view.findViewById(R.id.medicine_A3);
        A4 = (TextView) view.findViewById(R.id.medicine_A4);
        A5 = (TextView) view.findViewById(R.id.medicine_A5);

        B1 = (TextView) view.findViewById(R.id.medicine_B1);

        C1 = (TextView) view.findViewById(R.id.medicine_C1);
        C2 = (TextView) view.findViewById(R.id.medicine_C2);
        C3 = (TextView) view.findViewById(R.id.medicine_C3);
        C4 = (TextView) view.findViewById(R.id.medicine_C4);
        C5 = (TextView) view.findViewById(R.id.medicine_C5);

        D1 = (TextView) view.findViewById(R.id.medicine_D1);
        D2 = (TextView) view.findViewById(R.id.medicine_D2);

        E1 = (TextView) view.findViewById(R.id.medicine_E1);
        E2 = (TextView) view.findViewById(R.id.medicine_E2);
        E3 = (TextView) view.findViewById(R.id.medicine_E3);
        E4 = (TextView) view.findViewById(R.id.medicine_E4);
        E5 = (TextView) view.findViewById(R.id.medicine_E5);
        E6 = (TextView) view.findViewById(R.id.medicine_E6);
        E7 = (TextView) view.findViewById(R.id.medicine_E7);
        E8 = (TextView) view.findViewById(R.id.medicine_E8);

        F1 = (TextView) view.findViewById(R.id.medicine_F1);
        F2 = (TextView) view.findViewById(R.id.medicine_F2);
        F3 = (TextView) view.findViewById(R.id.medicine_F3);
        F4 = (TextView) view.findViewById(R.id.medicine_F4);
        F5 = (TextView) view.findViewById(R.id.medicine_F5);
        F6 = (TextView) view.findViewById(R.id.medicine_F6);

        G1 = (TextView) view.findViewById(R.id.medicine_G1);
        G2 = (TextView) view.findViewById(R.id.medicine_G2);
        G3 = (TextView) view.findViewById(R.id.medicine_G3);
        G4 = (TextView) view.findViewById(R.id.medicine_G4);

        H1 = (TextView) view.findViewById(R.id.medicine_H1);

        I1 = (TextView) view.findViewById(R.id.medicine_I1);
        I2 = (TextView) view.findViewById(R.id.medicine_I2);
        I3 = (TextView) view.findViewById(R.id.medicine_I3);
        I4 = (TextView) view.findViewById(R.id.medicine_I4);
        I5 = (TextView) view.findViewById(R.id.medicine_I5);
        I6 = (TextView) view.findViewById(R.id.medicine_I6);
        I7 = (TextView) view.findViewById(R.id.medicine_I7);

        L1 = (TextView) view.findViewById(R.id.medicine_L1);
        L2 = (TextView) view.findViewById(R.id.medicine_L2);
        L3 = (TextView) view.findViewById(R.id.medicine_L3);
        L4 = (TextView) view.findViewById(R.id.medicine_L4);
        L5 = (TextView) view.findViewById(R.id.medicine_L5);
        L6 = (TextView) view.findViewById(R.id.medicine_L6);
        L7 = (TextView) view.findViewById(R.id.medicine_L7);

        M1 = (TextView) view.findViewById(R.id.medicine_M1);
        M2 = (TextView) view.findViewById(R.id.medicine_M2);
        M3 = (TextView) view.findViewById(R.id.medicine_M3);
        M4 = (TextView) view.findViewById(R.id.medicine_M4);
        M5 = (TextView) view.findViewById(R.id.medicine_M5);
        M6 = (TextView) view.findViewById(R.id.medicine_M6);
        M7 = (TextView) view.findViewById(R.id.medicine_M7);
        M8 = (TextView) view.findViewById(R.id.medicine_M8);
        M9 = (TextView) view.findViewById(R.id.medicine_M9);
        M10 = (TextView) view.findViewById(R.id.medicine_M10);
        M11 = (TextView) view.findViewById(R.id.medicine_M11);

        N1 = (TextView) view.findViewById(R.id.medicine_N1);

        O1 = (TextView) view.findViewById(R.id.medicine_O1);
        O2 = (TextView) view.findViewById(R.id.medicine_O2);

        P1 = (TextView) view.findViewById(R.id.medicine_P1);
        P2 = (TextView) view.findViewById(R.id.medicine_P2);
        P3 = (TextView) view.findViewById(R.id.medicine_P3);
        P4 = (TextView) view.findViewById(R.id.medicine_P4);
        P5 = (TextView) view.findViewById(R.id.medicine_P5);
        P6 = (TextView) view.findViewById(R.id.medicine_P6);
        P7 = (TextView) view.findViewById(R.id.medicine_P7);
        P8 = (TextView) view.findViewById(R.id.medicine_P8);
        P9 = (TextView) view.findViewById(R.id.medicine_P9);
        P10 = (TextView) view.findViewById(R.id.medicine_P10);

        R1 = (TextView) view.findViewById(R.id.medicine_R1);
        R2 = (TextView) view.findViewById(R.id.medicine_R2);

        S1 = (TextView) view.findViewById(R.id.medicine_S1);
        S2 = (TextView) view.findViewById(R.id.medicine_S2);

        T1 = (TextView) view.findViewById(R.id.medicine_T1);
        T2 = (TextView) view.findViewById(R.id.medicine_T2);
        T3 = (TextView) view.findViewById(R.id.medicine_T3);
        T4 = (TextView) view.findViewById(R.id.medicine_T4);
        T5 = (TextView) view.findViewById(R.id.medicine_T5);
        T6 = (TextView) view.findViewById(R.id.medicine_T6);
        T7 = (TextView) view.findViewById(R.id.medicine_T7);
        T8 = (TextView) view.findViewById(R.id.medicine_T8);
        T9 = (TextView) view.findViewById(R.id.medicine_T9);
        T10 = (TextView) view.findViewById(R.id.medicine_T10);
        T11 = (TextView) view.findViewById(R.id.medicine_T11);
        T12 = (TextView) view.findViewById(R.id.medicine_T12);

        U1 = (TextView) view.findViewById(R.id.medicine_U1);
        U2 = (TextView) view.findViewById(R.id.medicine_U2);

        V1 = (TextView) view.findViewById(R.id.medicine_V1);
        V2 = (TextView) view.findViewById(R.id.medicine_V2);
        V3 = (TextView) view.findViewById(R.id.medicine_V3);
        V4 = (TextView) view.findViewById(R.id.medicine_V4);

        W1 = (TextView) view.findViewById(R.id.medicine_W1);

        A1.setOnClickListener(this);
        A2.setOnClickListener(this);
        A3.setOnClickListener(this);
        A4.setOnClickListener(this);
        A5.setOnClickListener(this);

        B1.setOnClickListener(this);

        C1.setOnClickListener(this);
        C2.setOnClickListener(this);
        C3.setOnClickListener(this);
        C4.setOnClickListener(this);
        C5.setOnClickListener(this);

        D1.setOnClickListener(this);
        D2.setOnClickListener(this);

        E1.setOnClickListener(this);
        E2.setOnClickListener(this);
        E3.setOnClickListener(this);
        E4.setOnClickListener(this);
        E5.setOnClickListener(this);
        E6.setOnClickListener(this);
        E7.setOnClickListener(this);
        E8.setOnClickListener(this);

        F1.setOnClickListener(this);
        F2.setOnClickListener(this);
        F3.setOnClickListener(this);
        F4.setOnClickListener(this);
        F5.setOnClickListener(this);
        F6.setOnClickListener(this);

        G1.setOnClickListener(this);
        G2.setOnClickListener(this);
        G3.setOnClickListener(this);
        G4.setOnClickListener(this);

        H1.setOnClickListener(this);

        I1.setOnClickListener(this);
        I2.setOnClickListener(this);
        I3.setOnClickListener(this);
        I4.setOnClickListener(this);
        I5.setOnClickListener(this);
        I6.setOnClickListener(this);
        I7.setOnClickListener(this);

        L1.setOnClickListener(this);
        L2.setOnClickListener(this);
        L3.setOnClickListener(this);
        L4.setOnClickListener(this);
        L5.setOnClickListener(this);
        L6.setOnClickListener(this);
        L7.setOnClickListener(this);

        M1.setOnClickListener(this);
        M2.setOnClickListener(this);
        M3.setOnClickListener(this);
        M4.setOnClickListener(this);
        M5.setOnClickListener(this);
        M6.setOnClickListener(this);
        M7.setOnClickListener(this);
        M8.setOnClickListener(this);
        M9.setOnClickListener(this);
        M10.setOnClickListener(this);
        M11.setOnClickListener(this);

        N1.setOnClickListener(this);

        O1.setOnClickListener(this);
        O2.setOnClickListener(this);

        P1.setOnClickListener(this);
        P2.setOnClickListener(this);
        P3.setOnClickListener(this);
        P4.setOnClickListener(this);
        P5.setOnClickListener(this);
        P6.setOnClickListener(this);
        P7.setOnClickListener(this);
        P8.setOnClickListener(this);
        P9.setOnClickListener(this);
        P10.setOnClickListener(this);

        R1.setOnClickListener(this);
        R2.setOnClickListener(this);

        S1.setOnClickListener(this);
        S2.setOnClickListener(this);

        T1.setOnClickListener(this);
        T2.setOnClickListener(this);
        T3.setOnClickListener(this);
        T4.setOnClickListener(this);
        T5.setOnClickListener(this);
        T6.setOnClickListener(this);
        T7.setOnClickListener(this);
        T8.setOnClickListener(this);
        T9.setOnClickListener(this);
        T10.setOnClickListener(this);
        T11.setOnClickListener(this);
        T12.setOnClickListener(this);

        U1.setOnClickListener(this);
        U2.setOnClickListener(this);

        V1.setOnClickListener(this);
        V2.setOnClickListener(this);
        V3.setOnClickListener(this);
        V4.setOnClickListener(this);

        W1.setOnClickListener(this);


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if (id == R.id.medicine_A1) {
            String Url = getResources().getString(R.string.url_A1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_A2) {
            String Url = getResources().getString(R.string.url_A2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_A3) {
            String Url = getResources().getString(R.string.url_A3);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_A4) {
            String Url = getResources().getString(R.string.url_A4);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_A5) {
            String Url = getResources().getString(R.string.url_A5);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_B1) {
            String Url = getResources().getString(R.string.url_B1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_C1) {
            String Url = getResources().getString(R.string.url_C1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_C2) {
            String Url = getResources().getString(R.string.url_C2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_C3) {
            String Url = getResources().getString(R.string.url_C3);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_C4) {
            String Url = getResources().getString(R.string.url_C4);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_C5) {
            String Url = getResources().getString(R.string.url_C5);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_D1) {
            String Url = getResources().getString(R.string.url_D1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_D2) {
            String Url = getResources().getString(R.string.url_D2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_E1) {
            String Url = getResources().getString(R.string.url_E1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_E2) {
            String Url = getResources().getString(R.string.url_E2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_E3) {
            String Url = getResources().getString(R.string.url_E3);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_E4) {
            String Url = getResources().getString(R.string.url_E4);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_E5) {
            String Url = getResources().getString(R.string.url_E5);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_E6) {
            String Url = getResources().getString(R.string.url_E6);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_E7) {
            String Url = getResources().getString(R.string.url_E7);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_E8) {
            String Url = getResources().getString(R.string.url_E8);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_F1) {
            String Url = getResources().getString(R.string.url_F1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_F2) {
            String Url = getResources().getString(R.string.url_F2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_F3) {
            String Url = getResources().getString(R.string.url_F3);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_F4) {
            String Url = getResources().getString(R.string.url_F4);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_F5) {
            String Url = getResources().getString(R.string.url_F5);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_F6) {
            String Url = getResources().getString(R.string.url_F6);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_G1) {
            String Url = getResources().getString(R.string.url_G1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_G2) {
            String Url = getResources().getString(R.string.url_G2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_G3) {
            String Url = getResources().getString(R.string.url_G3);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_G4) {
            String Url = getResources().getString(R.string.url_G4);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_H1) {
            String Url = getResources().getString(R.string.url_H1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_I1) {
            String Url = getResources().getString(R.string.url_I1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_I2) {
            String Url = getResources().getString(R.string.url_I2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_I3) {
            String Url = getResources().getString(R.string.url_I3);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_I4) {
            String Url = getResources().getString(R.string.url_I4);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_I5) {
            String Url = getResources().getString(R.string.url_I5);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_I6) {
            String Url = getResources().getString(R.string.url_I6);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_I7) {
            String Url = getResources().getString(R.string.url_I7);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_L1) {
            String Url = getResources().getString(R.string.url_L1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_L2) {
            String Url = getResources().getString(R.string.url_L2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_L3) {
            String Url = getResources().getString(R.string.url_L3);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_L4) {
            String Url = getResources().getString(R.string.url_L4);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_L5) {
            String Url = getResources().getString(R.string.url_L5);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_L6) {
            String Url = getResources().getString(R.string.url_L6);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_L7) {
            String Url = getResources().getString(R.string.url_L7);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_M1) {
            String Url = getResources().getString(R.string.url_M1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_M2) {
            String Url = getResources().getString(R.string.url_M2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_M3) {
            String Url = getResources().getString(R.string.url_M3);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_M4) {
            String Url = getResources().getString(R.string.url_M4);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_M5) {
            String Url = getResources().getString(R.string.url_M5);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_M6) {
            String Url = getResources().getString(R.string.url_M6);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_M7) {
            String Url = getResources().getString(R.string.url_M7);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_M8) {
            String Url = getResources().getString(R.string.url_M8);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_M9) {
            String Url = getResources().getString(R.string.url_M9);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_M10) {
            String Url = getResources().getString(R.string.url_M10);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_M11) {
            String Url = getResources().getString(R.string.url_M11);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_N1) {
            String Url = getResources().getString(R.string.url_N1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_O1) {
            String Url = getResources().getString(R.string.url_O1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_O2) {
            String Url = getResources().getString(R.string.url_O2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_P1) {
            String Url = getResources().getString(R.string.url_P1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_P2) {
            String Url = getResources().getString(R.string.url_P2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_P3) {
            String Url = getResources().getString(R.string.url_P3);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_P4) {
            String Url = getResources().getString(R.string.url_P4);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_P5) {
            String Url = getResources().getString(R.string.url_P5);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_P6) {
            String Url = getResources().getString(R.string.url_P6);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_P7) {
            String Url = getResources().getString(R.string.url_P7);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_P8) {
            String Url = getResources().getString(R.string.url_P8);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_P9) {
            String Url = getResources().getString(R.string.url_P9);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_P10) {
            String Url = getResources().getString(R.string.url_P10);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_R1) {
            String Url = getResources().getString(R.string.url_R1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_R2) {
            String Url = getResources().getString(R.string.url_R2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_S1) {
            String Url = getResources().getString(R.string.url_S1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_S2) {
            String Url = getResources().getString(R.string.url_S2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_T1) {
            String Url = getResources().getString(R.string.url_T1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_T2) {
            String Url = getResources().getString(R.string.url_T2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_T3) {
            String Url = getResources().getString(R.string.url_T3);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_T4) {
            String Url = getResources().getString(R.string.url_T4);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_T5) {
            String Url = getResources().getString(R.string.url_T5);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_T6) {
            String Url = getResources().getString(R.string.url_T6);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_T7) {
            String Url = getResources().getString(R.string.url_T7);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_T8) {
            String Url = getResources().getString(R.string.url_T8);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_T9) {
            String Url = getResources().getString(R.string.url_T9);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_T10) {
            String Url = getResources().getString(R.string.url_T10);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_T11) {
            String Url = getResources().getString(R.string.url_T11);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_T12) {
            String Url = getResources().getString(R.string.url_T12);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_U1) {
            String Url = getResources().getString(R.string.url_U1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_U2) {
            String Url = getResources().getString(R.string.url_U2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_V1) {
            String Url = getResources().getString(R.string.url_V1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_V2) {
            String Url = getResources().getString(R.string.url_V2);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_V3) {
            String Url = getResources().getString(R.string.url_V3);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_V4) {
            String Url = getResources().getString(R.string.url_V4);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

        if (id == R.id.medicine_W1) {
            String Url = getResources().getString(R.string.url_W1);
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(Url)));
        }

    }
}

