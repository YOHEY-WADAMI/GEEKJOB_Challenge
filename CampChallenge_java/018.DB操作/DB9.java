/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sec18;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class DB9 extends HttpServlet {

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
            ResultSet rs = null;

            try {
                request.setCharacterEncoding("UTF-8");
                int str1 = Integer.parseInt(request.getParameter("id"));
                String str2 = request.getParameter("name");
                String str3 = request.getParameter("tel");
                int str4 = Integer.parseInt(request.getParameter("age"));
                String str5 = request.getParameter("birth");

                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "wadami", "password");
                if (con != null) {
                    out.println("接続成功しました。");
                }

                //SQL文
                ps = con.prepareStatement("insert into profiles values(?,?,?,?,?)");
                ps.setInt(1, str1);
                ps.setString(2, str2);
                ps.setString(3, str3);
                ps.setInt(4, str4);
                ps.setString(5, str5);
                int num = ps.executeUpdate();
                out.println("今回追加したレコードは" + num + "件です。");
                
                ps = con.prepareStatement("select * from profiles where profilesid = ?");
                ps.setInt(1, str1);
                rs = ps.executeQuery();
                while(rs.next()){
                    out.println("今回追加した情報は以下のとおりです。<br><br>");
                    out.println(str1 + "／" + str2 + "／" + str3 + "／" + str4 + "／" + str5 + "<br>");
                }
                

                con.close();
                ps.close();
                rs.close();
            } catch (Exception e) {
                out.print("エラーが発生しました。" + e.toString() + "<br>");
            } finally {
                if (con != null) {
                    try {
                        con.close();
                        out.println("コネクション切断に成功しました。" + "<br><br>");
                    } catch (Exception e) {
                        out.println("コネクションはありません。" + "<br><br>");
                        out.print(e.getMessage());
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
