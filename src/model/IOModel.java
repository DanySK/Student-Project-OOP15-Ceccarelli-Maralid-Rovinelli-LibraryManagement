package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IOModel<T,X> implements Model {

  
 /**metodo che prende come input la path e crea una mappa di classi */  
public Map<Integer,T> readFile(String path) throws IOException, ClassNotFoundException{
       T t = null;
       try
       {
          FileInputStream fileIn = new FileInputStream(path);
          ObjectInputStream in = new ObjectInputStream(fileIn);
          t = (T) in.readObject();
          in.close();
          fileIn.close();
       }catch(IOException i)
       {
          i.printStackTrace();
          throw i;
       }catch(ClassNotFoundException c)
       {
          System.out.println("class not found");
          c.printStackTrace();
          throw c;
       }
       
    return (Map<Integer, T>) t;
       
   }

@Override
public void writeFile(String path, Object o) {
    try
    {
       FileOutputStream fileOut = new FileOutputStream(path);
       ObjectOutputStream out = new ObjectOutputStream(fileOut);
       out.writeObject(o);
       out.close();
       fileOut.close();
       System.out.printf("Serialized data is saved in "+path);
    }catch(IOException i)
    {
        i.printStackTrace();
    }  
    
}

@Override
public Object search(Map genericMap, Object field) {
    Iterator<Integer> it = genericMap.keySet().iterator();
    Object obj = null;
   int counter = 0;
    while(it.hasNext()){
       if(genericMap.get(counter).equals(field)){
           obj = genericMap.get(counter);
       }
       counter++;
    }
 return obj;
}
  
}
