/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author usER
 */
public class TransaksiSementara {

    public TransaksiSementara(String[] idLayanan, double[] diskon, double[] subototal, String[] kodeVoucher) {
        this.idLayanan = idLayanan;
        this.diskon = diskon;
        this.subototal = subototal;
        this.kodeVoucher = kodeVoucher;
    }

    public TransaksiSementara() {
    }
    
    private String[] idLayanan;
    private double[] diskon;
    private double[] subototal;
    private String[] kodeVoucher;

    public String[] getIdLayanan() {
        return idLayanan;
    }

    public void setIdLayanan(String[] idLayanan) {
        this.idLayanan = idLayanan;
    }
    
    public double[] getDiskon() {
        return diskon;
    }

    public void setDiskon(double[] diskon) {
        this.diskon = diskon;
    }

    public double[] getSubototal() {
        return subototal;
    }

    public void setSubototal(double[] subototal) {
        this.subototal = subototal;
    }
    
        public String[] getKodeVoucher() {
        return kodeVoucher;
    }

    public void setKodeVoucher(String[] kodeVoucher) {
        this.kodeVoucher = kodeVoucher;
    }
}
