package com.example.reico_000.prescriptionreadernfc;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;


public final class MedicationContract {

        /**
         * The authority of the Medication provider.
         */
        public static final String AUTHORITY =
                "com.example.reico_000.prescriptionreadernfc.provider";
        /**
         * The content URI for the top-level
         * Medication authority.
         */
        public static final Uri CONTENT_URI =
                Uri.parse("content://" + AUTHORITY);

        /**
         * Constants for the Medications table
         * of the Medication provider.
         */
        public static final class Medications
                implements BaseColumns {
            /**
            * The content URI for this table.
            */
            public static final Uri CONTENT_URI =
                    Uri.withAppendedPath(
                            MedicationContract.CONTENT_URI,
                            "medicationTable");
            /**
             * The mime type of a directory of items.
             */
            public static final String CONTENT_TYPE =
                    ContentResolver.CURSOR_DIR_BASE_TYPE +
                            "/vnd.example.reico_000.prescriptionreadernfc.provider.medicationTable";
            /**
             * The mime type of a single item.
             */
            public static final String CONTENT_MED_TYPE =
                    ContentResolver.CURSOR_ITEM_BASE_TYPE +
                            "/vnd.example.reico_000.prescriptionreadernfc.provider.medicationTable";
            /**
             * A projection of all columns
             * in the items table.
             */
            public static final String KEY_ID = "_id";
            public static final String KEY_BRAND_NAME = "BrandName";
            public static final String KEY_GENERIC_NAME = "GenericName";
            public static final String KEY_DOSAGE_FORM = "DosageForm";
            public static final String KEY_UNIT = "Unit";
            public static final String KEY_PER_DOSAGE = "PerDosage";
            public static final String KEY_TOTAL_DOSAGE = "TotalDosage";
            public static final String KEY_CONSUMPTION_TIME = "ConsumptionTime";
            public static final String KEY_PATIENT_ID = "PatientID";
            public static final String KEY_ADMINISTRATION = "Administration";
            public static final String KEY_REMARKS = "Remarks";
            public static final String KEY_PRESCRIPTIONDATE = "PrescriptionDate";
            public static final String KEY_STATUS = "Status";
            public static final String[] PROJECTION_ALL = new String[] {KEY_ID, KEY_BRAND_NAME,
                    KEY_GENERIC_NAME, KEY_DOSAGE_FORM, KEY_UNIT, KEY_PER_DOSAGE, KEY_TOTAL_DOSAGE,
                    KEY_CONSUMPTION_TIME, KEY_PATIENT_ID, KEY_ADMINISTRATION, KEY_REMARKS,
                    KEY_PRESCRIPTIONDATE, KEY_STATUS};
            /**
             * The default sort order for
             * queries containing NAME fields.
             */
            public static final String SORT_ORDER_DEFAULT =
                    KEY_ID + " ASC";
        }

    /**
     * Constants for the Consumption table of the
     * Medication provider.
     */
    public static final class Consumption
            implements BaseColumns {
        /**
         * The content URI for this table.
         */
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(
                        MedicationContract.CONTENT_URI,
                        "consumptionTable");
        /**
         * The mime type of a directory of items.
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE +
                        "/vnd.example.reico_000.prescriptionreadernfc.provider/consumptionTable";
        /**
         * The mime type of a single item.
         */
        public static final String CONTENT_CONSUMPTION_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE +
                        "/vnd.example.reico_000.prescriptionreadernfc.provider/consumptionTable";
        /**
         * A projection of all columns
         * in the items table.
         */
        public static final String KEY_ID = "_id";
        public static final String KEY_MEDICATION_ID = "MedicationID";
        public static final String KEY_CONSUMED_AT = "ConsumedAt";
        public static final String KEY_IS_TAKEN = "IsTaken";
        public static final String KEY_REMAINING_DOSAGE = "RemainingDosage";
        public static final String[] PROJECTION_ALL = new String[] {KEY_ID, KEY_MEDICATION_ID, KEY_CONSUMED_AT,
        KEY_IS_TAKEN, KEY_REMAINING_DOSAGE};
        /**
         * The default sort order for
         * queries containing NAME fields.
         */
        public static final String SORT_ORDER_DEFAULT =
                KEY_ID + " ASC";
    }

