/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.util;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author folli
 */
public class ExcelGenerator {
        public void exportarExcelDosTablas(JTable tabla1, JTable tabla2) throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos Excel", "xls");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo Excel");

        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".xls");
            File archivoXLS = new File(ruta);
            if (archivoXLS.exists()) {
                archivoXLS.delete();
            }

            try (Workbook libro = new HSSFWorkbook(); FileOutputStream archivo = new FileOutputStream(archivoXLS)) {

                Sheet hoja1 = libro.createSheet("TablaReportes");
                Sheet hoja2 = libro.createSheet("TablaReportes2");

                crearHojaDesdeTabla(hoja1, tabla1);
                crearHojaDesdeTabla(hoja2, tabla2);

                libro.write(archivo);
            }

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(archivoXLS);
            }
        }
    }

    private void crearHojaDesdeTabla(Sheet hoja, JTable tabla) {
        // Encabezados
        Row filaEncabezado = hoja.createRow(0);
        for (int c = 0; c < tabla.getColumnCount(); c++) {
            Cell celda = filaEncabezado.createCell(c);
            celda.setCellValue(tabla.getColumnName(c));
        }

        // Datos
        for (int f = 0; f < tabla.getRowCount(); f++) {
            Row fila = hoja.createRow(f + 1);
            for (int c = 0; c < tabla.getColumnCount(); c++) {
                Cell celda = fila.createCell(c);
                Object valor = tabla.getValueAt(f, c);
                if (valor instanceof Number) {
                    celda.setCellValue(((Number) valor).doubleValue());
                } else {
                    celda.setCellValue(valor != null ? valor.toString() : "");
                }
            }
        }
    }
    
}
