package com.example.reico_000.prescriptionreadernfc;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;


public class MoreInfoFragment extends Fragment {
    // Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView genericNameTextView;
    private TextView brandNameTextView;
    private TextView indicationsTextView;
    private TextView dosageTextView;
    private TextView administrationTextView;
    private TextView contraindicationsTextView;
    private TextView specialPrecautionsTextView;
    private TextView adverseDrugReactionsTextView;
    private TextView drugInteractionsTextView;
    private TextView pregnancyCategoryTextView;
    private TextView pdfFileTextView;

    private OnFragmentInteractionListener mListener;
    private String pdfFileLink = "";
    Communicator comm;
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PrescriptionDateList.
     */
    // Rename and change types and number of parameters
    public static MoreInfoFragment newInstance(String param1, String param2) {
        MoreInfoFragment fragment = new MoreInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MoreInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MedAdherenceFragment", "MedAdherenceFragment was created");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_more_info, container, false);
        // Inflate the layout for this fragment
//        medList = (ListView) view.findViewById(R.id.inventoryList);
        genericNameTextView = (TextView) view.findViewById(R.id.moreInfo_GenericName);
        brandNameTextView = (TextView) view.findViewById(R.id.moreInfo_BrandName);
        indicationsTextView = (TextView) view.findViewById(R.id.moreInfo_Indications);
        dosageTextView = (TextView) view.findViewById(R.id.moreInfo_Dosage);
        administrationTextView = (TextView) view.findViewById(R.id.moreInfo_Administration);
        contraindicationsTextView = (TextView) view.findViewById(R.id.moreInfo_Contraindications);
        specialPrecautionsTextView = (TextView) view.findViewById(R.id.moreInfo_SpecialPrecautions);
        adverseDrugReactionsTextView = (TextView) view.findViewById(R.id.moreInfo_AdverseDrugReactions);
        drugInteractionsTextView = (TextView) view.findViewById(R.id.moreInfo_DrugInteractions);
        pregnancyCategoryTextView = (TextView) view.findViewById(R.id.moreInfo_PregnancyCategory);
        pdfFileTextView = (TextView) view.findViewById(R.id.moreInfo_PDFLeaflet);
        pdfFileTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!genericNameTextView.getText().toString().equals("") && !pdfFileLink.equals("")) {
                    openOrDownloadPDFFile(genericNameTextView.getText().toString(),
                            pdfFileLink);
                }
            }
        });
        return view;
    }
    @Override
    public void onStart(){
        super.onStart();
//        registerListClickCallback();
    }
    // Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

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
            mListener = (OnFragmentInteractionListener) activity;
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    public void changeText(String genericName, String brandName, String indications, String dosage,
                           String administration, String contraindications, String specialPrecautions,
                           String adverseDrugReactions, String drugInteractions, String pregnancyCategory,
                           String pdfFilePath) {
        Log.d("MainActivity", "Show more info: " + genericName);
        genericNameTextView.setText(genericName);
        brandNameTextView.setText(brandName);
        indicationsTextView.setText(indications);
        dosageTextView.setText(dosage);
        administrationTextView.setText(administration);
        contraindicationsTextView.setText(contraindications);
        specialPrecautionsTextView.setText(specialPrecautions);
        adverseDrugReactionsTextView.setText(adverseDrugReactions);
        drugInteractionsTextView.setText(drugInteractions);
        pregnancyCategoryTextView.setText(pregnancyCategory);
        pdfFileLink = pdfFilePath;
        if (!pdfFilePath.equals("")) {
            SpannableString stringContent = new SpannableString("Click here to open the leaflet.");
            stringContent.setSpan(new UnderlineSpan(), 0, stringContent.length(), 0);
            pdfFileTextView.setText(stringContent);
        } else {
            pdfFileTextView.setText("No leaflet available.");
        }
//        pdfFileTextView.setText(pdfFilePath);
    }

    public void openOrDownloadPDFFile(final String genericName, String pdfFile) {
        String siteName = "https://www.onco-informatics.com/medfc/";
        File file = new File(getActivity().getExternalFilesDir(null).getAbsolutePath() +
                "/" + genericName + ".pdf");
        if (file.exists()) {
            // Open the pdf file
            openPDFFile(file);
        } else {
            // Download, then open
            String downloadURL = siteName + pdfFile;
            downloadURL = downloadURL.replaceAll(" ", "%20");
            //String fileName = filePath.substring(4);
            String fileName = genericName + ".pdf";
            DownloadManager.Request request = new
                    DownloadManager.Request(Uri.parse(downloadURL));
            request.setDescription("Downloading medication information file...");
            request.setTitle("Downloading Medication Information");
            // in order for this if to run, you must use the android 3.2 to compile your app
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            }

            request.setDestinationInExternalFilesDir(getActivity(), null, fileName);

            // get download service and enqueue file
            DownloadManager manager = (DownloadManager) getActivity().getSystemService(Context.DOWNLOAD_SERVICE);
            manager.enqueue(request);

            BroadcastReceiver onComplete = new BroadcastReceiver() {
                public void onReceive(Context ctxt, Intent intent) {
                    // your code
                    openPDFFile(new File(getActivity().getExternalFilesDir(null).getAbsolutePath() +
                            "/" + genericName + ".pdf"));
                }
            };

            getActivity().registerReceiver(onComplete, new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
        }
    }

    private void openPDFFile(File file) {
        Intent target = new Intent(Intent.ACTION_VIEW);
        target.setDataAndType(Uri.fromFile(file), "application/pdf");
        target.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

//        Intent intent = Intent.createChooser(target, "Open File");
        try {
            getActivity().startActivity(target);
        } catch (ActivityNotFoundException e) {
            // Instruct the user to install a PDF reader here, or something
        }
    }
}
