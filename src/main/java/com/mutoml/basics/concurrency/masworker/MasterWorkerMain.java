package com.mutoml.basics.concurrency.masworker;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-21
 * @time: 14:56
 */
public class MasterWorkerMain {
    public static void main(String[] args) {
        CountWorker countWorker = new CountWorker();
        Master master = new Master(countWorker, 10);
        for (int i = 0; i < 100; i++) {
            master.commit(i);
        }
        master.excute();

        for (int i = 0; i < 100; i++) {
            System.out.println("result：" + master.getResult(String.valueOf(i)));
            ;
        }
    }
}
