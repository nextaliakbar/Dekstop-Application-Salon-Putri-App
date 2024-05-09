/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author usER
 */
public class ModelKaryawan {

    public ModelKaryawan(String idKaryawan, String namaKaryawan, String noTelp, String alamat, String posisi, String status) {
        this.idKaryawan = idKaryawan;
        this.namaKaryawan = namaKaryawan;
        this.noTelp = noTelp;
        this.alamat = alamat;
        this.posisi = posisi;
        this.status = status;
    }

    public ModelKaryawan() {
    }
    
    private String idKaryawan;
    private String namaKaryawan;
    private String noTelp;
    private String alamat;
    private String posisi;
    private String status;

    public String getIdKaryawan() {
        return idKaryawan;
    }

    public void setIdKaryawan(String idKaryawan) {
        this.idKaryawan = idKaryawan;
    }

    public String getNamaKaryawan() {
        return namaKaryawan;
    }

    public void setNamaKaryawan(String namaKaryawan) {
        this.namaKaryawan = namaKaryawan;
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

    public String getPosisi() {
        return posisi;
    }

    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
