package com.string.spout;

import com.string.generator.StringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Component
public class SignalSpout implements Runnable{

    @Autowired
    private StringGenerator stringGenerator;


    public void signalSpout(int times) throws IOException {

        FileWriter fileWriter;
        File file = new File("/home/che/signal.txt");

        long startmillis = System.currentTimeMillis();

        try {

            fileWriter = new FileWriter(file);

            BufferedWriter bw = new BufferedWriter(fileWriter);

            for (int i = 0; i < times; i++) {

                String signal = stringGenerator.stringGenerator();

                fileWriter.write(signal + "\r\n");

            }

            long endmillis = System.currentTimeMillis();

            long time = endmillis - startmillis;

            String msg = "共耗时:" + String.valueOf(time);

            System.out.println(msg);

            fileWriter.write(msg);

            fileWriter.flush();

            fileWriter.close();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    public void run() {

        try {

            signalSpout(10000);

        } catch (Exception e) {

            e.printStackTrace();
        }


    }

}
