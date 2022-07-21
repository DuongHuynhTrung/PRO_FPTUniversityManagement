/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import DTO.Course;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class CourseList {

    //TreeSet<Course> t;
    ArrayList<Course> t;
    public CourseList() {
        //t = new TreeSet<>();
        t = new ArrayList<>();
    }

    public boolean addCourse(Course svc) {
        return t.add(svc);
    }

    public boolean isEmpty() {
        return t.isEmpty();
    }

    public int takeLenght() {
        return t.size();
    }

    public Course searchCourse(String code) {
        code = code.toLowerCase();
        for (Course course : t) {
            if (course.getCode().toLowerCase().equals(code)) {
                return course;
            }
        }
        return null;
    }

    public boolean removeCorse(String code) {
        Course svc = searchCourse(code);
        if (svc == null) {
            return false;
        }
        t.remove(svc);
        return true;
    }

    public boolean updateCourse(String code) {
        Course svc = searchCourse(code);
        Scanner sc = new Scanner(System.in);
        if (svc == null) {
            return false;
        }
        int input = 0;
        boolean check = false;
        do {
            try {
                System.out.println("");
                System.out.printf("%-10s %-15s %-13s\n", "----", "------", "-----------");
                svc.output();
                System.out.println("Which one you want to update: ");
                System.out.println("*************************");
                System.out.println("*    1 - Name           *");
                System.out.println("*    2 - Creadits       *");
                System.out.println("*    3 - Exit           *");
                System.out.println("*************************");
                sc = new Scanner(System.in);
                System.out.print("--> Input your choice: ");
                input = sc.nextInt();
                if (input < 1 || input > 3) {
                    throw new Exception();
                }
                switch (input) {
                    case 1:
                        do {
                            try {
                                sc = new Scanner(System.in);
                                System.out.print("--> Input new Course's Name: ");
                                svc.setName(sc.nextLine());
                                if (svc.getName().equals("")) {
                                    throw new Exception();
                                }
                                check = false;
                            } catch (Exception e) {
                                System.out.println("Name can not Empty!\n");
                                check = true;
                            }
                        } while (check);
                        check = true;
                        break;
                    case 2:
                        do {
                            try {
                                sc = new Scanner(System.in);
                                System.out.print("--> Input new Course's Creadits: ");
                                svc.setCreadits(sc.nextInt());
                                if (svc.getCreadits() <= 0) {
                                    throw new Exception();
                                }
                                check = false;
                            } catch (InputMismatchException e) {
                                System.out.println("Creadits is a number!\n");
                                check = true;
                            } catch (Exception e) {
                                System.out.println("Creadits is a positive number!\n");
                                check = true;
                            }
                        } while (check);
                        check = true;
                        break;
                    case 3:
                        check = false;
                        break;

                }
            } catch (Exception e) {
                System.out.println("\nInput Invalied!");
                System.out.println("Input again!");
                check = true;
            }
        } while (check);

        return true;
    }

    public void displayAll() {
        if (t.size() == 0) {
            System.out.println("        Course list is Empty!");
        } else {
            System.out.println("     All information of Course: ");
            System.out.printf("%-10s %-15s %-13s\n", "Code", "Name", "Creadits");
            for (Course course : t) {
                course.output();
                System.out.printf("%-10s %-15s %-13s\n", "----", "------", "-----------");

            }
        }

    }

}
