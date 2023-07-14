package org.aplana;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    static String path = "C:/Users/User/Desktop/file.txt";

    public static void main(String[] args) throws FileNotFoundException {
        int maxCount = 0;
        Map<String, Integer> wordMax = new HashMap<>();
        List<String> stringList = new ArrayList<>();
        Scanner sc = new Scanner(new File(path));

        while (sc.hasNext()) {
            stringList.add(sc.next());
        }
        sc.close();

        //сортировка по алфавиту
        Collections.sort(stringList);
        System.out.println(stringList);
        System.out.println("\n");

        //подсчет количества слов, встречающихся в файле
        Set<String> mySet = new HashSet<String>(stringList);
        for(String s: mySet){
            //вычисления для следующего задания
            int count = Collections.frequency(stringList, s);
            if(maxCount < count) maxCount = count;
            wordMax.put(s, count);
            //
            System.out.println(s + " " + count);
        }

        //слово с максимальным количеством повторений
        System.out.println("\n");
        System.out.print("Слово (слова) с максимальным количеством повторений: \n");
        for(Map.Entry<String, Integer> entry: wordMax.entrySet()) {
            if(entry.getValue() == maxCount) System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }


}
