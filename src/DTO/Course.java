/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import List.CourseList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Course {

    private String code;
    private String name;
    private int creadits;

    public Course() {
    }

    public Course(String code, String name, int creadits) {
        this.code = code;
        this.name = name;
        this.creadits = creadits;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreadits() {
        return creadits;
    }

    public void setCreadits(int creadits) {
        this.creadits = creadits;
    }

    public void inputCourse(CourseList courseList) {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        System.out.println("Please input Course information:");
        do {
            try {
                System.out.print("--> Input Course's Code: ");
                code = sc.nextLine();
                if (code.equals("")) {
                    throw new Exception("Code can not Empty!\n");
                }
                for (int i = 0; i < courseList.takeLenght(); i++) {
                    if (courseList.searchCourse(code) == null) {
                        continue;
                    } else if (courseList.searchCourse(this.code).getCode().toLowerCase().equals(this.code.toLowerCase())) {
                        throw new Exception("Course has alreay exist!\n");
                    }

                }
                check = false;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = true;
            }
        } while (check);

        do {
            try {
                System.out.print("--> Input Course's Name: ");
                name = sc.nextLine();
                if (name.equals("")) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.println("Name can not Empty!\n");
                check = true;
            }
        } while (check);

        do {
            try {
                sc = new Scanner(System.in);
                System.out.print("--> Input creadits of Course: ");
                creadits = sc.nextInt();
                if (creadits <= 0) {
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

    }

    public void output() {
        System.out.printf("%-10s %-15s %d\n", getCode(), getName(), getCreadits());
    }

}
