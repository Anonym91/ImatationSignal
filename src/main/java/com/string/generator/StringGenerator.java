package com.string.generator;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class StringGenerator {

    public String stringGenerator() {

        String type = "AB";
        String number = "012";
        String channal = "ABC";
        String temperature = "ABC";
        String fireAlarm = "ABC";
        int length = 2;

        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {
            sb.append(type.charAt(random.nextInt(2)));
        }

        for (int i = 0; i < length; i++) {
            sb.append(number.charAt(random.nextInt(3)));
        }

        for (int i = 0; i < length; i++) {
            sb.append(channal.charAt(random.nextInt(3)));
        }

        for (int i = 0; i < length; i++) {
            sb.append(temperature.charAt(random.nextInt(3)));
        }

        for (int i = 0; i < length; i++) {
            sb.append(fireAlarm.charAt(random.nextInt(3)));
        }

        String signal = sb.toString();
        System.out.println(signal);
        return signal;
    }

}
