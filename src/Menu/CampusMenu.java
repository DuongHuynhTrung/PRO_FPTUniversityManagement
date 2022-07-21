/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import DTO.Student;
import List.CampusList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CampusMenu {

    public CampusList Menu(CampusList campusList) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean check = false;
        String isContinue;
        do {
            System.out.println("*********  Student - Menu  **********");
            System.out.println("*    1. Add Student information    *");
            System.out.println("*    2. Display All Student        *");
            System.out.println("*    3. Update Student             *");
            System.out.println("*    4. Remove Student             *");
            System.out.println("*    5. Exit                       *");
            System.out.println("************************************");
            try {
                System.out.print("--> Input your choice: ");
                sc = new Scanner(System.in);
                choice = sc.nextInt();
                if (choice < 1 || choice > 5) {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.out.println("\nInput Invalied!");
                System.out.println("Input again!\n");
                check = true;
            }
            switch (choice) {
                case 1:
                    String code;
                    do {
                        campusList.displayAll();
                        System.out.print("--> Input Campus's Code you want to own Student: ");
                        sc = new Scanner(System.in);
                        code = sc.nextLine();
                        if (campusList.searchCampus(code) == null) {
                            System.out.println("\n          Student must belong to one Campus!");
                            System.out.println("                Please enter correctly!\n");
                            check = true;
                        } else {
                            check = false;
                        }
                    } while (check);
                    Student st = new Student();
                    st.inputStudent(campusList.searchCampus(code));
                    campusList.searchCampus(code).setStudent(st);
                    System.out.println("\n Added!\n");
                    check = true;
                    break;
                case 2:
                    do {
                        campusList.displayAll();
                        System.out.print("--> Input Campus's Code you want to see information: ");
                        sc = new Scanner(System.in);
                        code = sc.nextLine();
                        if (campusList.searchCampus(code) == null) {
                            System.out.println("\n          FPT University doesn't have this Campus!");
                            System.out.println("                    Please enter correctly!\n");
                            check = true;
                        } else {
                            check = false;
                        }
                    } while (check);
                    campusList.searchCampus(code).displayStudent();
                    System.out.println("Press Enter key to continue!");
                    sc.nextLine();
                    check = true;
                    break;
                case 3:
                    do {
                        campusList.displayAll();
                        System.out.print("--> Input Campus's Code you want to see information: ");
                        sc = new Scanner(System.in);
                        code = sc.nextLine();
                        if (campusList.searchCampus(code) == null) {
                            System.out.println("\n          FPT University doesn't have this Campus!");
                            System.out.println("                    Please enter correctly!\n");
                            check = true;
                        } else {
                            check = false;
                        }
                    } while (check);
                    if (campusList.searchCampus(code).isEmpty()) {
                        System.out.println("\n          This Campus has no Student!\n");
                        check = true;
                        break;
                    } else {
                        
                        campusList.searchCampus(code).displayStudent();
                        int id = 0;
                        do {                            
                            try {
                                sc = new Scanner(System.in);
                                System.out.print("--> Input Student's ID you want to Update: ");
                                id = sc.nextInt();
                                check =  false;
                            } catch (InputMismatchException e) {
                                System.out.println("ID is a number!");
                                check = true;
                            }
                        } while (check);
                       
                        if (campusList.searchCampus(code).searchStuden(id) == null) {
                            System.out.println("\n          Student doesn't exist!");
                            System.out.println("                Update Fail!\n");
                            check = true;
                            break;
                        } else {
                            if (campusList.searchCampus(code).updateStudent(campusList.searchCampus(code).searchStuden(id).getId())) {
                                System.out.println("\n          Updateed\n");

                            } else {
                                System.out.println("\n          Update Fail!\n");

                            }
                            check = true;
                            break;
                        }
                    }

                case 4:
                    do {
                        campusList.displayAll();
                        System.out.print("--> Input Campus's Code you want to see information: ");
                        sc = new Scanner(System.in);
                        code = sc.nextLine();
                        if (campusList.searchCampus(code) == null) {
                            System.out.println("\n          FPT University doesn't have this Campus!");
                            System.out.println("                    Please enter correctly!\n");
                            check = true;
                        } else {
                            check = false;
                        }
                    } while (check);
                    if (campusList.searchCampus(code).isEmpty()) {
                        System.out.println("\n          This Campus has no Student!\n");
                        check = true;
                        break;
                    } else {
                        campusList.searchCampus(code).displayStudent();
                        int id = 0;
                        do {                            
                            try {
                                sc = new Scanner(System.in);
                                System.out.print("--> Input Student's ID you want to Remove: ");
                                id = sc.nextInt();
                                check = false;
                            } catch (InputMismatchException e) {
                                System.out.println("ID is a number!");
                                check = true;
                            }
                        } while (check);
                        if (campusList.searchCampus(code).searchStuden(id) == null) {
                            System.out.println("\n          Student doesn't exist!");
                            System.out.println("                Remove Fail!\n");
                            check = true;
                            break;
                        } else {
                            if (campusList.searchCampus(code).removeStudent(id)) {
                                System.out.println("\n              Removed!\n");
                                check = true;
                                break;
                            } else {
                                System.out.println("\n              Remove fail!\n");
                                check = true;
                                break;
                            }
                        }
                    }
                  
                case 5:
                    System.out.println("\n********Go out of Student - Menu********\n");
                    check = false;
                    break;
            }

        } while (check);
        return campusList;
    }
}
