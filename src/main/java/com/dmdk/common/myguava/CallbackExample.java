package com.dmdk.common.myguava;

import com.google.common.util.concurrent.*;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class CallbackExample {

    public static void main(String[] args) {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

        ListenableFuture<Integer> future = executorService.submit(() -> {
            System.out.println("future 内部执行开始..");
            // 异步计算逻辑
            Thread.sleep(2000);
            System.out.println("future 内部执行完毕，返回42");
            return 42;
        });

        FutureCallback<Integer> callback = new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer result) {
                // 处理成功结果的逻辑
                System.out.println("Result: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                // 处理异常情况的逻辑
                System.out.println("Error: " + t.getMessage());
            }
        };

        Futures.addCallback(future, callback, executorService);

        // 等待异步操作完成
        try {
            Thread.sleep(100);
            System.out.println("future get之前");
            future.get();
            System.out.println("future get之后");
            executorService.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}