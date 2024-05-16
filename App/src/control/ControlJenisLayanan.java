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
/**
 *
 * @author usER
 */
public class ControlJenisLayanan {
    private Connection connection;

    public ControlJenisLayanan() {
        connection = Config.getConnection();
    }
    
    public List<ModelJenisLayanan> getData() {
        List<ModelJenisLayanan> modelJenis = new ArrayList<>();
        String query = "SELECT * FROM jenis_layanan";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                String idJenisLayanan = rst.getString("ID_Jenis_Layanan");
                String namaJenis = rst.getString("Nama_Layanan");
                modelJenis.add(new ModelJenisLayanan(idJenisLayanan, namaJenis));
            }
        } catch(Exception ex) {
           ex.printStackTrace();
        }
        return modelJenis;
    }
    
    public void addData(ModelJenisLayanan modelJenis) {
        String query = "INSERT INTO jenis_layanan (ID_Jenis_Layanan, Nama_Layanan) VALUES (?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelJenis.getIdJenisLayanan());
            pst.setString(2, modelJenis.getNamaJenis());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan Jenis Layanan Baru");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateData(ModelJenisLayanan modelJenis) {
        String query = "UPDATE jenis_layanan SET Nama_Layanan=? WHERE ID_Jenis_Layanan=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelJenis.getNamaJenis());
            pst.setString(2, modelJenis.getIdJenisLayanan());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Merubah Jenis Layanan");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteData(ModelJenisLayanan modelJenis) {
        String query = "DELETE FROM jenis_layanan WHERE ID_Jenis_Layanan=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelJenis.getIdJenisLayanan());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menghapus Jenis Layanan");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean validationDelete(ModelJenisLayanan modelJenis) {
        boolean valid = true;
        String query = "SELECT ID_Jenis_Layanan FROM layanan WHERE ID_Jenis_Layanan=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelJenis.getIdJenisLayanan());
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                if(modelJenis.getIdJenisLayanan().equals(rst.getString("ID_Jenis_Layanan"))) {
                    valid = false;
                    JOptionPane.showMessageDialog(null, "Tidak dapat menghapus jenis layanan ini\n"
                    + "Jenis layanan ini sedang digunakan pada\nmenu layanan", "Peringtan", JOptionPane.WARNING_MESSAGE);
                    break;
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return valid;
    }
    
    public String autoID() {
        String idJenisLayanan = null;
        String query = "SELECT RIGHT (ID_Jenis_Layanan, 3) AS Number FROM jenis_layanan ORDER BY ID_Jenis_Layanan DESC LIMIT 1";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            if(rst.next()) {
                int number = Integer.parseInt(rst.getString("Number"));
                number++;
                idJenisLayanan = "JNS-" + String.format("%03d", number);
            } else {
                idJenisLayanan = "JNS-001";
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return idJenisLayanan;
    }
}
