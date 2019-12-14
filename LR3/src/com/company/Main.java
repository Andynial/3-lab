package com.company;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<User>();
        ArrayList<String> instruments = new ArrayList<String>();
        User currentUser = new User("Andy", "andynial", "1234");
        users.add(currentUser);

        instruments.add("wrench");
        instruments.add("hammer");
        instruments.add("nails");

        Scanner in = new Scanner(System.in);
        String login, password;
        System.out.print("Введите логин: "); //andynial
        login = in.next();
        System.out.print("Введите пароль: "); //1234
        login = in.next();

        if (currentUser.Enter("andynial", "1234")){
            boolean flag = true;

            while(flag) {
                int N;

                System.out.println("1 - сгенерировать запросы");
                System.out.println("2 - подсчитать минимальное время выполнения заказа");
                System.out.println("3 - выход");

                N = in.nextInt();

                ArrayList<Request> requests = FormRequests(instruments);
                switch (N){
                    case (1):
                        System.out.println("Incoming requests:");
                        for (int i = 0; i < requests.size(); i++) {
                            requests.get(i).PrintRequest();
                            System.out.println("===");
                        }
                        break;

                    case (2):
                        ArrayList<Integer> times = new ArrayList<Integer>();
                        for (int i = 0; i < instruments.size(); i++) {
                            String inst = instruments.get(i);
                            int time = 0;
                            for (int j = 0; j < requests.size(); j++) {
                                Request req = requests.get(j);
                                for (int c = 0; c < req.parts.size(); c++) {
                                    if (req.parts.get(c).GetInstrument() == inst)
                                        time += req.parts.get(c).GetTime();
                                }
                            }
                            times.add(time);
                        }

                        int max = -1;
                        for (int i = 0; i < times.size(); i++) {
                            if (times.get(i) > max)
                                max = times.get(i);
                        }

                        System.out.println("The minimal possible time is " + max + " days.");
                        break;

                    case (3):
                        flag = false;
                        break;
                }
            }

        }

    }

    static ArrayList<Request> FormRequests(ArrayList<String> instruments ){
        int req_number = 4;
        ArrayList<Request> requests = new ArrayList<Request>();
        for (int i = 0; i < req_number; i++){
            Request request = new Request();
            for (int j = 0; j < instruments.size(); j++) {
                Random rnd = new Random();
                int index = rnd.nextInt(instruments.size());
                Part part = new Part(instruments.get(index), rnd.nextInt(19) + 1);
                request.AddPart(part);
            }
            requests.add(request);
        }
        return requests;
    }

}

