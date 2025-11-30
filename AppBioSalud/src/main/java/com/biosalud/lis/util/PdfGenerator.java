/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biosalud.lis.util;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;


public class PdfGenerator {
     public void exportarPDFDosTablas(JTable tabla1, JTable tabla2) throws IOException, DocumentException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos PDF", "pdf");
        chooser.setFileFilter(filter);
        chooser.setDialogTitle("Guardar archivo PDF");

        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String ruta = chooser.getSelectedFile().toString().concat(".pdf");
            File archivoPDF = new File(ruta);
            if (archivoPDF.exists()) {
                archivoPDF.delete();
            }

            Document document = new Document(PageSize.A4, 36, 36, 36, 36);
            PdfWriter.getInstance(document, new FileOutputStream(archivoPDF));
            document.open();

            Font tituloFont = new Font(Font.HELVETICA, 16, Font.BOLD);
            Paragraph titulo = new Paragraph("Reporte de Laboratorio", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            titulo.setSpacingAfter(20);
            document.add(titulo);

            // Tabla 1
            document.add(new Paragraph("TablaReportes", new Font(Font.HELVETICA, 12, Font.BOLD)));
            document.add(crearTablaPDF(tabla1));
            document.add(Chunk.NEWLINE);

            // Tabla 2
            document.add(new Paragraph("TablaReportes2", new Font(Font.HELVETICA, 12, Font.BOLD)));
            document.add(crearTablaPDF(tabla2));

            document.close();

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(archivoPDF);
            }
        }
    }

    private PdfPTable crearTablaPDF(JTable tabla) {
        PdfPTable pdfTable = new PdfPTable(tabla.getColumnCount());
        pdfTable.setWidthPercentage(100);

        // Encabezados
        Font headerFont = new Font(Font.HELVETICA, 12, Font.BOLD);
        for (int c = 0; c < tabla.getColumnCount(); c++) {
            PdfPCell celda = new PdfPCell(new Phrase(tabla.getColumnName(c), headerFont));
            celda.setHorizontalAlignment(Element.ALIGN_CENTER);
            celda.setBackgroundColor(Color.LIGHT_GRAY); // Cambiado a java.awt.Color
            pdfTable.addCell(celda);
        }

        // Datos
        Font dataFont = new Font(Font.HELVETICA, 11);
        for (int f = 0; f < tabla.getRowCount(); f++) {
            for (int c = 0; c < tabla.getColumnCount(); c++) {
                Object valor = tabla.getValueAt(f, c);
                PdfPCell celda = new PdfPCell(new Phrase(valor != null ? valor.toString() : "", dataFont));
                celda.setHorizontalAlignment(valor instanceof Number ? Element.ALIGN_RIGHT : Element.ALIGN_LEFT);
                pdfTable.addCell(celda);
            }
        }
        return pdfTable;
    }
    
}
