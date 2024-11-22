/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Angel
 */
public class ControladorReportes {
    
public void BuscarFacturaMostrarDatosCliente(JTextField numeroFactura, JLabel numeroFacturaEncontrado, JLabel fechaFacturaEncontrado,
                                             JLabel nombresCliente, JLabel apellidosCliente) {
    
    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();

    try {
        String consulta = "SELECT factura.idfactura, factura.fechafactura, cliente.nombres, cliente.apellidos FROM factura " +
                          "INNER JOIN cliente ON cliente.idcliente = factura.fkcliente WHERE factura.idfactura = ?";
        
        PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);
        ps.setInt(1, Integer.parseInt(numeroFactura.getText()));
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            numeroFacturaEncontrado.setText(String.valueOf(rs.getInt("idfactura")));
            fechaFacturaEncontrado.setText(rs.getDate("fechafactura").toString());
            nombresCliente.setText(rs.getString("nombres"));
            apellidosCliente.setText(rs.getString("apellidos"));
        } else {
            numeroFacturaEncontrado.setText("");
            fechaFacturaEncontrado.setText("");
            nombresCliente.setText("");
            apellidosCliente.setText("");
            
            JOptionPane.showMessageDialog(null, "No se encontró la factura");
        }
        
        rs.close();
        ps.close();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al buscar la factura: " + e.toString());
    } finally {
        objetoConexion.cerrarConexion();
    }
}


public void configurarEstiloTabla(JTable tablaTotal) {
    // Configuración del estilo de la cabecera de la tabla
    JTableHeader cabecera = tablaTotal.getTableHeader();
    cabecera.setFont(new Font("Arial", Font.BOLD, 14));          // Tipo de letra Arial Bold, tamaño 14
    cabecera.setForeground(Color.decode("#1a3e59"));             // Color de texto (#1a3e59)
    cabecera.setBackground(Color.decode("#d9e5f2"));             // Fondo de la cabecera (#d9e5f2)
    
    // Configurar el estilo para las celdas de la tabla
    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
    cellRenderer.setFont(new Font("Arial", Font.PLAIN, 12));       // Tipo de letra Arial, tamaño 12
    cellRenderer.setForeground(Color.decode("#1a3e59"));           // Color del texto
    cellRenderer.setBackground(Color.WHITE);                       // Fondo blanco para las celdas

    // Aplicar el renderizador a todas las columnas de la tabla
    for (int i = 0; i < tablaTotal.getColumnCount(); i++) {
        tablaTotal.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
    }
}


