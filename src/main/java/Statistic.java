import java.util.ArrayList;
import java.util.Collections;

public class Statistic {
    public static void shortStatistic(ArrayList<Long> longNumbers,
                                      ArrayList<Double> doubleNumbers,
                                      ArrayList<String> strings, String prefix) {
        if (!longNumbers.isEmpty())
            System.out.println(String.format("Колличество элементов записаных в файл %sintegers.txt: %d",
                    prefix, longNumbers.size()));
        if (!doubleNumbers.isEmpty())
            System.out.println(String.format("Колличество элементов записаных в файл %sfloats.txt: %d",
                    prefix, doubleNumbers.size()));
        if (!strings.isEmpty())
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

        if (!strings.isEmpty()) {
            System.out.println("Общее количество строк: " + UtilityFilterOfFile.strings.size());
            System.out.println("Размер самой длинной строки: " + Collections.max(strings).length());
            System.out.println("Размер самой короткой строки: " + Collections.min(strings).length());
        }

    }
}
