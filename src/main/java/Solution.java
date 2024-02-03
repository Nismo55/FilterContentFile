import java.io.*;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {


    public static void main(String[] args) throws FileNotFoundException {

        args = new String[]{"-s -a -p sample- D:/JavaTestTask/in1.txt D:/JavaTestTask/in2.txt"};
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
        /** в мэйне оставить только создание пути к файлу, сделать отдельный метод для подсчёта статистики*/
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
                            String str = line;
                            strings.add(str);
                       }
                   }
                }
            } catch (IOException e) {
                System.out.println("Файла с именем " + file + " не существует");
            }
        }
        System.out.println(strings);
        System.out.println(longNumbers);
        System.out.println(floatNumbers);



        //try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter()))


    }


}
