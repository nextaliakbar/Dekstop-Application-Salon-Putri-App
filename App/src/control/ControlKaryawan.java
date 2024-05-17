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
import model.ModelKaryawan;
/**
 *
 * @author usER
 */
public class ControlKaryawan {
    private Connection connection;

    public ControlKaryawan() {
        connection = Config.getConnection();
    }
    
    public List<ModelKaryawan> getData() {
        List<ModelKaryawan> karyawan = new ArrayList<>();
        String query = "SELECT * FROM karyawan";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                String idKaryawan = rst.getString("ID_Karyawan");
                String namaKaryawan = rst.getString("Nama_Karyawan");
                String noTelp = rst.getString("No_Telp");
                String alamat = rst.getString("Alamat");
                String posisi = rst.getString("Posisi");
                String status = rst.getString("Status");
                karyawan.add(new ModelKaryawan(idKaryawan, namaKaryawan, noTelp, alamat, posisi, status));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            
        return karyawan;
    }
    
    public void addData(ModelKaryawan modelKaryawan) {
        String query = "INSERT INTO karyawan (ID_Karyawan, Nama_Karyawan, No_Telp, Alamat, Posisi, Status) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelKaryawan.getIdKaryawan());
            pst.setString(2, modelKaryawan.getNamaKaryawan());
            pst.setString(3, modelKaryawan.getNoTelp());
            pst.setString(4, modelKaryawan.getAlamat());
            pst.setString(5, modelKaryawan.getPosisi());
            pst.setString(6, modelKaryawan.getStatus());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan Karyawan Baru");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateData(ModelKaryawan modelKaryawan) {
        String query = "UPDATE karyawan SET Nama_Karyawan=?, No_Telp=?, Alamat=?, Posisi=?, Status=? WHERE ID_Karyawan=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelKaryawan.getNamaKaryawan());
            pst.setString(2, modelKaryawan.getNoTelp());
            pst.setString(3, modelKaryawan.getAlamat());
            pst.setString(4, modelKaryawan.getPosisi());
            pst.setString(5, modelKaryawan.getStatus());
            pst.setString(6, modelKaryawan.getIdKaryawan());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Merubah Data Karyawan");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteData(ModelKaryawan modelKaryawan) {
        String query = "DELETE FROM karyawan WHERE ID_Karyawan=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelKaryawan.getIdKaryawan());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menghapus Karyawan");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean validationDelete(ModelKaryawan modelKaryawan) {
        boolean valid = true;
        String query = "SELECT ID_Karyawan FROM transaksi WHERE ID_Karyawan=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelKaryawan.getIdKaryawan());
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                if(modelKaryawan.getIdKaryawan().equals(rst.getString("ID_Karyawan"))) {
                    valid = false;
                    JOptionPane.showMessageDialog(null, "Tidak dapat menghapus karyawan ini\n"
                    + "Karyawan ini pernah melakukan\ntransaksi", "Peringtan", JOptionPane.WARNING_MESSAGE);
                    break;
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return valid;
    }
    
    public String autoID() {
        String idCustomer = null;
        String query = "SELECT RIGHT (ID_Karyawan, 3) AS Number FROM karyawan ORDER BY ID_Karyawan DESC LIMIT 1";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            if(rst.next()) {
                int number = Integer.parseInt(rst.getString("Number"));
                number++;
                idCustomer = "KRYWN-" + String.format("%03d", number);
            } else {
                idCustomer = "KRYWN-001";
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return idCustomer;
    }
}
