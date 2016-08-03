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
import java.util.Map;

public class IOModel<T> implements Model {

  
   
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
}
