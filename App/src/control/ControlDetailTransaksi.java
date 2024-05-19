/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import config.Config;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.time.LocalDate;
import model.ModelDetailTransaksi;
import model.ModelVoucher;
import model.TransaksiSementara;

public class ControlDetailTransaksi {
    private Connection connection;
    
    public ControlDetailTransaksi() {
        connection = Config.getConnection();
    }
        
    public void addDataDetail(ModelDetailTransaksi modelDetail, TransaksiSementara ts) {
        String query = "INSERT INTO detail_transaksi (No_Transaksi, ID_Layanan, Diskon, Subtotal_Transaksi, Kode_Voucher) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelDetail.getModelTransaksi().getNoTransaksi());
            
            for(String idLayanan : ts.getIdLayanan()) {
                pst.setString(2, idLayanan);
            }
            
            for(double diskon : ts.getDiskon()) {
                pst.setDouble(3, diskon);
            }
            
            for(double subtotal : ts.getSubototal()) {
                pst.setDouble(4, subtotal);
            }
            
            for(String kodeVoucher : ts.getKodeVoucher()) {
                pst.setString(5, kodeVoucher);
            }
            
            pst.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
        public String checkVoucher(ModelVoucher modelVoucher) {
            String strBesarVoucher = null;
            String query = "SELECT Tanggal_Berakhir, Besar_Voucher FROM voucher WHERE Kode_Voucher='"+modelVoucher.getKodeVoucher()+"' "
                    + "AND Status='Belum Digunakan' ";
            try {
                PreparedStatement pst = connection.prepareStatement(query);
                ResultSet rst = pst.executeQuery();
                if(rst.next()) {
                    String tglBerakhir = rst.getString("Tanggal_Berakhir");
                    LocalDate lastDate = LocalDate.parse(tglBerakhir);
                    LocalDate dateNow = LocalDate.now();
                    if(dateNow.getYear() > lastDate.getYear() || dateNow.getMonthValue() >= lastDate.getMonthValue() && dateNow.getDayOfMonth() > lastDate.getDayOfMonth()) {
                        strBesarVoucher = "Kode Voucher Tidak Berlaku";
                    } else {
                        strBesarVoucher = rst.getString("Besar_Voucher");
                    }
                } else {
                    strBesarVoucher = "Kode Voucher Tidak Berlaku";
                }
            } catch(Exception ex) {
                ex.printStackTrace();
            }
            return strBesarVoucher;
    }
}
