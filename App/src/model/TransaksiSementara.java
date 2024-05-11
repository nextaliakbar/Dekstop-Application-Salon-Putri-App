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

    public TransaksiSementara(String[] idLayanan, double[] diskon, double[] subototal) {
        this.idLayanan = idLayanan;
        this.diskon = diskon;
        this.subototal = subototal;
    }

    public TransaksiSementara() {
    }
    
    private String[] idLayanan;
    private double[] diskon;
    private double[] subototal;

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
}
