/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package 文字列;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author guest1Day
 */
public class kakidashi {
    public static void main(String[] args) throws IOException{
        File fp = new File("test.txt");
        FileWriter fw = new FileWriter(fp,false);
        fw.write("和田見洋平です。よろしくお願いします。\n");
        fw.close();
    }
    
}
