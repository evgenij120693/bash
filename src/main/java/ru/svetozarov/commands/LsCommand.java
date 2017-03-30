package ru.svetozarov.commands;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Evgenij on 30.03.2017.
 */
public class LsCommand {
    private String directory;
    public LsCommand(String directory) {
        this.directory = directory;
    }

    public void ShowContentDirectory(){
        File dir = new File(directory);
        File[] temp = dir.listFiles();
        for (File element :
                temp) {
            String type;
            if(element.isDirectory()){
                type = "d";
            }else{
                type = "f";
            }
            System.out.println(type + " "+ element.getName());
        }
    }

}
