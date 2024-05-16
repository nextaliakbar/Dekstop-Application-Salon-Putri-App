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
import model.ModelCustomer;
/**
 *
 * @author usER
 */
public class ControlCustomer {
    private Connection connection;

    public ControlCustomer() {
        connection = Config.getConnection();
    }
    
    public List<ModelCustomer> getData() {
        List<ModelCustomer> customer = new ArrayList<>();
        String query = "SELECT * FROM customer";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                String idCustomer = rst.getString("ID_Customer");
                String namaCustomer = rst.getString("Nama_Customer");
                String noTelp = rst.getString("No_Telp");
                String alamat = rst.getString("Alamat");
                customer.add(new ModelCustomer(idCustomer, namaCustomer, noTelp, alamat));
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
            
        return customer;
    }
    
    public void addData(ModelCustomer modelCustomer) {
        String query = "INSERT INTO customer (ID_Customer, Nama_Customer, No_Telp, Alamat) VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelCustomer.getIdCustomer());
            pst.setString(2, modelCustomer.getNamaCustomer());
            pst.setString(3, modelCustomer.getNoTelp());
            pst.setString(4, modelCustomer.getAlamat());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menambahkan Customer Baru");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateData(ModelCustomer modelCustomer) {
        String query = "UPDATE customer SET Nama_Customer=?, No_Telp=?, Alamat=? WHERE ID_Customer=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelCustomer.getNamaCustomer());
            pst.setString(2, modelCustomer.getNoTelp());
            pst.setString(3, modelCustomer.getAlamat());
            pst.setString(4, modelCustomer.getIdCustomer());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Merubah Data Customer");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteData(ModelCustomer modelCustomer) {
        String query = "DELETE FROM customer WHERE ID_Customer=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelCustomer.getIdCustomer());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Menghapus Customer");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean validationDelete(ModelCustomer modelCustomer) {
        boolean valid = true;
        String query = "SELECT ID_Customer FROM transaksi WHERE ID_Customer=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelCustomer.getIdCustomer());
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                if(modelCustomer.getIdCustomer().equals(rst.getString("ID_Customer"))) {
                    valid = false;
                    JOptionPane.showMessageDialog(null, "Tidak dapat menghapus customer ini\n"
                    + "Customer ini pernah melakukan\ntransaksi", "Peringtan", JOptionPane.WARNING_MESSAGE);
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
        String query = "SELECT RIGHT (ID_Customer, 3) AS Number FROM customer ORDER BY ID_Customer DESC LIMIT 1";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            if(rst.next()) {
                int number = Integer.parseInt(rst.getString("Number"));
                number++;
                idCustomer = "CSTMR-" + String.format("%03d", number);
            } else {
                idCustomer = "CSTMR-001";
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        return idCustomer;
    }
}
