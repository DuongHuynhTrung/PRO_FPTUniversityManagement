/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import DTO.Log;
import DTO.Student;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Loglist {

    ArrayList<Log> logs;

    public Loglist() {
        logs = new ArrayList<>();
    }

    public boolean addLog(Log log) {
        for (Log log1 : logs) {
            if (log1.getStudent().getId() == log.getStudent().getId()) {
                if (log1.getCourse().getCode().toLowerCase().equals(log.getCourse().getCode().toLowerCase())) {
                    return false;
                }
            }
        }
        return logs.add(log);
    }

    public boolean isEmpty() {
        return logs.isEmpty();
    }

    public int takeLenght() {
        return logs.size();
    }

    public Log searchLog(Student p) {
        for (Log log : logs) {
            if (log.getStudent() == p) {
                return log;
            }
        }
        return null;
    }

    public void display(Student p, String code) {
        int count = -1;
        int total = 0;
        int[] arraycount = new int[100];
        for (int i = 0; i < takeLenght(); i++) {
            if (logs.get(i).getStudent().getId() == p.getId()) {
                count++;
                arraycount[count] = i;
                total += logs.get(i).getCourse().getCreadits();
            }
        }
        if (count < 0) {
            System.out.println("\nThis pet has not used any services yet\n");
        } else {
            for (int i = 0; i <= count; i++) {
                if (p.equals(logs.get(arraycount[i]).getStudent())) {
                    if (i == 0) {
                        System.out.printf("%-18s %-12s %-12s %-12s %s\n", logs.get(arraycount[i]).getStudent().getName(), logs.get(arraycount[i]).getCourse().getCode(), logs.get(arraycount[i]).getCourse().getName(), logs.get(arraycount[i]).getCourse().getCreadits(), total);

                    } else {
                        System.out.printf("%-18s %-12s %-12s %s\n", "", logs.get(arraycount[i]).getCourse().getCode(), logs.get(arraycount[i]).getCourse().getName(), logs.get(arraycount[i]).getCourse().getCreadits());
                        System.out.printf("%-18s %-12s %-12s %-12s %s\n", "---------------", "-----", "-------", "---------", "----------------");

                    }
                }
            }
        }
    }

    public void displayAll(CampusList campusList, String code) {
        for (int i = 0; i < campusList.searchCampus(code).getStudents().size(); i++) {
            display(campusList.searchCampus(code).getStudents().get(i), code);
        }
    }

    public boolean removeLog(int id, String nameCourse) {
        nameCourse = nameCourse.toLowerCase();
        for (Log log : logs) {
            if (log.getStudent().getId() == id) {
                if (log.getCourse().getName().toLowerCase().equals(nameCourse)) {
                    return logs.remove(log);
                }
            }
        }
        return false;
    }
}
