package model.core;

import java.util.Map;

import model.BookModel;

public interface ShopAndWarehouseModel {
    public void addNewBookInLibrary(BookModel b);
    public Map<BookModel,Integer> getBooks();
}
