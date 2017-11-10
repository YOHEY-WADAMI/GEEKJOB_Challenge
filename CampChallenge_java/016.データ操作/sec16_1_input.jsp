<%-- 
    Document   : _16_1_1
    Created on : 2017/11/10, 13:02:15
    Author     : guest1Day
--%>

<!--以下の入力フィールドを持ったHTMLを、Javaで処理する想定で記述してください。
・名前（テキストボックス）、性別（ラジオボタン）、趣味（複数行テキストボックス）-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>サンプルコード</title>
    </head>
    <body>
        <form action="output.jsp" method="post">            
            <!-- formタグで括られた入力項目はこれら -->
            【氏名】<input type="text" name="name"><br><br>
<!--            value=""とするのは外部入力する文字がないためあらかじめ指定してあげるため。-->
            【性別】<input type="radio" name="gender" value="男">男
            <input type="radio" name="gender" value="女">女
            <input type="radio" name="gender" value="その他">その他<br><br>
            【趣味】<br>
            <textarea name="hobby" cols="50" rows="10"></textarea><br><br>
            <!--cols横幅、rows縦幅-->
            <input type="submit" name="btnSubmit" value="送信">
            <input type="reset" name="rstSubmit" value="リセット">
    </body>
</html>
