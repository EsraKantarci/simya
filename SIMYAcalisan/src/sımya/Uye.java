/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sımya;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author n
 */
public class Uye {

    //TC --> Isim
    //Name --> Soyisim
    //Surname--> eposta
    // Uni --> Sifre
    // Pop--> Sehir
    //Decdate ->hakkkında
    //Decno -> ilgi alanları
    //durum-->yas
    private IntegerProperty ID;
    private StringProperty Isim;
    private StringProperty Soyisim;
    private StringProperty Eposta;
    private StringProperty Sifre;
    private StringProperty Sehir;
    private StringProperty Hakkinda;
    private StringProperty Ilgialanlari;
    private IntegerProperty Yas;

    public Uye() {
        this.ID = new SimpleIntegerProperty();
        this.Isim = new SimpleStringProperty();
        this.Soyisim = new SimpleStringProperty();
        this.Eposta = new SimpleStringProperty();
        this.Sifre = new SimpleStringProperty();
        this.Sehir = new SimpleStringProperty();
        this.Hakkinda = new SimpleStringProperty();
        this.Ilgialanlari = new SimpleStringProperty();
        this.Yas = new SimpleIntegerProperty();
    }

    public int getID() {
        return ID.get();
    }

    public void setID(int personId) {
        this.ID.set(personId);
    }

    public IntegerProperty idProperty() {
        return ID;
    }

    public String getIsim() {
        return Isim.get();
    }

    public void setIsim(String isim) {
        this.Isim.set(isim);
    }

    public StringProperty isimProperty() {
        return Isim;
    }

    public String getSoyisim() {
        return Soyisim.get();
    }

    public void setSoyisim(String a) {
        this.Soyisim.set(a);
    }

    public StringProperty soyisimProperty() {
        return Soyisim;
    }

    public String getEposta() {
        return Eposta.get();
    }

    public void setEposta(String a) {
        this.Eposta.set(a);
    }

    public StringProperty epostaProperty() {
        return Eposta;
    }

    public String getSifre() {
        return Sifre.get();
    }

    public void setSifre(String a) {
        this.Sifre.set(a);
    }

    public StringProperty sifreProperty() {
        return Sifre;
    }

    public String getSehir() {
        return Sehir.get();
    }

    public void setSehir(String a) {
        this.Sehir.set(a);
    }

    public StringProperty sehirProperty() {
        return Sehir;
    }

    public String getHakkinda() {
        return Hakkinda.get();
    }

    public void setHakkinda(String hireDate) {
        this.Hakkinda.set(hireDate);
    }

    public StringProperty Hakkinda() {
        return Hakkinda;
    }

    public String getIlgialanlari() {
        return Ilgialanlari.get();
    }

    public void setIlgialanlari(String salary) {
        this.Ilgialanlari.set(salary);
    }

    public StringProperty ilgialanlariProperty() {
        return Ilgialanlari;
    }

    public int getYas() {
        return Yas.get();
    }

    public void setYas(int process) {
        this.Yas.set(process);
    }

    public IntegerProperty YasProperty() {
        return Yas;
    }

    private static Uye getPersonFromResultSet(ResultSet rs) throws SQLException {
        Uye per = null;
        if (rs.next()) {
            per = new Uye();
            per.setID(rs.getInt("id"));
            per.setIsim(rs.getString("isim"));
            per.setSoyisim(rs.getString("soyisim"));
            per.setEposta(rs.getString("eposta"));
            per.setSifre(rs.getString("sifre"));
            per.setSehir(rs.getString("sehir"));
            per.setHakkinda(rs.getString("hakkinda"));
            per.setIlgialanlari(rs.getString("ilgialanlari"));
            per.setYas(rs.getInt("yas"));

        }

        return per;
    }

    private static ObservableList<Uye> getPersonList(ResultSet rs) throws SQLException, ClassNotFoundException {

        ObservableList<Uye> perList = FXCollections.observableArrayList();

        while (rs.next()) {
            Uye per = new Uye();
            per.setID(rs.getInt("id"));
            per.setIsim(rs.getString("isim"));
            per.setSoyisim(rs.getString("soyisim"));
            per.setEposta(rs.getString("eposta"));
            per.setSifre(rs.getString("sifre"));
            per.setSehir(rs.getString("sehir"));
            per.setHakkinda(rs.getString("hakkinda"));
            per.setIlgialanlari(rs.getString("ilgialanlari"));
            per.setYas(rs.getInt("yas"));

            perList.add(per);
        }

        return perList;
    }

