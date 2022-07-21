/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import List.CampusList;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Campus {

    private String code;
    private String name;
    private String address;
    ArrayList<Student> t;

    public Campus() {
    }

    public Campus(String code, String name, String address) {
        this.code = code;
        this.name = name;
        this.address = address;
        this.t = new ArrayList<>();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Student> getStudents() {
        return t;
    }

    public Student searchStuden(int id) {
        for (Student student : t) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student searchStudent(String name) {
        name = name.toLowerCase();
        for (Student student : t) {
            if (student.getName().toLowerCase().equals(name)) {
                return student;
            }
        }
        return null;

    }

    public boolean checkID(int id) {
        for (Student student : t) {
            if (student.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean removeStudent(int id) {
        Student st = new Student();
        st = searchStuden(id);
        if (st == null) {
            System.out.println("\n      Student doesn't exist!\n");
        } else {
            for (Student student : t) {
                if (student.getId() == id) {
                    return t.remove(st);
                }
            }
        }
        return false;
    }

    public boolean addStudent(Student st) {
        return t.add(st);
    }

    public boolean updateStudent(int id) {
        Student st = new Student();
        st = searchStuden(id);
        if (st == null) {
            System.out.println("\n        Student doesn't exist!\n");
            return false;
        } else {
            Scanner sc = new Scanner(System.in);
            boolean check = false;
            int input = 0;
            do {
                try {
                    System.out.println("");
                    System.out.printf("%-10s %-15s %-18s %s\n", "ID", "Name", "Address", "Gender");
                    st.OutputStudent();
                    System.out.println("Which one you want to update: ");
                    System.out.println("**************************");
                    System.out.println("*    1 - Name            *");
                    System.out.println("*    2 - Address         *");
                    System.out.println("*    3 - Gender          *");
                    System.out.println("*    4 - Campus          *");
                    System.out.println("*    5 - Exit            *");
                    System.out.println("**************************");
                    System.out.print("--> Input your choice: ");
                    sc = new Scanner(System.in);
                    input = sc.nextInt();
                    if (input < 1 || input > 5) {
                        throw new Exception();
                    }
                    switch (input) {
                        case 1:
                            do {
                                try {
                                    sc = new Scanner(System.in);
                                    System.out.print("--> Input new Student's Name: ");
                                    st.setName(sc.nextLine());
                                    if (st.getName().equals("")) {
                                        throw new Exception();
                                    }
                                    check = false;
                                } catch (Exception e) {
                                    System.out.print("Name can not Empty!\n");
                                    check = true;
                                }
                            } while (check);
                            check = true;
                            break;
                        case 2:
                            do {
                                try {
                                    sc = new Scanner(System.in);
                                    System.out.print("--> Input new Student's Address: ");
                                    st.setAddress(sc.nextLine());
                                    if (st.getAddress().equals("")) {
                                        throw new Exception();
                                    }
                                    check = false;
                                } catch (Exception e) {
                                    System.out.println("Address can not Empty!\n");
                                    check = true;
                                }
                            } while (check);
                            check = true;
                            break;
                        case 3:
                            do {
                                try {
                                    sc = new Scanner(System.in);
                                    System.out.print("--> Input new Student's Gender (Male/Female) : ");
                                    String gender = sc.nextLine();
                                    if (gender.toLowerCase().equals("male") || gender.toLowerCase().equals("female")) {
                                        st.setGender(gender);
                                    } else {
                                        throw new Exception();
                                    }
                                    check = false;
                                } catch (Exception e) {
                                    System.out.println("Gender must follow format!\n");
                                    check = true;
                                }
                            } while (check);
                            check = true;
                            break;
                        case 4:

                            check = true;
                            break;
                        case 5:
                            check = false;
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("\nInput Invalied!");
                    System.out.println("Input again!\n");
                }
            } while (check);

        }
        return true;
    }

    public void displayStudent() {
        if (t.isEmpty()) {
            System.out.println("\n  Student list is Empty!\n");
        } else {
            System.out.printf("%-10s %-15s %-18s %s\n", "ID", "Name", "Address", "Gender");
            for (Student student : t) {
                student.OutputStudent();
                System.out.printf("%-10s %-15s %-18s %s\n", "--", "-----", "-------", "------");
            }
        }

    }

    public void outputCampus() {
        if (t.size() == 0) {
            System.out.printf("%-10s %-30s %-30s %s\n", getCode(), getName(), getAddress(), "Empty!");
        } else {
            for (int i = 0; i < t.size(); i++) {
                if (i == 0) {
                    System.out.printf("%-10s %-30s %-30s %s\n", getCode(), getName(), getAddress(), t.get(i).getName());
                } else {
                    System.out.printf("%-10s %-30s %-30s %s\n", "", "", "", t.get(i).getName());

                }
            }
        }
    }

    public boolean setStudent(Student student) {
        for (int i = 0; i < t.size(); i++) {
            if (t.get(i) == student) {
                System.out.println("\n This Campus has already own this Student!\n");
                return false;
            }

        }
        return t.add(student);

    }

    public boolean isEmpty() {
        return t.isEmpty();
    }

}
