package pl.zycinski;

import java.io.*;

public class Vigenere {

    public static String alf = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String code="";


    public static String onlyLetters(String text) {

        String newText = "";
        for (int i = 0; i < text.length(); i++) {

            if (Character.isLetter(text.charAt(i))) {
                newText += text.charAt(i);

            }
        }

        return newText.toUpperCase();
    }





    public static String codeVigenere(String text, String password) {
        code="";
        String newText = text.toUpperCase();
        String newPassword = generetePassword(text, password);
       // newPassword = generetePassword(text,password);


        for (int i = 0; i < text.length(); i++) {
            if (Character.isLetter(text.charAt(i))|| Character.isDigit(text.charAt(i))) {
                int find =alf.indexOf(newText.charAt(i)) + alf.indexOf(newPassword.charAt(i)) ;

                if(find >=36)
                {
                    find = find - 36;
                }


                code+=alf.charAt(find);



            }
            else{
                code+=text.charAt(i);
            }
        }
        return code;
    }

    public static void fileOpen(String password) throws FileNotFoundException {



        String line;

        try {

            BufferedReader bufferreader = new BufferedReader(new FileReader("D:\\Projekty\\IntelijjProject\\OchronaDanych\\DominikZycinski\\2.SzyfrVigenere\\vigenere.txt"));

            line = bufferreader.readLine();


            while (line != null) {


                try (PrintWriter out = new PrintWriter(new FileWriter("outputVigenere.txt", true))) {
                    out.println(Vigenere.codeVigenere(line,password));
                }


                System.out.println(Vigenere.codeVigenere(line,password));

                line = bufferreader.readLine();

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void closeFiles() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("outputVigenere.txt");
        writer.print("");
        writer.close();

        PrintWriter writer2 = new PrintWriter("decryptVigenere.txt");
        writer2.print("");
        writer2.close();
    }
    public static void openFileToDecrypt(String password)
    {
        String line= "";



        try {

            BufferedReader bufferreader = new BufferedReader(new FileReader("D:\\Projekty\\IntelijjProject\\OchronaDanych\\outputVigenere.txt"));

            line = bufferreader.readLine();


            while (line != null) {

                try (PrintWriter out = new PrintWriter(new FileWriter("decryptVigenere.txt", true))) {
                    out.println(decrypt(line,password));
                }
                System.out.println( decrypt(line,password));
                line = bufferreader.readLine();

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String decrypt(String textToDecrypt,String password){


        String encrypt ="";


        String newPassword = generetePassword(textToDecrypt, password);

        for (int i = 0; i < textToDecrypt.length(); i++) {
            if (Character.isLetter(textToDecrypt.charAt(i))|| Character.isDigit(textToDecrypt.charAt(i))) {
                int find =alf.indexOf(textToDecrypt.charAt(i)) - alf.indexOf(newPassword.charAt(i)) ;


                if(find <0)
                {
                    find = find + 36;
                }

                encrypt+=alf.charAt(find);
            }
            else{
                encrypt+=textToDecrypt.charAt(i);
            }
        }

        return encrypt;

    }
    public static String generetePassword(String text, String password) {

        String newPassword="";
        int x = 0;


        for (int i = 0; i < (text.length()); i++) {

            if (Character.isLetter(text.charAt(i))|| Character.isDigit(text.charAt(i))) {

                if (x == (password.length() )) {
                    x = 0;
                }

                newPassword += password.charAt(x);
                x++;
            }
            else {
                newPassword += text.charAt(i);

            }
        }
        return newPassword.toUpperCase();
    }
}

