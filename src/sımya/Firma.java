/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sımya;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author n
 */
public class Firma {

    
    //ID -> fID
    //TC --> fad
    //Name --> fsektor
    //Surname--> fadres
    // Uni --> ftelefon
    // Pop--> feposta
    
    private IntegerProperty fID;
    private StringProperty fAd;
    private StringProperty fSektor;
    private StringProperty fAdres;
    private StringProperty fTelefon;
    private StringProperty fEposta;
    private StringProperty Dec_No;    
    private StringProperty Dec_Date;
    private IntegerProperty Durum;

   
 

    public Firma() {
        this.fID = new SimpleIntegerProperty();
        this.fAd = new SimpleStringProperty();
        this.fSektor = new SimpleStringProperty();
        this.fAdres = new SimpleStringProperty();
        this.fTelefon = new SimpleStringProperty();
        this.fEposta = new SimpleStringProperty();
        this.Dec_No = new SimpleStringProperty();
        this.Dec_Date = new SimpleStringProperty();
        this.Durum = new SimpleIntegerProperty();
    }
 
  
    public int getfID() {
        return fID.get();
    }
 
    public void setfID(int personId){
        this.fID.set(personId);
    }
 
    public IntegerProperty fidProperty(){
        return fID;
    }
    
    public String getfAd () {
        return fAd.get();
    }
 
    public void setfAd (String tc){
        this.fAd.set(tc);
    }
 
    public StringProperty fAdProperty() {
        return fAd;
    }
 
 
    public String getfSektor () {
        return fSektor.get();
    }
 
    public void setfSektor(String firstName){
        this.fSektor.set(firstName);
    }
 
    public StringProperty fSektorProperty() {
        return fSektor;
    }
 
    
    public String getfAdres () {
        return fAdres.get();
    }
 
    public void setfAdres(String a){
        this.fAdres.set(a);
    }
 
    public StringProperty fAdresProperty() {
        return fAdres;
    }
 
    
    public String getfTelefon() {
        return fTelefon.get();
    }
 
    public void setfTelefon (String a){
        this.fTelefon.set(a);
    }
 
    public StringProperty fTelefonProperty() {
        return fTelefon;
    }
 
    
    public String getfEposta () {
        return fEposta.get();
    }
 
    public void setfEposta (String jobId){
        this.fEposta.set(jobId);
    }
 
    public StringProperty fEpostaProperty() {
        return fEposta;
    }
 
    
    public String getDec_Date(){
        return Dec_Date.get();
    }
 
    public void setDec_Date(String hireDate){
        this.Dec_Date.set(hireDate);
    }
 
    public StringProperty dec_dateProperty(){
        return Dec_Date;
    }
    
    
    public String getDec_No() {
        return Dec_No.get();
    }
 
    public void setDec_No(String salary){
        this.Dec_No.set(salary);
    }
 
    public StringProperty dec_noProperty(){
        return Dec_No;
    }
    
    
    public int getProcess() {
        return Durum.get();
    }
 
    public void setProcess(int process){
        this.Durum.set(process);
    }
    
    public IntegerProperty processProperty() {
        return Durum;
    }
 
}

