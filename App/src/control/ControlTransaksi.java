/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelCustomer;
import model.ModelKaryawan;
import model.ModelTransaksi;
import model.ModelUser;
import model.ModelVoucher;

/**
 *
 * @author usER
 */
public class ControlTransaksi {

    private Connection connection;
    public ControlTransaksi() {
        connection = Config.getConnection();
    }
    
    public List<ModelTransaksi> getData() {
        List<ModelTransaksi> modelTransaksi = new ArrayList<>();
        String query = "SELECT trsk.No_Transaksi, trsk.Tgl_Transaksi, trsk.Total_Transaksi, trsk.Bayar, " +
                        "trsk.Kembali, trsk.Jenis_Pembayaran, trsk.ID_Customer, cst.Nama_Customer, " +
                        "trsk.ID_Karyawan, krn.Nama_Karyawan, trsk.ID_User " +
                        "FROM transaksi trsk INNER JOIN customer cst ON trsk.ID_Customer=cst.ID_Customer " +
                        "INNER JOIN karyawan krn ON trsk.ID_Karyawan=krn.ID_Karyawan " +
                        "INNER JOIN user usr ON trsk.ID_User=usr.ID_User ORDER BY No_Transaksi DESC ";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                String noTransaksi = rst.getString("No_Transaksi");
                String tglTransaksi = rst.getString("Tgl_Transaksi");
                String idCustomer = rst.getString("ID_Customer");
                String namaCustomer = rst.getString("Nama_Customer");
                double totalTransaksi = rst.getDouble("Total_Transaksi");
                double bayar = rst.getDouble("Bayar");
                double kembali = rst.getDouble("Kembali");
                String jenisPembayaran = rst.getString("Jenis_Pembayaran");
                String idKaryawan = rst.getString("ID_Karyawan");
                String namaKaryawan = rst.getString("Nama_Karyawan");
                String idUser = rst.getString("ID_User");
                ModelCustomer modelCustomer = new ModelCustomer(idCustomer, namaCustomer, "", "");
                ModelKaryawan modelKaryawan = new ModelKaryawan(idKaryawan, namaKaryawan, "", "", "", "");
                ModelUser modelUser = new ModelUser(idUser, "", "", "", "", "");
                modelTransaksi.add(new ModelTransaksi(noTransaksi, tglTransaksi, totalTransaksi, bayar, kembali, jenisPembayaran, 
                modelCustomer, modelKaryawan, modelUser));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return modelTransaksi;
    }
    
    public void addData(ModelTransaksi modelTransaksi) {
        String query = "INSERT INTO transaksi (No_Transaksi, Tgl_Transaksi, Total_Transaksi, Bayar, Kembali, Jenis_Pembayaran, ID_Customer, ID_Karyawan, ID_User) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelTransaksi.getNoTransaksi());
            pst.setString(2, modelTransaksi.getTglTransaksi());
            pst.setDouble(3, modelTransaksi.getTotal());
            pst.setDouble(4, modelTransaksi.getBayar());
            pst.setDouble(5, modelTransaksi.getKembali());
            pst.setString(6, modelTransaksi.getJenisPembayaran());
            pst.setString(7, modelTransaksi.getModelCustomer().getIdCustomer());
            pst.setString(8, modelTransaksi.getModelKaryawan().getIdKaryawan());
            pst.setString(9, modelTransaksi.getModelUser().getIdUser());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan Transaksi Baru");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public String autoID() {
        String autoID = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
        Date dateNow = new Date();
        String strFormat = sdf.format(dateNow);
        String query = "SELECT RIGHT(No_Transaksi, 3) AS No_Transaksi FROM transaksi WHERE No_Transaksi LIKE 'TRNKS-"+strFormat+"%' ORDER BY No_Transaksi DESC LIMIT 1";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            if(rst.next()) {
                int number = Integer.parseInt(rst.getString("No_Transaksi"));
                number++;
                autoID = "TRNKS-" + strFormat + "-" +String.format("%03d", number);
            } else {
                autoID = "TRNKS-"+strFormat+"-001";
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return autoID;
    }
        
//    Laporan
    public List<ModelTransaksi> loadData(String from, String to) {
        List<ModelTransaksi> modelTransaksi = new ArrayList<>();
        String query = "SELECT trsk.No_Transaksi, trsk.Tgl_Transaksi, trsk.Total_Transaksi, trsk.Bayar, " +
                        "trsk.Kembali, trsk.Jenis_Pembayaran, trsk.ID_Customer, cst.Nama_Customer, " +
                        "trsk.ID_Karyawan, krn.Nama_Karyawan, trsk.ID_User " +
                        "FROM transaksi trsk INNER JOIN customer cst ON trsk.ID_Customer=cst.ID_Customer " +
                        "INNER JOIN karyawan krn ON trsk.ID_Karyawan=krn.ID_Karyawan " +
                        "INNER JOIN user usr ON trsk.ID_User=usr.ID_User "
                        + "WHERE Tgl_Transaksi BETWEEN '"+from+"' AND '"+to+"' ORDER BY No_Transaksi DESC";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                String noTransaksi = rst.getString("No_Transaksi");
                String tglTransaksi = rst.getString("Tgl_Transaksi");
                String idCustomer = rst.getString("ID_Customer");
                String namaCustomer = rst.getString("Nama_Customer");
                double totalTransaksi = rst.getDouble("Total_Transaksi");
                double bayar = rst.getDouble("Bayar");
                double kembali = rst.getDouble("Kembali");
                String jenisPembayaran = rst.getString("Jenis_Pembayaran");
                String idKaryawan = rst.getString("ID_Karyawan");
                String namaKaryawan = rst.getString("Nama_Karyawan");
                String idUser = rst.getString("ID_User");
                ModelCustomer modelCustomer = new ModelCustomer(idCustomer, namaCustomer, "", "");
                ModelKaryawan modelKaryawan = new ModelKaryawan(idKaryawan, namaKaryawan, "", "", "", "");
                ModelUser modelUser = new ModelUser(idUser, "", "", "", "", "");
                modelTransaksi.add(new ModelTransaksi(noTransaksi, tglTransaksi, totalTransaksi, bayar, kembali, jenisPembayaran, 
                modelCustomer, modelKaryawan, modelUser));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return modelTransaksi;
    }
    
}
