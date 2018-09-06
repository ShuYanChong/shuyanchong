package com.example.reico_000.prescriptionreadernfc;

import android.content.ContentValues;
import android.database.Cursor;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class MedicationUseHistoryObject implements Comparable<MedicationUseHistoryObject> {

    int _ID = -1;
    String _medicationUseHistory = "";
    String _medicationConsumedAt = "";

    public MedicationUseHistoryObject(){
    }

    public MedicationUseHistoryObject(String medicationUseHistory, String medicationConsumedAt) {

        this._medicationUseHistory = medicationUseHistory;
        this._medicationConsumedAt = medicationConsumedAt;
    }

    public int get_id(){
        return this._ID;
    }

    public String get_medicationUseHistory(){
        return this._medicationUseHistory;
    }

    public String get_medicationConsumedAt(){
        return this._medicationConsumedAt;
    }

    /**
     * Convenient method to get the objects data members in ContentValues object.
     * This will be useful for Content Provider operations,
     * which use ContentValues object to represent the data.
     *
     * @return
     */
    public ContentValues getContentValues() {
        ContentValues values = new ContentValues();
        values.put(MedicationDatabaseSQLiteHandler.KEY_ID, _ID);
        values.put(MedicationDatabaseSQLiteHandler.KEY_MEDICATION_ID, _medicationUseHistory);
        values.put(MedicationDatabaseSQLiteHandler.KEY_CONSUMED_AT, _medicationConsumedAt);
        return values;
    }

    // Create a Medication Use History object from a cursor
    public static MedicationUseHistoryObject fromCursor(Cursor curMedicationUseHistory) {
        int id = curMedicationUseHistory.getInt(curMedicationUseHistory.getColumnIndex(MedicationDatabaseSQLiteHandler.KEY_ID));
        String medicationUseHistory = curMedicationUseHistory.getString(curMedicationUseHistory.getColumnIndex(MedicationDatabaseSQLiteHandler.KEY_MEDICATION_USE_HISTORY));
        String medicationConsumedAt = curMedicationUseHistory.getString(curMedicationUseHistory.getColumnIndex(MedicationDatabaseSQLiteHandler.KEY_MEDICATION_CONSUMED_AT));

        return new MedicationUseHistoryObject(medicationUseHistory, medicationConsumedAt);
    }

    @Override
    public int compareTo(MedicationUseHistoryObject obj) {
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm a", Locale.UK);
        Date curObjDate = dateFormat.parse(get_medicationConsumedAt(), new ParsePosition(0));
        Date targetObjDate = dateFormat.parse(obj.get_medicationConsumedAt(), new ParsePosition(0));

        return curObjDate.compareTo(targetObjDate);
    }
}


