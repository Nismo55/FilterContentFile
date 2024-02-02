import java.io.FileWriter;

public class Solution {


    public static void main(String[] args) {
        String prefix = "";
        String path = "";
        boolean append = false;
        int shortStatistic = 0;
        boolean isFullStatistic = false;
        boolean isShortStatistic = false;

        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-p"))
                prefix = args[i + 1];

            if (args[i].equals("-o"))
                path = args[i + 1] + prefix;

            if (args[i].equals("-a"))
                append = true;

            if (args[i].equals("-f"))
                append = true;

        }

    }


}
