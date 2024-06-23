/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Miguel
 */
public class LoginDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Conexion cn = new Conexion();
    
    public login log(String email, String pass){
        login l = new login();
        String sql = "SELECT * FROM mae_usuario WHERE email = ? AND contrasena = ?";
        try{
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if(rs.next()){
                l.setId(rs.getInt("id_cuenta"));
                l.setEmail(rs.getString("email"));
                l.setPass(rs.getString("contrasena"));
                l.setNombre(rs.getString("nombre"));
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return l;
    }
}
