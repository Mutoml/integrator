package com.mutoml.basics.concurrency.Future.jdk;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: Mutoml
 * @date: 2018-03-11
 * @time: 17:06
 */
public class JdkFutureMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new RealData("a"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.execute(futureTask);

        System.out.println("请求完毕");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //如果此时call方法没有执行完成，则会依然等待
        System.out.println("数据：" + futureTask.get());
    }
}
