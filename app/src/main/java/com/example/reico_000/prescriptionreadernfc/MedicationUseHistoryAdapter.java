package com.example.reico_000.prescriptionreadernfc;

import android.accounts.Account;
import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import helper.DataTransferInterface;

public class MedicationUseHistoryAdapter extends BaseAdapter{
    private ArrayList<MedicationUseHistoryObject> mainList;
    private Context context;
    private Account account;
    private MedicationUseHistoryObject medicationUseHistoryObject;

    DataTransferInterface dtInterface;

    //Dialog in other avtivity
    private AlertDialog stopMedicationDialog = null;

    public MedicationUseHistoryAdapter(Context applicationContext, Account account,
                           List<MedicationUseHistoryObject> medicationUseHistoryList, DataTransferInterface dtInterface) {
        super();
        this.account = account;
        this.context = applicationContext;
        this.dtInterface = dtInterface;
        this.mainList = new ArrayList<MedicationUseHistoryObject>(medicationUseHistoryList);
    }

    public MedicationUseHistoryAdapter() {

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
            convertView = inflater.inflate(R.layout.medication_use_item_layout, null);
        }

        medicationUseHistoryObject = (MedicationUseHistoryObject) getItem(position);
        if (medicationUseHistoryObject != null) {

            TextView genericNameView = (TextView) convertView
                    .findViewById(R.id.list_MedicineName);
            TextView consumedOnView = (TextView) convertView
                    .findViewById(R.id.list_ConsumedOn);

            if (consumedOnView != null) {
                consumedOnView.setText(medicationUseHistoryObject.get_medicationConsumedAt());
            }
            if (genericNameView != null) {
                genericNameView.setText(medicationUseHistoryObject.get_medicationUseHistory());
            }

        }

        else {Log.d("MUH Adapter", "is empty");}
        return convertView;
    }
}
