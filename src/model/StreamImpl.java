package model;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Mattia.Rovinelli
 *
 * @param <T>
 * @param <X>
 */

public class StreamImpl<T,X> implements StreamModel<T,X>  {

@SuppressWarnings("unchecked")
public Map<T, X> readFile(String path) throws IOException, ClassNotFoundException{
	 
	  Map <T, X> map = new HashMap<T, X>();
       try
       {
          FileInputStream fis = new FileInputStream(path);
          ObjectInputStream ois = new ObjectInputStream(fis);
     
          map = (Map<T, X>) ois.readObject();  
          
          ois.close();
          fis.close();
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
  public void writeFile(String path, Map<T, X> map) {
      try
       {
        FileOutputStream fos = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
       
        oos.writeObject(map);
       
        oos.close();
       fos.close();
       System.out.println("Serialized data is saved in "+ path);
    }catch(IOException i){
        i.printStackTrace();
     }  
    
  }
}
