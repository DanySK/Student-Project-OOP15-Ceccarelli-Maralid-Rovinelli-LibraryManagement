package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class IOModelImpl {

    public Map<Integer, ArrayList<String>> readFile(String path) throws IOException {
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
    public void writeNewLine(String pathWrite,ArrayList<String> line){

        String path = pathWrite;
        try{
            File file = new File(path);
            
            if(file.exists()){
               FileOutputStream fwos = new FileOutputStream(path,true);
               PrintWriter fw = new PrintWriter(fwos);
               writeTheLine(fw,line);
               
               fw.close();
            }else if(file.createNewFile()){
                PrintWriter fw = new PrintWriter(file);
                writeTheLine(fw,line);
            }
           
        
            }catch(IOException e){
                e.printStackTrace();
        }
        
     
    }
    /**Scrittura di una riga di un file dato il dato da scrivere e il suo percorso*/
    private void writeTheLine(PrintWriter fw,ArrayList<String>line2){
                for(int a = 0;a<line2.size();a++){
                    if(a+1 == line2.size()){
                        fw.append(line2.get(a)+"\n");
                    }else{
                        fw.append(line2.get(a)+",");
                    }
                }
            fw.close();
    }
    public Map<Integer,ArrayList<String>> searchInFile(Map<Integer,ArrayList<String>> completeList,Integer idSearch,String nameSearch){
       completeList = new HashMap<>();
       Map<Integer,ArrayList<String>> newMap = new HashMap<>();
       ArrayList<String> analyzedValue ;
       Iterator<Integer> it = completeList.keySet().iterator();
       int counter = 0;//contatore per rillevare quante array vengono inserite nel map
       while(it.hasNext()){
         analyzedValue = completeList.get(it.next());  
         if(!nameSearch.equals(null)&& nameSearch.equals(analyzedValue.get(idSearch))){
            newMap.put(counter, analyzedValue); 
            counter++;
         }
       }
        return newMap;
     }
}
