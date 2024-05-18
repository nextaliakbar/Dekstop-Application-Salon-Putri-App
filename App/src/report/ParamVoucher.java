/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;

import java.io.InputStream;
import java.util.List;

/**
 *
 * @author usER
 */
public class ParamVoucher {

    public ParamVoucher(InputStream barcode, String tglBerakhir, List<FieldVoucher> fields) {
        this.barcode = barcode;
        this.tglBerakhir = tglBerakhir;
        this.fields = fields;
    }
 
    private InputStream barcode;
    private String tglBerakhir;
    private List<FieldVoucher> fields;

    public String getTglBerakhir() {
        return tglBerakhir;
    }

    public InputStream getBarcode() {
        return barcode;
    }

    public List<FieldVoucher> getFields() {
        return fields;
    }
}
