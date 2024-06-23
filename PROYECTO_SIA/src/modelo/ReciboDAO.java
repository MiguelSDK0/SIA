/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Miguel
 */
public class ReciboDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarRecibo(Recibo rb){
        String sql = "INSERT INTO trans_recibo (id_deuda, id_cliente, id_documento, id_tipoPago, fecha, fechaExp, monto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, rb.getCodDeuda());
            ps.setInt(2, rb.getCodCliente());
            ps.setInt(3, rb.getCodDocumento());
            ps.setInt(4, rb.getCodTipoPago());
            ps.setString(5, rb.getFecha());
            ps.setString(6, rb.getFechaExp());
            ps.setDouble(7, rb.getMonto());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
    public List ListarRecibos(){
        List<Recibo> ListaRecibo = new ArrayList();
        String sql = "SELECT * FROM trans_recibo";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Recibo rr = new Recibo();
                rr.setCodRecibo(rs.getInt("id_recibo"));
                rr.setCodDeuda(rs.getInt("id_deuda"));
                rr.setCodCliente(rs.getInt("id_cliente"));
                rr.setCodDocumento(rs.getInt("id_documento"));
                rr.setCodTipoPago(rs.getInt("id_tipoPago"));
                rr.setFecha(rs.getString("fecha"));
                rr.setFechaExp(rs.getString("fechaExp"));
                rr.setMonto(rs.getDouble("monto"));
                ListaRecibo.add(rr);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ListaRecibo;
    }
    
    public void ConsultarDocumento(JComboBox documento){
        String sql = "SELECT descripcion FROM mae_documento";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                documento.addItem(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    //
    
    
    
    //
    
    public void ConsultarCodigoCliente(JComboBox codigoCliente){
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
    
    public void ConsultarDeudas(int codigo, JComboBox codigoDeuda){
        String sql = "SELECT id_deuda FROM mae_deudas WHERE id_cliente = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                codigoDeuda.addItem(rs.getString("id_deuda"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void ConsultarMetodosDePago(JComboBox metodos){
        String sql = "SELECT descripcion FROM mae_pagos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                metodos.addItem(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void SeleccionarMonto(int codigo, JTextField monto){
        String sql = "SELECT monto FROM mae_deudas WHERE id_deuda = ?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            while(rs.next()){
                monto.setText(rs.getString("monto"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
