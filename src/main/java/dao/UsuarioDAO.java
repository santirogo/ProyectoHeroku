/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Conexion;
import vo.UsuarioVO;

/**
 *
 * @author ayoro
 */
public class UsuarioDAO {
    private Connection conexion;

    public UsuarioDAO() {
        try {
            this.conexion = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean insertar(UsuarioVO usuario) throws SQLException{
        boolean res = false;
        String query = "INSERT INTO Usuarios VALUES (?,?,?)";
        PreparedStatement preparedStmt = this.conexion.prepareStatement(query);
        
        preparedStmt.setInt(1, usuario.getId());
        preparedStmt.setString(2, usuario.getUser());
        preparedStmt.setString(3, usuario.getPassword());
        res = preparedStmt.execute();
        
        return res;
    }
    
    public boolean editarUsuario(UsuarioVO usuario){
        boolean res = false;
        String query ="update Usuarios set Usuario = ? where IdUsuario = ?";
        
        try {
            PreparedStatement preparedStmt = this.conexion.prepareStatement(query);
            
            preparedStmt.setString(1, usuario.getUser());
            preparedStmt.setInt(2, usuario.getId());
            
            if (preparedStmt.executeUpdate() > 0) {
                res = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public boolean editarPassword(UsuarioVO usuario){
        boolean res = false;
        String query ="update Usuarios set Contrasena = ? where IdUsuario = ?";
        
        try {
            PreparedStatement preparedStmt = this.conexion.prepareStatement(query);
            
            preparedStmt.setString(1, usuario.getPassword());
            preparedStmt.setInt(2, usuario.getId());
            
            if (preparedStmt.executeUpdate() > 0) {
                res = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
    
    public boolean borrar(UsuarioVO usuario){
        boolean res = false;
        
        String query = "delete from Usuarios where IdUsuario = ?";
        try {
            PreparedStatement preparedStmt = this.conexion.prepareStatement(query);
            
            preparedStmt.setInt(1, usuario.getId());
            res = preparedStmt.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return res;
    }
}
