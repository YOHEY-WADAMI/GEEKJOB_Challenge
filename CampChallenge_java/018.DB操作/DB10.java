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
public class DB10 extends HttpServlet {

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
                int id = Integer.parseInt(request.getParameter("profilesid"));

                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "wadami", "password");
                if (con != null) {
                    out.println("接続成功しました。");
                }

                ps = con.prepareStatement("delete from profiles where profilesid = ?");
                ps.setInt(1, id);
                int num = ps.executeUpdate();
                out.print("今回削除した情報は" + num + "件です。");

                // SQL文の実行
                ps = con.prepareStatement("select * from profiles");
                rs = ps.executeQuery();
                out.print("現在、登録されている情報は以下のとおりです。<br><br>");
                while (rs.next()) {
                    String pid = rs.getString("profilesid");
                    String nm = rs.getString("name");
                    String tl = rs.getString("tel");
                    String ag = rs.getString("age");
                    String bir = rs.getString("birthday");
                    
                    out.print(pid + "／" + nm + "／" + tl + "／" + ag + "／" + bir + "<br>");
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
