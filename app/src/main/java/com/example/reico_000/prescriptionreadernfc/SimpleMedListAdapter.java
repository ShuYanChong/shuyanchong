package com.example.reico_000.prescriptionreadernfc;

import android.accounts.Account;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DownloadManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import helper.DataTransferInterface;
import helper.VolleyCallback;


public class SimpleMedListAdapter extends BaseAdapter {
    private ArrayList<MedicationObject> mainList;
    private Context context;
    private Account account;
    private String patientID;
    private ArrayList<String> checkedTimeList;
    private String[] consumptionTimeArr;
    private MedicationObject medObject;
    private ConsumptionTimeListAdapter consumptionTimeAdapter;
    private String filePath;
    DataTransferInterface dtInterface;

    private static final String siteName = "https://www.onco-informatics.com/medfc/";

    //Dialog in other avtivity
    private AlertDialog stopMedicationDialog = null;

    public SimpleMedListAdapter(Context applicationContext, Account account, String patientID,
                                 List<MedicationObject> medList, DataTransferInterface dtInterface) {

        super();
        this.context = applicationContext;
        this.account = account;
        this.patientID = patientID;
        this.dtInterface = dtInterface;
        this.mainList = new ArrayList<MedicationObject>(medList);
    }

    public SimpleMedListAdapter() {

        super();
//        this.mainList = QuestionForSliderMenu;

    }

    @Override
    public int getCount() {

        return mainList.size();
    }

    @Override
    public Object getItem(int position) {

        return mainList.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.simple_med_layout, null);
        }
//        final MedicationObject medicationObject = (MedicationObject) getItem(position);
        medObject = (MedicationObject) getItem(position);
        if (medObject != null) {
            TextView genericNameView = (TextView) convertView
                    .findViewById(R.id.list_simpleMedGenericName);
            TextView brandNameView = (TextView) convertView
                    .findViewById(R.id.list_simpleMedBrandName);

            if (genericNameView != null) {
                genericNameView.setText(medObject.get_genericName());
            }
            if (brandNameView != null) {
                brandNameView.setText(medObject.get_brandName());
            }
        }

        return convertView;
    }
}
