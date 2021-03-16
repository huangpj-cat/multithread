package com.gupao.study.multithread.threadstate;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Author: huangpj
 * @Description: 获取现存线程的信息
 * @Date: Created in 15:43 15
 * @Modified By:
 */
public class AllThreadStackState {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        long[] ids=threadMXBean.getAllThreadIds();

        for(Long id:ids ){
            ThreadInfo threadInfo=threadMXBean.getThreadInfo(id);
            System.out.println(threadInfo.toString());
        }
    }
}
