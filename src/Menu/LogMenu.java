/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import DTO.Log;
import List.CampusList;
import List.CourseList;
import List.Loglist;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class LogMenu {

    public Loglist Menu(Loglist loglist, CampusList campusList, CourseList courseList) {
        int choice = 0;
        boolean check = false;
        boolean isContinue = false;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("***************   LearningCourse - Menu   *****************");
            System.out.println("*   1 - Learning course                                   *");
            System.out.println("*   2 - Course registration history of specify Student    *");
            System.out.println("*   3 - Course registration history of all Student        *");
            System.out.println("*   4 - Cancel Course                                     *");
            System.out.println("*   5 - Back to Management - Menu                         *");
            System.out.println("***********************************************************\n");
            do {
                try {
                    sc = new Scanner(System.in);
                    System.out.print("--> What is your choice: ");
                    choice = sc.nextInt();
                    if (choice < 1 || choice > 5) {
                        throw new Exception();
                    }
                    check = false;
                } catch (Exception e) {
                    System.out.println("\nInput Invalied!");
                    System.out.println("Input again!\n");
                    check = true;
                }
            } while (check);

            System.out.println("");
            switch (choice) {
                case 1: {

                    String CourseCode = "";
                    int StudentID = 0;
                    String code;
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
                        do {
                            try {
                                campusList.searchCampus(code).displayStudent();
                                int id = 0;
                                do {
                                    try {
                                        sc = new Scanner(System.in);
                                        System.out.print("--> Input Student's ID you want to choose: ");
                                        StudentID = sc.nextInt();
                                        check = false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("ID is a number!");
                                        check = true;
                                    }
                                } while (check);
                                if (campusList.searchCampus(code).searchStuden(StudentID) == null) {
                                    System.out.println("\n           Student doesn't exist!");
                                    System.out.println("                  Input again!\n");
                                    check = true;
                                } else {
                                    check = false;
                                }
                            } catch (Exception e) {
                                System.out.println("\n      Input Invalied!");
                                System.out.println("        Input Agian!\n");

                            }

                        } while (check);

                        do {
                            String continueString = "";
                            do {
                                try {
                                    System.out.println("---------------------------------------------");
                                    courseList.displayAll();
                                    System.out.println("---------------------------------------------\n");
                                    sc = new Scanner(System.in);
                                    System.out.print("--> Input Course's Code you want to choose: ");
                                    CourseCode = sc.nextLine();
                                    if (courseList.searchCourse(CourseCode) == null) {
                                        throw new Exception("\n                   Course doesn't exist!\n");
                                    }
                                    if (CourseCode.equals("")) {
                                        throw new Exception("\n                   Course's Code can not Empty!\n");
                                    }
                                    check = false;
                                } catch (Exception e) {
                                    System.out.println(e.getMessage());
                                    check = true;
                                }
                            } while (check);

                            Log log = new Log(campusList.searchCampus(code).searchStuden(StudentID), courseList.searchCourse(CourseCode));
                            if (loglist.addLog(log)) {
                                System.out.println("\n          Registered!\n");
                            } else {
                                System.out.println("\n                      Register Fail! ");
                                System.out.println("            This Student already Register this Course!\n");
                            }

                            System.out.println("Do you want to continue Register: "
                                    + "Y = Yes/ Other = No");
                            continueString = sc.nextLine();
                            if (continueString.toLowerCase().equals("y")) {
                                isContinue = true;
                            } else {
                                isContinue = false;
                            }
                        } while (isContinue);

                        check = true;
                        break;
                    }
                }

                case 2: {
                    if (loglist.isEmpty()) {
                        System.out.println("\n          No Course is Learned!\n");
                    } else {
                        String CourseCode = "";
                        int StudentID = 0;
                        String code = "";
                        do {
                            try {
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
                            } catch (Exception e) {
                                System.out.println("\n      Input Invalied!");
                                System.out.println("        Input Agian!\n");
                            }
                        } while (check);

                        if (campusList.searchCampus(code).isEmpty()) {
                            System.out.println("\n          This Campus has no Student!\n");
                            check = true;
                            break;
                        } else {
                            do {
                                try {
                                    campusList.searchCampus(code).displayStudent();
                                    int id = 0;
                                    do {
                                        try {
                                            sc = new Scanner(System.in);
                                            System.out.print("--> Input Student's ID you want to choose: ");
                                            StudentID = sc.nextInt();
                                            check = false;
                                        } catch (InputMismatchException e) {
                                            System.out.println("ID is a number!");
                                            check = true;
                                        }
                                    } while (check);
                                    if (campusList.searchCampus(code).searchStuden(StudentID) == null) {
                                        System.out.println("\n           Student doesn't exist!");
                                        System.out.println("                  Input again!\n");
                                        check = true;
                                    } else {
                                        check = false;
                                    }

                                } catch (Exception e) {
                                    System.out.println("\n      Input Invalied!");
                                    System.out.println("        Input Agian!\n");
                                }

                            } while (check);
                            System.out.println("\n      Information about registering Course of Student");
                            System.out.printf("%-18s %-12s %-12s %-12s %s\n", "Student Name", "Code", "Name", "Creadits", "Total Creadits");
                            loglist.display(campusList.searchCampus(code).searchStuden(StudentID), code);
                            System.out.println("\n      Press Enter to continue!");
                            sc = new Scanner(System.in);
                            sc.nextLine();
                        }

                    }
                    check = true;
                    break;
                }

                case 3:
                    if (loglist.isEmpty()) {
                        System.out.println("\n          No Course is Learned!\n");
                    } else {
                        String CourseCode = "";
                        int StudentID = 0;
                        String code;
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

                            System.out.println("\n    All information about regestering Course of all Student:");
                            System.out.printf("%-18s %-12s %-12s %-12s %s\n", "Student Name", "Code", "Name", "Creadits", "Total Creadits");
                            loglist.displayAll(campusList, code);
                            sc = new Scanner(System.in);
                            System.out.println("\nPress Enter to continue!");
                            sc.nextLine();
                        }
                        check = true;
                        break;
                    }

                case 4:
                    if (loglist.isEmpty()) {
                        System.out.println("\n          No Course is Learned!\n");
                    } else {
                        String CourseCode = "";
                        int StudentID = 0;
                        String code;
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
                            do {
                                try {
                                    campusList.searchCampus(code).displayStudent();
                                    do {
                                        try {
                                            sc = new Scanner(System.in);
                                            System.out.print("--> Input Student's ID you want to choose: ");
                                            StudentID = sc.nextInt();
                                            check = false;
                                        } catch (InputMismatchException e) {
                                            System.out.println("ID is a number!");
                                            check = true;
                                        }
                                    } while (check);
                                    if (campusList.searchCampus(code).searchStuden(StudentID) == null) {
                                        System.out.println("\n           Student doesn't exist!");
                                        System.out.println("                  Input again!\n");
                                        check = true;
                                    } else {
                                        check = false;
                                    }
                                } catch (Exception e) {
                                    System.out.println("\n      Input Invalied!");
                                    System.out.println("        Input Agian!\n");
                                }

                            } while (check);

                            do {
                                try {
                                    System.out.printf("%-18s %-12s %-12s %-12s %s\n", "Student Name", "Code", "Name", "Creadits", "Total Creadits");
                                    loglist.display(campusList.searchCampus(code).searchStuden(StudentID), code);
                                    System.out.print("\n--> Input Course's Code you want to remove: ");
                                    sc = new Scanner(System.in);
                                    CourseCode = sc.nextLine();
                                    if (CourseCode.equals("")) {
                                        throw new Exception();
                                    }
                                    check = false;
                                } catch (Exception e) {
                                    System.out.println("\n      Input Invalied!");
                                    System.out.println("        Input again!\n");
                                    check = true;
                                }
                            } while (check);
                            if (loglist.removeLog(StudentID, CourseCode)) {
                                System.out.println("\n Removed! \n");
                            } else {
                                System.out.println("\n Remove failed! \n");
                            }
                            check = true;
                            break;
                        }

                    }
                case 5:
                    System.out.println("\n********Go out of UsingService - Menu********\n");
                    check = false;
            }

        } while (choice <= 4);
        return loglist;
    }

}
