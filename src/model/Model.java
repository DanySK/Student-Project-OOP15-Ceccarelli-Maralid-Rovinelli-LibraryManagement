package model;

import java.io.IOException;
import java.util.Map;

public interface Model<T,X> {
    public Map<Integer,T> readFile(String path) throws IOException, ClassNotFoundException;
    public void writeFile(String path,T o);
    public Object search(Map<Integer,T> genericMap,X field);
    
}
