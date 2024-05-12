/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;

import java.util.List;

/**
 *
 * @author usER
 */
public class ParamTransaksi {

    public ParamTransaksi(String tglJam, String noTransaksi, String user, String customer, 
    String total, String totalDiskon, String bayar, String kembali, String jenis, List<FieldTransaksi> fields) {
        this.tglJam = tglJam;
        this.noTransaksi = noTransaksi;
        this.user = user;
        this.customer = customer;
        this.total = total;
        this.totalDiskon = totalDiskon;
        this.bayar = bayar;
        this.kembali = kembali;
        this.jenis = jenis;
        this.fields = fields;
    }

    
    
    public ParamTransaksi() {
    }
    
    private String tglJam;
    private String noTransaksi;
    private String user;
    private String customer;
    private String total;
    private String totalDiskon;
    private String bayar;
    private String kembali;
    private String jenis;
    private List<FieldTransaksi> fields;    

    public String getTglJam() {
        return tglJam;
    }

    public String getNoTransaksi() {
        return noTransaksi;
    }

    public String getUser() {
        return user;
    }

    public String getCustomer() {
        return customer;
    }

    public String getTotal() {
        return total;
    }

    public String getTotalDiskon() {
        return totalDiskon;
    }

    public String getBayar() {
        return bayar;
    }

    public String getKembali() {
        return kembali;
    }

    public String getJenis() {
        return jenis;
    }

    public List<FieldTransaksi> getFields() {
        return fields;
    }
    
}
