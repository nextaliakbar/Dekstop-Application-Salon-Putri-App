/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelJenisLayanan;
import model.ModelLayanan;
/**
 *
 * @author usER
 */
public class ControlLayanan {
    private Connection connection;
    public ControlLayanan() {
        connection = Config.getConnection();
    }
    
    public List<ModelLayanan> getData() {
        List<ModelLayanan> layanan = new ArrayList<>();
        String query = "SELECT lyn.ID_Layanan, jns.Nama_Layanan, lyn.Tipe_Layanan, lyn.Harga, lyn.ID_Jenis_Layanan FROM layanan lyn "
                + "INNER JOIN jenis_layanan jns ON lyn.ID_Jenis_Layanan=jns.ID_Jenis_Layanan";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                String idLayanan = rst.getString("ID_Layanan");
                String namaLayanan = rst.getString("Nama_Layanan");
                String tipeLayanan = rst.getString("Tipe_Layanan");
                double harga = rst.getDouble("Harga");
                String idJenisLayanan = rst.getString("ID_Jenis_Layanan");
                ModelJenisLayanan modelJenisLayanan = new ModelJenisLayanan(idJenisLayanan, namaLayanan);
                ModelLayanan modelLayanan = new ModelLayanan(idLayanan, tipeLayanan, harga, modelJenisLayanan);
                layanan.add(modelLayanan);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            
        return layanan;
    }
    
    public void addData(ModelLayanan modelLayanan) {
        String query = "INSERT INTO layanan (ID_Layanan, Tipe_Layanan, Harga, ID_Jenis_Layanan) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelLayanan.getIdLayanan());
            pst.setString(2, modelLayanan.getTipeLayanan());
            pst.setDouble(3, modelLayanan.getHarga());
            pst.setString(4, modelLayanan.getModelJenisLayanan().getIdJenisLayanan());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan Layanan Baru");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateData(ModelLayanan modelLayanan) {
        String query = "UPDATE layanan SET Tipe_Layanan=?, Harga=?, ID_Jenis_Layanan=? WHERE ID_Layanan=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelLayanan.getTipeLayanan());
            pst.setDouble(2, modelLayanan.getHarga());
            pst.setString(3, modelLayanan.getModelJenisLayanan().getIdJenisLayanan());
            pst.setString(4, modelLayanan.getIdLayanan());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Merubah Layanan");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteData(ModelLayanan modelLayanan) {
        String query = "DELETE FROM layanan WHERE ID_Layanan=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelLayanan.getIdLayanan());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menghapus Layanan");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean validationDelete(ModelLayanan modelLayanan) {
        boolean valid = true;
        String query = "SELECT ID_Layanan FROM detail_transaksi WHERE ID_Layanan=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelLayanan.getIdLayanan());
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                if(modelLayanan.getIdLayanan().equals(rst.getString("ID_Layanan"))) {
                    valid = false;
                    JOptionPane.showMessageDialog(null, "Tidak dapat menghapus layanan ini\n"
                    + "Layanan ini sedang digunakan pada\nmenu transaksi", "Peringtan", JOptionPane.WARNING_MESSAGE);
                    break;
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return valid;
    }
    
    public String autoID() {
        String idLayanan = null;
        String query = "SELECT RIGHT (ID_Layanan, 3) AS Number FROM layanan ORDER BY ID_Layanan DESC LIMIT 1";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            if(rst.next()) {
                int number = Integer.parseInt(rst.getString("Number"));
                number++;
                idLayanan = "LYN-" + String.format("%03d", number);
            } else {
                idLayanan = "LYN-001";
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return idLayanan;
    }
}
