
package Servlet;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ConsultaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        try{
          PrintWriter out = response.getWriter();
          Class.forName("com.mysql.cj.jdbc.Driver");
          String url = "jdbc:mysql://localhost/Platillos?user=root&password=mysqladmin";
          Connection connect = DriverManager.getConnection(url);
          Statement statement = connect.createStatement();
          String query = "SELECT * FROM platos ORDER BY id_platos DESC";
          ResultSet rs = statement.executeQuery(query);
          
          JsonObject gson = new JsonObject();
          JsonArray jarray = new JsonArray();
          while(rs.next()) {
              int id_platos = rs.getInt("id_platos");
              String nombre = rs.getString("nombre");
              double precio = rs.getDouble("precio");
              String categoria = rs.getString("categoria");
              gson = new JsonObject();
              gson.addProperty("id_platos",id_platos);
              gson.addProperty("nombre",nombre);
              gson.addProperty("precio",precio);
              gson.addProperty("categoria",categoria);
              
              jarray.add(gson);
              
          }
          out.print(jarray.toString());
          
        }catch(Exception e) {
            System.out.println(e);
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
