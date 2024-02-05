
import java.util.ArrayList;

public class UtilityFilterOfFile {
    static String prefix = "";
    static String path = "";
    static boolean isAppend = false;
    static long sumLong = 0;
    static double sumDouble = 0.0;
    static ArrayList<Long> longNumbers = new ArrayList<>();
    static ArrayList<Double> doubleNumbers = new ArrayList<>();
    static ArrayList<String> strings = new ArrayList<>();


    public static void main(String[] args) {

        args = new String[]{"-s -f -s in1.txt in2.txt"};//// не забыть удалить
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

        ///записываем информацию в файлы
        DataProcessing.writeToFile(path, prefix, isAppend);

        /// выводим статистику
        if (isShortStatistic)
            Statistic.shortStatistic(longNumbers, doubleNumbers, strings, prefix);
        if (isFullStatistic)
            Statistic.fullStatistic(longNumbers, doubleNumbers, strings, sumLong, sumDouble);
    }
}
