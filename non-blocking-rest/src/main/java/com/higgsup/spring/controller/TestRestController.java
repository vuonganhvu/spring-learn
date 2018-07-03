package com.higgsup.spring.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by anhvu on 03-Jul-18.
 */
@RestController
public class TestRestController {

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
}
