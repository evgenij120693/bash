package ru.svetozarov.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by Evgenij on 30.03.2017.
 */
public class ZipCommand {
    private String zipName;
    private String[] listFiles;

    public ZipCommand(String zipName, String[] listFiles) {
        this.zipName = zipName;
        this.listFiles = listFiles;
    }

    public void createZip() {
        try (FileOutputStream fout = new FileOutputStream(zipName)){
            ZipOutputStream zout = new ZipOutputStream(fout);
            {
                for (int i = 3; i <listFiles.length; i++) {
                    if((!listFiles.equals("")) && new File(listFiles[i]).exists()) {
                        ZipEntry ze = new ZipEntry(listFiles[i]);
                        zout.putNextEntry(ze);
                    }else {
                        System.out.println("Файл '"+ listFiles[i]+"' не найден.");
                        throw new IOException();
                    }
                }
                zout.closeEntry();
            }
            zout.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка создания архива с именем '" + zipName + "'.");
        } catch (IOException e) {
            System.out.println("Ошибка создания архива");
        }
    }
}
