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
public class ControladorServicios {
    

public void MostrarServicios(JTable tablaTotalServicios) {
    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    Modelos.ModeloServicios objetoServicios = new Modelos.ModeloServicios();
    DefaultTableModel modelo = new DefaultTableModel();
    
    modelo.addColumn("ID");
    modelo.addColumn("SERVICIO");
    modelo.addColumn("PLAN");
    modelo.addColumn("PRECIO");
    
    tablaTotalServicios.setModel(modelo);
    
    String sql = "SELECT servicios.idservicio, servicios.servicio, servicios.plan, servicios.precio FROM servicios";
    
    try {
        Statement st = objetoConexion.estableceConexion().createStatement();
        ResultSet rs = st.executeQuery(sql);
        
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
        tablaTotalServicios.setModel(modelo);
        
        // Ajuste de tamaño de columnas
        tablaTotalServicios.getColumnModel().getColumn(0).setPreferredWidth(15);  // ID Servicio
        tablaTotalServicios.getColumnModel().getColumn(1).setPreferredWidth(220); // Servicio
        tablaTotalServicios.getColumnModel().getColumn(2).setPreferredWidth(100); // Plan
        tablaTotalServicios.getColumnModel().getColumn(3).setPreferredWidth(40);  // Precio
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al mostrar servicio: " + e.toString());
    } finally {
        objetoConexion.cerrarConexion();
    }
    
    for (int column = 0; column < tablaTotalServicios.getColumnCount(); column++) {
    Class<?> columnClass = tablaTotalServicios.getColumnClass(column);
    tablaTotalServicios.setDefaultEditor(columnClass, null);
    }
}

public void AgregarServicio (JTextField servicio, JTextField plan, JTextField precio){
    
    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    Modelos.ModeloServicios objetoServicios = new Modelos.ModeloServicios();
    
    String consulta = "insert into servicios (servicio,plan,precio) values (?,?,?);";
    
    try {
        
        objetoServicios.setNombreservicio(servicio.getText());
        objetoServicios.setNombreplan(plan.getText());
        objetoServicios.setPrecioservicio(Double.valueOf(precio.getText()));
        
        
        CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
        cs.setString(1, objetoServicios.getNombreservicio());
        cs.setString(2, objetoServicios.getNombreplan());
        cs.setDouble(3, objetoServicios.getPrecioservicio());
        
        cs.execute();
        
        //JOptionPane.showMessageDialog(null, "Se guardo correctamente");
        
    } catch (Exception e) {
        
        JOptionPane.showMessageDialog(null, "Error al guardar: " +e.toString());
    }
    finally {
        objetoConexion.cerrarConexion();
    }
}

public void SeleccionarServicio(JTable totalServicio, JTextField id, JTextField servicio, JTextField plan, JTextField precio){
    
    int fila = totalServicio.getSelectedRow();
    try{ 
        if (fila>=0) {
            
            id.setText(totalServicio.getValueAt(fila, 0).toString());
            servicio.setText(totalServicio.getValueAt(fila, 1).toString());
            plan.setText(totalServicio.getValueAt(fila, 2).toString());
            precio.setText(totalServicio.getValueAt(fila, 3).toString());
        }
    
} catch (Exception e) {
    
    JOptionPane.showMessageDialog(null, "Error al seleccionar:"+ e.toString());
}
}

 public void ModificarServicio(JTextField id, JTextField servicio, JTextField plan, JTextField precio){

    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    Modelos.ModeloServicios objetoServicios = new Modelos.ModeloServicios();
    
    String consulta = "UPDATE servicios SET servicios.servicio=?, servicios.plan=?, servicios.precio=? where servicios.idservicio=?;";
    
    try {
        objetoServicios.setIdservicio(Integer.parseInt(id.getText()));
        objetoServicios.setNombreservicio(servicio.getText());
        objetoServicios.setNombreplan(plan.getText());
        objetoServicios.setPrecioservicio(Double.valueOf(precio.getText()));
        
        CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
       
        cs.setString(1, objetoServicios.getNombreservicio());
        cs.setString(2, objetoServicios.getNombreplan());
        cs.setDouble(3, objetoServicios.getPrecioservicio());
        cs.setInt(4, objetoServicios.getIdservicio());

        
        cs.execute();
        
        JOptionPane.showMessageDialog(null, "Se modifico correctamente");

        
    }catch (Exception e) {
        
        JOptionPane.showMessageDialog(null, "Error al modificar: "+ e.toString());
        
    }   finally {
        objetoConexion.cerrarConexion();
        
    }
}

 
    public void limpiarCamposServicios(JTextField id, JTextField servicio, JTextField plan, JTextField precio) {
    
    id.setText("");
    servicio.setText("");
    plan.setText("");
    precio.setText("");

}


    public void EliminarServicios (JTextField idservicio) {
    
    Configuracion.CConexion objetoConexion = new Configuracion.CConexion();
    Modelos.ModeloServicios objetoServicios = new Modelos.ModeloServicios();
    
    String consulta = "delete from servicios where servicios.idservicio=?;";
    
    try {
        
       objetoServicios.setIdservicio(Integer.parseInt(idservicio.getText()));
       CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta);
       cs.setInt(1, objetoServicios.getIdservicio());
       
       cs.execute();
       
       JOptionPane.showMessageDialog(null, "Se elimino correctamente");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "No se elimino correctamente, error"+ e.toString());
    }
    finally{
        objetoConexion.cerrarConexion();
    }
    
    }
    
    public void ajustarAnchoColumnasServicios(JTable tablaServicios) {
    // Establece el ancho preferido de cada columna en la JTable
    tablaServicios.getColumnModel().getColumn(0).setPreferredWidth(8);  // ID
    tablaServicios.getColumnModel().getColumn(1).setPreferredWidth(200); // Nombres
    tablaServicios.getColumnModel().getColumn(2).setPreferredWidth(200); // Apellidos
   
}
     public void configurarCabeceraTablaServicios(JTable tablaServicios) {
        // Configurar el estilo de la cabecera
        JTableHeader cabecera = tablaServicios.getTableHeader();
        
        // Establecer el tipo de letra, tamaño y color para la cabecera
        cabecera.setFont(new Font("Arial", Font.BOLD, 14));  // Ajusta el tamaño aquí
        cabecera.setForeground(Color.decode("#1a3e59"));     // Color de texto
        cabecera.setBackground(Color.decode("#d9e5f2"));     // Fondo de la cabecera

        // Aplicar alineación y estilo en cada columna de la cabecera
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) cabecera.getDefaultRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);  // Centrar el texto de la cabecera
    }
}


