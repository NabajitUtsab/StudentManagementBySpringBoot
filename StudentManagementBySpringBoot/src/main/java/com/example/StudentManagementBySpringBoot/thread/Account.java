package com.example.StudentManagementBySpringBoot.thread;

public class Account {
     private int balance;

     Account(int balance) {
         this.balance = balance;
     }
     public void showBalance(){
         System.out.println("The balance is: " + balance);
     }

     public void withdraw() {
         balance--;
         System.out.println(balance);
     }


}
