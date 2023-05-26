/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cine.cine.presentation.cartelera;

import com.cine.cine.logic.*;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ramim
 */
@WebServlet(name = "carteleraController", urlPatterns = {"/presentation/cartelera/show","/presentation/cartelera/ver","/presentation/cartelera/imagen"})
public class Controller extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("model", new Model()); 
        
        String viewUrl="";
        switch(request.getServletPath()){
            case "/presentation/cartelera/show":
                viewUrl=this.show(request,response);
                break;  
            case "/presentation/cartelera/ver":
                viewUrl=this.ver(request);
                break; 
            case "/presentation/cartelera/imagen":
                viewUrl=this.getImage(request,response);
                break; 
        }
        request.getRequestDispatcher(viewUrl).forward( request, response); 
        }

    public String show(HttpServletRequest request,HttpServletResponse response){
        Service service = Service.instance();
        Model model = (Model)request.getAttribute("model");
        model.setPeliculas(service.getPeliculas());
        model.getDias().add(service.obtenerFechaActual());
        model.getDias().add(service.obtenerFechaFutura(1));
        model.getDias().add(service.obtenerFechaFutura(2));
        model.getDias().add(service.obtenerFechaFutura(3));
        return "/presentation/cartelera/View.jsp";
    }
    
    public String ver(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        Service service = Service.instance();
        String peliculaTanda = request.getParameter("tandaFld"); 
        String fecha = request.getParameter("fechaFld"); 
    
        String[] partes = peliculaTanda.split("-"); 
        String nombrePelicula = partes[0]; 
        String tanda = partes[1]; 
        List<String> tandas = new ArrayList<String>();
        tandas.add(tanda);
    
        Pelicula pelicula = service.getPelicula(nombrePelicula);
        pelicula.setFecha(fecha);
        pelicula.setTandas(tandas);
        session.setAttribute("pelicula", pelicula);
        return "/presentation/compra/show";
    }
            
    public String getImage(HttpServletRequest request, HttpServletResponse response){
        String LOCATION="C:/AAA/cine/";
        String nombre=request.getParameter("nombre");
        try{
            ServletOutputStream os=response.getOutputStream();
            FileInputStream is=new FileInputStream(LOCATION + nombre);
            is.transferTo(os);
            os.close();
            return "/presentation/cartelera/View.jsp";
        }catch(IOException ex){
            return null;
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
