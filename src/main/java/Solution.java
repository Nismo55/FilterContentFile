import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {


    public static void main(String[] args) throws FileNotFoundException {

        args = new String[]{"-s -a -p sample- -o D:/JavaTestTask/write in1.txt in2.txt"};
        String[] split = String.join(" ", args).split(" ");
        String prefix = "";
        String path = "";
        boolean append = false;
        int shortStatistic = 0;
        boolean isFullStatistic = false;
        boolean isShortStatistic = false;
        ArrayList<String> files = new ArrayList<>();

        ArrayList<Long> longNumbers = new ArrayList<>();
        ArrayList<Float> floatNumbers = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();

        for (int i = 0; i < split.length; i++) {

            if (split[i].equals("-p"))
                prefix = split[i + 1];

            else if (split[i].equals("-o"))
                path = split[i + 1];

            else if (split[i].equals("-a"))
                append = true;

            else if (split[i].equals("-s"))
                isShortStatistic = true;

            else if (split[i].equals("-f"))
                isFullStatistic = true;

            else if (split[i].endsWith(".txt"))
                files.add(split[i]);
        }
        if (files.isEmpty())
            System.out.println("Не заданы файлы с входными данными");
        else {
            for(String file : files) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                    while (bufferedReader.ready()) {
                       String line = bufferedReader.readLine();
                       try {
                           Long number = Long.parseLong(line);
                           longNumbers.add(number);
                       } catch (NumberFormatException e) {
                           try {
                               Float floating = Float.parseFloat(line);
                               floatNumbers.add(floating);
                           } catch (NumberFormatException x) {
                               strings.add(line);
                           }
                       }
                    }
                } catch (IOException e) {
                    System.out.println("Файла с именем " + file + " не существует");
                }
            }
        }
        /**System.out.println(strings);
        System.out.println(longNumbers);
        System.out.println(floatNumbers);*/


        if ((!longNumbers.isEmpty() || !floatNumbers.isEmpty() || !strings.isEmpty()) && !path.isEmpty()) {
            Path pathDirectory = Path.of(path);
            if (!Files.isDirectory(pathDirectory)) {
                try {
                    Files.createDirectories(pathDirectory);
                } catch (IOException e) {
                    System.out.println("Не корректно задан путь к директории");
                }
            };
        }


        if (!longNumbers.isEmpty()) {
            Path pathInteger;
            if (path.isEmpty())
                pathInteger = Path.of(prefix + "integers.txt");
             else
                pathInteger = Path.of(path + "/" + prefix + "integers.txt");
            if (Files.notExists(pathInteger)) {
                try {
                    Files.createFile(pathInteger);
                } catch (IOException e) {
                    System.out.println("Не коректно задано имя файла");
                }
            }
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathInteger.toFile(), append))) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Long longNumber : longNumbers) {
                    stringBuilder.append(longNumber).append("\n");
                }
                Files.write(pathInteger, stringBuilder.toString().getBytes(), StandardOpenOption.APPEND);

            } catch (IOException e) {
                System.out.println("Ошибка записи в файл");
            }
        }
        Statistic.shortStatistic(longNumbers, floatNumbers, strings, prefix);
    }
}
