import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Statistic {
    /** Класс служит для вывода статистики на экран */
    public static void shortStatistic(ArrayList<Long> longNumbers,
                                      ArrayList<Double> doubleNumbers,
                                      ArrayList<String> strings, String prefix) {
        System.out.println(String.format("Колличество элементов записаных в файл %sintegers.txt: %d",
                prefix, longNumbers.size()));;
        System.out.println(String.format("Колличество элементов записаных в файл %sfloats.txt: %d",
                prefix, doubleNumbers.size()));
        System.out.println(String.format("Колличество элементов записаных в файл %sstrings.txt: %d",
                prefix, strings.size()));
    }


    public static void fullStatistic(ArrayList<Long> longNumbers,
                                     ArrayList<Double> doubleNumbers,
                                     ArrayList<String> strings, long longSum, double doubleSum) {
        if (!longNumbers.isEmpty()) {
            System.out.println("Максимальное целое число: " + Collections.max(longNumbers));
            System.out.println("Минимальное целое число: " + Collections.min(longNumbers));
            System.out.println("Сумма целых чисел: " + longSum);
            System.out.println("Среднее значение целых чисел: " + (longSum / longNumbers.size()));
        }

        if (!doubleNumbers.isEmpty()) {
            System.out.println("Максимальное вещественное число: " + Collections.max(doubleNumbers));
            System.out.println("Минимальное вещественное число: " + Collections.min(doubleNumbers));
            System.out.println("Сумма вещественных чисел: " + doubleSum);
            System.out.println("Среднее значение вещественных чисел: " + (doubleSum / doubleNumbers.size()));
        }

    }
}
