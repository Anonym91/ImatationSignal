package com.string.spout;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class PostStartUp implements ApplicationListener<ContextRefreshedEvent> {

    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext ac = event.getApplicationContext();
        PostSignal postSignal = ac.getBean(PostSignal.class);
        Thread thread = new Thread(postSignal);
        thread.start();
    }
}
