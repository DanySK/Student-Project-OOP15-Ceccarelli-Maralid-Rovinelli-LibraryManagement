package model;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class IOModel<T,X> implements Model<T, X> {

    private Employee user;
  
 /**metodo che prende come input la path e crea una mappa di classi */  

    ///////PER PIF/////////////////////////////////////////////////////////
    /*
     * Il problema è nella lettura o nella scrittura, in sostanza lui scrive "male" e quando va a leggere non riesce a leggere una istanza della classe alla volta
     * legge il tutto come unico file quindi mette tutto quello che c'è scritto dentro al file dentro alla mappa nel primo elemento (della mappa)
     * Quindi bisogna fare in modo che scriva magari gli oggetti uno sotto l'altro e che quando vai a leggere riesca a leggere una riga alla volta capendo che ogni riga
     * è un oggetto di una determinata classe
     * 
     * 
     * */
@SuppressWarnings("unchecked")
public Map<Integer, T> readFile(String path) throws IOException, ClassNotFoundException{
	   T t = null;
	   int count = 0;
	   Map <Integer, T> map = new HashMap<>();
       try
       {
          FileInputStream fileIn = new FileInputStream(path);
          ObjectInputStream in = new ObjectInputStream(fileIn);
          t =  (T) in.readObject();
          map.put(count, t);
          count++;
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
    return map;
       
   }

@Override
public void writeFile(String path, T o) {
    try
    {
       FileOutputStream fileOut = new FileOutputStream(path, true);
       ObjectOutputStream out = new ObjectOutputStream(fileOut);
       out.writeObject(o+" \n");
       out.close();
       fileOut.close();
       System.out.printf("Serialized data is saved in "+path);
    }catch(IOException i)
    {
        i.printStackTrace();
    }  
    
}

@Override
public Object search(Map<Integer, T> genericMap, String field) {
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
 
public Employee getUser(){
    return user;
}
public void setUser(Employee newUser){
    user = newUser;
}
}
