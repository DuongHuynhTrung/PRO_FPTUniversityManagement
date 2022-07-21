/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Student implements Comparable<Student> {

    private int id;
    private String name;
    private String address;
    private String gender;
    private Campus campus;

    public Student() {
    }

    public Student(int id, String name, String address, String gender, Campus campus) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.campus = campus;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void inputStudent(Campus campus) {
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        System.out.println("\nPlease input Student information:");
        do {
            try {
                sc = new Scanner(System.in);
                System.out.print("--> Input Student's ID: ");
                id = sc.nextInt();
                if (id <= 0) {
                    throw new Exception("ID is a positive number!\n");
                }
                if (campus.checkID(id))
                    throw new Exception("\nThis Student is already in this Campus!\n");
                check = false;
            } catch (InputMismatchException e) {
                System.out.print("ID is a number!\n");
                check = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                check = true;
            }
        } while (check);
        
        do {
            try {
                sc = new Scanner(System.in);
                System.out.print("--> Input Student's Name: ");
                setName(sc.nextLine());
                if (getName().equals("")) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.print("Name can not Empty!\n");
                check = true;
            }
        } while (check);
        
        do {
            try {
                sc = new Scanner(System.in);
                System.out.print("--> Input Student's Address: ");
                setAddress(sc.nextLine());
                if (getAddress().equals("")) {
                    throw new Exception();
                }
                check = false;
            } catch (Exception e) {
                System.out.println("Address can not Empty!\n");
                check = true;
            }
        } while (check);
        
        do {
            try {
                sc = new Scanner(System.in);
                System.out.print("--> Input Student's Gender (Male/Female) : ");
                gender = sc.nextLine();
                if (gender.toLowerCase().equals("male") || gender.toLowerCase().equals("female")) {
                    setGender(gender);
                }
                else
                    throw new Exception();
                check = false;
            } catch (Exception e) {
                System.out.println("Gender must follow format!\n");
                check = true;
            }
        } while (check);
    }

    public void OutputStudent() {
            System.out.printf("%-10d %-15s %-18s %s\n", getId(), getName(), getAddress(), getGender());

    }

    @Override
    public int compareTo(Student o) {
        if (id > o.id) {
            return 1;
        } else if (id < o.id) {
            return -1;
        }
        return 0;
    }

}
