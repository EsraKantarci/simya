/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sımya;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TableRow;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.text.Text;

/**
 *
 * @author n
 */
public class TabController implements Initializable {

    Statement stmt;
    Connection conn;
    @FXML
    private Parent paneMesaj;
     
    private int suankidurum = 0;
    @FXML
    private Button btnCikisCikisyap;
    @FXML
    private Button msjgonder;
    @FXML
    private Text msjtxt;
    @FXML
    private TextField tfKayitAd;
    @FXML
    private TextField tfKayitSoyad;
    @FXML
    private TextField tfKayitEposta;
    @FXML
    private TextField tfKayitSifre;
    @FXML
    private TextField aramayap;
    @FXML
    
    private TextField tfilanadi;
    @FXML
    private TextField tfsehiris;
    @FXML
    private TextField tfucret;
    @FXML
    private TextField tfad;
    @FXML
    private TextField tfsoyad;
    @FXML
    private TextField tfyas;
    @FXML
    private TextField tfhakkinda;
    @FXML
    private TextField tfilgialanlari;
    @FXML
    private TextField tficerik;
    @FXML
    private TextField tfsehir;
    
    @FXML
    private TextField tfsoyadkisi;
    @FXML
    private TextField tfadkisi;
    @FXML
    private TextField tfdiger;
    @FXML
    private TextField tfilgikisi;
     @FXML
    private TextField tfsehirkisi;
    
    @FXML
    private MenuButton calismasekli;
    @FXML
    private Button profiliduzenle;
    @FXML
    private Button isara;
    @FXML
    private Button kisiara;
    @FXML
    private Button btnkisiara;
    @FXML
    private Button btnisara;
    @FXML
    private Button searchperson;
    
    
    
    @FXML
    private TextArea aciklama;

    
    
   int duzenlenecekid=1;
   
    public void initialize(URL url, ResourceBundle rb) {
        paneMesaj.setVisible(false);
        msjtxt.setVisible(false);
        tfad.setDisable(true);
        tfsehir.setDisable(true);
        tfsoyad.setDisable(true);
        tfyas.setDisable(true);
        tfhakkinda.setDisable(true);
        tfilgialanlari.setDisable(true);

    }

      @FXML
    private void kisi1() {
        paneMesaj.setVisible(true);

    }
    
    @FXML
    private void profiliduzenle() {
    tfad.setDisable(false);
               tfad.setDisable(false);
    tfsehir.setDisable(false);
        tfsoyad.setDisable(false);
        tfyas.setDisable(false);
        tfhakkinda.setDisable(false);
        tfilgialanlari.setDisable(false);


    }
       @FXML
    private void degisiklik() {
        String updateStmt = "";
        try {

            updateStmt = "   UPDATE uye\n"
                    + "SET \n"
                    + " ad = ?,\n"
                    + " soyad = ?,\n"
                    + " sehir = ?,\n"
                    + " yas = ?,\n"
                    + " hakkinda = ?,\n"
                    + " ilgialanlari = ?\n"
                  
                    + " WHERE id = ?;";
            PreparedStatement prep = Database.dbPrepareStatement(updateStmt);
            prep.setString(1, tfad.getText());
            prep.setString(2, tfsoyad.getText());
            prep.setString(3, tfsehir.getText());
            prep.setString(4, tfyas.getText());
            prep.setString(5, tfhakkinda.getText());
            prep.setString(6, tfilgialanlari.getText());
         
            prep.setInt(7, duzenlenecekid);

 
            
        
            
            Database.dbEndPrepareStatement(prep);
            Uye sdsd =new Uye();
            /* bunu nasıl üyeye set edeceğiz *///Uye sdsd = (Uye) .getSelectionModel().getSelectedItem();
            sdsd.setIsim(tfad.getText());
            sdsd.setSoyisim(tfsoyad.getText());
            sdsd.setSehir(tfsehir.getText());
            sdsd.setYas(Integer.parseInt(tfyas.getText()));
            sdsd.setIlgialanlari(tfilgialanlari.getText());
            sdsd.setHakkinda(tfhakkinda.getText());
         
           

//            ShowAll();
        } catch (Exception e) {
            System.out.println(e + " ");
        } finally {
//            clearFields();
        }
    }

    
    
    @FXML
    private void kisi2() {
        paneMesaj.setVisible(true);

    }

