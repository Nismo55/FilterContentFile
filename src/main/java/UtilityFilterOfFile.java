import java.io.*;
import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class UtilityFilterOfFile {
    static String prefix = "";
    static String path = "";
    static boolean isAppend = false;


    static ArrayList<Long> longNumbers = new ArrayList<>();
    static ArrayList<Double> doubleNumbers = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();

    static long sumLong = 0;

    public static void main(String[] args) {

        args = new String[]{"-s -a -p sample- -o D:/JavaTestTask/write in1.txt in2.txt"};
        String[] split = String.join(" ", args).split(" ");

        boolean isFullStatistic = false;
        boolean isShortStatistic = false;
        ArrayList<String> files = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {

            if (split[i].equals("-p"))
                prefix = split[i + 1];

            else if (split[i].equals("-o"))
                path = split[i + 1];

            else if (split[i].equals("-a"))
                isAppend = true;

            else if (split[i].equals("-s"))
                isShortStatistic = true;

            else if (split[i].equals("-f"))
                isFullStatistic = true;

            else if (split[i].endsWith(".txt"))
                files.add(split[i]);
        }

        DataProcessing.readFiles(files);


        ////создаем директории если их нет
        if ((!longNumbers.isEmpty() || !doubleNumbers.isEmpty() || !strings.isEmpty()) && !path.isEmpty())
            DataProcessing.createDirectory(path);

        DataProcessing.writeToFile(path, prefix, isAppend);


        Statistic.shortStatistic(longNumbers, doubleNumbers, strings, prefix);
        Statistic.fullStatistic(longNumbers, doubleNumbers, strings, sumLong);
    }
}
