/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import com.umariana.mavenproject1.ControlTareas;
import com.umariana.mavenproject1.Tarea;
import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author valentina
 */
@WebServlet(name = "SvEditar", urlPatterns = {"/SvEditar"})
public class SvEditar extends HttpServlet {

   
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
        HttpSession session = request.getSession(false);
        String nombreUsuario = (String) session.getAttribute("nombre_usuario");
        
        String titulo= request.getParameter("titulo");
        String descripcion= request.getParameter("descripcion");
        String fecha= request.getParameter("fecha");        
        String id= request.getParameter("id"); 
        System.out.println("Tarea a dvsfhjkafgaaagagagagagagagagaa "+id);
        
        Tarea aEditar = ControlTareas.buscarTareaPorId(id);
        

        ControlTareas.editarTarea(aEditar, titulo, descripcion, fecha, context, nombreUsuario);
        
        session.setAttribute("tareas", ControlTareas.obtenerTodasLasTareas());
        
        request.getRequestDispatcher("templates/listas.jsp").forward(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
