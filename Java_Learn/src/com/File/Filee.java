package com.File;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Filee {

    public static void write(int time){

        long start = System.currentTimeMillis();

        try(FileWriter writer = new FileWriter("Test.txt", true))
        {
            while (System.currentTimeMillis() - start < time*1000){
                TimeUnit.SECONDS.sleep(3);
                Date date = new Date();
                writer.write(date.toString()+"\n");
            }
        }
        catch(IOException | InterruptedException ex){
            System.out.println(ex.getMessage());
        }
    }
}
