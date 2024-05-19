/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author usER
 */
public class ModelVoucher {

    public ModelVoucher(String kodeVoucher, String tglPembuatan, String tglBerakhir, int besarVoucher, String status) {
        this.kodeVoucher = kodeVoucher;
        this.tglPembuatan = tglPembuatan;
        this.tglBerakhir = tglBerakhir;
        this.besarVoucher = besarVoucher;
        this.status = status;
    }

    public ModelVoucher() {
    }
        
    private String kodeVoucher;
    private String tglPembuatan;
    private String tglBerakhir;
    private int besarVoucher;
    private String status;

    public String getKodeVoucher() {
        return kodeVoucher;
    }

    public void setKodeVoucher(String kodeVoucher) {
        this.kodeVoucher = kodeVoucher;
    }

    public String getTglPembuatan() {
        return tglPembuatan;
    }

    public void setTglPembuatan(String tglPembuatan) {
        this.tglPembuatan = tglPembuatan;
    }

    public String getTglBerakhir() {
        return tglBerakhir;
    }

    public void setTglBerakhir(String tglBerakhir) {
        this.tglBerakhir = tglBerakhir;
    }

    public int getBesarVoucher() {
        return besarVoucher;
    }

    public void setBesarVoucher(int besarVoucher) {
        this.besarVoucher = besarVoucher;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
