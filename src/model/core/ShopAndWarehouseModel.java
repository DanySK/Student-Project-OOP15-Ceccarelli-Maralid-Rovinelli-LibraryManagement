package model.core;

import java.util.Map;

import model.BookModel;

public interface ShopAndWarehouseModel {
    public void update(Map<BookModel,Integer> booksInLibrary);
    public void addNewBookInLibrary(BookModel b);
    public Map<BookModel,Integer> getBooks();
    public void replaceQuantity(BookModel b,int quantity);
    public Integer getBookQuantity(BookModel b);
}
