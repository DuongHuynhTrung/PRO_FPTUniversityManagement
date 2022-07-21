/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package List;

import DTO.Campus;
import DTO.Student;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class CampusList {

    ArrayList<Campus> t;

    public CampusList() {
        t = new ArrayList<>();
        t.add(new Campus("FPTHN", "HA NOI FPT University", "Thach That, Ha Noi City"));
        t.add(new Campus("FPTDN", "DA NANG FPT University", "Ngu Hanh Son, Danang City"));
        t.add(new Campus("FPTQN", "QUY NHON FPT University", "Quy Nhon City, Binh Dinh"));
        t.add(new Campus("FPTHCM", "HO CHI MINH FPT University", "Thu Duc, Ho Chi Minh City"));
        t.add(new Campus("FPTCT", "CAN THO FPT University", "Ninh Kieu, Can Tho City"));
    }

    public Campus searchCampus(String code) {
        code = code.toLowerCase();
        for (Campus campus : t) {
            if (campus.getCode().toLowerCase().equals(code)) {
                return campus;
            }
        }
        return null;
    }

    public void displayAll() {
        if (t.isEmpty()) {
            System.out.println("\nYou must Input Campus's information!\n");
        } else {
            System.out.printf("%-10s %-30s %-30s %s\n", "Code", "Name", "Address", "Student");
            for (int i = 0; i < t.size(); i++) {
                t.get(i).outputCampus();
                System.out.printf("%-10s %-30s %-30s %s\n", "------", "--------------------------", "--------------------------", "------------");
            }
        }

    }

    public boolean setStudent(String campusCode, Student student) {
        Campus cmp = searchCampus(campusCode);
        return cmp.setStudent(student);
    }

}
