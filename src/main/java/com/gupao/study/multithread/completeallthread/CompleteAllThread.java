package com.gupao.study.multithread.completeallthread;

/**
 * @Author: huangpj
 * @Description:  怎样保证主线程推出前所有子线程都运行完-----Threadroup
 * @Date: Created in 16:55 15
 * @Modified By:
 */
public class CompleteAllThread {
    public static void main(String[] args) {

        Thread t1 =new Thread(CompleteAllThread::test,"thread-1");
        Thread t2 =new Thread(CompleteAllThread::test,"thread-2");
        Thread t3 =new Thread(CompleteAllThread::test,"thread-3");

        t1.start();
        t2.start();
        t3.start();
        //获取当前主线程
        Thread main = Thread.currentThread();
        //获取主线程所属组
        ThreadGroup group=main.getThreadGroup();
        //获取活跃线程数
        int count = group.activeCount();
        Thread[] threads = new Thread[count];
        group.enumerate(threads,true);//递归

        for(Thread thread:threads){
            System.out.println(".......");
        }
    }
    private static void test(){
        System.out.printf("线程[%s]正在执行。。。。。\n",Thread.currentThread().getName());
    }
}
