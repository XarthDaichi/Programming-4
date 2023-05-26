/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.cine.cine.presentation.comprado;

import com.cine.cine.presentation.encontrado.*;
import com.cine.cine.presentation.cartelera.*;
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

/**
 *
 * @author ramim
 */
@WebServlet(name = "compradoController", urlPatterns = {"/presentation/comprado/show","/presentation/comprado/imagen"})
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("model", new Model()); 
        
        String viewUrl="";
        switch(request.getServletPath()){
            case "/presentation/comprado/show":
                viewUrl=this.show(request);
                break;
            case "/presentation/comprado/imagen":
                viewUrl=this.getImage(request,response);
                break;  
        }
        request.getRequestDispatcher(viewUrl).forward( request, response); 
    }
    
    public String show(HttpServletRequest request){
        Service service = Service.instance();
        HttpSession session = request.getSession();
        Model model = (Model)request.getAttribute("model");
        model.setTicket((Ticket)session.getAttribute("ticket"));
        session.removeAttribute("ticket");
        model.setPelicula(model.getTicket().getPelicula());
        request.setAttribute("model", model);
        return "/presentation/comprado/View.jsp";
    }
    
    public String getImage(HttpServletRequest request, HttpServletResponse response){
        String LOCATION="C:/AAA/cine/";
        String nombre=request.getParameter("nombre");
        try{
            ServletOutputStream os=response.getOutputStream();
            FileInputStream is=new FileInputStream(LOCATION + nombre);
            is.transferTo(os);
            os.close();
            return "/presentation/comprado/View.jsp";
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
