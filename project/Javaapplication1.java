
package algo.project;

import java.util.HashMap;
import java.util.Scanner;

public class Javaapplication1 {

    Scanner input = new Scanner(System.in);
    public static boolean dicission;
    private  static String encrypt;
    public static HashMap<String, Character> tree;
    private static String encooder(String orgStr) {

        Huffman h = new Huffman(orgStr);
        String e = h.encode();
        HashMap<String, Character> huffman_tree = h.huffmanTree();
        value_set(e,huffman_tree);
        return e;
    }

    private  static void decooder(String orgStr) {
        Decoder h = new Decoder(orgStr,tree);
        String d = h.decode();
        System.out.println("Your Message: " + d + "\n");
        
    }


    public static boolean matchPass(String pass, int option) {
        if ("111011101000".equals(pass) && option == 1) {
            return true;
        } else return "000111010111".equals(pass) && option == 2;

    }

    public  static boolean login(String password, int select_option) {
       
        while (true) {
            switch (select_option) {
                case 1: {
                    
                    Huffman huff = new Huffman(password);
                    String pass = huff.encode();
                    
                    return matchPass(pass, select_option);
                }
                case 2: {
                    
                    Huffman huff = new Huffman(password);
                    String pass = huff.encode();
                    boolean dicision = matchPass(pass, select_option);
                    return dicision;
                }
                
            }
        }

    }
    private static void value_set(String message,HashMap<String, Character> tree)
        {
           Javaapplication1.encrypt = message;
           Javaapplication1.tree    = tree;
        }
    public static void main(String[] args) {
        System.out.println("*********Wellcome To Sectrect Chat*************\n");
        
        while(true)
        {
         Scanner input = new Scanner(System.in);
         
        System.out.println("Login as: \n1.Sender \n2.Receiver");
        int option = input.nextInt(); 
        Scanner input2 = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter Your login Password: ");
            String password = input2.nextLine();
            dicission = login(password, option);
            if(dicission == true && option == 1)
            {
                System.out.println("You Have Successfully Login As Sender\n");
                break;
            }
            else if(dicission == true && option == 2)
            {
                System.out.println("You Have Successfully Login As Receiver\n");
                break;
            }
            else
            {
                System.out.println("You Have Enter A Wrong Password!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! \n Enter Your Password Again\n");
                
                continue;
            }
        }
        
        switch (option)
        {
            case 1:
                if(dicission == true)
                {
                    System.out.println("Write Your message: ");
                    Scanner input3 = new Scanner(System.in);
                    String message = input3.nextLine();
                    String encrypted = encooder(message);  
                    System.out.println("You Have Successfully Sent Your Message :) :) :) \n\n ");
                    continue;
                }
            case 2:
                if(dicission == true)
                {
                    System.out.println("Encypted message: "+ encrypt);
                    System.out.println("Huffman Tree: "+tree.toString());
                    decooder(encrypt);
                    System.out.println("\n\n-----Done-----");
                    break;
                }
            

        }
        break;

    }
        
 }
}
