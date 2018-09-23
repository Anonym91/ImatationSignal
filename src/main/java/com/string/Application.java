package com.string;


import com.string.spout.PostStartUp;
import com.string.spout.SpoutStartUp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(Application.class);
        springApplication.addListeners(new PostStartUp());
        springApplication.addListeners(new SpoutStartUp());
        springApplication.run(args);
    }

}
