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
public class DB8 extends HttpServlet {

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
                String str = request.getParameter("search"); //strに代入して使えるようにセット。

                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "root", "");

                ps = con.prepareStatement("select * from profiles where name like ? ");

                //setStringで上記sqlのパラメータに代入するときは''で囲まれるので記述の必要はない
                ps.setString(1, "%" + str + "%");

                rs = ps.executeQuery();

                while (rs.next()) {
                    int id = rs.getInt("profilesid");
                    String name = rs.getString("name");
                    String tell = rs.getString("tel");
                    int age = rs.getInt("age");
                    String birth = rs.getString("birthday");
                    out.print("ID：" + id + "<br>名前：" + name + "<br>電話番号：" + tell + "<br>年齢：" + age + "<br>誕生日：" + birth +"<br><br>");
                }

                con.close();
                ps.close();
                rs.close();

            } catch (Exception e) {
                out.print("エラーが発生しました。" + e.toString());
            } finally {
                if (con != null) {
                    try {
                        con.close();
                        out.println("コネクション切断に成功しました。");
                    } catch (Exception e) {
                        out.println("コネクションはありません。");
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
