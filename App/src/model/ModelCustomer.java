/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author usER
 */
public class ModelCustomer {

    public ModelCustomer(String idCustomer, String namaCustomer, String noTelp, String alamat) {
        this.idCustomer = idCustomer;
        this.namaCustomer = namaCustomer;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }

    public ModelCustomer() {
    }
    
    private String idCustomer;
    private String namaCustomer;
    private String noTelp;
    private String alamat;

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNamaCustomer() {
        return namaCustomer;
    }

    public void setNamaCustomer(String namaCustomer) {
        this.namaCustomer = namaCustomer;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
