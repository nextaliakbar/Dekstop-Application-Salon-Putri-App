/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import main.Main;
import model.ModelUser;
/**
 *
 * @author usER
 */
public class ControlLogin {
    private Connection connection;
    
    public ControlLogin() {
        connection = Config.getConnection();
    }
    
    public void login(ModelUser user, JFrame frame) {
        String query = "SELECT ID_User, Nama_User, Level, Status FROM user WHERE "
                + "Username='"+user.getUsername()+"' AND Password='"+user.getPassword()+"' ";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            if(rst.next()) {
                String idUser = rst.getString("ID_User");
                String namaUser = rst.getString("Nama_User");
                String level = rst.getString("Level");
                String status = rst.getString("Status");
                if(status.equals("Aktif")) {
                    ModelUser modelUser = new ModelUser(idUser, namaUser, "", "", level, status);
                    Main main = new Main(modelUser);
                    main.setVisible(true);
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "User ini sudah tidak aktif");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah");
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean  cekIdUser(String txtIdUser) {
        boolean check = true;
        String query = "SELECT ID_User FROM user WHERE Status='Aktif'";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            ResultSet rst = pst.executeQuery();
            while(rst.next()) {
                if(txtIdUser.equals(rst.getString("ID_User"))) {
                   check = false; 
                }
            }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return check;
    }
    
    public void changePassword(ModelUser modelUser) {
        String query = "UPDATE user SET Password=? WHERE ID_User=?";
        try {
            PreparedStatement pst = connection.prepareStatement(query);
            pst.setString(1, modelUser.getPassword());
            pst.setString(2, modelUser.getIdUser());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Password berhasil di ubah");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
