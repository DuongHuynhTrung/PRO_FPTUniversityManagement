/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Campus;
import List.CampusList;
import List.CourseList;
import List.Loglist;
import Menu.CampusMenu;
import Menu.CourseMenu;
import Menu.LogMenu;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Tester {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        CampusList campusList = new CampusList();
        CourseList courseList = new CourseList();
        Loglist loglist = new Loglist();
        int choice = 0;

        do {
            System.out.println("**********  Management - Menu  **********");
            System.out.println("*    1. Manage Student list             *");
            System.out.println("*    2. Manage Course list              *");
            System.out.println("*    3. Learning Course                 *");
            System.out.println("*    4. Exit                            *");
            System.out.println("*****************************************");
            boolean checkChoice = false;
            do {
                try {
                    sc = new Scanner(System.in);
                    System.out.print("--> What is your choice: ");
                    choice = Integer.parseInt(sc.nextLine());
                    if (choice <= 0 || choice > 5) {
                        throw new Exception();
                    }
                    System.out.println("");
                    checkChoice = false;
                } catch (Exception e) {
                    System.out.println("\nInput Invalied");
                    System.out.println("Input agian\n");
                    checkChoice = true;
                }
            } while (checkChoice);

            switch (choice) {
                case 1:
                    CampusMenu campusMenu = new CampusMenu();
                    campusList = campusMenu.Menu(campusList);
                    break;
                case 2:
                    CourseMenu courseMenu = new CourseMenu();
                    courseList = courseMenu.Menu(courseList);
                    break;
                case 3:
                    LogMenu logMenu = new LogMenu();
                    loglist = logMenu.Menu(loglist, campusList, courseList);
                    break;
                case 4:
                    System.out.println("\n               **********GOOD BYE**********");
                    System.out.println("         **********HOPE TO SEE YOU SOON**********\n");
                    break;
            }

        } while (choice <= 3);
    }

}
