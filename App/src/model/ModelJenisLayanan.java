/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author usER
 */
public class ModelJenisLayanan {

    public ModelJenisLayanan(String idJenisLayanan, String namaJenis) {
        this.idJenisLayanan = idJenisLayanan;
        this.namaJenis = namaJenis;
    }

    public ModelJenisLayanan() {
    }

    private String idJenisLayanan;
    private String namaJenis;
    
    public String getIdJenisLayanan() {
        return idJenisLayanan;
    }

    public void setIdJenisLayanan(String idJenisLayanan) {
        this.idJenisLayanan = idJenisLayanan;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    public void setNamaJenis(String namaJenis) {
        this.namaJenis = namaJenis;
    }
}
