
package pe.edu.upeu.oracle.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.oracle.config.Conexion;
import pe.edu.upeu.oracle.dao.AlumnoDao;
import pe.edu.upeu.oracle.entity.Alumno;

/**
 *
 * @author Usuario
 */
public class AlumnoDaoImpl implements AlumnoDao {
    private PreparedStatement ps;
private ResultSet rs;
private Connection cx= null;

    @Override
    public int createAlumno(Alumno alumno) {
           
        String SQL= "INSERT INTO alumno (nombres,apellidos,correo,telefono,idescuela,) VALUES(?,?,?,?,?)";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, alumno.getNombres());
            ps.setString(2, alumno.getApellidos());
            ps.setString(3, alumno.getCorreo());
            ps.setInt(4, alumno.getTelefono());
            ps.setInt(5, alumno.getIdescuela());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;
      }

    @Override
    public int updateAlumno(Alumno alumno) {
        String SQL= "UPDATE alumno SET idalumno=sq_alumno.NEXTVAL , nombres=?,apellidos=?,correo=?,telefono=?,idescuela=?, WHERE idalumno=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, alumno.getNombres());
            ps.setString(2, alumno.getApellidos());
            ps.setString(3, alumno.getCorreo());
            ps.setInt(4, alumno.getTelefono());
            ps.setInt(5, alumno.getIdescuela());
            ps.setInt(6, alumno.getIdalumno());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x;   }

    @Override
    public int deleteAlumno(int id) {
        String SQL= "DELETE FROM WHERE idrol=?";
        String SQL1= "UPDATE rol SET estado=0 WHERE idrol=?";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL1);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return x; }

    @Override
    public Alumno readAlumno(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Alumno> readAllAlumno() {
        List<Alumno> lista = new ArrayList<>(); 
        String SQL= "SELECT *FROM alumno";
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Alumno alumno =new Alumno(); 
                alumno.setIdalumno(rs.getInt("idalumno"));
                alumno.setNombres(rs.getString("nombres"));
                alumno.setApellidos(rs.getString("apellidos"));
                alumno.setCorreo(rs.getString("correo"));
                alumno.setTelefono(rs.getInt("telefono"));
                alumno.setIdescuela(rs.getInt("idescuela"));
                lista.add(alumno);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        
        return lista; }
    
}
