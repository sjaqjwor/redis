package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    //멀티 스레드 환경에서 다른 스레드에서 수행 되는 일련의 작업이 완료 되기 까지 기다리는 동기화
    // 주어진 수로 초기화
    //
    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        LOGGER.info("Received <" + message + ">");
        //latch에 카운터 -1
        latch.countDown();
    }
}