    @FXML
    private void spam1() {
        paneMesaj.setVisible(true);

    }

    @FXML
    private void spam2() {
        paneMesaj.setVisible(true);

    }

    @FXML
    private void msjgonder() {
        msjtxt.setVisible(true);

    }
    String sea = "";

    public void handleButtonAction(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent root = null;
        if (event.getSource() == btnCikisCikisyap) {
            root = FXMLLoader.load(getClass().getResource("LoginPage.fxml"));
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void yeniUye() throws ClassNotFoundException {

        /* String updateStmt="INSERT INTO uye (";
        String valuestmt="VALUES ('";
        if(!tc.getText().isEmpty()){
            updateStmt+="tc,";
        }if(!ad.getText().isEmpty()){
            updateStmt+="ad,";
        
        böyle de yapılabilir
        }*/
        //    if (!ad.getText().isEmpty() && !soyad.getText().isEmpty() && !uni.getText().isEmpty()){
        String updateStmt = "INSERT INTO uye(isim,soyisim,eposta,sifre)\n"
                + "VALUES ('" + tfKayitAd.getText() + "','" + tfKayitSoyad.getText() + "', '" + tfKayitEposta.getText() + "','" + tfKayitSifre.getText() + "');";

        try {
            Database.dbExecuteUpdate(updateStmt);

            stmt = conn.createStatement();
            stmt.executeUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Girdi eklenemedi");
            System.out.println("dene");
        }
    }
    
    public void isara() {

        String ney = "",
                o = "";
        String yeni = "SELECT * FROM isler"
                + " WHERE (";
        String kriter = "";

        String[] keys = aramayap.getText().split(" ");

        for (int i = 0; i < keys.length - 1; i++) {

//        for(int i=0;i<keys.length;i++){
            yeni += "isadi LIKE '%" + keys[i] + "%' OR"
                    + "sehir LIKE '%" + keys[i] + "%' OR"
                    + "ucret LIKE '%" + keys[i] + "%' OR"
                    + "aciklamalar LIKE '%" + keys[i] + "%'";

//            }
            yeni += ") AND (";
        }
        yeni += "isadi LIKE '%" + keys[keys.length - 1] + "%' OR"
                + "sehir LIKE '%" + keys[keys.length - 1] + "%' OR"
                + "soyad LIKE '%" + keys[keys.length - 1] + "%' OR"
                + "ucret LIKE '%" + keys[keys.length - 1] + "%' OR"
                + "aciklamalar LIKE '%" + keys[keys.length - 1] + "%')";

    }

    
     public void kisiara() {

        String ney = "",
                o = "";
        String yeni = "SELECT * FROM uye"
                + " WHERE (";
        String kriter = "";

        String[] keys = aramayap.getText().split(" ");

        for (int i = 0; i < keys.length - 1; i++) {

//        for(int i=0;i<keys.length;i++){
            yeni += "isim LIKE '%" + keys[i] + "%' OR"
                    + "soyisim LIKE '%" + keys[i] + "%' OR"
                    + "ilgialanlari LIKE '%" + keys[i] + "%' OR"
                     + "sehir LIKE '%" + keys[i] + "%' OR"
                    + "hakkinda LIKE '%" + keys[i] + "%'";

//            }
            yeni += ") AND (";
        }
        yeni += "isim LIKE '%" + keys[keys.length - 1] + "%' OR"
                + "sehir LIKE '%" + keys[keys.length - 1] + "%' OR"
                + "soyisim LIKE '%" + keys[keys.length - 1] + "%' OR"
                + "ilgialanlari LIKE '%" + keys[keys.length - 1] + "%' OR"
                + "hakkinda LIKE '%" + keys[keys.length - 1] + "%')";

    }
     
     
    // datayı yazarken çekmek için 
    public void askData(KeyEvent key) {
        sea += key.getCharacter();
        System.out.println(sea);

    }

    public void searchjob() {

        // String[] keys = ara.getText().split(" ");
//        HashMap map = new HashMap();
        String ney = "",
                o = "";
        String yeni = "SELECT * FROM isler WHERE";
        String kriter = "";
        if (!tfilanadi.getText().isEmpty()) {
            kriter = kriter + "isadi='" + tfilanadi.getText() + "'";
        }
        if (!tficerik.getText().isEmpty()) {
            if (kriter != "") {
                kriter += " AND ";
            }
            kriter += "aciklamalar='" + tficerik.getText() + "'";
        }

        if (!tfsehiris.getText().isEmpty()) {
            if (kriter != "") {
                kriter += " AND ";
            }
            kriter += "sehir='" + tfsehiris.getText() + "'";
        }

        if (!tfucret.getText().isEmpty()) {
            if (kriter != "") {
                kriter += " AND ";
            }
            kriter += "ucret='" + tfucret.getText() + "'";
        }

       
        if (!calismasekli.getText().isEmpty()) {
            if (kriter != "") {
                kriter += " AND ";
            }
            kriter += "calismatipi='" + calismasekli.getText() + "'";
        }

    }
    
         public void searchperson() {

        // String[] keys = ara.getText().split(" ");
//        HashMap map = new HashMap();
        String ney = "",
                o = "";
        String yeni = "SELECT * FROM uye WHERE";
        String kriter = "";
        if (!tfadkisi.getText().isEmpty()) {
            kriter = kriter + "isim='" + tfadkisi.getText() + "'";
        }
        if (!tfsoyadkisi.getText().isEmpty()) {
            if (kriter != "") {
                kriter += " AND ";
            }
            kriter += "soyisim='" + tfsoyadkisi.getText() + "'";
        }
   if (!tfsehirkisi.getText().isEmpty()) {
            if (kriter != "") {
                kriter += " AND ";
            }
            kriter += "sehir='" + tfsehirkisi.getText() + "'";
            
        }
      if (!tfilgikisi.getText().isEmpty()) {
            if (kriter != "") {
                kriter += " AND ";
            }
            kriter += "ilgialanlari='" + tfilgikisi.getText() + "'";
        }
      
       
        if (!tfdiger.getText().isEmpty()) {
            if (kriter != "") {
                kriter += " AND ";
            }
            kriter += "aciklamalar='" + tfdiger.getText() + "'";
        }

        /*for(String key : keys){
            
            // ad:    Eray     İsmet 
            int nere = key.indexOf(":");
            
            if(nere != -1){
                if(!o.isEmpty()){
                    yeni += " AND";
//                    map.put(ney, o);
                }
                
                ney = key.substring(0,nere);
                yeni+= " " + ney + " LIKE " ;
                
                if(nere != key.length()-1){
                    o = key.substring(nere+1,key.length());
                    yeni+= "'%" + o + "%'";
                }
            }
            else {
                
                o += (o.isEmpty() ? "" : " ") + key;
                yeni+= "'%" + o + "%'";
                       
            }
//            System.out.println(yeni);
        }
         */
        try {
            System.out.println(yeni + " " + kriter);
            ResultSet rsPers = Database.dbExecuteQuery(yeni + " " + kriter);
    
            ObservableList<Isler> perList = getJobsList(rsPers);
            populateJobs(perList);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void full1() {
        suankidurum = 0;
        calismasekli.setText("Fulltime");
    }

    public void part1() {
        suankidurum = 1;
        calismasekli.setText("Parttime");
    }

    public void tek1() {
        suankidurum = 2;
        calismasekli.setText("Tek Seferlik");
    }
}

    /*
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        update.setDisable(true);
        tableview.setRowFactory(tv -> {
            TableRow<Person> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (!row.isEmpty())) {
                    Person rowData = row.getItem();
                    fillTF(rowData);
                    update.setDisable(false);
                }
            });
            return row;
        });
        id.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        tctb.setCellValueFactory(cellData -> cellData.getValue().tcProperty());
        adtb.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        soyadtb.setCellValueFactory(cellData -> cellData.getValue().surnameProperty());
        unitb.setCellValueFactory(cellData -> cellData.getValue().uniProperty());
        ikametgahtb.setCellValueFactory(cellData -> cellData.getValue().popProperty());
        kararnotb.setCellValueFactory(cellData -> cellData.getValue().dec_noProperty());
        karartarihtb.setCellValueFactory(cellData -> cellData.getValue().dec_dateProperty());
        durumtb.setCellValueFactory(cellData -> cellData.getValue().processProperty());
    }

    private void populatePersons(ObservableList<Person> perData) throws ClassNotFoundException {
        tableview.setVisible(true);
        tableview.setItems(perData);
    }

}

@Override
     
}
}
*/
    
