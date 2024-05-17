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
import model.ModelUser;
/**
 *
 * @author usER
 */
public class ControlUser {
    private Connection connection;

    public ControlUser() {
        connection = Config.getConnection();
    }
    
    public List<ModelUser> getData() {
        List<ModelUser> user = new ArrayList<>();
        String query = "SELECT ID_User, Nama_User, Username, Level, Status FROM user";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                String idUser = rst.getString("ID_User");
                String namaUser = rst.getString("Nama_User");
                String username = rst.getString("Username");
                String level = rst.getString("Level");
                String status = rst.getString("Status");
                user.add(new ModelUser(idUser, namaUser, username, "", level, status));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            
        return user;
    }
    
    public void addData(ModelUser modelUser) {
        String query = "INSERT INTO user (ID_User, Nama_User, Username, Password, Level, Status) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelUser.getIdUser());
            pst.setString(2, modelUser.getNamaUser());
            pst.setString(3, modelUser.getUsername());
            pst.setString(4, modelUser.getPassword());
            pst.setString(5, modelUser.getLevel());
            pst.setString(6, modelUser.getStatus());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan User Baru");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateData(ModelUser modelUser) {
        String query = "UPDATE user SET Nama_User=?, Username=?, Level=?, Status=? WHERE ID_User=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelUser.getNamaUser());
            pst.setString(2, modelUser.getUsername());
            pst.setString(3, modelUser.getLevel());
            pst.setString(4, modelUser.getStatus());
            pst.setString(5, modelUser.getIdUser());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Merubah Data User");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteData(ModelUser modelUser) {
        String query = "DELETE FROM user WHERE ID_User=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelUser.getIdUser());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menghapus User");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean validationDelete(ModelUser modelUser) {
        boolean valid = true;
        String query = "SELECT ID_User FROM transaksi WHERE ID_User=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelUser.getIdUser());
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                if(modelUser.getIdUser().equals(rst.getString("ID_User"))) {
                    valid = false;
                    JOptionPane.showMessageDialog(null, "Tidak dapat menghapus user ini\n"
                    + "User ini pernah melakukan\ntransaksi", "Peringtan", JOptionPane.WARNING_MESSAGE);
                    break;
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return valid;
    }
    
    public String autoID() {
        String idUser = null;
        String query = "SELECT RIGHT (ID_User, 3) AS Number FROM user ORDER BY ID_User DESC LIMIT 1";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            if(rst.next()) {
                int number = Integer.parseInt(rst.getString("Number"));
                number++;
                idUser = "USER-" + String.format("%03d", number);
            } else {
                idUser = "USER-001";
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return idUser;
    }
}
