package com.gupao.study.multithread.creatthread;

/**
 * @Author: huangpj
 * @Description:用Thread类构建线程--->继承Thread类
 * @Date: Created in 10:45 15
 * @Modified By:
 */
public class UseThreadClass  extends Thread{

    @Override
    public void run() {
        System.out.println("extends Thread!!!");
    }

    public static void main(String[] args) {

       new UseThreadClass().start();
       new Thread(()-> {System.out.println("hello world");},"thread-test").start();
    }
}
