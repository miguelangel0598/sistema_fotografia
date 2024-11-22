/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.awt.Color;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
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
public class ControladorProducto {
    
    public void MostrarProductos(JTable tablaTotalProductos)    {
    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    
    Modelos.ModeloProducto objetoProducto = new Modelos.ModeloProducto();
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    String sql ="";
    
    modelo.addColumn("ID");
    modelo.addColumn("Nombre Producto");
    modelo.addColumn("Precio");
    modelo.addColumn("Stock");
    
    tablaTotalProductos.setModel(modelo);
    
    sql="select producto.idproducto, producto.nombre, producto.precioProducto, producto.stock from producto";
    
    try {
        Statement st = objetoConexion.estableceConexion().createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            
            objetoProducto.setIdproducto(rs.getInt("idproducto"));
            objetoProducto.setNombreproducto(rs.getString("nombre"));
            objetoProducto.setPrecioproducto(rs.getDouble("precioProducto"));
            objetoProducto.setStockproducto(rs.getInt("stock"));
            
            modelo.addRow(new Object[]{objetoProducto.getIdproducto(),objetoProducto.getNombreproducto(),objetoProducto.getPrecioproducto(), objetoProducto.getStockproducto()});
        }
        tablaTotalProductos.setModel(modelo);
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Error al mostrar productos," +e.toString());
}
    finally {
        
        objetoConexion.cerrarConexion();
    }
    
    for (int column = 0; column < tablaTotalProductos.getColumnCount(); column++) {
    Class<?> columnClass = tablaTotalProductos.getColumnClass(column);
    tablaTotalProductos.setDefaultEditor(columnClass, null);
    
    }
    }
    
    public void configurarCabeceraTablaProductos(JTable tablaTotalProductos) {
    // Configurar el estilo de la cabecera
    JTableHeader cabecera = tablaTotalProductos.getTableHeader();

    // Establecer el tipo de letra, tamaño y color para la cabecera
    cabecera.setFont(new Font("Arial", Font.BOLD, 14));          // Tipo de letra Arial Bold, tamaño 14
    cabecera.setForeground(Color.decode("#1a3e59"));             // Color de texto (#1a3e59)
    cabecera.setBackground(Color.decode("#d9e5f2"));             // Fondo de la cabecera (#d9e5f2)

    // Aplicar alineación y estilo en cada columna de la cabecera
    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) cabecera.getDefaultRenderer();
    renderer.setHorizontalAlignment(SwingConstants.CENTER);      // Centrar el texto de la cabecera
    
    }

    
    public void AgregarProducto (JTextField nombre, JTextField precioProducto, JTextField stock){
    
    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    Modelos.ModeloProducto objetoProducto = new Modelos.ModeloProducto();
    
    String consulta = "insert into producto (nombre,precioProducto,stock) values (?,?,?);";
    
    try {
        
        objetoProducto.setNombreproducto(nombre.getText());
        objetoProducto.setPrecioproducto(Double.valueOf(precioProducto.getText()));
        objetoProducto.setStockproducto(Integer.parseInt(stock.getText()));
        
        CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
        cs.setString(1, objetoProducto.getNombreproducto());
        cs.setDouble(2, objetoProducto.getPrecioproducto());
        cs.setInt(3, objetoProducto.getStockproducto());


        
        cs.execute();
        
        //JOptionPane.showMessageDialog(null, "Se guardo correctamente");
        
    } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null, "Error al guardar: " +e.toString());
    }
    finally {
        objetoConexion.cerrarConexion();
    }
}
    public void Seleccionar(JTable totalProducto, JTextField id, JTextField nombre, JTextField precioProducto, JTextField stock){
    
    int fila = totalProducto.getSelectedRow();
    try{ 
        if (fila>=0) {
            
            id.setText(totalProducto.getValueAt(fila, 0).toString());
            nombre.setText(totalProducto.getValueAt(fila, 1).toString());
            precioProducto.setText(totalProducto.getValueAt(fila, 2).toString());
            stock.setText(totalProducto.getValueAt(fila, 3).toString());
        }
    
} catch (Exception e) {
    
    JOptionPane.showMessageDialog(null, "Error al seleccionar:"+ e.toString());
}
}
    public void ModificarProducto(JTextField id, JTextField nombre, JTextField precioProducto, JTextField stock){

    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    Modelos.ModeloProducto objetoProducto = new Modelos.ModeloProducto();
    
    String consulta = "UPDATE producto SET producto.nombre=?, producto.precioProducto=?, producto.stock=? where producto.idproducto=?;";
    
    try {
        objetoProducto.setIdproducto(Integer.parseInt(id.getText()));
        objetoProducto.setNombreproducto(nombre.getText());
        objetoProducto.setPrecioproducto(Double.valueOf(precioProducto.getText()));
        objetoProducto.setStockproducto(Integer.parseInt(stock.getText()));
        
        CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
       
        cs.setString(1, objetoProducto.getNombreproducto());
        cs.setDouble(2, objetoProducto.getPrecioproducto());
        cs.setInt(3, objetoProducto.getStockproducto());
        cs.setInt(4, objetoProducto.getIdproducto());

        cs.execute();
        
        JOptionPane.showMessageDialog(null, "Se modifico correctamente");

        
    }catch (Exception e) {
        
        JOptionPane.showMessageDialog(null, "Error al modificar: "+ e.toString());
        
    }   finally {
        objetoConexion.cerrarConexion();
        
    }
}

    public void limpiarCamposProductos(JTextField id, JTextField nombre, JTextField precioProducto, JTextField stock) {
    
    id.setText("");
    nombre.setText("");
    precioProducto.setText("");
    stock.setText("");
    
}
    
    public void EliminarProductos (JTextField id) {
    
    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    Modelos.ModeloProducto objetoProducto = new Modelos.ModeloProducto();
    
    String consulta = "delete from producto where producto.idproducto=?;";
    
    try {
        
       objetoProducto.setIdproducto(Integer.parseInt(id.getText()));
       CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
       cs.setInt(1, objetoProducto.getIdproducto());
       
       cs.execute();
       
       JOptionPane.showMessageDialog(null, "Se elimino correctamente");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "No se elimino correctamente, error"+ e.toString());
    }
    finally{
        objetoConexion.cerrarConexion();
    }
    
}
    
}
