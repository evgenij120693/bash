package ru.svetozarov.commands;

import java.io.*;

/**
 * Created by Evgenij on 30.03.2017.
 */
public class CatCommand {
    private String fileName;

    public CatCommand(String fileName) {
        this.fileName = fileName;
    }

    public void showContentFile() {
        try(FileReader inputStreamReader = new FileReader(new File(fileName))) {
            int s;
            while ((s = inputStreamReader.read()) != -1) {
                System.out.print((char) s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("файл '" + fileName + "' не найден.");
        } catch (IOException ex) {
            System.out.println("Произошла ошибка чтения файла '" + fileName + "'.");
        }
    }
}
