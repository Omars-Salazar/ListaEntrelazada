
package servlet;

import com.umariana.mavenproject1.ControlTareas;
import com.umariana.mavenproject1.ControlUsuario;
import com.umariana.mavenproject1.Tarea;
import com.umariana.mavenproject1.Usurios;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
/**
 *
 * @author omar salazar
 */
@WebServlet(name = "SvVerificar", urlPatterns = {"/SvVerificar"})
public class SvVerificar extends HttpServlet {

    public Usurios usuarioActivo;

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
                ServletContext context = getServletContext();
                String nombre= request.getParameter("email");
                String contrasenia = request.getParameter("contra");
                System.out.println("nombre: "+ nombre);
                System.out.println("contraseña " + contrasenia);
                String nombreUsuario = ControlUsuario.verificarUsuarioCreado(nombre, contrasenia, context);
                System.out.println("nombre usuario "+nombreUsuario);
                List<Tarea>  tareasUsuarioActivo= new ArrayList<>();
                
                Usurios usuarioActivo = ControlUsuario.obtenerUsuarioActivo( nombre, contrasenia, context);
                
                if(nombreUsuario!=null){
                       HttpSession session = request.getSession();
                       
                       session.setAttribute("nombre_usuario", nombreUsuario);
                      
                       session.setAttribute("cedula_usuario", contrasenia);
                                       
                        ControlTareas.cargarTareasDesdeArchivo(context, nombreUsuario);
                        //tareasUsuarioActivo=ControlTareas.cargarTareasDesdeArchivo(context, nombreUsuario);
                        // Guarda las tareas en la sesión para que estén disponibles en tu JSP
                        System.out.println("control ver tareas: "+ControlTareas.obtenerTodasLasTareas());
                        session.setAttribute("tareas", ControlTareas.obtenerTodasLasTareas());

                       
                      
                       request.setAttribute("nombre_usuario", nombreUsuario);
                    
                       request.getRequestDispatcher("/templates/listas.jsp").forward(request, response);

                   }else{
                       System.out.println("usuario incorrecto");
                       String script = "<script>alert('Usuario incorrecto'); window.location.href = 'index.jsp?nombre_usuario=" + nombreUsuario + "';</script>";
                       response.setContentType("text/html");
                       response.getWriter().write(script);
                     //  request.getRequestDispatcher("index.jsp").forward(request, response);
                   }
              
                
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
