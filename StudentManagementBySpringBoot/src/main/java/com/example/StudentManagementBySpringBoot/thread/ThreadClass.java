package com.example.StudentManagementBySpringBoot.thread;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;



public class ThreadClass extends Thread{

    private String name;
    public ThreadClass(String name) {
        this.name = name;
    }

    public void run(){
        for(int i = 0; i<=100;i++){
            System.out.println(i+" "+name);
        }
    }

}
