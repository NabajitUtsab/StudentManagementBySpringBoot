package com.example.StudentManagementBySpringBoot.thread;

public class RacingProblem  {

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(500);
        account.showBalance();


        Thread myWithdrawalThread = new Thread((Runnable) () -> {
            for (int i = 0; i < 100; i++) {
                account.withdraw();

            }
        });

        Thread someOneWithdrawalThread = new Thread((Runnable) () -> {
            for (int i = 0; i < 100; i++) {
                account.withdraw();
            }
        });

//        myWithdrawalThread.start();
//        myWithdrawalThread.join();
//        someOneWithdrawalThread.start();

        synchronized (myWithdrawalThread){
            myWithdrawalThread.start();
        }

        someOneWithdrawalThread.start();

    }


}
