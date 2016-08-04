package model;

import java.util.ArrayList;

public interface Subscription {
      public Long getId();
      public String getName();
      public String getSurname();
      public String getType();
      public int getBook();
      
     
      public void setName(String name);
      public void setSurname(String surname);
      public void setType(String type);
      public void setBook(int book);
}
