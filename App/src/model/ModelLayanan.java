/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author usER
 */
public class ModelLayanan {

    public ModelLayanan(String idLayanan, String tipeLayanan, double harga, ModelJenisLayanan modelJenisLayanan) {
        this.idLayanan = idLayanan;
        this.tipeLayanan = tipeLayanan;
        this.harga = harga;
        this.modelJenisLayanan = modelJenisLayanan;
    }
    
    public ModelLayanan() {
    }
    
    private String idLayanan;
    private String tipeLayanan;
    private double harga;
    private ModelJenisLayanan modelJenisLayanan;

    public String getIdLayanan() {
        return idLayanan;
    }

    public void setIdLayanan(String idLayanan) {
        this.idLayanan = idLayanan;
    }

    public String getTipeLayanan() {
        return tipeLayanan;
    }

    public void setTipeLayanan(String tipeLayanan) {
        this.tipeLayanan = tipeLayanan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }
    
    public ModelJenisLayanan getModelJenisLayanan() {
        return modelJenisLayanan;
    }

    public void setModelJenisLayanan(ModelJenisLayanan modelJenisLayanan) {
        this.modelJenisLayanan = modelJenisLayanan;
    }
}
