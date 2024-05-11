/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import model.ModelDetailTransaksi;
import model.TransaksiSementara;

public class ControlDetailTransaksi {
    private Connection connection;
    
    public ControlDetailTransaksi() {
        connection = Config.getConnection();
    }
    
    public List<ModelDetailTransaksi> getDataDetail() {
        return null;
    }
    
    public void addDataDetail(ModelDetailTransaksi modelDetail, TransaksiSementara ts) {
        String query = "INSERT INTO detail_transaksi (No_Transaksi, ID_Layanan, Diskon, Subtotal_Transaksi) VALUES (?,?,?,?)";
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
            
            pst.executeUpdate();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
