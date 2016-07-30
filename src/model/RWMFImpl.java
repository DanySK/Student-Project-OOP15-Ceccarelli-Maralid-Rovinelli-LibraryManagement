package model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RWMFImpl implements ReadWriteModificationFile {

    
    @Override
    public Map<Integer, ArrayList<String>> readLineFile(String path) throws IOException {
       FileReader f = null;
       try {
           f=new FileReader(path);
       } catch (FileNotFoundException e1) {
         e1.printStackTrace();
       }
       BufferedReader b;
       b=new BufferedReader(f);
      
       String s = null;
       ArrayList <String> row = new ArrayList <>();
       ArrayList<String> word = new ArrayList<>();
       Map<Integer,ArrayList<String>> dbfile = new HashMap<>();
       while(true) {
           try {
             s=b.readLine();
         } catch (IOException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
         }
           
           if(s==null)
             break;
         row.add(s);
         for(int i = 0;i <row.size();i++){
             String[] words = row.get(i).split(",");
             word.clear();
             for(int a = 0;a<words.length;a++){
                 word.add(words[a]);
             }
             words = null;
             dbfile.put(i, new ArrayList<String>(word));
         }
          b.close();
          f.close();
         }
        return dbfile;
    }

  

}
