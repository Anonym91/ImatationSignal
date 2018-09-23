package com.string.spout;

import com.string.generator.StringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class PostSignal implements Runnable {

    private long starttime=System.currentTimeMillis();

    public static final String URL_API="http://192.168.50.211:9999/api/input";

    @Autowired
    private StringGenerator stringGenerator;

    private String signal;

    public void postSignal(String postmsg)throws Exception{

        PrintWriter out=null;



        try{

            URL url = new URL(URL_API);

            HttpURLConnection connection= (HttpURLConnection) url.openConnection();

            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setRequestMethod("POST");
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            connection.setRequestProperty("Content-Type",
                    "application/x-javascript;charset=utf-8");
            connection.connect();
            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(
                    connection.getOutputStream(),"utf-8");

            out=new PrintWriter(outputStreamWriter);
            out.print(postmsg);
            out.flush();
            out.close();
            System.out.println(connection.getResponseCode());
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(),
                    "UTF-8"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = bf.readLine()) != null) {
                sb.append(line).append(System.getProperty("line.separator"));
            }
            bf.close();
            connection.disconnect();
            System.out.println("连接写入："+postmsg);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void run(){



        try{

            for(int i=0;i<10000;i++){
                signal=stringGenerator.stringGenerator();
                postSignal(signal);
            }
            long endTime=System.currentTimeMillis();
            long time=endTime-starttime;
            System.out.println("POST 耗时："+time);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
