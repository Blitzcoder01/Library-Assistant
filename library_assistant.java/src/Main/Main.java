package Main;

import read.read;
import search.search;
import speech.speech;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws IOException ,Exception {
        Scanner sc = new Scanner(System.in);
        speech speak=new speech();
        speak.voice("kevin16");
        System.out.println("@@@@@----Library Assistant----@@@@@");
        System.out.println("Hi there! I am Lorex, your Library Assistant Helper.\n Tell me your name?");
        speak.doSpeak("Hi there! I am Lorex, your Library Assistant Helper.\n Tell me your name?");
        String name=sc.nextLine();
        while(true) {
            System.out.println("Hello there! " + name + " ,are you a student or a faculty of GLA University");
            speak.doSpeak("Hello there! " + name + " ,are you a student or a faculty of GLA University");
            System.out.println("1>> press s/S if you are a Student");
            System.out.println("2>> press f/F if you are a Faculty");
            System.out.print("your choice:");
            String choice = sc.nextLine();
            try {
                if (choice.equals("s") || choice.equals("S")) {
                    System.out.println(name + " I can help you in searching any book which is present in this library.");
                    speak.doSpeak(name + " I can help you in searching any book which is present in this library.");
                    System.out.println("Do you want to search for a Book?");
                    speak.doSpeak("Do you want to search for a Book");
                    System.out.println("1>> press y/Y for proceed");
                    System.out.println("2>> press n/N for cancel the search");
                    System.out.print("your choice:");
                    String choice2 = sc.nextLine();
                    try {
                        if (choice2.equals("y") || choice2.equals("Y")) {
                            System.out.println("Make sure that the name of the book must be correct");
                            speak.doSpeak("Make sure that the name of the book must be correct");
                            search sh = new search();
                            sh.search();
                        } else if (choice2.equals("n") || choice2.equals("N")) {
                            System.out.println("successfully exit..");
                            System.out.println("Have a nice one!!");
                            speak.doSpeak("Have a nice one");

                        } else {
                            System.out.println("wrong input");
                            break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("wrong input,you are asked to type string value only");
                        break;
                    }

                } else if (choice.equals("f") || choice.equals("F")) {
                    System.out.println("How can I help you?");
                    speak.doSpeak("How can I help you?");
                    sc.nextLine();
                    System.out.println("1>> press 1 for read whole file");
                    System.out.println("2>> press 0 for search for a book");
                    System.out.print("your choice:");
                    int choice3 = sc.nextInt();

                    if (choice3 == 1) {
                        System.out.println("whole database is:");
                        read ob = new read();
                        ob.read();
                    } else if (choice3 == 0) {
                        System.out.println("Make sure that the name of the book must be correct");
                        speak.doSpeak("Make sure that the name of the book must be correct");
                        search sh = new search();
                        sh.search();
                    } else {
                        System.out.println("wrong input");
                        break;

                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("wrong input,you are asked to type string value only");
                break;
            }
        }

    }
}
