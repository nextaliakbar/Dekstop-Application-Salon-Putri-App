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
import model.ModelVoucher;
/**
 *
 * @author usER
 */
public class ControlVoucher {
    private Connection connection;

    public ControlVoucher() {
        connection = Config.getConnection();
    }
    
    public List<ModelVoucher> getData() {
        List<ModelVoucher> voucher = new ArrayList<>();
        String query = "SELECT * FROM voucher ORDER BY Tanggal_Berakhir DESC";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                String kodeVoucher = rst.getString("Kode_Voucher");
                String tglPembuatan = rst.getString("Tanggal_Pembuatan");
                String tglBerakhir = rst.getString("Tanggal_Berakhir");
                int besarVoucher = rst.getInt("Besar_Voucher");
                String status = rst.getString("Status");
                voucher.add(new ModelVoucher(kodeVoucher, tglPembuatan, tglBerakhir, besarVoucher, status));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            
        return voucher;
    }
    
    public void addData(ModelVoucher modelVoucher) {
        String query = "INSERT INTO voucher (Kode_Voucher, Tanggal_Pembuatan, Tanggal_Berakhir, Besar_Voucher, Status) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelVoucher.getKodeVoucher());
            pst.setString(2, modelVoucher.getTglPembuatan());
            pst.setString(3, modelVoucher.getTglBerakhir());
            pst.setInt(4, modelVoucher.getBesarVoucher());
            pst.setString(5, modelVoucher.getStatus());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Membuat Voucher Baru\nSilahkan Simpan atau Cetak Voucher");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
        
    public String autoID() {
        String idUser = null;
        String format = new SimpleDateFormat("yyMM").format(new Date());
        String query = "SELECT RIGHT (Kode_Voucher, 3) AS Number FROM voucher WHERE Kode_Voucher LIKE 'VCR-"+format+"%' ORDER BY Kode_Voucher DESC LIMIT 1";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            if(rst.next()) {
                int number = Integer.parseInt(rst.getString("Number"));
                number++;
                idUser = "VCR-" + format + "-" + String.format("%03d", number);
            } else {
                idUser = "VCR-" + format + "001";
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return idUser;
    }
}
