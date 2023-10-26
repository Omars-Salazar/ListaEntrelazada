
package servlet;

import com.umariana.mavenproject1.ControlUsuario;
import com.umariana.mavenproject1.Usurios;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author valentina
 */
@WebServlet(name = "SvRegistrar", urlPatterns = {"/SvRegistrar"})
public class SvRegistrar extends HttpServlet {
    
    ArrayList<Usurios> UsuarioIngresar= new ArrayList<>();
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                
                String cedula = request.getParameter("cedula");
                String nombre= request.getParameter("usuario");
                String contrasenia = request.getParameter("contrasenia");
                ServletContext context= getServletContext();
                Usurios usuario = new Usurios(cedula, nombre, contrasenia);
 
                System.out.println("si se pudo "+nombre + cedula );
  
                String nombreUsuario = ControlUsuario.verificarUsuarioCreado(nombre, contrasenia, context);
                System.out.println("holi: "+nombreUsuario);
                if(nombreUsuario==null){
                    UsuarioIngresar.add(usuario);
                    ControlUsuario.guardarUsuarios(UsuarioIngresar , context);
                    String script = "<script>alert('Se ha registrado exitosamente.'); window.location.href = 'index.jsp?nombreUsuario=" + nombreUsuario + "';</script>";
                    response.setContentType("text/html");
                    response.getWriter().write(script);
                }else{
                    //String nombreUsuario = nuevoUsuario.getNombre_usuario();
                    String script = "<script>alert('el usuario ya se ha registrado previamente.'); window.location.href = 'index.jsp?nombreUsuario=" + nombreUsuario + "';</script>";
                    response.setContentType("text/html");
                    response.getWriter().write(script);
                }
                
               
                
                

    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
