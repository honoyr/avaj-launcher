package avaj.simulator;

import java.io.FileWriter;
import java.io.IOException;

public class LogFile {

    private static FileWriter file = null;

    LogFile() {
        try
        {
            this.file = new FileWriter("simulation.txt");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void AddToFile(String data) {
        try{
            file.write(data);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void closeFile(){
        try{
            file.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

//    public static FileWriter getFile(){
//        return file;
//    }
}
