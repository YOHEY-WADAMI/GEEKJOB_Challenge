/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sec18_11;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class Search extends HttpServlet {

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
//                if (con != null) {
//                    out.println("接続成功しました。");
//                }

                ps = con.prepareStatement("SELECT * from profiles WHERE profilesid =?");
                ps.setInt(1, id);
                rs = ps.executeQuery();

                String pid = null;
                String nm=null;
                String tl=null;
                String ag=null;
                String bir=null;
                
                while (rs.next()) {
                    pid = rs.getString("profilesid");
                    nm = rs.getString("name");
                    tl = rs.getString("tel");
                    ag = rs.getString("age");
                    bir = rs.getString("birthday");
                }

                request.setAttribute("record", nm + "/" + tl + "/" + ag + "/" + bir);
                request.setAttribute("id", pid);
                final String result = "./Sec18_11/confirm.jsp";

                RequestDispatcher rd = request.getRequestDispatcher(result);//resultを引数にインスタンス生成
                rd.forward(request, response);//forwardメソッドを使ってjspを呼び出す

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