    public static void updatePerson(String perID, String Isim, String Soyisim, String Eposta, String Sifre, String Sehir, String Dec_No, String Dec_Date, String Process) throws SQLException, ClassNotFoundException {

        String updateStmt = "   UPDATE kayitlar\n"
                + "SET \n"
                + " isim = ?\n"
                + " soyisim = ?\n"
                + " eposta = ?\n"
                + " sifre = ?\n"
                + " sehir = ?\n"
                + " hakkinda = ?\n"
                + " ilgialanlari  = ?\n"
                + " yas = ?\n"
                + "    WHERE id = ?;";
        PreparedStatement prep = Database.conn.prepareStatement(updateStmt);
        prep.setString(1, Isim);
        prep.setString(2, Soyisim);
        prep.setString(3, Eposta);
        prep.setString(4, Sifre);
        prep.setString(5, Sehir);
        prep.setString(6, Dec_No);
        prep.setString(7, Dec_Date);
        prep.setString(8, Process);
        prep.setString(9, perID);

        try {
            prep.executeUpdate();
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    public static void deletePerson(String perId) throws SQLException, ClassNotFoundException {

        String updateStmt = "   DELETE FROM kayitlar\n"
                + "         WHERE id =" + perId + ";";

        try {
            Database.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    public static void insertPerson(String Isim, String Soyisim, String Eposta, String Uni, String Pop, String Dec_No, String Dec_Date, String Process) throws SQLException, ClassNotFoundException {

        String updateStmt = "INSERT INTO kayitlar(isim, soyisim, eposta, sifre, sehir, hakkinda ,ilgialanlari,yas)\n"
                + "VALUES ('" + Isim + "','" + Soyisim + "', '" + Eposta + "','" + Uni + "','" + Pop + "','" + Dec_No + "','" + Dec_Date + "','" + Process + "');";

        try {
            Database.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

    public static ObservableList<Uye> searchPersons(String isim, String ad, String soyad, String ikametgah, String kayitno, String kayittarihi, String durum) throws ClassNotFoundException, SQLException {

        String selectStmt = "SELECT * FROM uye WHERE ";
        String yenisi = "";
        if (!isim.isEmpty()) {
            yenisi += "isim LIKE '%" + isim + "%'";
        }
        if (!ad.isEmpty()) {
            if (!yenisi.isEmpty()) {
                yenisi += " AND ";
            }
            yenisi += "soyisim LIKE '%" + ad + "%'";
        }

        if (!soyad.isEmpty()) {
            if (!yenisi.isEmpty()) {
                yenisi += " AND ";
            }
            yenisi += "eposta LIKE '%" + soyad + "%'";
        }

        if (!ikametgah.isEmpty()) {
            if (!yenisi.isEmpty()) {
                yenisi += " AND ";
            }
            yenisi += "sehir LIKE '%" + ikametgah + "%'";
        }

        if (!kayitno.isEmpty()) {
            if (!yenisi.isEmpty()) {
                yenisi += " AND ";
            }
            yenisi += "hakkinda LIKE '%" + kayitno + "%'";
        }

        if (!kayittarihi.isEmpty()) {
            if (!yenisi.isEmpty()) {
                yenisi += " AND ";
            }
            yenisi += "ilgialanlari LIKE '%" + kayittarihi + "%'";
        }

        if (!durum.isEmpty()) {
            if (!yenisi.isEmpty()) {
                yenisi += " AND ";
            }
            yenisi += "yas LIKE '%" + durum + "%'";
        }
        selectStmt += yenisi;
        System.out.println(selectStmt);
        try {

            ResultSet rsPers = Database.dbExecuteQuery(selectStmt);

            ObservableList<Uye> perList = getPersonList(rsPers);

            return perList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);

            throw e;
        }
    }

    public static ObservableList<Uye> searchPersonsAll() throws ClassNotFoundException, SQLException {

        String selectStmt = "SELECT * FROM Uye";

        try {

            ResultSet rsPers = Database.dbExecuteQuery(selectStmt);

            ObservableList<Uye> perList = getPersonList(rsPers);

            return perList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);

            throw e;
        }
    }
}
