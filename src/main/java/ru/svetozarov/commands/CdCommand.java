package ru.svetozarov.commands;

import java.io.File;

/**
 * Created by Evgenij on 30.03.2017.
 */
public class CdCommand {
    private String userDirectory;
    private String openDirectory;
    public CdCommand(String userDirectory, String openDirectory) {
        this.userDirectory = userDirectory;
        this.openDirectory = openDirectory;
    }
    public String openDirectory(){
        if(!openDirectory.equals("")){
            String path;
            if(openDirectory.indexOf(":")!=-1)
                path=openDirectory;
            else
                path=userDirectory+openDirectory;
            if(new File(path).exists()){
                return (path.toCharArray()[path.length()-1]=='\\')? path.substring(0, path.length()-1):path;
            }
            return null;
        }else{
            return null;
        }
    }
}
