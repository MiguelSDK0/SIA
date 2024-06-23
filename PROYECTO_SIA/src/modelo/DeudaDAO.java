/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JTextField;
/**
 *
 * @author Miguel
 */
public class DeudaDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public void ConsultarCliente(JComboBox codigoCliente){
        String sql = "SELECT id_cliente FROM mae_cliente";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                codigoCliente.addItem(rs.getString("id_cliente"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public boolean RegistrarDeuda(Deuda dd){
        String sql = "INSERT INTO mae_deudas (id_cliente, monto) VALUES (?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dd.getId_cliente());
            ps.setDouble(2, dd.getMonto());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public void SeleccionarCliente(String codigoCliente, JTextField nombre){
        int seleccionar = Integer.parseInt(codigoCliente);
        String sql = "SELECT DISTINCT c.nombre FROM mae_cliente c JOIN mae_deudas d ON c.id_cliente = d.id_cliente WHERE d.id_cliente = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, seleccionar);
            rs = ps.executeQuery();
            while(rs.next()){
                nombre.setText(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public boolean EliminarDeuda(int id){
        String sql = "DELETE FROM mae_deudas WHERE id_deuda = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
    
    public List ListarDeuda(){
        List<Deuda> ListaDeudas = new ArrayList();
        String sql = "SELECT * FROM mae_deudas WHERE monto > 0";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Deuda dd = new Deuda();
                dd.setId_deuda(rs.getInt("id_deuda"));
                dd.setId_cliente(rs.getInt("id_cliente"));
                dd.setMonto(rs.getDouble("monto"));
                ListaDeudas.add(dd);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaDeudas;
    }
    
    public boolean ModificarDeuda(Deuda dd){
        String sql = "UPDATE mae_deudas SET monto = ? WHERE id_deuda = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1, dd.getMonto());
            ps.setInt(2, dd.getId_deuda());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                System.out.println(ex.toString());
            }
        }
    }
}
