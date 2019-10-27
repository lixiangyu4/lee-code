package com.lixiangyu.lee.springboot.async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-05-27 15:52
 **/
@Service
public class SyncService {

    @Async
    public void asyncMethodWithVoidReturnType() {
        System.out.println("VoidReturnType. "
            + Thread.currentThread().getName());
    }

    @Async
    public Future<String> asyncMethodWithReturnType() {
        System.out.println("WithReturnType - "
            + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            return new AsyncResult<String>("hello world !!!!");
        } catch (InterruptedException e) {
            //
        }

        return null;
    }

}
