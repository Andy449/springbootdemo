package com.alphaomega.demo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleUtil {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 6000)
//    public void reportCurrentTime() {
//        System.out.println("现在时间：" + dateFormat.format(new Date()));
//    }
}