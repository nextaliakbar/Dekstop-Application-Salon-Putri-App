/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package report;

import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author usER
 */
public class ReportManager {
    private static ReportManager instance;
    private JasperReport struk;
    private JasperReport voucher;
    
    public static ReportManager getIntance() {
        if(instance == null) {
            instance = new ReportManager();
        }
        
        return instance;
    }
    
    public void compileReport() throws JRException {
        struk = JasperCompileManager.compileReport(getClass().getResourceAsStream("/design/StrukTransaksi.jrxml"));
        voucher = JasperCompileManager.compileReport(getClass().getResourceAsStream("/design/KartuVoucher.jrxml"));
    }
    
    public void printReport(ParamTransaksi data) throws JRException {
        Map paramater = new HashMap();
        paramater.put("tglJam", data.getTglJam());
        paramater.put("noTransaksi", data.getNoTransaksi());
        paramater.put("user", data.getUser());
        paramater.put("customer", data.getCustomer());
        paramater.put("total", data.getTotal());
        paramater.put("totalDiskon", data.getTotalDiskon());
        paramater.put("bayar", data.getBayar());
        paramater.put("kembali", data.getKembali());
        paramater.put("jenis", data.getJenis());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getFields());
        JasperPrint print = JasperFillManager.fillReport(struk, paramater, dataSource);
        viewReport(print);
    }
    
    public void printVoucher(ParamVoucher data) throws JRException{
        Map paramater = new HashMap();
        paramater.put("barcode", data.getBarcode());
        paramater.put("tglBerakhir", data.getTglBerakhir());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data.getFields());
        JasperPrint print = JasperFillManager.fillReport(voucher, paramater, dataSource);
        viewReport(print);
    }
    
    private void viewReport(JasperPrint print) {
        JasperViewer viewer = new JasperViewer(print, false);
        viewer.setVisible(true);
    }
}
