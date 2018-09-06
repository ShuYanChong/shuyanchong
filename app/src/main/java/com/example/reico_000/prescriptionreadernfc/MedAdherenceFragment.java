package com.example.reico_000.prescriptionreadernfc;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.helper.DateAsXAxisLabelFormatter;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link PrescriptionDateList.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PrescriptionDateList#newInstance} factory method to
 * create an instance of this fragment.
 */


public class MedAdherenceFragment extends Fragment{
    // Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private ListView medList;
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
    public static MedAdherenceFragment newInstance(String param1, String param2) {
        MedAdherenceFragment fragment = new MedAdherenceFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public MedAdherenceFragment() {
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

        View view = inflater.inflate(R.layout.fragment_inventory, container, false);
        // Inflate the layout for this fragment
        medList = (ListView) view.findViewById(R.id.inventoryList);

        return view;
    }
    @Override
    public void onStart(){
        super.onStart();
        registerListClickCallback();
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

    //    public void populateList(CursorAdapter cursorAdapter){
    public void populateList(SimpleMedListAdapter simpleMedListAdapter){
        Log.d("Test", "setAdapter entered");

        medList.setAdapter(simpleMedListAdapter);
//        InventoryList.setAdapter(cursorAdapter);
    }

    private void registerListClickCallback() {
        Log.d("Item click", "Entered Function");
        medList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                           @Override
                                           public void onItemClick(AdapterView<?> parent, View viewClicked,
                                                                   int position, long idInDB) {
                                               Log.d("Item click", "ID =" + idInDB);
                                               int required = -1;
                                               List<String> dateStringList = new ArrayList<String>();
                                               List<Date> dateList = new ArrayList<Date>();
                                               List<Integer> dailyCountList = new ArrayList<Integer>();

                                               comm.displayToastForId(idInDB);
                                               MedicationObject medObject = (MedicationObject) parent.getItemAtPosition(position);
                                               required = medObject.get_consumptionTime().split(", ").length;
//                Toast.makeText(getActivity(), medObject.get_genericName() + " " + medObject.get_id(),
//                        Toast.LENGTH_SHORT).show();
                                               ContentResolver resolver = getActivity().getContentResolver();
                                               Uri uri = MedicationContract.Consumption.CONTENT_URI;
                                               String[] projection = MedicationDatabaseSQLiteHandler.ALL_CONSUMPTION_KEYS;
                                               String selection = MedicationDatabaseSQLiteHandler.KEY_MEDICATION_ID + " = ?";
                                               String[] selectionArgs = new String[]{String.valueOf(medObject.get_id())};
                                               String sortOrder = MedicationDatabaseSQLiteHandler.KEY_CONSUMED_AT + " ASC";
                                               Cursor cursor =
                                                       resolver.query(uri,
                                                               projection,
                                                               selection,
                                                               selectionArgs,
                                                               sortOrder);
                                               if (cursor != null) {
                                                   if (cursor.moveToFirst()) {
                                                       String curCountedDate = "";
                                                       int i = 0, counter = 0;
                                                       do {
                                                           ConsumptionDetailsObject consumptionObject = ConsumptionDetailsObject.fromCursor(cursor);
                                                           String consumedAt = consumptionObject.get_consumedAt();
                                                           String isTaken = consumptionObject.get_isTaken();
                                                           SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", java.util.Locale.US);
                                                           SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd MMM ''yy", java.util.Locale.US);
                                                           SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                                           Date date = oldDateFormat.parse(consumedAt, new ParsePosition(0));
                                                           if (curCountedDate.equals("")) {
                                                               curCountedDate = dateFormat.format(date);
                                                               Date date2 = dateFormat.parse(curCountedDate, new ParsePosition(0));
                                                               dateList.add(date2);
                                                               dateStringList.add(curCountedDate);
                                                               if (isTaken.equals("Yes") || isTaken.equals("Overdose")) {
                                                                   dailyCountList.add(1);
                                                               } else {
                                                                   dailyCountList.add(0);
                                                               }
//                                counter++;
                                                           } else {
                                                               String curInspectedDate = dateFormat.format(date);
                                                               if (curCountedDate.equals(curInspectedDate)) {
                                                                   if (isTaken.equals("Yes") || isTaken.equals("Overdose")) {
                                                                       dailyCountList.set(i, dailyCountList.get(i) + 1);
                                                                   }
//                                    counter++;
                                                               } else {
                                                                   curCountedDate = curInspectedDate;
                                                                   Date date2 = dateFormat.parse(curInspectedDate, new ParsePosition(0));
                                                                   dateList.add(date2);
                                                                   dateStringList.add(curInspectedDate);
                                                                   if (isTaken.equals("Yes") || isTaken.equals("Overdose")) {
                                                                       dailyCountList.add(1);
                                                                   } else {
                                                                       dailyCountList.add(0);
                                                                   }
                                                                   i++;
                                                               }
                                                           }
                                                       } while (cursor.moveToNext());
                                                   }
                                                   cursor.close();
                                               }
                                               LayoutInflater inflater = (LayoutInflater) getActivity()
                                                       .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                               View view = inflater.inflate(R.layout.med_adherence_graph_dialog, null);
//                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.GraphTheme)
                                               AlertDialog.Builder builder = new AlertDialog.Builder(getActivity())
                                                       .setTitle(medObject.get_genericName())
                                                       .setView(view);
//                        .setMessage(Html.fromHtml("Message"))
                                               GraphView graph = (GraphView) view.findViewById(R.id.med_adherence_graph);
//                graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
//                    @Override
//                    protected String formatLabel(double value, boolean isValueX) {
//                        if (isValueX) {
//                            // transform number to time
//                            return dateTimeFormatter.format(new Date((long) value * 1000));
//                        } else {
//                            return super.formatLabel(value, isValueX);
//                        }
//                    }
//                });
                                               LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                                               });
                                               Date tempDate;
                                               Calendar c = Calendar.getInstance();
                                               for (int i = 0; i < dateList.size(); i++) {
                                                   series.appendData(new DataPoint(dateList.get(i), dailyCountList.get(i)), true, 1000000);
                                                   if (i == dateList.size() - 1) {
                                                       tempDate = dateList.get(i);
                                                       c.setTime(tempDate);
                                                       for (int j = 0; j < 7; j++) {
                                                           c.add(Calendar.DATE, 1);
                                                           tempDate = c.getTime();
                                                           int tempVal = -1;
                                                           if ((j == 0) || (j == 1) || (j == 5)) {
                                                               tempVal = 1;
                                                           } else if ((j == 2) || (j == 6)) {
                                                               tempVal = 0;
                                                           } else {
                                                               tempVal = 2;
                                                           }
                                                           series.appendData(new DataPoint(tempDate, tempVal), true, 1000000);
                                                       }
                                                   }
                                               }
//                c.setTime(tempDate);
//                c.add(Calendar.DATE, 1);
//                tempDate = c.getTime();

//                series.appendData(new DataPoint(dateList.get(0), dailyCountList.get(0)), true, 1000000);
//                series.appendData(new DataPoint(dateList.get(1), dailyCountList.get(1)), true, 1000000);
//                series.appendData(new DataPoint(dateList.get(2), dailyCountList.get(2)), true, 1000000);

//                series.appendData(new DataPoint(tempDate, 1), true, 1000000);
//
//                c.add(Calendar.DATE, 1);
//                tempDate = c.getTime();
//                series.appendData(new DataPoint(tempDate, 1), true, 1000000);
//
//                c.add(Calendar.DATE, 1);
//                tempDate = c.getTime();
//                series.appendData(new DataPoint(tempDate, 0), true, 1000000);
//
//                c.add(Calendar.DATE, 1);
//                tempDate = c.getTime();
//                series.appendData(new DataPoint(tempDate, 2), true, 1000000);
//
//                c.add(Calendar.DATE, 1);
//                tempDate = c.getTime();
//                series.appendData(new DataPoint(tempDate, 2), true, 1000000);
//
//                c.add(Calendar.DATE, 1);
//                tempDate = c.getTime();
//                series.appendData(new DataPoint(tempDate, 1), true, 1000000);
//
//                c.add(Calendar.DATE, 1);
//                tempDate = c.getTime();
//                series.appendData(new DataPoint(tempDate, 0), true, 1000000);


                                               series.setColor(Color.rgb(11, 116, 206));
                                               series.setDrawDataPoints(true);
                                               series.setDataPointsRadius(5);
                                               series.setThickness(8);

                                               LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(new DataPoint[]{
                                               });
                                               series2.setColor(Color.GREEN);

// custom paint to make a dotted line
                                               Paint paint = new Paint();
                                               paint.setColor(Color.GREEN);
                                               paint.setStyle(Paint.Style.STROKE);
                                               paint.setStrokeWidth(5);
                                               paint.setPathEffect(new DashPathEffect(new float[]{20, 10}, 0));
                                               series2.setCustomPaint(paint);
                                               for (int i = 0; i < dateList.size(); i++) {
                                                   series2.appendData(new DataPoint(dateList.get(i), required),
                                                           true, 1000000);
                                                   if (i == dateList.size() - 1) {
                                                       tempDate = dateList.get(i);
                                                       c = Calendar.getInstance();
                                                       c.setTime(tempDate);
                                                       for (int j = 0; j < 7; j++) {
                                                           c.add(Calendar.DATE, 1);
                                                           tempDate = c.getTime();
                                                           series2.appendData(new DataPoint(tempDate, required), true, 1000000);
                                                       }
                                                   }
                                               }

                                               series.setTitle("Actual Consumption");
                                               series2.setTitle("Required Consumption");
                                               graph.addSeries(series);
                                               graph.addSeries(series2);
                                               // use static labels for horizontal and vertical labels
//                StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
//                staticLabelsFormatter.setHorizontalLabels(dateStringList.toArray(new String[dateStringList.size()]));
//                graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
//                                               graph.getViewport().setScalable(true);
                                               graph.getViewport().setScrollable(true);
                                               graph.getGridLabelRenderer().setNumHorizontalLabels(3);
//                graph.getGridLabelRenderer().setNumHorizontalLabels(dateList.size());
                                               graph.getGridLabelRenderer().setNumVerticalLabels(required + 2);
                                               // set manual x bounds to have nice steps
                                               graph.getViewport().setMinX(dateList.get(0).getTime());
//                graph.getViewport().setMaxX(dateList.get(2).getTime());
                                               tempDate = dateList.get(dateList.size() - 1);
                                               c.setTime(tempDate);
                                               c.add(Calendar.DATE, 2);
                                               tempDate = c.getTime();
                                               graph.getViewport().setMaxX(tempDate.getTime());
//                                               graph.getViewport().setMaxX(dateList.get(dateList.size() - 1).getTime());

                                               graph.getViewport().setXAxisBoundsManual(true);

                                               // set manual y bounds to have nice steps
                                               graph.getViewport().setMinY(0);
                                               graph.getViewport().setMaxY(required + 1);
                                               graph.getViewport().setYAxisBoundsManual(true);

//                graph.getGridLabelRenderer().setLabelFormatter(new DateAsXAxisLabelFormatter(getActivity()));
                                               graph.getGridLabelRenderer().setLabelFormatter(new CustomLabelFormatter(getActivity()));
                                               graph.getLegendRenderer().setVisible(true);
                                               graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.TOP);
                                               //comm.test();
                                               AlertDialog graphDialog = builder.create();
                                               graphDialog.show();
                                           }
                                       }

        );
            medList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()

                                               {
                                                   @Override
                                                   public boolean onItemLongClick(AdapterView<?> parent, View viewClicked,
                                                                                  int position, long idInDB) {

                                                       Log.d("Item Long Click", "Entered");
                                                       comm.deleteId(idInDB);

                                                       return true;
                                                   }
                                               }

            );
        }
    }
