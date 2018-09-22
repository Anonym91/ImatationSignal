package com.string.spout;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class SpoutStartUp implements ApplicationListener<ContextRefreshedEvent>{

    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext ac= event.getApplicationContext();
        SignalSpout signalSpout=ac.getBean(SignalSpout.class);
        Thread thread=new Thread(signalSpout);
        thread.start();
    }

}
