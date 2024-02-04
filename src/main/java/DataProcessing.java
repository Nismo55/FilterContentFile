import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class DataProcessing {

    public static void readFiles(ArrayList<String> files) {
        ////читаем строки с файлов, парсим и кладем в соответствующие списки
        if (files.isEmpty())
            System.out.println("Не заданы файлы с входными данными");
        else {
            for(String file : files) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                    while (bufferedReader.ready()) {
                        String line = bufferedReader.readLine();
                        try {
                            Long number = Long.parseLong(line);
                            UtilityFilterOfFile.longNumbers.add(number);
                        } catch (NumberFormatException e) {
                            try {
                                Double doubling = Double.parseDouble(line);
                                UtilityFilterOfFile.doubleNumbers.add(doubling);
                            } catch (NumberFormatException x) {
                                UtilityFilterOfFile.strings.add(line);
                            }
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Файла с именем " + file + " не существует");
                }
            }
        }
    }

    public static void createDirectory(String path) {
        Path pathDirectory = Path.of(path);
        if (!Files.isDirectory(pathDirectory)) {
            try {
                Files.createDirectories(pathDirectory);
            } catch (IOException e) {
                System.out.println("Не корректно задан путь к директории");
            }
        }
    }
    public static void writeToFile(String path, String prefix, boolean isAppend) {
        /// создание файла
        if (!UtilityFilterOfFile.longNumbers.isEmpty()) {
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
            /// запись в файл
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathInteger.toFile(), isAppend))) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Long longNumber : UtilityFilterOfFile.longNumbers) {
                    stringBuilder.append(longNumber).append("\n");
                    UtilityFilterOfFile.sumLong += longNumber;
                }
                bufferedWriter.write(stringBuilder.toString());

            } catch (IOException e) {
                System.out.println("Ошибка записи в файл");
            }
        }
        //// создание файла
        if (!UtilityFilterOfFile.doubleNumbers.isEmpty()) {
            Path pathDouble;
            if (path.isEmpty())
                pathDouble = Path.of(prefix + "floats.txt");
            else
                pathDouble = Path.of(path + "/" + prefix + "floats.txt");
            if (Files.notExists(pathDouble)) {
                try {
                    Files.createFile(pathDouble);
                } catch (IOException e) {
                    System.out.println("Не коректно задано имя файла");
                }
            }
            //// запись в файл
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathDouble.toFile(), isAppend))) {
                StringBuilder stringBuilder = new StringBuilder();
                for (Double doubleNumber : UtilityFilterOfFile.doubleNumbers) {
                    stringBuilder.append(doubleNumber).append("\n");
                    UtilityFilterOfFile.sumDouble += doubleNumber;
                }
                bufferedWriter.write(stringBuilder.toString());


            } catch (IOException e) {
                System.out.println("Ошибка записи в файл");
            }
        }

        //// создание файла
        if (!UtilityFilterOfFile.strings.isEmpty()) {
            Path pathStrings;
            if (path.isEmpty())
                pathStrings = Path.of(prefix + "strings.txt");
            else
                pathStrings = Path.of(path + "/" + prefix + "strings.txt");
            if (Files.notExists(pathStrings)) {
                try {
                    Files.createFile(pathStrings);
                } catch (IOException e) {
                    System.out.println("Не коректно задано имя файла");
                }
            }
            //// запись в файл
            try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathStrings.toFile(), isAppend))) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String string : UtilityFilterOfFile.strings) {
                    stringBuilder.append(string).append("\n");
                }
                bufferedWriter.write(stringBuilder.toString());

            } catch (IOException e) {
                System.out.println("Ошибка записи в файл");
            }
        }
    }
}
