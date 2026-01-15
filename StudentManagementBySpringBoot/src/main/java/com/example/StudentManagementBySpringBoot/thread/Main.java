package com.example.StudentManagementBySpringBoot.thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadClass nabajitThread = new ThreadClass("Nabajit----");
        ThreadClass niloyThread = new ThreadClass("Niloy");

        nabajitThread.start();
      //  System.out.println(Thread.MAX_PRIORITY);
      //  nabajitThread.setPriority(Thread.MAX_PRIORITY);

      //  nabajitThread.join();
        //Thread.sleep(200);

        niloyThread.start();
    }
}
