/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sec18_12;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class Search_1 extends HttpServlet {

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
                String nm = request.getParameter("name");
                String ag = request.getParameter("age");
                String bir = request.getParameter("birthday");

                if (nm.equals("") || ag.equals("") || bir.equals("")) {
                    out.print("検索できません。<br>前の画面に戻り、検索したい内容を入力してください。");
                    return;//returnすると処理自体を終わらせられる。
                    
                } else {
                    out.print("検索を開始します。<br><br>");
                }

                Class.forName("com.mysql.jdbc.Driver").newInstance();
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge_db", "wadami", "password");

                //下記and条件で３つともヒットすれば（部分一致）。
                ps = con.prepareStatement("SELECT * from profiles WHERE name like ? and age like ? and birthday like ?");
                ps.setString(1, "%" + nm + "%");
                ps.setString(2, "%" + ag + "%");
                ps.setString(3, "%" + bir + "%");
                rs = ps.executeQuery();

                Boolean judge = false;
                while (rs.next()) {
                    int id = rs.getInt("profilesid");
                    String name = rs.getString("name");
                    String tel = rs.getString("tel");
                    int age = rs.getInt("age");
                    String birth = rs.getString("birthday");

                    out.print("情報が見つかりました。下記です。" +"<br>");
                    out.print(id + "/" + name + "/" + tel + "/" + age + "/" + birth + "<br>");

                    judge = true;
                }

                if (judge == false) {
                    out.print("ヒットしませんでした。" +"<br>");
                }

                con.close();
                ps.close();
                rs.close();

            } catch (Exception e) {
                out.print("エラーが発生しました" + e.toString() + "<br>");
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
                if (ps != null) {
                    try {
                        ps.close();
                        out.println("コネクション切断に成功しました。" + "<br><br>");
                    } catch (Exception e) {
                        out.println("コネクションはありません。" + "<br><br>");
                        out.println(e.getMessage());
                    }
                }
                if (rs != null) {
                    try {
                        rs.close();
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
