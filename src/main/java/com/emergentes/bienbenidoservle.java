
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "bienbenidoservle", urlPatterns = {"/bienbenidoservle"})
public class bienbenidoservle extends HttpServlet {

    
   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int ver ;
        ver=0;
        
        Cookie[] cokis = request.getCookies(); 
        if (cokis != null){
         for( Cookie c : cokis){
             if(c.getName().equals("visitas")){
                 ver = Integer.parseInt(c.getValue());
             }
         }
        }
        ver ++;
        Cookie c = new Cookie("visitas",Integer.toString(ver));
        c.setMaxAge(30);
        response.addCookie(c);
        
        if (ver >1)
        {
        response.setContentType("text/html");
        
        PrintWriter out= response.getWriter();
        out.println("GRACIAS POR VISITARNOS NUEVAMENTE");
        }else{
            
        response.setContentType("text/html");
        
        PrintWriter out= response.getWriter();
        out.println("BIENVENIDO A LA AL SITIO WEB" );
        }
       
        
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
