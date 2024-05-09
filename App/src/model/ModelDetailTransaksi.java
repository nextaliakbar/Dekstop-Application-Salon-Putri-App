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

    public ModelDetailTransaksi(ModelTransaksi modelTransaksi, ModelLayanan modelLayanan, double subtotal) {
        this.modelTransaksi = modelTransaksi;
        this.modelLayanan = modelLayanan;
        this.subtotal = subtotal;
    }

    public ModelDetailTransaksi() {
    }
    
    private ModelTransaksi modelTransaksi;
    private ModelLayanan modelLayanan;
    private double subtotal;

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

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
