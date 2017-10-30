/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
//課題「引数、戻り値2」の処理において、Integer limit=2を用意し、limitを利用して２名のプロフィール表示までで停止する様に処理を実装してください。
public class Hikisu_modori_03 extends HttpServlet {

    ArrayList<String[]> prof() {
        String[] wadami = {"1", "wadami", "1988/05/24", "tokyo"};
        String[] arai = {"2", "arai", "1988/01/01", "kanagawa"};
        String[] soeda = {"3", "soeda", "2000/01/01", null};

        ArrayList<String[]> array = new ArrayList<String[]>();
        array.add(wadami);  //array0番目　wadami
        array.add(arai);
        array.add(soeda);

        return array;

    }

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

            ArrayList<String[]> str = prof();
            Integer limit = 2;

            for (int i = 0; i < limit; i++) {
                for (int j = 1; j < 4; j++) {
                    if (str.get(i)[j] == null) {
                        continue;
                    }
                    out.print(str.get(i)[j] + " ");
                }
                out.print("<br>");
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