    /**
     * Constants for the Medication Use History table of the
     * Medication provider.
     */

    public static final class MedicationUseHistory
            implements BaseColumns {


        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(
                        MedicationContract.CONTENT_URI,
                        "medicationUseHistoryTable");

        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE +
                        "/vnd.example.reico_000.prescriptionreadernfc.provider/medicationUseHistoryTable";

        public static final String CONTENT_MEDICATION_USE_HISTORY_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE +
                        "/vnd.example.reico_000.prescriptionreadernfc.provider/medicationUseHistoryTable";

        public static final String KEY_ID = "_id";
        public static final String KEY_MEDICATION_USE_HISTORY = "MedicationUseHistory";
        public static final String KEY_MEDICATION_CONSUMED_AT = "MedicationConsumedAt";
        public static final String[] PROJECTION_ALL = new String[] {KEY_ID, KEY_MEDICATION_USE_HISTORY,
                KEY_MEDICATION_CONSUMED_AT};

        public static final String SORT_ORDER_DEFAULT =
                KEY_ID + " ASC";

    }

    /**
     * Constants for the Symptoms table of the
     * Medication provider.
     */
    public static final class Symptoms
            implements BaseColumns {
        /**
         * The content URI for this table.
         */
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(
                        MedicationContract.CONTENT_URI,
                        "symptomsTable");
        /**
         * The mime type of a directory of items.
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE +
                        "/vnd.example.reico_000.prescriptionreadernfc.provider/symptomsTable";
        /**
         * The mime type of a single item.
         */
        public static final String CONTENT_SYMPTOMS_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE +
                        "/vnd.example.reico_000.prescriptionreadernfc.provider/symptomsTable";
        /**
         * A projection of all columns
         * in the items table.
         */
        public static final String KEY_ID = "_id";
        public static final String KEY_NRIC = "NRIC";
        public static final String KEY_PATIENT_NAME = "PatientName";
        public static final String KEY_SYMPTOMS = "Symptoms";
        public static final String KEY_REPORTED_ON = "ReportedOn";
        public static final String[] PROJECTION_ALL = new String[] {KEY_ID, KEY_NRIC, KEY_PATIENT_NAME,
                        KEY_SYMPTOMS, KEY_REPORTED_ON};
        /**
         * The default sort order for
         * queries containing NAME fields.
         */
        public static final String SORT_ORDER_DEFAULT =
                KEY_ID + " ASC";
    }

    /**
     * Constants for the Consumption table of the
     * Medication provider.
     */
    public static final class PastMedication
            implements BaseColumns {
        /**
         * The content URI for this table.
         */
        public static final Uri CONTENT_URI =
                Uri.withAppendedPath(
                        MedicationContract.CONTENT_URI,
                        "pastMedicationTable");
        /**
         * The mime type of a directory of items.
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE +
                        "/vnd.example.reico_000.prescriptionreadernfc.provider/pastMedicationTable";
        /**
         * The mime type of a single item.
         */
        public static final String CONTENT_PAST_MED_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE +
                        "/vnd.example.reico_000.prescriptionreadernfc.provider/pastMedicationTable";
        /**
         * A projection of all columns
         * in the items table.
         */
        public static final String KEY_ID = "_id";
        public static final String KEY_MEDICATION_ID = "MedicationID";
        public static final String KEY_GENERIC_NAME = "GenericName";
        public static final String KEY_BRAND_NAME = "BrandName";
        public static final String KEY_PRESCRIPTION_DATE = "PrescriptionDate";
        public static final String KEY_FINISHED_ON= "FinishedOn";
        public static final String[] PROJECTION_ALL = new String[] {KEY_ID, KEY_MEDICATION_ID, KEY_GENERIC_NAME,
                            KEY_BRAND_NAME, KEY_PRESCRIPTION_DATE, KEY_FINISHED_ON};
        /**
         * The default sort order for
         * queries containing NAME fields.
         */
        public static final String SORT_ORDER_DEFAULT =
                KEY_ID + " ASC";
    }

}

//        /**
//         * This interface defines common columns
//         * found in multiple tables.
//         */
//        public static interface CommonColumns
//                extends BaseColumns { … }


