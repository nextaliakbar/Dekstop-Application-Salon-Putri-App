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
import java.util.Date;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author usER
 */
public class ControlDashboard {
    private Connection connection;
    private final String dateNow = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    public ControlDashboard() {
        connection = Config.getConnection();
    }
    
    public int totalTransaksiCustomer() {
        int total = 0;
        String query = "SELECT COUNT(ID_Customer) AS Total FROM transaksi WHERE Tgl_Transaksi='"+dateNow+"' ";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            if(rst.next()) {
                total = rst.getInt("Total");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return total;
    }
    
    public double totalPendapatan() {
        double total = 0;
        String query = "SELECT SUM(Total_Transaksi) AS Total FROM transaksi WHERE Tgl_Transaksi='"+dateNow+"' ";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            if(rst.next()) {
                total = rst.getDouble("Total");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return total;
    }
    
    public int totalVoucher() {
        int total = 0;
        String query = "SELECT COUNT(Kode_Voucher) AS Total FROM voucher WHERE Status='Belum Digunakan' ";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            if(rst.next()) {
                total = rst.getInt("Total");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return total;
    }
    
    public void loadData(DefaultTableModel model) {
        String query = "SELECT dtl.ID_Layanan, lyn.Tipe_Layanan, lyn.ID_Jenis_Layanan, \n" +
                        "jns.Nama_Layanan, lyn.Harga, COUNT(dtl.ID_Layanan) AS Jumlah \n" +
                        "FROM detail_transaksi dtl JOIN layanan lyn \n" +
                        "ON dtl.ID_Layanan=lyn.ID_Layanan \n" +
                        "JOIN jenis_layanan jns ON lyn.ID_Jenis_Layanan=jns.ID_Jenis_Layanan \n" +
                        "GROUP BY dtl.ID_Layanan ORDER BY Jumlah DESC ";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                String idLayanan = rst.getString("ID_Layanan");
                String jenisLayanan = rst.getString("Nama_Layanan");
                String tipeLayanan = rst.getString("Tipe_Layanan");
                String namaLayanan = jenisLayanan.concat(" - ").concat(tipeLayanan);
                String harga = rst.getString("Harga");
                String jumlah = rst.getString("Jumlah");
                model.addRow(new String[]{idLayanan, namaLayanan, harga, jumlah});
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
}
