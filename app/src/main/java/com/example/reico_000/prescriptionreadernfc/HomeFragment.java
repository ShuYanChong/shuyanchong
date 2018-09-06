package com.example.reico_000.prescriptionreadernfc;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;


///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link HomeFragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link HomeFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button scanMedicine;
    private Button medicationList;
    private Button reportSymptoms;
    private Button pastSymptomRecord;
    private Button medicationUseRecord;


    Communicator comm;
    private Inventory.OnFragmentInteractionListener mListener;

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public HomeFragment() {
        // Required empty public constructor
    }

//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment HomeFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static HomeFragment newInstance(String param1, String param2) {
//        HomeFragment fragment = new HomeFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Home", "Home Fragment was created");
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_main2, container, false);


        scanMedicine = (Button) view.findViewById(R.id.scanMedicine);
        medicationList = (Button) view.findViewById(R.id.medicationList);
        reportSymptoms = (Button) view.findViewById(R.id.reportSymptoms);
        pastSymptomRecord = (Button) view.findViewById(R.id.pastSymptomRecord);
        medicationUseRecord = (Button) view.findViewById(R.id.medicationUseRecord);

        scanMedicine.setOnClickListener(this);
        medicationList.setOnClickListener(this);
        reportSymptoms.setOnClickListener(this);
        pastSymptomRecord.setOnClickListener(this);
        medicationUseRecord.setOnClickListener(this);

        ((MainActivity)getActivity()).checkHomeFragment();


        return view;
    }

//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.action_legends).setVisible(false);
        menu.findItem(R.id.action_legends2).setVisible(false);
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


        if (id == R.id.scanMedicine) {

            Log.d("HomeFragment", "Going to Scan Fragment");

            ((MainActivity) getActivity()).onNavigationDrawerItemSelected(1);

        }

        if (id == R.id.medicationList) {

            Log.d("HomeFragment", "Going to Inv Fragment");

            ((MainActivity) getActivity()).onNavigationDrawerItemSelected(2);

        }

        if (id == R.id.reportSymptoms) {

            Log.d("HomeFragment", "Going to newreportSymptoms Fragment");

            ((MainActivity) getActivity()).onNavigationDrawerItemSelected(4);

        }

        if (id == R.id.pastSymptomRecord) {

            Log.d("HomeFragment", "Going to Report history Fragment");

            ((MainActivity) getActivity()).onNavigationDrawerItemSelected(5);

        }

        if (id == R.id.medicationUseRecord) {

            Log.d("HomeFragment", "Going to Medication Use Fragment");

            ((MainActivity) getActivity()).onNavigationDrawerItemSelected(6);

        }

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
}
