package com.company;

import java.util.*;

public class Main {

    static ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        Map<String, Integer> hmap = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Put the string: ");
        String abc = sc.nextLine();

        arrayList = splitTheWords(abc);
        for (int i = 0; i < arrayList.size(); i++) {
            String temp = arrayList.get(i);
            int k = 1;
            for (int j = i + 1; j < arrayList.size(); j++) {
                if (temp.equals(arrayList.get(j)))
                    k++;
            }
            if (!hmap.containsKey(temp))
                hmap.put(temp, k);
        }
        //  for (Map.Entry<String, Integer> item : hmap.entrySet()) {
        //      System.out.printf("Word: %10s Frequency: %d \n", item.getKey(), item.getValue());
        // }
        System.out.println("Words frequency:");
        hmap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);
    }

    public static ArrayList<String> splitTheWords(String str) {
        String first = "";
        int end = str.indexOf(" ");
        if (end == -1) {
            arrayList.add(str);
            return arrayList;
        }
        first = str.substring(0, end);
        arrayList.add(first);
        str = str.substring(end).trim();
        splitTheWords(str);
        return arrayList;
    }
}
