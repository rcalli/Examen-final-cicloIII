
package pe.edu.upeu.oracle.test;

import com.google.gson.Gson;
import pe.edu.upeu.oracle.config.Conexion;
import pe.edu.upeu.oracle.dao.AlumnoDao;
import pe.edu.upeu.oracle.dao.RolDao;
import pe.edu.upeu.oracle.dao.UsuarioDao;
import pe.edu.upeu.oracle.daoImpl.AlumnoDaoImpl;
import pe.edu.upeu.oracle.daoImpl.RolDaoImpl;
import pe.edu.upeu.oracle.daoImpl.UsuarioDaoImpl;
import pe.edu.upeu.oracle.entity.Alumno;

/**
 *
 * @author Docente
 */
public class Test {
static AlumnoDao rdao = new AlumnoDaoImpl();
static UsuarioDao udao = new UsuarioDaoImpl();
static Gson g = new Gson();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        if(Conexion.getConexion()!=null){
            System.out.println("Conectado");
        }else{
            System.out.println("no conectado");
        }
        //System.out.println(rdao.createAlumno(new Alumno("pruebanombre","PRUEBAapellido","prueba correo",1,1)));
        //System.out.println(rdao.updateRol(new Alumno(21,"PRUEBA2",1)));
        //System.out.println(rdao.deleteRol(21));
        //System.out.println(g.toJson(rdao.readRol(21)));
        //System.out.println(g.toJson(rdao.readAllRol()));
        //System.out.println(g.toJson(udao.login("rofriz", "123")));
    }
    
}
