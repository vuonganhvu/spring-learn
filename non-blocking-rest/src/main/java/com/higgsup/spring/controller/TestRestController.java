package com.higgsup.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by anhvu on 03-Jul-18.
 */
@RestController
public class TestRestController {

    private final Timer timer = new Timer();
    private final int DelayTime = 100;
    private final int threadCount = 100;
    private final ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

    @GetMapping("/blocking")
    public ResponseEntity blockingRest(@RequestParam("i") Long i) throws InterruptedException {
        System.out.println("blocking i = " + i);
        Thread.sleep(5000);
        System.out.println("done blocking i = " + i);
        return ResponseEntity.ok("Ok 5000");
    }

    @GetMapping("/blocking2")
    public ResponseEntity blockingRest2() {
        return ResponseEntity.ok("Ok");
    }

    @GetMapping("/non-blocking")
    public DeferredResult<ResponseEntity<?>> testNonBlocking(@RequestParam("i") Long i)
            throws Exception {
        System.out.println("Non-blocking i = " + i);
        DeferredResult<ResponseEntity<?>> output = new DeferredResult<>();
        ForkJoinPool.commonPool().submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
            output.setResult(ResponseEntity.ok("ok"));
            System.out.println("Done Non-blocking i = " + i);
        });
        return output;
    }


    public DeferredResult<String> getAsyncBlocking() {
        DeferredResult<String> deferredResult = new DeferredResult<>();
        executorService.submit(() -> {
           try {
               Thread.sleep(DelayTime);
           }
           catch (InterruptedException e)
           {
               throw  new RuntimeException();
           }
           deferredResult.setResult("async-blocking");
        });
        return deferredResult;
    }

    @RequestMapping("/async-nonblocking")
    public DeferredResult<String> getAsyncNonBlocking()
    {
        final DeferredResult<String> deferredResult = new DeferredResult<>();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(deferredResult.isSetOrExpired())
                {
                    throw  new RuntimeException();
                }
                else
                {
                    deferredResult.setResult("Async-nonblock");
                }
            }
        }, DelayTime);
        return deferredResult;
    }
}
