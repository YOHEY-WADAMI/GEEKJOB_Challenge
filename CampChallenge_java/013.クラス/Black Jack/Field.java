package BlackJack;

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
public class Field extends HttpServlet {

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
            //BlackJackを全自動で実施し勝敗を決める
            
            out.print("Let's Start!<br>ブラックジャックを始めましょう！<br><br>");
            //[38.39行]Dealer/Userのインスタンスを生成
            Dealer dealer = new Dealer();
            User user = new User();

            //ArrayList temp = dealer.deal();
            //dealer.setCard(temp);
            //↑は　↓と同じ意味
            dealer.setCard(dealer.deal());
            
            //deal()で処理したカードをsetCardにセットしてsetCard()の処理でmyCardに加える
            user.setCard(dealer.deal());
            //
            out.print("開始時<br>");
            //↑で処理した結果を　↓で表示
            
            out.print("User:" + user.myCards + "<br>");
            out.print("Dealer" + dealer.myCards + "<br>");
            out.print("");

            while (user.checkSum()) {
                user.setCard(dealer.hit());
            }
            while (dealer.checkSum()) {
                dealer.setCard(dealer.hit());
            }

            out.print("<br>結果<br>");
            out.print("Dealer:" + dealer.open() + "<br>");
            out.print("手札:" + dealer.myCards + "<br>");
            out.print("" + "<br>");
            out.print("User:" + user.open() + "<br>");
            out.print("手札:" + user.myCards + "<br>");
            out.print("" + "<br>");

            out.print("~~~~~~~~~~~~~~~~~~>>結果発表");

            if (dealer.open() == user.open()) {
                out.print("引き分け");
            } else if (dealer.open() > 21 && user.open() > 21) {
                out.print("Dealerの勝ち");
            } else if (user.open() > 21) {
                out.print("Dealerの勝ち");
            } else if (dealer.open() > 21) {
                out.print("Userの勝ち");
            } else if (dealer.open() == 21) {
                out.print("Dealerの勝ち");
            } else if (user.open() == 21) {
                out.print("Userの勝ち");
            } else if (dealer.open() > user.open()) {
                out.print("Dealerの勝ち");
            } else if (user.open() > dealer.open()) {
                out.print("Userの勝ち");
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
