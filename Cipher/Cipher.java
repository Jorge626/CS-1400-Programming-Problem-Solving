/*
    Jorge Aranda
    CS 1400.03
    10/2/2020
    Project 1: Encryption/Decryption Utility
*/

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;

public class Cipher {
    static Scanner userInput = new Scanner(System.in);

    public static void main (String[] args) throws IOException {
        String welcomeMessage = "Welcome to My Encryption/Decryption Program";
        String menu = "Please enter the letter of your chosen operation:\n\ta) Encrypt a message\n\tb) Decrypt a message\n\tc) Exit\n";
        String inputMenu = "Enter option: ";
        String inputMessage = "Input your message: ";
        String inputFileName = "Enter filename: ";
        String errorMenu = "Invalid choice, please try again\n";
        String exitMessage = "Thank you for using my Encryption/Decryption Program!\n";
        boolean isDone = false;
        String password = "", fileName = "";
        Scanner userInput = new Scanner(System.in);

        System.out.println(welcomeMessage);
        do {
            System.out.print(menu + inputMenu);
            String input = userInput.nextLine().toLowerCase();
            if (input.compareTo("a") < 0 ||  input.compareTo("c") > 0)
                System.out.print(errorMenu);
            else {
                switch(input){
                case "a":
                    System.out.print(inputMessage);
                    String message = userInput.nextLine();
                    password = getPassword();
                    System.out.print(inputFileName);
                    fileName = userInput.nextLine();
                    createFile(message, password, fileName);
                    break;
                case "b":
                    password = getPassword();
                    System.out.print(inputFileName);
                    fileName = userInput.nextLine();
                    readFile(password, fileName);
                    break;
                case "c":
                    System.out.print(exitMessage);
                    isDone = true;
                    break;
                default: break;
                }
            }
            System.out.println();
        } while (isDone != true);
    }

    public static String encrypt(String message, String password) {
        String cipherText = "0x";
        char passwordChar, messageChar;
        int cipherChar, passwordIt = 0;

        for (int i = 0; i < message.length(); i++)
        {
            if (passwordIt == password.length() - 1)
                passwordIt = 0;
            passwordChar = password.charAt(passwordIt);
            cipherChar = message.charAt(i) ^ passwordChar;
            String hex = Integer.toHexString(cipherChar);
            if (hex.length() == 1)
                hex = "0" + hex;
            cipherText = cipherText + hex;
            passwordIt++;
        }
        return cipherText;
    }

    public static String decrypt(String ciphertext, String password) {
        String message = "", cipherDigits;
        char passwordChar;
        int cipherChar, plaintextChar, passwordIt = 0;

        for (int i = 2; i < ciphertext.length(); i += 2)
        {
            cipherDigits = ciphertext.substring(i, i + 2);
            cipherChar = Integer.parseInt(cipherDigits, 16);
            if (passwordIt == password.length() - 1)
                passwordIt = 0;
            passwordChar = password.charAt(passwordIt);
            plaintextChar = cipherChar ^ passwordChar;
            message = message + (char) plaintextChar;
            passwordIt++;
        }
        return message;
    }

    public static void createFile(String message, String password, String fileName)throws IOException {
        PrintWriter outputFile = new PrintWriter(fileName);
        String cipherText = encrypt(message, password);
        outputFile.println(cipherText);
        outputFile.close();
    }

    public static void readFile (String password, String fileName) throws IOException {
        File file = new File(fileName);
        if (!file.exists())
        {
            String errorFile = "That file doesn't exist.\nPlease enter the correct filename or press ctrl->c to exit";
            do {
                System.out.println(errorFile);
                fileName = userInput.nextLine();
                file = new File(fileName);
            } while (!file.exists());
        }
        Scanner inputFile = new Scanner(file);
        String fileText = inputFile.nextLine();
        inputFile.close();
        String message = decrypt(fileText, password);
        System.out.println(message);
    }

    public static String getPassword() {
        String inputPassword = "Input password (must be greater than 8 characters): ";
        String errorPasswordLength = "Invalid password length.\nPlease try again or press ctrl->c to quit.\n";
        System.out.print(inputPassword);
        String password = userInput.nextLine();
        if (password.length() < 9){
            do {
                System.out.print(errorPasswordLength + inputPassword);
                password = userInput.nextLine();
            } while (password.length() < 9);
        }
        return password;
    }
}

