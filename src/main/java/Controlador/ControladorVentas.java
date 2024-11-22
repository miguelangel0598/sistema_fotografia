/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Controlador;

import java.awt.Color;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Angel
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class ControladorVentas {

    public void BuscarProducto(JTextField nombreProducto, JTable tablaproductos) {
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Modelos.ModeloProducto objetoProducto = new Modelos.ModeloProducto();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio Producto");
        modelo.addColumn("Stock");

        tablaproductos.setModel(modelo);

        try {
            String consulta = "select * from producto WHERE producto.nombre like concat('%',?,'%');";
            PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);

            ps.setString(1, nombreProducto.getText());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objetoProducto.setIdproducto(rs.getInt("idproducto"));
                objetoProducto.setNombreproducto(rs.getString("nombre"));
                objetoProducto.setPrecioproducto(rs.getDouble("precioProducto"));
                objetoProducto.setStockproducto(rs.getInt("stock"));

                modelo.addRow(new Object[]{
                    objetoProducto.getIdproducto(),
                    objetoProducto.getNombreproducto(),
                    objetoProducto.getPrecioproducto(),
                    objetoProducto.getStockproducto()
                });
            }
            tablaproductos.setModel(modelo);

            tablaproductos.getColumnModel().getColumn(0).setPreferredWidth(8);  // Columna "ID"
            tablaproductos.getColumnModel().getColumn(1).setPreferredWidth(140); // Columna "Nombre"
            tablaproductos.getColumnModel().getColumn(2).setPreferredWidth(75); // Columna "Precio Producto"
            tablaproductos.getColumnModel().getColumn(3).setPreferredWidth(35);  // Columna "Stock"

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }

        for (int column = 0; column < tablaproductos.getColumnCount(); column++) {
            Class<?> columnClass = tablaproductos.getColumnClass(column);
            tablaproductos.setDefaultEditor(columnClass, null);
        }
    }

    public void SeleccionarProductoVenta(JTable tablaProducto, JTextField id, JTextField nombres, JTextField precioProducto, JTextField stock, JTextField precioFinal) {
        int fila = tablaProducto.getSelectedRow();

        try {
            if (fila >= 0) {
                id.setText(tablaProducto.getValueAt(fila, 0).toString());
                nombres.setText(tablaProducto.getValueAt(fila, 1).toString());
                precioProducto.setText(tablaProducto.getValueAt(fila, 2).toString());
                stock.setText(tablaProducto.getValueAt(fila, 3).toString());
                precioFinal.setText(tablaProducto.getValueAt(fila, 2).toString());
                              
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección: " + e.toString());
        }
    }

    public void BuscarServicio(JTextField nombreServicio, JTable tablaservicios) {
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Modelos.ModeloServicios objetoServicios = new Modelos.ModeloServicios();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Servicio");
        modelo.addColumn("Plan");
        modelo.addColumn("Precio");

        tablaservicios.setModel(modelo);

        try {
            String consulta = "select * from servicios WHERE servicios.servicio like concat('%',?,'%');";
            PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);

            ps.setString(1, nombreServicio.getText());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objetoServicios.setIdservicio(rs.getInt("idservicio"));
                objetoServicios.setNombreservicio(rs.getString("servicio"));
                objetoServicios.setNombreplan(rs.getString("plan"));
                objetoServicios.setPrecioservicio(rs.getDouble("precio"));

                modelo.addRow(new Object[]{
                    objetoServicios.getIdservicio(),
                    objetoServicios.getNombreservicio(),
                    objetoServicios.getNombreplan(),
                    objetoServicios.getPrecioservicio()
                });
            }
            tablaservicios.setModel(modelo);

            tablaservicios.getColumnModel().getColumn(0).setPreferredWidth(8);  // Columna "ID"
            tablaservicios.getColumnModel().getColumn(1).setPreferredWidth(140); // Columna "Servicio"
            tablaservicios.getColumnModel().getColumn(2).setPreferredWidth(75); // Columna "Plan"
            tablaservicios.getColumnModel().getColumn(3).setPreferredWidth(35);  // Columna "Precio"

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }

        for (int column = 0; column < tablaservicios.getColumnCount(); column++) {
            Class<?> columnClass = tablaservicios.getColumnClass(column);
            tablaservicios.setDefaultEditor(columnClass, null);
        }
    }

    public void SeleccionarServicioVenta(JTable tablaServicios, JTextField id, JTextField servicios, JTextField plan, JTextField precio, JTextField precioFinal) {
        int fila = tablaServicios.getSelectedRow();

        try {
            if (fila >= 0) {
                id.setText(tablaServicios.getValueAt(fila, 0).toString());
                servicios.setText(tablaServicios.getValueAt(fila, 1).toString());
                plan.setText(tablaServicios.getValueAt(fila, 2).toString());
                precio.setText(tablaServicios.getValueAt(fila, 3).toString());
                precioFinal.setText(tablaServicios.getValueAt(fila, 3).toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección: " + e.toString());
        }
    }

    public void BuscarCliente(JTextField nombreCliente, JTable tablaclientes) {
        Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
        Modelos.ModeloCliente objetoCliente = new Modelos.ModeloCliente();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");

        tablaclientes.setModel(modelo);

        try {
            String consulta = "select * from cliente WHERE cliente.nombres like concat('%',?,'%');";
            PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);

            ps.setString(1, nombreCliente.getText());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                objetoCliente.setIdcliente(rs.getInt("idcliente"));
                objetoCliente.setNombres(rs.getString("nombres"));
                objetoCliente.setApellidos(rs.getString("apellidos"));

                modelo.addRow(new Object[]{
                    objetoCliente.getIdcliente(),
                    objetoCliente.getNombres(),
                    objetoCliente.getApellidos()
                });
            }
            tablaclientes.setModel(modelo);

            tablaclientes.getColumnModel().getColumn(0).setPreferredWidth(8);  // Columna "ID"
            tablaclientes.getColumnModel().getColumn(1).setPreferredWidth(115); // Columna "Nombre"
            tablaclientes.getColumnModel().getColumn(2).setPreferredWidth(115); // Columna "Apellidos"

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar: " + e.toString());
        } finally {
            objetoConexion.cerrarConexion();
        }

        for (int column = 0; column < tablaclientes.getColumnCount(); column++) {
            Class<?> columnClass = tablaclientes.getColumnClass(column);
            tablaclientes.setDefaultEditor(columnClass, null);
        }
    }

    public void SeleccionarClienteVenta(JTable tablaClientes, JTextField id, JTextField nombres, JTextField apellidos) {
        int fila = tablaClientes.getSelectedRow();

        try {
            if (fila >= 0) {
                id.setText(tablaClientes.getValueAt(fila, 0).toString());
                nombres.setText(tablaClientes.getValueAt(fila, 1).toString());
                apellidos.setText(tablaClientes.getValueAt(fila, 2).toString());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de selección: " + e.toString());
        }
    }

    public void pasarProductosVenta(JTable tablaResumen, JTextField idproducto, JTextField nombreProducto, JTextField precioProducto, JTextField stock, JTextField cantidadVenta) {
    DefaultTableModel modelo = (DefaultTableModel) tablaResumen.getModel();

    int stockDisponible = Integer.parseInt(stock.getText());
    String idProducto = idproducto.getText();
    String tipo = "Producto"; // Identifica que esta entrada es un producto

    // Verifica si el producto ya ha sido agregado a la tabla
    for (int i = 0; i < modelo.getRowCount(); i++) {
        String idExistente = (String) modelo.getValueAt(i, 0);
        String tipoExistente = (String) modelo.getValueAt(i, 1); // Nueva columna para tipo

        if (idExistente.equals(idProducto) && tipoExistente.equals(tipo)) {
            JOptionPane.showMessageDialog(null, "El producto ya está registrado");
            
        }
    }

    String nProducto = nombreProducto.getText();
    double precioUnitario = Double.parseDouble(precioProducto.getText());
    int cantidad = Integer.parseInt(cantidadVenta.getText());

    if (cantidad > stockDisponible) {
        JOptionPane.showMessageDialog(null, "La cantidad de venta no puede ser mayor al stock disponible");
        return;
    }

    double subtotal = precioUnitario * cantidad;

    // Agrega el producto a la tabla de resumen en el orden correcto
    modelo.addRow(new Object[]{idProducto, tipo, nProducto, precioUnitario,cantidad, subtotal});
    
    idproducto.setText("");
    nombreProducto.setText("");
    precioProducto.setText("");
    stock.setText("");
    cantidadVenta.setText("");   
   
}

   public void pasarServiciosVenta(JTable tablaResumen, JTextField idServicio, JTextField nombreServicio, JTextField planServicio, JTextField precioServicio, JTextField cantidadVenta) {
    DefaultTableModel modelo = (DefaultTableModel) tablaResumen.getModel();

    String idServicioText = idServicio.getText();
    String tipo = "Servicio"; // Identifica que esta entrada es un servicio

    // Verifica si el servicio ya ha sido agregado a la tabla
    for (int i = 0; i < modelo.getRowCount(); i++) {
        String idExistente = (String) modelo.getValueAt(i, 0);
        String tipoExistente = (String) modelo.getValueAt(i, 1); // Nueva columna para tipo

        if (idExistente.equals(idServicioText) && tipoExistente.equals(tipo)) {
            JOptionPane.showMessageDialog(null, "El servicio ya está registrado");
          
        }
    }

    String nServicio = nombreServicio.getText();
    String plan = planServicio.getText();
    int cantidad = Integer.parseInt(cantidadVenta.getText());
    double precioUnitario = Double.parseDouble(precioServicio.getText());

    // Calcula el subtotal correctamente
    double subtotal = precioUnitario * cantidad;
    
    

    // Agrega el servicio a la tabla de resumen en el orden correcto
    modelo.addRow(new Object[]{idServicioText, tipo, nServicio + " - " + plan, precioUnitario, cantidad, subtotal});

idServicio.setText("");  
nombreServicio.setText(""); 
planServicio.setText(""); 
precioServicio.setText(""); 
cantidadVenta.setText(""); 
}


    public void eliminarProductosSeleccionadosResumenVenta(JTable tablaResumen) {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tablaResumen.getModel();

            int indiceSeleccionado = tablaResumen.getSelectedRow();

            if (indiceSeleccionado != -1) {
                modelo.removeRow(indiceSeleccionado);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al seleccionar: " + e.toString());
        }
    }
    
    

public void calcularTotalPagar(JTable tablaResumen, JLabel totalPagar) {
    DefaultTableModel modelo = (DefaultTableModel) tablaResumen.getModel();
    double totalSubtotal = 0;

    // Configurar el formato para mostrar valores con separador de miles y dos decimales
    DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    symbols.setGroupingSeparator(',');
    symbols.setDecimalSeparator('.');
    DecimalFormat formato = new DecimalFormat("#,##0.00", symbols);

    for (int i = 0; i < modelo.getRowCount(); i++) {
        // Asegurarse de que el valor en la columna 5 sea un número
        Object valor = modelo.getValueAt(i, 5);
        if (valor instanceof Number) {
            totalSubtotal += ((Number) valor).doubleValue();
        } else {
            try {
                totalSubtotal += Double.parseDouble(valor.toString());
            } catch (NumberFormatException e) {
                System.out.println("Error al convertir el valor en la fila " + i + " a número: " + valor);
            }
        }
    }

    // Mostrar el total en el JLabel con el formato de miles y dos decimales
    totalPagar.setText(formato.format(totalSubtotal));
}

     
     public void ajustarAnchoColumnas(JTable tablaResumen) {
    // Establece el ancho preferido de cada columna en la JTable
    tablaResumen.getColumnModel().getColumn(0).setPreferredWidth(8);  // ID
    tablaResumen.getColumnModel().getColumn(1).setPreferredWidth(40); // Tipo
    tablaResumen.getColumnModel().getColumn(2).setPreferredWidth(300); // Nombre
    tablaResumen.getColumnModel().getColumn(3).setPreferredWidth(40);  // Precio Unitario
    tablaResumen.getColumnModel().getColumn(4).setPreferredWidth(7);  // Cantidad
    tablaResumen.getColumnModel().getColumn(5).setPreferredWidth(70); // Subtotal
}
     public void configurarCabeceraTabla(JTable tablaResumen) {
        // Configurar el estilo de la cabecera
        JTableHeader cabecera = tablaResumen.getTableHeader();
        
        // Establecer el tipo de letra, tamaño y color para la cabecera
        cabecera.setFont(new Font("Arial", Font.BOLD, 14));  // Ajusta el tamaño aquí
        cabecera.setForeground(Color.decode("#1a3e59"));     // Color de texto
        cabecera.setBackground(Color.decode("#d9e5f2"));     // Fondo de la cabecera

        // Aplicar alineación y estilo en cada columna de la cabecera
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) cabecera.getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);  // Centrar el texto de la cabecera
    }
        
     public void crearFactura(JTextField codCliente) {

    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    Modelos.ModeloCliente objetoCliente = new Modelos.ModeloCliente();
    
    // Cambiamos curdate() a NOW() para obtener la fecha y hora actuales
    String consulta = "INSERT INTO factura(fechaFactura, fkcliente) VALUES (NOW(), ?)";

    try {
        objetoCliente.setIdcliente(Integer.parseInt(codCliente.getText()));
        
        CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
        cs.setInt(1, objetoCliente.getIdcliente());
        
        cs.execute();
        JOptionPane.showMessageDialog(null, "Factura creada con fecha y hora exactas.");
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al crear factura: " + e.toString());
    } finally {
        objetoConexion.cerrarConexion();
    }
}
   
   public void realizarVenta(JTable tablaResumenVenta) {
    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();

    // Consulta para insertar en la tabla detalle
    String consultaDetalle = "INSERT INTO detalle (fkfactura, id_item, tipo, cantidad, precioVenta) VALUES ((SELECT MAX(idfactura) FROM factura), ?, ?, ?, ?)";
    // Consulta para actualizar el stock de productos
    String consultaStock = "UPDATE producto SET stock = stock - ? WHERE idproducto = ?";
    

    try {
        PreparedStatement psDetalle = objetoConexion.estableceConexion().prepareStatement(consultaDetalle);
        PreparedStatement psStock = objetoConexion.estableceConexion().prepareStatement(consultaStock);

        int filas = tablaResumenVenta.getRowCount();

        for (int i = 0; i < filas; i++) {
            int idItem = Integer.parseInt(tablaResumenVenta.getValueAt(i, 0).toString()); // ID del producto o servicio
            String tipo = tablaResumenVenta.getValueAt(i, 1).toString(); // Tipo: Producto o Servicio
            int cantidad = Integer.parseInt(tablaResumenVenta.getValueAt(i, 4).toString());
            double precioVenta = Double.parseDouble(tablaResumenVenta.getValueAt(i, 3).toString());

            // Configurar los valores para la inserción en detalle
            psDetalle.setInt(1, idItem); // id_item
            psDetalle.setString(2, tipo); // tipo
            psDetalle.setInt(3, cantidad); // cantidad
            psDetalle.setDouble(4, precioVenta); // precioVenta
            psDetalle.executeUpdate();

            // Si es un producto, actualizamos el stock
            if (tipo.equalsIgnoreCase("Producto")) {
                psStock.setInt(1, cantidad);
                psStock.setInt(2, idItem);
                psStock.executeUpdate();
            }
        }

        JOptionPane.showMessageDialog(null, "Venta realizada con éxito");

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al vender: " + e.toString());
    } finally {
        objetoConexion.cerrarConexion();
    }
}

    public void limpiarCamposLuegoVenta(JTextField buscarCliente, JTextField buscarProducto, JTextField buscarServicio, 
                                    JTable tablaCliente, JTable tablaServicios, JTable tablaProductos, 
                                    JTextField selectIdCliente, JTextField selectNombres, JTextField selectApellidos, 
                                    JTable tablaResumen, JLabel total) {
                                        
    // Limpiar campos de búsqueda
    buscarCliente.setText("");
    buscarCliente.requestFocus();
    buscarProducto.setText("");
    buscarServicio.setText("");
    
    // Limpiar las tablas de búsqueda
    DefaultTableModel modeloCliente = (DefaultTableModel) tablaCliente.getModel();
    modeloCliente.setRowCount(0);
   
    DefaultTableModel modeloServicios = (DefaultTableModel) tablaServicios.getModel();
    modeloServicios.setRowCount(0);
    
    DefaultTableModel modeloProductos = (DefaultTableModel) tablaProductos.getModel();
    modeloProductos.setRowCount(0);
   
    // Limpiar selección de cliente
    selectIdCliente.setText("");
    selectNombres.setText("");
    selectApellidos.setText("");

    // Limpiar tabla de resumen de venta
    DefaultTableModel modeloResumen = (DefaultTableModel) tablaResumen.getModel();
    modeloResumen.setRowCount(0);
   
    // Limpiar total
    total.setText("0.00");
}
    
    
    public void MostrarUltimaFactura(JLabel ultimaFactura) {
    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    
    try {
        String consulta = "SELECT MAX(idfactura) as UltimaFactura FROM factura";
        
        PreparedStatement ps = objetoConexion.estableceConexion().prepareStatement(consulta);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            ultimaFactura.setText(String.valueOf(rs.getInt("UltimaFactura")));
        }
        
        rs.close();
        ps.close();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al mostrar la última factura: " + e.toString());
    } finally {
        objetoConexion.cerrarConexion();
    }
    }
}
