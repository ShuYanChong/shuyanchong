package com.example.reico_000.prescriptionreadernfc;


public interface Communicator {

    public void respondReset();
    public void displayToastForId(long idInDB);
    public void deleteId(long idInDB);
    public void respondConsumeMed();

}
