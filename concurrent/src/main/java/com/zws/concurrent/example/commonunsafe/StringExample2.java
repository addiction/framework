package com.zws.concurrent.example.commonunsafe;

import com.zws.concurrent.annoations.NotThreadSafe;
import com.zws.concurrent.annoations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author zws
 * @email 2848392861@qq.com
 * date 2018/11/12
 */
@Slf4j
@ThreadSafe
public class StringExample2 {

    private static StringBuffer builder = new StringBuffer();
    private static int threadCount = 2000;
    private static int clientTotal = 50;


    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        final Semaphore semaphore = new Semaphore(clientTotal);
        for(int i=0;i<threadCount;i++){
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        update();
                        semaphore.release();
                    }catch (Exception e){
                        log.error("error,{}",e);
                    }
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}",builder.length());

    }


    private static void update(){
        builder.append("1");
    }
}