public void BuscarFacturaMostrarDatos(JTextField numeroFactura, JTable tablaDatos, JLabel total) {
    
    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    DefaultTableModel modelo = new DefaultTableModel();
    
    // Definir las columnas de la tabla
    modelo.addColumn("TIPO");
    modelo.addColumn("NOMBRE");
    modelo.addColumn("PRECIOVENTA");
    modelo.addColumn("CANTIDAD");
    modelo.addColumn("SUBTOTAL");

    tablaDatos.setModel(modelo);
    double totalFactura = 0.0;

     // Ajustar el tamaño de las columnas
    tablaDatos.getColumnModel().getColumn(0).setPreferredWidth(60); // TIPO
    tablaDatos.getColumnModel().getColumn(1).setPreferredWidth(200); // NOMBRE
    tablaDatos.getColumnModel().getColumn(2).setPreferredWidth(100); // PRECIOVENTA
    tablaDatos.getColumnModel().getColumn(3).setPreferredWidth(40);  // CANTIDAD
    tablaDatos.getColumnModel().getColumn(4).setPreferredWidth(100); // SUBTOTAL
    
    // Formato para mostrar valores con dos decimales
      DecimalFormat formato = new DecimalFormat("#,##0.00");

    try {
        // Validación del número de factura
        if (numeroFactura.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Número de factura vacío. Por favor, ingrese un número de factura.");
            return;
        }

        int numFactura = Integer.parseInt(numeroFactura.getText());
        String consulta = "SELECT detalle.tipo, detalle.id_item, detalle.cantidad, detalle.precioVenta, detalle.cantidad * detalle.precioVenta AS subtotal " +
                          "FROM detalle WHERE detalle.fkfactura = ?";
        
        PreparedStatement psDetalle = objetoConexion.estableceConexion().prepareStatement(consulta);
        psDetalle.setInt(1, numFactura);
        
        ResultSet rsDetalle = psDetalle.executeQuery();
        
        // Revisión del ResultSet
        if (!rsDetalle.isBeforeFirst()) {
            JOptionPane.showMessageDialog(null, "No se encontraron datos para la factura ingresada.");
            return;
        }

        while (rsDetalle.next()) {
            String tipo = rsDetalle.getString("tipo");
            int idItem = rsDetalle.getInt("id_item");
            int cantidad = rsDetalle.getInt("cantidad");
            double precioVenta = rsDetalle.getDouble("precioVenta");
            double subtotal = rsDetalle.getDouble("subtotal");
            String nombre = "";

            // Consultar la tabla correspondiente según el tipo
            if (tipo.equalsIgnoreCase("Producto")) {
                String consultaProducto = "SELECT nombre FROM producto WHERE idproducto = ?";
                PreparedStatement psProducto = objetoConexion.estableceConexion().prepareStatement(consultaProducto);
                psProducto.setInt(1, idItem);
                
                ResultSet rsProducto = psProducto.executeQuery();
                if (rsProducto.next()) {
                    nombre = rsProducto.getString("nombre");
                }
                rsProducto.close();
                psProducto.close();
            } else if (tipo.equalsIgnoreCase("Servicio")) {
                // Cambiamos "servicio" por "servicios" para que coincida con el nombre de la tabla en la base de datos
                String consultaServicio = "SELECT servicio FROM servicios WHERE idservicio = ?";
                PreparedStatement psServicio = objetoConexion.estableceConexion().prepareStatement(consultaServicio);
                psServicio.setInt(1, idItem);
                
                ResultSet rsServicio = psServicio.executeQuery();
                if (rsServicio.next()) {
                    nombre = rsServicio.getString("servicio");
                }
                rsServicio.close();
                psServicio.close();
            }

            // Agregar la fila al modelo de la tabla con formato
            Object[] fila = {
                tipo,
                nombre,
                formato.format(precioVenta),  // Formato para precioVenta
                cantidad,
                formato.format(subtotal)      // Formato para subtotal
            };
            modelo.addRow(fila);
            
            // Sumar al total de la factura
            totalFactura += subtotal;
        }
        
        // Mostrar el total en el JLabel con formato
        total.setText(formato.format(totalFactura));
        
        rsDetalle.close();
        psDetalle.close();

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Error: el número de factura debe ser un valor numérico.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al mostrar datos de la factura: " + e.toString());
    } finally {
        objetoConexion.cerrarConexion();
    }
}

