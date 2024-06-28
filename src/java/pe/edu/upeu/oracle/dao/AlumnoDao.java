/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.oracle.dao;

import java.util.List;
import pe.edu.upeu.oracle.entity.Alumno;

/**
 *
 * @author Usuario
 */
public interface AlumnoDao {
        public int createAlumno(Alumno alumno);
    public int updateAlumno(Alumno alumno);
    public int deleteAlumno(int id);
    public Alumno readAlumno(int id);
    public List<Alumno> readAllAlumno();
    
}
