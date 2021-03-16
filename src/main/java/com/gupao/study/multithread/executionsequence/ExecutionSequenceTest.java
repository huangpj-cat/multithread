package com.gupao.study.multithread.executionsequence;

/**
 * @Author: huangpj
 * @Description: 怎样使线程顺序执行
 * @Date: Created in 12:43 15
 * @Modified By:
 */
public class ExecutionSequenceTest {
    public static void main(String[] args) throws InterruptedException {
        joinOneBYOne();//用join实现顺序执行
        threadLoop();//使用循环-----线程的自旋
        threadWait();//join的实现原理
    }

    private static void threadWait() {
        Thread t1 =new Thread(ExecutionSequenceTest::test,"thread-1");
        Thread t2 =new Thread(ExecutionSequenceTest::test,"thread-2");
        Thread t3 =new Thread(ExecutionSequenceTest::test,"thread-3");
        doWait(t1);
        doWait(t2);
        doWait(t3);
    }
    private static void doWait(Thread thread){
        thread.start();
        while(thread.isAlive()){
            synchronized (thread){
                try {
                    thread.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private static void threadLoop() {
        Thread t1 =new Thread(ExecutionSequenceTest::test,"thread-1");
        Thread t2 =new Thread(ExecutionSequenceTest::test,"thread-2");
        Thread t3 =new Thread(ExecutionSequenceTest::test,"thread-3");

        t1.start();
        while(t1.isAlive()){
        }
        t2.start();
        while(t2.isAlive()){
        }
        t3.start();
        while(t3.isAlive()){
        }

    }

    private static void joinOneBYOne() throws InterruptedException {
        Thread t1 =new Thread(ExecutionSequenceTest::test,"thread-1");
        Thread t2 =new Thread(ExecutionSequenceTest::test,"thread-2");
        Thread t3 =new Thread(ExecutionSequenceTest::test,"thread-3");

        //使用join----注意一定要在启动时开启
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();
        t3.join();
    }
    private static void test(){
        System.out.printf("线程[%s]正在执行。。。。。\n",Thread.currentThread().getName());
    }
}
