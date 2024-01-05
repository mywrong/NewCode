package com.example.demo;

import org.springframework.stereotype.Service;


@Service
public class WorkImpl implements Work{

    @Override
    @Retry
    public void doWork() throws Exception {
        throw new Exception("process error");

    }
}
