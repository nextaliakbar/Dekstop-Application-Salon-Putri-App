/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;

/**
 *
 * @author usER
 */
public class FieldTransaksi {

    public FieldTransaksi(String layanan, double harga, double diskon, double subtotal) {
        this.layanan = layanan;
        this.harga = harga;
        this.diskon = diskon;
        this.subtotal = subtotal;
    }

    public FieldTransaksi() {
    }
        
    private String layanan;
    private double harga;
    private double diskon;
    private double subtotal;

    public String getLayanan() {
        return layanan;
    }

    public double getHarga() {
        return harga;
    }

    public double getDiskon() {
        return diskon;
    }

    public double getSubtotal() {
        return subtotal;
    }
}
