package com.example.reico_000.prescriptionreadernfc;

import android.content.ContentValues;
import android.database.Cursor;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ConsumptionDetailsObject implements Comparable<ConsumptionDetailsObject> {
    int _medicationID = -1;
    String _consumedAt = "";
    String _isTaken = "false";
    String _remainingDosage = "";

    public ConsumptionDetailsObject(){
    }

    public ConsumptionDetailsObject(int medicationID, String consumedAt, String isTaken, String remainingDosage){
        this._medicationID = medicationID;
        this._consumedAt = consumedAt;
        this._isTaken = isTaken;
        this._remainingDosage = remainingDosage;
    }

    public int get_medicationID() {
        return this._medicationID;
    }

    public String get_consumedAt() {
        return this._consumedAt;
    }

    public String get_isTaken() {
        return this._isTaken;
    }

    public String get_remainingDosage() {
        return this._remainingDosage;
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
        values.put(MedicationDatabaseSQLiteHandler.KEY_MEDICATION_ID, _medicationID);
        values.put(MedicationDatabaseSQLiteHandler.KEY_CONSUMED_AT, _consumedAt);
        values.put(MedicationDatabaseSQLiteHandler.KEY_IS_TAKEN, _isTaken);
        values.put(MedicationDatabaseSQLiteHandler.KEY_REMAINING_DOSAGE, _remainingDosage);
        return values;
    }

    // Create a ConsumptionDetailsObject object from a cursor
    public static ConsumptionDetailsObject fromCursor(Cursor curConsumptionDetails) {
        int medId = curConsumptionDetails.getInt(curConsumptionDetails.getColumnIndex(MedicationDatabaseSQLiteHandler.KEY_MEDICATION_ID));
        String consumedAt = curConsumptionDetails.getString(curConsumptionDetails.getColumnIndex(MedicationDatabaseSQLiteHandler.KEY_CONSUMED_AT));
        String isTaken = curConsumptionDetails.getString(curConsumptionDetails.getColumnIndex(MedicationDatabaseSQLiteHandler.KEY_IS_TAKEN));
        String remainingDosage = curConsumptionDetails.getString(curConsumptionDetails.getColumnIndex(MedicationDatabaseSQLiteHandler.KEY_REMAINING_DOSAGE));

        return new ConsumptionDetailsObject(medId, consumedAt, isTaken, remainingDosage);
    }

    @Override
    public int compareTo(ConsumptionDetailsObject obj) {
        SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm a");
        Date curObjDate = dateFormat.parse(get_consumedAt(), new ParsePosition(0));
        Date targetObjDate = dateFormat.parse(obj.get_consumedAt(), new ParsePosition(0));

        return curObjDate.compareTo(targetObjDate);
    }
}
