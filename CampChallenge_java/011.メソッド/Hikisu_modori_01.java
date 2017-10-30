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
//引数が１つのメソッドを作成してください。
//メソッドの中の処理は、３人分のプロフィール（項目は戻り値2と同様）を作成し、引数として渡された値と同じIDを持つ人物のプロフィールを返却する様にしてください。
//それ以降は課題「戻り値2」と同じ処理にしてください。
public class Hikisu_modori_01 extends HttpServlet {

    ArrayList<String> myprofile(int num) {
        if (num == 1) {
            ArrayList<String> data = new ArrayList<String>();
            data.add("1 ");
            data.add("wadami ");
            data.add("1988/05/24 ");
            data.add("tokyo");

            return data;
        } else if (num == 2){
            ArrayList<String> data = new ArrayList<String>();
            data.add("2 ");
            data.add("arai ");
            data.add("1988/01/01 ");
            data.add("kanagawa");
            
            return data;
        } else if (num == 3){
            ArrayList<String> data = new ArrayList<String>();
            data.add("3 ");
            data.add("tanaka ");
            data.add("2000/01/01 ");
            data.add("chiba");
            
            return data;
        }else{
            ArrayList<String> data = new ArrayList<String>();
            data.add("想定外");
            return data;
        }
        
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
            /* TODO output your page here. You may use following sample code. */

            ArrayList<String> array = myprofile(1);
            for (int i = 0; i < array.size(); i++) {
                if (i == 0) {
                    continue;
                }
                out.print(array.get(i));
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
