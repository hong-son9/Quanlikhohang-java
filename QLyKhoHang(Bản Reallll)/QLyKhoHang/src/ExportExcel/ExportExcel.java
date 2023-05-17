/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExportExcel;

import java.io.File;
import java.io.FileOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author MRSTHAO
 */
public class ExportExcel {
    public static void exportExcel(JTable table){
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Save as");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILE", "xls","xlsx","xlsm");
        chooser.setFileFilter(fnef);
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                XSSFWorkbook excelFWorkbook = new XSSFWorkbook();
                XSSFSheet excelSheet = excelFWorkbook.createSheet("Phiếu Xuất Sheet");
                DefaultTableModel model = (DefaultTableModel) table.getModel();
                //set hearder for table;             
                XSSFRow excelRowHead = excelSheet.createRow(0);
                for(int column=0; column <model.getColumnCount(); column++){
                    XSSFCell excelCell = excelRowHead.createCell(column);
                    excelCell.setCellValue(model.getColumnName(column));
                    excelSheet.autoSizeColumn(column);
                }
                //set value of cell
                for(int j=0;j<model.getRowCount();j++){//row
                    XSSFRow excelRow = excelSheet.createRow(j+1);
                    for(int k = 0; k<model.getColumnCount() ;k++){//cell
                        XSSFCell excelCell = excelRow.createCell(k);
                        excelCell.setCellValue(model.getValueAt(j, k).toString());
                    }       
                }
                //fix column size
                for(int column=0; column <model.getColumnCount(); column++){
                    excelSheet.autoSizeColumn(column);
                }
                
                FileOutputStream fileExcel = new FileOutputStream(file +".xlsx");
                excelFWorkbook.write(fileExcel);
                fileExcel.close();
                excelFWorkbook.close();
                
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");

            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Lỗi, lưu file ko thành công!");

            }
        }
    }
}
