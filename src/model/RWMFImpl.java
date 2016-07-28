package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RWMFImpl implements ReadWriteModificationFile {

    
    @Override
    public ArrayList<String> readLineFile(String path) {
       FileReader f = null;
       try {
           f=new FileReader(path);
       } catch (FileNotFoundException e1) {
         e1.printStackTrace();
       }
       BufferedReader b;
       b=new BufferedReader(f);
       String s = null;
       ArrayList <String> rlFile = new ArrayList <>();
       while(true) {
           try {
             s=b.readLine();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
           
           if(s==null)
             break;
          rlFile.add(s);
          
         }
        return rlFile;
    }

  

}
