package controlador;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import conexion.Conexion;

import javax.swing.JOptionPane;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;

public class ReportesController {

    public void TicketRetiro(int idVehiculo) throws SQLException {
        Document documento = new Document();
        try {
            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Ticket Parqueadero.pdf"));

            Image header = Image.getInstance("src/img/estacionamiento.png");
            header.scaleToFit(100, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            Connection cn = (Connection) Conexion.conectar();
            PreparedStatement pst = (PreparedStatement) cn.prepareStatement(
                "select * from tb_vehiculo where id_vehiculo = '" + idVehiculo + "';");
            ResultSet rs = (ResultSet) pst.executeQuery();

            if (rs.next()) {
                Paragraph parrafo = new Paragraph();
                parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                parrafo.add("Sistema de parqueadero \n grupo 9 \n\n");
                parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
                parrafo.add("____________________\n\n");

                java.sql.Timestamp timestampSalida = rs.getTimestamp("hora_salida"); // Corrección aquí
                Date fecha = new Date(timestampSalida.getTime());
                parrafo.add("Ticket de retiro de " + rs.getString("tipo_vehiculo") + "- (Placa:" + rs.getString("placa") + ")\n\n");
                parrafo.add(fecha + "\n");
                parrafo.add("____________________\n\n");

                Paragraph contenido = new Paragraph();
                contenido.setAlignment(Paragraph.ALIGN_CENTER);
                contenido.add("Propietario: " + rs.getString("propietario") + "\n");

                java.sql.Timestamp timestampEntrada = rs.getTimestamp("hora_entrada");
                Time horaEntrada = new Time(timestampEntrada.getTime());
                contenido.add("Entrada: " + horaEntrada + "\n");

                Time horaSalida = new Time(timestampSalida.getTime());
                contenido.add("Salida: " + horaSalida + "\n");

                contenido.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.RED));
                contenido.add("\nValor Pagado: " + rs.getString("valor_pagado") + "\n");
                contenido.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
                parrafo.add(" _\n\n");

                documento.open();
                documento.add(header);
                documento.add(parrafo);
                documento.add(contenido);
            }

            documento.close();
            JOptionPane.showMessageDialog(null, "Ticket creado");
        } catch (DocumentException e) {
            System.out.println("ERROR 2 EN " + e);
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR 3 EN " + ex);
        } catch (IOException ex) {
            System.out.println("ERROR 4 EN : " + ex);
        }
    }
}