public void mostrarTotalVentaPorFecha(JDateChooser desde, JDateChooser hasta, JTable tablaVentas, JLabel totalGeneral) {

    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    
    DefaultTableModel modelo = new DefaultTableModel();
    modelo.addColumn("ID Factura");
    modelo.addColumn("Fecha Factura");
    modelo.addColumn("Nombre");
    modelo.addColumn("Cantidad");
    modelo.addColumn("Precio Venta");
    modelo.addColumn("Subtotal");

    tablaVentas.setModel(modelo);
    
    // Configurar el tamaño de las columnas
    tablaVentas.getColumnModel().getColumn(0).setPreferredWidth(50);  // ID Factura
    tablaVentas.getColumnModel().getColumn(1).setPreferredWidth(90); // FechaFactura
    tablaVentas.getColumnModel().getColumn(2).setPreferredWidth(80); // Nombre
    tablaVentas.getColumnModel().getColumn(3).setPreferredWidth(65);  // Cantidad
    tablaVentas.getColumnModel().getColumn(4).setPreferredWidth(140); // PrecioVenta
    tablaVentas.getColumnModel().getColumn(5).setPreferredWidth(140); // Subtotal
    

    // Configuración de formato para mostrar valores con separador de miles y dos decimales en estilo estadounidense
    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    symbols.setGroupingSeparator(',');
    symbols.setDecimalSeparator('.');
    DecimalFormat formato = new DecimalFormat("#,##0.00", symbols);

    double totalVenta = 0.0;

    // Formato para las fechas en SQL
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String fechaInicio = sdf.format(desde.getDate());
    String fechaFin = sdf.format(hasta.getDate());

    // Formato para la fecha en el formato deseado (día/mes/año)
    SimpleDateFormat formatoFechaMostrar = new SimpleDateFormat("dd/MM/yyyy");

    try {
        String consulta = "SELECT factura.idfactura, factura.fechafactura, cliente.nombres, detalle.cantidad, " +
                          "detalle.precioVenta, (detalle.cantidad * detalle.precioVenta) AS subtotal " +
                          "FROM factura " +
                          "INNER JOIN cliente ON factura.fkcliente = cliente.idcliente " +
                          "INNER JOIN detalle ON factura.idfactura = detalle.fkfactura " +
                          "WHERE factura.fechafactura BETWEEN ? AND ?";
        
        PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);
        ps.setString(1, fechaInicio);
        ps.setString(2, fechaFin);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int idFactura = rs.getInt("idfactura");
            Date fechaFactura = rs.getDate("fechafactura");
            String fechaFacturaFormateada = formatoFechaMostrar.format(fechaFactura);  // Formatear fecha en día/mes/año
            String nombreCliente = rs.getString("nombres");
            int cantidad = rs.getInt("cantidad");
            double precioVenta = rs.getDouble("precioVenta");
            double subtotal = rs.getDouble("subtotal");

            // Agregar la fila al modelo de la tabla con formato adecuado
            Object[] fila = {
                idFactura,
                fechaFacturaFormateada,       // Usar la fecha formateada
                nombreCliente,
                cantidad,
                formato.format(precioVenta),  // Formatear precioVenta con separador de miles
                formato.format(subtotal)       // Formatear subtotal con separador de miles
            };
            modelo.addRow(fila);

            // Sumar al total general de ventas
            totalVenta += subtotal;
        }

        // Mostrar el total general en el JLabel con el formato de separador de miles
        totalGeneral.setText(formato.format(totalVenta));

        rs.close();
        ps.close();

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al mostrar ventas por fecha: " + e.toString());
    } finally {
        objetoConexion.cerrarConexion();
    }
}

public void configurarEstiloTablaDatos(JTable tablaDatos) {
    // Configuración del estilo de la cabecera de la tabla
    JTableHeader cabecera = tablaDatos.getTableHeader();
    cabecera.setFont(new Font("Arial", Font.BOLD, 14));          // Tipo de letra Arial Bold, tamaño 14
    cabecera.setForeground(Color.decode("#1a3e59"));             // Color de texto (#1a3e59)
    cabecera.setBackground(Color.decode("#d9e5f2"));             // Fondo de la cabecera (#d9e5f2)
    
    // Configurar el estilo para las celdas de la tabla
    DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
    cellRenderer.setFont(new Font("Arial", Font.BOLD, 12));       // Tipo de letra Arial Bold, tamaño 12
    cellRenderer.setForeground(Color.decode("#1a3e59"));           // Color del texto
    cellRenderer.setHorizontalAlignment(SwingConstants.CENTER);    // Centrando el texto en las celdas
    cellRenderer.setBackground(Color.WHITE);                       // Fondo blanco para las celdas

    // Aplicar el renderizador a todas las columnas de la tabla
    for (int i = 0; i < tablaDatos.getColumnCount(); i++) {
        tablaDatos.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
    }
}


}