package com.ericaShy.netty.echo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class LogTest
{
    static final Logger log = LoggerFactory.getLogger("logTest");

    @Test
    public void dasd() throws Exception
    {
        Pattern patter1 = Pattern.compile("\\A");
        Pattern patter2 = Pattern.compile("\\p{javaWhitespace}+");
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("test.txt")) {

            Scanner scanner = new Scanner(stream);

            scanner.useDelimiter(patter1);
            String testString = scanner.next();
            String[] testArray = patter2.split(testString);

            System.out.println(Arrays.toString(testArray));


//            System.out.println(scanner.hasNextLine());
//
//            System.out.println(scanner.nextInt());
//
//
//
//
//
//            System.out.println("----------");
//
//            System.out.println(scanner.next());

        }
//        String test = "This is a test";
     //   Scanner scanner = new Scanner(new )
    }
}
