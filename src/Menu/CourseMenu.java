/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import DTO.Course;
import List.CourseList;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CourseMenu {
    public CourseList Menu(CourseList ds3){
        
        Scanner sc = new Scanner(System.in);
        int choice3 = 0;
        do {
            System.out.println("*********  Services - Menu  *********");
            System.out.println("*    1. Add Cource                  *");
            System.out.println("*    2. Display All Course          *");
            System.out.println("*    3. Update Course               *");
            System.out.println("*    4. Remove Course               *");
            System.out.println("*    5. Exit                        *");
            System.out.println("*************************************");
            boolean checkChoice3 = false;
            do {
                try {
                    sc = new Scanner(System.in);
                    System.out.print("--> What is your choice: ");
                    choice3 = Integer.parseInt(sc.nextLine());
                    if (choice3 <= 0 || choice3 > 5) {
                        throw new Exception();
                    }
                    checkChoice3 = false;
                } catch (Exception e) {
                    System.out.println("\nInput Invalied!");
                    System.out.println("Input again!\n");
                    checkChoice3 = true;
                }
            } while (checkChoice3);
            System.out.println("");
            switch (choice3) {
                case 1:
                    Course svc = new Course();
                    svc.inputCourse(ds3);
                    if (ds3.addCourse(svc)) {
                        System.out.println("Added!\n");
                    } else {
                        System.out.println("Add fail!\n");
                    }
                    break;
                case 2:
                    ds3.displayAll();
                    System.out.println("\nPress Enter to continue!");
                    sc.nextLine();
                    break;
                case 3:
                    if (ds3.isEmpty()) {
                        System.out.println("          Course list is Empty!");
                        System.out.println("\nPress Enter to continue!");
                        sc = new Scanner(System.in);
                        sc.nextLine();
                        break;
                    }
                    System.out.println("-----------------------------------------");
                    ds3.displayAll();
                    System.out.println("-----------------------------------------\n");
                    String code = "";
                    boolean checkIdUpdate = false;
                    do {
                        try {
                            sc = new Scanner(System.in);
                            System.out.print("--> Input Course's Code you want to update: ");
                            code = sc.nextLine();
                            checkIdUpdate = false;
                        } catch (Exception e) {
                            System.out.println("\nInput Invalied!");
                            System.out.println("Input again!\n");
                            checkIdUpdate = true;
                        }
                    } while (checkIdUpdate);

                    if (ds3.updateCourse(code)) {
                        System.out.println("\nUpdated!\n");
                    } else {
                        System.out.println("\nUpdate Fail!\n");
                    }
                    break;
                case 4:
                    if (ds3.isEmpty()) {
                        System.out.println("          Course list is Empty!");
                        System.out.println("\nPress Enter to continue!");
                        sc = new Scanner(System.in);
                        sc.nextLine();
                        break;
                    }
                    System.out.println("-----------------------------------------");
                    ds3.displayAll();
                    System.out.println("-----------------------------------------\n");
                    boolean checkIdRemove = false;
                    code = "";
                    do {
                        try {
                            sc = new Scanner(System.in);
                            System.out.print("--> Input Course's ID you want to Remove: ");
                            code = sc.nextLine();
                            checkIdRemove = false;
                        } catch (Exception e) {
                            System.out.println("\nInput Invalied!");
                            System.out.println("Input again!\n");
                            checkIdRemove = true;
                        }
                    } while (checkIdRemove);
                    if (ds3.removeCorse(code)) {
                        System.out.println("\nRemoved!\n");
                    } else {
                        System.out.println("\nRemove fail!\n");
                    }
                    break;
                case 5:
                    System.out.println("\n********Go out of Course - Menu********\n");
                    break;
            }
        } while (choice3 <= 4);
        return ds3;
    }
}
