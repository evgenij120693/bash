package ru.svetozarov;

import ru.svetozarov.commands.CatCommand;
import ru.svetozarov.commands.CdCommand;
import ru.svetozarov.commands.LsCommand;
import ru.svetozarov.commands.ZipCommand;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Evgenij on 30.03.2017.
 */
public class Main {
    public static final String LIST_COMMANDS = "Список команд:\n" +
            "ls - вывод содержимого текущего каталога. Каждый элемент с новой строки, в одной строке выводится <тип> <имя>  (, где f - для файлов, d - для директорий);\n" +
            "cd <имя_директории> - переход в директорию;\n" +
            "cat <имя_файла> - вывод содержимого файла на экран;\n" +
            "zip -r <имяархива> <имяфайла1> <имяфайла2> ... - создает архив, содержащий указанные файлы с наименованием <имяархива>;\n" +
            "sort <имя_файла> -  выводит на экран содержимое файла, отсортированное построчно в лексикографическом порядке по возрастанию;\n" +
            "uniq <имя_файла> - выводит список уникальных строк в файле, порядок строк должен оставаться без изменения;\n" +
            "exit - завершает работу приложения.";

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir") + "\\";
        Scanner sc = new Scanner(System.in);
        System.out.print(userDir);
        work:
        while (true) {
            String[] commands = sc.nextLine().trim().split(" ");
            String command = commands[0].trim();

            switch (command) {
                case "lk":
                    new LsCommand(userDir).ShowContentDirectory();
                    break;
                case "cd":
                    if (commands.length > 1) {
                        String newDir;
                        if ((newDir = new CdCommand(userDir, commands[1].trim()).openDirectory()) != null) {
                            userDir = newDir + "\\";
                        } else {
                            System.out.println("Директория '" + commands[1].trim() + "' не найдена");
                        }
                    } else
                        System.out.println("Ошибка! Введите имя директории.");
                    break;
                case "cat":
                    if (commands.length > 1)
                        new CatCommand(userDir + commands[1].trim()).showContentFile();
                    else
                        System.out.println("Ошибка! Введите имя файла.");
                    break;
                case "zip":
                    if (commands[1].equals("-r")) {
                        if (commands.length > 3) {
                            new ZipCommand(commands[2], commands).createZip();
                        } else {
                            System.out.println("Для создания архива укажите имя архива и файл/файлы добавляемые в архив.");
                        }
                    }
                    break;
                case "sort":

                    break;
                case "exit":
                    break work;
                default:
                    System.out.println("Команда '" + command + "' не найдена." + LIST_COMMANDS);
                    break;
            }
            System.out.print(userDir);
        }
    }
}
