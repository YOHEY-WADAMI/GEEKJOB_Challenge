/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */

//1. ３つの引数を持ち、渡された数値で掛け算をするメソッドを作成します。
//メソッドは、１つ目の引数と２つ目の引数を掛け算し、３つ目の引数がtrueの場合は結果を２乗させてください。
//また、２つ目の引数は5、３つ目の引数はfalseをデフォルト値として設定してください。
//2. 作成したメソッドを呼び出し、結果を表示してください。
public class Hikisu_02 extends HttpServlet {
    
    void kakezan(int num1 , int num2, boolean hantei, PrintWriter pw){
        int sum = num1*num2;
        pw.print(num1 +"と" +num2);
        pw.print("の掛け算：" +sum +"<br>");
        
        if( hantei == false){
            pw.print(sum +"の乗算：" +(sum*sum)+"<br><br>" );
        }
        
    }
    void kakezan(int num1,PrintWriter pw){
        kakezan(num1,5,false,pw);
    }
            
    void kakezan(int num1,int num2,PrintWriter pw){
        kakezan(num1,num2,false,pw);
    }
    
    void kakezan(int num1, boolean hantei, PrintWriter pw){
        kakezan(num1,2,hantei,pw);
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
            
            kakezan(2,out);
            kakezan(3,8,out);
            kakezan(7,true,out);
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
