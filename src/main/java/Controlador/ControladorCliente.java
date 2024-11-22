/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import com.mysql.cj.protocol.Resultset;
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
public class ControladorCliente {

public void MostrarClientes(JTable tablaTotalClientes)    {
    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    
    Modelos.ModeloCliente objetoCliente = new Modelos.ModeloCliente();
    
    DefaultTableModel modelo = new DefaultTableModel();
    
    String sql ="";
    
    modelo.addColumn("ID");
    modelo.addColumn("Nombres");
    modelo.addColumn("Apellidos");
    
    tablaTotalClientes.setModel(modelo);
    
    sql="select cliente.idcliente,cliente.nombres,cliente.apellidos from cliente";
    
    try {
        Statement st = objetoConexion.estableceConexion().createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while (rs.next()){
            
            objetoCliente.setIdcliente(rs.getInt("idcliente"));
            objetoCliente.setNombres(rs.getString("nombres"));
            objetoCliente.setApellidos(rs.getString("apellidos"));
            
            modelo.addRow(new Object[]{objetoCliente.getIdcliente(),objetoCliente.getNombres(),objetoCliente.getApellidos()});
        }
        tablaTotalClientes.setModel(modelo);
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Error al mostrar usuarios," +e.toString());
}
    finally {
        
        objetoConexion.cerrarConexion();
    }
    
    for (int column = 0; column < tablaTotalClientes.getColumnCount(); column++) {
    Class<?> columnClass = tablaTotalClientes.getColumnClass(column);
    tablaTotalClientes.setDefaultEditor(columnClass, null);
    
    }
}

public void configurarCabeceraTablaClientes(JTable tablaTotalClientes) {
    // Configurar el estilo de la cabecera
    JTableHeader cabecera = tablaTotalClientes.getTableHeader();

    // Establecer el tipo de letra, tamaño y color para la cabecera
    cabecera.setFont(new Font("Arial", Font.BOLD, 14));          // Tipo de letra Arial Bold, tamaño 14
    cabecera.setForeground(Color.decode("#1a3e59"));             // Color de texto (#1a3e59)
    cabecera.setBackground(Color.decode("#d9e5f2"));             // Fondo de la cabecera (#d9e5f2)

    // Aplicar alineación y estilo en cada columna de la cabecera
    DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) cabecera.getDefaultRenderer();
    renderer.setHorizontalAlignment(SwingConstants.CENTER);      // Centrar el texto de la cabecera
}
    
public void AgregarCliente (JTextField nombres, JTextField apellidos){
    
    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    Modelos.ModeloCliente objetoCliente = new Modelos.ModeloCliente();
    
    String consulta = "insert into cliente (nombres,apellidos) values (?,?);";
    
    try {
        
        objetoCliente.setNombres(nombres.getText());
        objetoCliente.setApellidos(apellidos.getText());
        
        CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
        cs.setString(1, objetoCliente.getNombres());
        cs.setString(2, objetoCliente.getApellidos());
        
        cs.execute();
        
        //JOptionPane.showMessageDialog(null, "Se guardo correctamente");
        
    } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null, "Error al guardar: " +e.toString());
    }
    finally {
        objetoConexion.cerrarConexion();
    }
}

public void Seleccionar(JTable totalcliente, JTextField id, JTextField nombres, JTextField apellidos){
    
    int fila = totalcliente.getSelectedRow();
    try{ 
        if (fila>=0) {
            
            id.setText(totalcliente.getValueAt(fila, 0).toString());
            nombres.setText(totalcliente.getValueAt(fila, 1).toString());
            apellidos.setText(totalcliente.getValueAt(fila, 2).toString());
        }
    
} catch (Exception e) {
    
    JOptionPane.showMessageDialog(null, "Error al seleccionar:"+ e.toString());
}
}

public void ModificarCliente(JTextField id, JTextField nombres, JTextField apellidos){

    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    Modelos.ModeloCliente objetoCliente = new Modelos.ModeloCliente();
    
    String consulta = "UPDATE cliente SET cliente.nombres=?, cliente.apellidos=? where cliente.idcliente=?;";
    
    try {
        objetoCliente.setIdcliente(Integer.parseInt(id.getText()));
        objetoCliente.setNombres(nombres.getText());
        objetoCliente.setApellidos(apellidos.getText());
        
        CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
        
        cs.setString(1, objetoCliente.getNombres());
        cs.setString(2, objetoCliente.getApellidos());
        cs.setInt(3, objetoCliente.getIdcliente());
        
        cs.execute();
        
        JOptionPane.showMessageDialog(null, "Se modifico correctamente");

        
    }catch (Exception e) {
        
        JOptionPane.showMessageDialog(null, "Error al modificar: "+ e.toString());
        
    }   finally {
        objetoConexion.cerrarConexion();
        
    }
}

public void limpiarCamposClientes(JTextField id, JTextField nombres, JTextField apellidos) {
    
    id.setText("");
    nombres.setText("");
    apellidos.setText("");
    
}

public void EliminarClientes (JTextField id) {
    
    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    Modelos.ModeloCliente objetoCliente = new Modelos.ModeloCliente();
    
    String consulta = "delete from cliente where cliente.idcliente=?;";
    
    try {
        
       objetoCliente.setIdcliente(Integer.parseInt(id.getText()));
       CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
       cs.setInt(1, objetoCliente.getIdcliente());
       
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
    
