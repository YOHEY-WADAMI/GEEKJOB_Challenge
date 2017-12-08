package jums;

import base.UserDataBeans;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * insertconfirm.jspと対応するサーブレット フォーム入力された情報はここでセッションに格納し、以降持ちまわることになる
 * 直接アクセスした場合はerror.jspに振り分け
 *
 * @author hayashi-s
 */
public class InsertConfirm extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        try {
            //直リンク防止
            HttpSession session = request.getSession();
            request.setCharacterEncoding("UTF-8");//セッションに格納する文字コードをUTF-8に変更
            String accesschk = request.getParameter("ac");
            if (accesschk == null || (Integer) session.getAttribute("ac") != Integer.parseInt(accesschk)) {
                throw new Exception("不正なアクセスです");
            }

            //フォームからの入力を取得
            String name = request.getParameter("name");
            String year = request.getParameter("year");
            String month = request.getParameter("month");
            String day = request.getParameter("day");
            String type = request.getParameter("type");
            String tell = request.getParameter("tell");
            String comment = request.getParameter("comment");

            if (!name.equals("") && !year.equals("") && !month.equals("") && !day.equals("") && !type.equals("") && !tell.equals("") && !comment.equals("")) {

                //beansを使いデータを格納保持
                UserDataBeans udb = new UserDataBeans();
                udb.setName(name);
                udb.setYear(year);
                udb.setMonth(month);
                udb.setDay(day);
                udb.setType(type);
                udb.setTell(tell);
                udb.setComment(comment);

                //beansをセッションに格納
                session.setAttribute("udb", udb);

                session.setAttribute("ac", (int) (Math.random() * 1000));
                request.getRequestDispatcher("/insertconfirm.jsp").forward(request, response);

            } else {
                //未入力だった時の処理
                //文字連結で作成
                String msg = "";

                //msg の中身を入れる処理
                if (name.equals("")) {
                    msg += "名前 ";
                }

                if (year.equals("")) {
                    msg += "年 ";
                }

                if (month.equals("")) {
                    msg += "月 ";
                }

                if (day.equals("")) {
                    msg += "日 ";
                }

                if (type.equals("")) {
                    msg += "種別 ";
                }

                if (tell.equals("")) {
                    msg += "電話番号 ";
                }

                if (comment.equals("")) {
                    msg += "自己紹介";
                }
                msg += "が未入力です！";
                request.setAttribute("msg", msg);
                request.getRequestDispatcher("/insert.jsp").forward(request, response);
            }

        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(InsertConfirm.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(InsertConfirm.class.getName()).log(Level.SEVERE, null, ex);
        }
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
