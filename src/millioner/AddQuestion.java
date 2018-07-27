/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package millioner;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Arslan
 */
public class AddQuestion {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Arslan\\Documents\\NetBeansProjects\\Millioner\\src\\files\\Question.txt";
        File doc = new File(path);
        FileWriter fw = new FileWriter(doc, true);
        
        Scanner in = new Scanner(System.in);
        String question = "";
        String answer = "";
        while(true){
            System.out.println("Write your answer or write #stop");
            question = in.nextLine();
            if(question.equals("#stop")){
                break;
            }
            fw.write(" "+System.lineSeparator()+question + System.lineSeparator());
            System.out.println("Write right answer");
            answer = in.nextLine();
            fw.write(answer + System.lineSeparator());
            System.out.println("Write not right answers with ';' as separator");
            answer = in.nextLine();
            fw.write(answer);
            fw.close();
            
        }
    
    }
}
