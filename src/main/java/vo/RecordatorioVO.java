/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author ayoro
 */
public class RecordatorioVO {
    private int idRecordatorio;
    private String fecha;
    private String hora;
    private String descripcion;

    public int getId() {
        return idRecordatorio;
    }

    public void setId(int id) {
        this.idRecordatorio = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
