package model.core;

import java.util.Map;
import model.BookModel;

public interface ShopAndWarehouseModel {
    /**
     * this method updates the map 
     * 
     * bookInLibrary is a Map and it is composed of Book and quantity
     * @param booksInLibrary
     */
    public void update(Map<BookModel,Integer> booksInLibrary);
    /**
     * this method add a new book in a library
     * @param Book
     */
    public void addNewBookInLibrary(BookModel book);
    /**
     * this method return a map of books
     * 
     * @return Map<BookModel,Integer> 
     */
    public Map<BookModel,Integer> getBooks();
    /**
     * this method replace the quantity of a book, if the book not exist 
     * this method add a new book in the map 
     * 
     * @param book
     * @param quantity
     */
    public void replaceQuantity(BookModel book,int quantity);
    /**
     * This method returns the amount of the requested book
     * 
     * @param book
     * @return amount of the book
     */
    public Integer getBookQuantity(BookModel book);
}
