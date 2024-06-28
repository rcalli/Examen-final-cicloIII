
package pe.edu.upeu.oracle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Docente
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuariLogin {
    private int idusuario;
    private String username;
    private String rol;
    private String nombrep;
    private String url;
    private String icono;
}
