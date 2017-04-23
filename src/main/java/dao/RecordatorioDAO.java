/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Conexion;
import vo.RecordatorioVO;

/**
 *
 * @author ayoro
 */
public class RecordatorioDAO {
    private Connection conexion;

    public RecordatorioDAO() {
        try {
            this.conexion = Conexion.getConnection();
        } catch (URISyntaxException ex) {
            Logger.getLogger(RecordatorioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public boolean insertar(RecordatorioVO recordatorio) {
        boolean resultado = false;
        try {
            //1.Establecer la consulta
            String consulta = "INSERT INTO Recordatorios VALUES(?,?,?,?)";
            //2. Crear el PreparedStament
            PreparedStatement statement
                    = this.conexion.prepareStatement(consulta);
            //-----------------------------------
            statement.setInt(1, recordatorio.getId());
            statement.setString(2, recordatorio.getFecha());
            statement.setString(3, recordatorio.getHora());
            statement.setString(4, recordatorio.getDescripcion());
            //--------------------------------------
            //3. Hacer la ejecucion
            resultado = statement.execute();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return resultado;
    }
    
    public ArrayList listarTodo(){
       //1.Consulta
       ArrayList respuesta = new ArrayList();
       String consulta ="SELECT * FROM Recordatorios";
        try {
            //----------------------------
            //Statement
            Statement statement =
                    this.conexion.createStatement();
            //Ejecucion
            ResultSet resultado = 
                    statement.executeQuery(consulta);
            //----------------------------
            //Recorrido sobre el resultado
            while(resultado.next()){
                int id = resultado.getInt("IdRecordatorios");
                respuesta.add(id);
                Date fecha = resultado.getDate("FechaRecordatorios");
                respuesta.add(fecha);
                Time hora = resultado.getTime("Hora");
                respuesta.add(hora);
                String descripcion = resultado.getString("Descripcion");
                respuesta.add(descripcion);
            }
        statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return respuesta;
    }
    
    public boolean editar(RecordatorioVO recordatorio) {
        boolean result = false;
        String query = "update Recordatorios set FechaRecordatorios = ?, Hora = ?, Descripcion = ? where IdRecordatorios = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = this.conexion.prepareStatement(query);
            preparedStmt.setString(1, recordatorio.getFecha());
            preparedStmt.setString(2, recordatorio.getHora());
            preparedStmt.setString(3, recordatorio.getDescripcion());
            preparedStmt.setInt(4, recordatorio.getId());
            if (preparedStmt.executeUpdate() > 0) {
                result = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public boolean borrar(RecordatorioVO recordatorio) {
        boolean result = false;
        String query = "delete from Recordatorios where IdRecordatorios = ?";
        PreparedStatement preparedStmt = null;
        try {
            preparedStmt = this.conexion.prepareStatement(query);
            preparedStmt.setInt(1, recordatorio.getId());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}

