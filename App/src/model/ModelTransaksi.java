/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author usER
 */
public class ModelTransaksi {

    public ModelTransaksi(String noTransaksi, String tglTransaksi, double total, double bayar, double kembali, String jenisPembayaran, 
            ModelCustomer modelCustomer, ModelKaryawan modelKaryawan, ModelUser modelUser) {
        this.noTransaksi = noTransaksi;
        this.tglTransaksi = tglTransaksi;
        this.total = total;
        this.bayar = bayar;
        this.kembali = kembali;
        this.jenisPembayaran = jenisPembayaran;
        this.modelCustomer = modelCustomer;
        this.modelKaryawan = modelKaryawan;
        this.modelUser = modelUser;
    }


    public ModelTransaksi() {
    }
    
    private String noTransaksi;
    private String tglTransaksi;
    private double total;
    private double bayar;
    private double kembali;
    private String jenisPembayaran;
    private ModelCustomer modelCustomer;
    private ModelKaryawan modelKaryawan;
    private ModelUser modelUser;

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public void setNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
    }

    public String getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(String tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public double getBayar() {
        return bayar;
    }

    public void setBayar(double bayar) {
        this.bayar = bayar;
    }

    public double getKembali() {
        return kembali;
    }

    public void setKembali(double kembali) {
        this.kembali = kembali;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }

    public ModelCustomer getModelCustomer() {
        return modelCustomer;
    }

    public void setModelCustomer(ModelCustomer modelCustomer) {
        this.modelCustomer = modelCustomer;
    }

    public ModelKaryawan getModelKaryawan() {
        return modelKaryawan;
    }

    public void setModelKaryawan(ModelKaryawan modelKaryawan) {
        this.modelKaryawan = modelKaryawan;
    }

    public ModelUser getModelUser() {
        return modelUser;
    }

    public void setModelUser(ModelUser modelUser) {
        this.modelUser = modelUser;
    }
}
