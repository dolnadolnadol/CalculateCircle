/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sarun
 */
public class circle extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    public void init()
            throws ServletException {
        System.out.println("Init"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy() {
        System.out.println("Destroy"); //To change body of generated methods, choose Tools | Templates.
    }
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String radiusStr = request.getParameter("radius");
        double radiusd = Double.parseDouble(radiusStr);
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet Circle</title>");  
        out.println("</head>");
        if(request.getParameter("submit").equals("Area")){
            double area = Math.PI * (radiusd * radiusd);
            try {            
                out.println("<body>");
                out.println("<h1> For the circle with radius = " + radiusd + "</h1>");
                out.println("<h1> area is " +area+ "</h1>");
                out.println("</body>");
            } finally {            
                out.close();
            }
        }else if(request.getParameter("submit").equals("Perimeter")){
            double peri = 2* Math.PI *radiusd;
            try {
                out.println("<body>");
                out.println("<h1> For the circle with radius = " + radiusd + "</h1>");
                out.println("<h1> Perimeter is " +peri+ "</h1>");
                out.println("</body>");
            } finally {            
                out.close();
            }
        }
        out.println("</html>");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
