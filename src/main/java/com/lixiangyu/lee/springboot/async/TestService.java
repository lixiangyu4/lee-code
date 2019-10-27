package com.lixiangyu.lee.springboot.async;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @program: leecode
 * @description:
 * @author: lixiangyu
 * @create: 2019-05-27 15:53
 **/
@Service
public class TestService {

    @Autowired
    private SyncService syncService;

    public void test_no_result() {
        System.out.println(Thread.currentThread().getName());
        syncService.asyncMethodWithVoidReturnType();
    }

    public void test_with_result() throws InterruptedException, ExecutionException {
        System.out.println(Thread.currentThread().getName());
        Future<String> stringFuture = syncService.asyncMethodWithReturnType();
        for (;;) {
            if(stringFuture.isDone()) {
                System.out.println("is done");
                System.out.println(stringFuture.get());
                break;
            }
            System.out.println("continue to sth else");
            Thread.sleep(1000);
        }
    }

}
