package com.eduzone.jpastudy.study.my.classroom;

import java.util.HashSet;
import java.util.Set;

public class MasterClassRoom {

    private Long id;

    private String type;    //  A, T, S

    private Set<AdmissionClassroom> admissionClassrooms = new HashSet<>();

    private Set<TutoringClassroom> tutoringClassrooms = new HashSet<>();

    private Set<ShortFormClassroom> shortFormClassrooms = new HashSet<>();


    public static void main(String[] args) {

        MasterClassRoom masterClassRoom = new MasterClassRoom(); // 리파지토라
        MasterClassRoom findMasterClassRoom1 = masterClassRoom.findById(1L);
        if(findMasterClassRoom1.getType() == "S") {
            findMasterClassRoom1.getAdmissionClassromms();
            //

        } else if() {

        }


    }
}

findById(1L);
isTutoring();
find
