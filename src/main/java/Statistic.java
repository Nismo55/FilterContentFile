import java.util.ArrayList;

public class Statistic {
    /** Класс служит для вывода статистики на экран */
    public static void shortStatistic(ArrayList<Long> longNumbers,
                                      ArrayList<Float> floatNumbers,
                                      ArrayList<String> strings, String prefix) {
        System.out.println(String.format("Колличество элементов записаных в файл %sintegers.txt: %d",
                prefix, longNumbers.size()));;
        System.out.println(String.format("Колличество элементов записаных в файл %sfloats.txt: %d",
                prefix, floatNumbers.size()));
        System.out.println(String.format("Колличество элементов записаных в файл %sstrings.txt: %d",
                prefix, strings.size()));
    }


    public static void fullStatistic(ArrayList<Long> longNumbers,
                                     ArrayList<Float> floatNumbers,
                                     ArrayList<String> strings, String prefix) {

    }
}
