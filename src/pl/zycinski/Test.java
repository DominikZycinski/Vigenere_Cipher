package pl.zycinski;

import java.io.IOException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) throws IOException {

        String password = "10Z";



        System.out.println("Would you like to encrypt(1) or decrypt(2) your text? ");
        Scanner scanner = new Scanner(System.in);
        String id = scanner.next();

            switch (id) {

                case ("1"): {
                    System.out.println("Encrypt Text");
                    Vigenere.fileOpen(password);
                    break;
                }
                case ("2"): {
                    System.out.println("Decrypt Text");
                    Vigenere.openFileToDecrypt(password);
                    break;
                }

            }

        System.out.println("Would you like to exit the program?");
        Scanner scanner1 = new Scanner(System.in);
        String id1 = scanner.next();

        Vigenere.closeFiles();


    }
}
