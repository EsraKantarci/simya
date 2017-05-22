/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sımya;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author n
 */
public class Isler {

    private IntegerProperty isid;
    private StringProperty isadi;
    private StringProperty aciklamalar;
    private StringProperty sehir;
    private StringProperty ucret;
    private SimpleObjectProperty<Date> bitistarihi;
    private IntegerProperty calismatipi;
    private StringProperty calismatipi2;
    private SimpleObjectProperty<Date> ilantarihi;

    public Isler() {
        this.isid = new SimpleIntegerProperty();
        this.isadi = new SimpleStringProperty();
        this.aciklamalar = new SimpleStringProperty();
        this.sehir = new SimpleStringProperty();
        this.ucret = new SimpleStringProperty();
        this.bitistarihi = new SimpleObjectProperty<>();
        this.ilantarihi = new SimpleObjectProperty<>();
        this.calismatipi = new SimpleIntegerProperty();
        this.calismatipi2 = new SimpleStringProperty();

    }

    public int getisid() {
        return isid.get();
    }

    public void setisid(int personId) {
        this.isid.set(personId);
    }

    public IntegerProperty isidProperty() {
        return isid;
    }

    public String getisadi() {
        return isadi.get();
    }

    public void setisadi(String tc) {
        this.isadi.set(tc);
    }

    public StringProperty isadiProperty() {
        return isadi;
    }

    public String getsehir() {
        return sehir.get();
    }

    public void setsehir(String firstad) {
        this.sehir.set(firstad);
    }

    public StringProperty sehirProperty() {
        return sehir;
    }

    public Object getbitistarihi() {
        return bitistarihi.get();
    }

    public void setbitistarihi(Date hireDate) {
        this.bitistarihi.set(hireDate);
    }

    public SimpleObjectProperty<Date> bitistarihiDateProperty() {
        return bitistarihi;
    }

    public Object getilantarihi() {
        return ilantarihi.get();
    }

    public void setilantarihi(Date hireDate) {
        this.ilantarihi.set(hireDate);
    }

    public SimpleObjectProperty<Date> ilantarihiDateProperty() {
        return ilantarihi;
    }

    public String getucret() {
        return ucret.get();
    }

    public void setucret(String lastad) {
        this.ucret.set(lastad);
    }

    public StringProperty ucretProperty() {
        return ucret;
    }

    public String getaciklamalar() {
        return aciklamalar.get();
    }

    public void setaciklamalar(String uni) {
        this.aciklamalar.set(uni);
    }

    public StringProperty aciklamalarProperty() {
        return aciklamalar;
    }

    public int getcalismatipi() {
        return calismatipi.get();
    }

    public void setcalismatipi(int process) {
        this.calismatipi.set(process);
        this.calismatipi2.set((process == 0 ? "Fulltime" : (process == 1 ? "Parttime" : "Bir kerelik")));
    }

    public StringProperty calismatipiProperty() {
        return calismatipi2;
    }

    private static Isler getJobFromResultSet(ResultSet rs) throws SQLException {
        Isler per = null;
        if (rs.next()) {
            per = new Isler();
            per.setisid(rs.getInt("isid"));
            per.setisadi(rs.getString("ilanadi"));
            per.setucret(rs.getString("ucret"));
            per.setsehir(rs.getString("sehir"));
            per.setaciklamalar(rs.getString("aciklamalar"));
            per.setbitistarihi(rs.getDate("bitistarihi"));
            per.setilantarihi(rs.getDate("ilantarihi"));

        }

        return per;
    }

    private static ObservableList<Isler> getJobsList(ResultSet rs) throws SQLException, ClassNotFoundException {

        ObservableList<Isler> perList = FXCollections.observableArrayList();

        while (rs.next()) {
            Isler per = new Isler();
            per.setisid(rs.getInt("isid"));
            per.setisadi(rs.getString("ilanadi"));
            per.setucret(rs.getString("ucret"));
            per.setsehir(rs.getString("sehir"));
            per.setaciklamalar(rs.getString("aciklamalar"));
            per.setbitistarihi(rs.getDate("bitistarihi"));
            per.setilantarihi(rs.getDate("ilantarihi"));

            perList.add(per);
        }

        return perList;
    }

    public static void updateJobs(String perID, String Isim, String Soyisim, String Eposta, String Sifre, String Sehir, String Dec_No, String Dec_Date, String Process) throws SQLException, ClassNotFoundException {

        String updateStmt = "   UPDATE isler\n"
                + "SET \n"
                + " isadi = ?\n"
                + " aciklamalar = ?\n"
                + " calismatipi = ?\n"
                + " sehir = ?\n"
                + " ucret = ?\n"
                + " bitistarihi = ?\n"
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

    public static void insertJob(String Isim, String Soyisim, String Eposta, String Uni, String Pop, String Dec_No, String Dec_Date, String Process) throws SQLException, ClassNotFoundException {

        String updateStmt = "INSERT INTO isler(isid, sehir, ucret, bitistarihi, calismasekli, aciklamalar, ilantarihi)\n"
                + "VALUES ('" + Isim + "','" + Soyisim + "', '" + Eposta + "','" + Uni + "','" + Pop + "','" + Dec_No + "','" + Dec_Date + "',now() ;";

        try {
            Database.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while UPDATE Operation: " + e);
            throw e;
        }
    }

    public static ObservableList<Isler> searchJobs(String isim, String ad, String soyad, String ikametgah, String kayitno, String kayittarihi, String durum) throws ClassNotFoundException, SQLException {

        String selectStmt = "SELECT * FROM isler WHERE ";
        String yenisi = "";
        if (!isim.isEmpty()) {
            yenisi += "isadi LIKE '%" + isim + "%'";
        }
        if (!ad.isEmpty()) {
            if (!yenisi.isEmpty()) {
                yenisi += " AND ";
            }
            yenisi += "sehir LIKE '%" + ad + "%'";
        }

        if (!soyad.isEmpty()) {
            if (!yenisi.isEmpty()) {
                yenisi += " AND ";
            }
            yenisi += "bitistarihi LIKE '%" + soyad + "%'";
        }

        if (!ikametgah.isEmpty()) {
            if (!yenisi.isEmpty()) {
                yenisi += " AND ";
            }
            yenisi += "calismatipi LIKE '%" + ikametgah + "%'";
        }

        if (!kayitno.isEmpty()) {
            if (!yenisi.isEmpty()) {
                yenisi += " AND ";
            }
            yenisi += "aciklamalar LIKE '%" + kayitno + "%'";
        }

        if (!kayittarihi.isEmpty()) {
            if (!yenisi.isEmpty()) {
                yenisi += " AND ";
            }
            yenisi += "ucret LIKE '%" + kayittarihi + "%'";
        }

        selectStmt += yenisi;
        System.out.println(selectStmt);
        try {

            ResultSet rsPers = Database.dbExecuteQuery(selectStmt);

            ObservableList<Isler> perList = getJobsList(rsPers);

            return perList;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);

            throw e;
        }
    }

    public static ObservableList<Isler> searchJobsAll() throws ClassNotFoundException, SQLException {

        String selectStmt = "SELECT * FROM Isler";

        try {

            ResultSet rsPers = Database.dbExecuteQuery(selectStmt);

            ObservableList<Isler> perList = getJobsList(rsPers);

            return perList;
            
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);

            throw e;
        }
    }
}

