/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sec18_11;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class Update extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Connection con = null;
            PreparedStatement ps = null;
            
            try {
                request.setCharacterEncoding("UTF-8");
                
                int id = Integer.parseInt(request.getParameter("profilesid"));
                String name = request.getParameter("name");
                String tel = request.getParameter("tel");
                int age = Integer.parseInt(request.getParameter("age"));
                String birth = request.getParameter("birthday");
                
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "wadami", "password");
                
                ps = con.prepareStatement("UPDATE profiles set name =?,tel =?,age =?,birthday =? WHERE profilesid =?");
                ps.setString(1, name);
                ps.setString(2, tel);
                ps.setInt(3, age);
                ps.setString(4, birth);
                ps.setInt(5, id);
                ps.executeUpdate();
                
//                String record = name +"/" +tel +"/" +age +"/" +birth;
                out.println("処理が完了しました。"+"<br>");
//                out.println(record);

                con.close();
                ps.close();

            } catch (Exception e) {
                out.println("エラーが発生しました。" + e.toString() + "<br>");

            } finally {
                if (con != null) {
                    try {
                        con.close();
                        out.println("コネクション切断に成功しました。" + "<br><br>");
                    } catch (Exception e) {
                        out.println("コネクションはありません。" + "<br><br>");
                        out.println(e.getMessage());
                    }
                }
            }
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
