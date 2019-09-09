package com.nattagan.ap;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

import java.util.List;


import static java.nio.charset.Charset.defaultCharset;


public class Main {

    List<String> lists;

    public static void main(String[] args) throws IOException {
	// write your code here

//        getList();
//        hashMap();
//        linkedHashMap();

    }

    public void getList() {
        this.lists = Files.readAllLines(Paths.get("src/collection.txt"), defaultCharset());
    }

    public static void hashMap() {

        HashMap<String, Sale > hMap = new HashMap<>(this.lists.size());

        long hmStartTime = System.nanoTime();

        for (String list: this.lists) {
            Sale sale = new Sale(list);
            hMap.put(sale.index, sale);
        }

        for(HashMap.Entry m:hMap.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        long hmEndTime = System.nanoTime();
        double diffTime = getDiffTime(hmStartTime, hmEndTime);
        System.out.println("HashMap Diff Time: " + diffTime + " seconds");

    }

    public static void linkedHashMap() {

        LinkedHashMap<String, Sale> lMap = new LinkedHashMap<>(this.lists.size());

        long hmStartTime = System.nanoTime();

        for (String list: this.lists) {
            Sale sale = new Sale(list);
            lMap.put(sale.index, sale);
        }

        for(HashMap.Entry m:lMap.entrySet()) {
            System.out.println(m.getKey() + " " + m.getValue());
        }

        long hmEndTime = System.nanoTime();
        double diffTime = getDiffTime(hmStartTime, hmEndTime);
        System.out.println("LinkedHashMap Diff Time: " + diffTime + " seconds");
    }


    public static double getDiffTime(long startTime, long endTime) {
        System.out.println("StartTime : "+ startTime);
        System.out.println("EndTime : "+ endTime);

        Long diff = endTime  - startTime;
        double elapsedTimeInSecond = (double) diff / 1_000_000_000;
        return elapsedTimeInSecond;

    }
}
