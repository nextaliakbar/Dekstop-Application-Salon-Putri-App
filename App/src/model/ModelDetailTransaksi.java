/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author usER
 */
public class ModelDetailTransaksi {

    public ModelDetailTransaksi(ModelTransaksi modelTransaksi, ModelLayanan modelLayanan, double diskon, double subtotal, ModelVoucher modelVoucher) {
        this.modelTransaksi = modelTransaksi;
        this.modelLayanan = modelLayanan;
        this.diskon = diskon;
        this.subtotal = subtotal;
        this.modelVoucher = modelVoucher;
    }

    public ModelDetailTransaksi() {
    }
    
    private ModelTransaksi modelTransaksi;
    private ModelLayanan modelLayanan;
    private double diskon;
    private double subtotal;
    private ModelVoucher modelVoucher;

    public ModelTransaksi getModelTransaksi() {
        return modelTransaksi;
    }

    public void setModelTransaksi(ModelTransaksi modelTransaksi) {
        this.modelTransaksi = modelTransaksi;
    }

    public ModelLayanan getModelLayanan() {
        return modelLayanan;
    }

    public void setModelLayanan(ModelLayanan modelLayanan) {
        this.modelLayanan = modelLayanan;
    }
    
    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double diskon) {
        this.diskon = diskon;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    public ModelVoucher getModelVoucher() {
        return modelVoucher;
    }

    public void setModelVoucher(ModelVoucher modelVoucher) {
        this.modelVoucher = modelVoucher;
    }
    
    public Object[] toRowTable() {
        return new Object[]{this, modelLayanan.getIdLayanan(), modelLayanan.getTipeLayanan(), modelLayanan.getHarga(), diskon, modelVoucher.getKodeVoucher() ,subtotal};
    }
}
