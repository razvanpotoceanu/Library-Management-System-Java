package org.example;

import java.util.ArrayList;


public class Library {

    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public void addBook(Book book){
        books.add(book);
    }

    public void displayAllBooks(){
        if (books.isEmpty()){
            System.out.println("No books found");
            return;
        }

        System.out.println("\n--- Lista Cartilor ---");
        for (Book book: books){
            System.out.println(book);
        }
    }
    public Book findBookByISBN(String ISBN){
        for(Book book:books)
            if(book.getISBN().equals(ISBN)){
                return book;
            }
        System.out.println("No book found with ISBN:"+ ISBN);
            return null;
    }

    public boolean removeBookByISBN(String ISBN){
        Book bookToDelete = findBookByISBN(ISBN);
        if (bookToDelete != null) {
            return books.remove(bookToDelete);
        }
        else {
            System.out.println("Cartea cu ISBN-ul " + ISBN + "nu a fost gasita pentru a o sterge");
            return false;
        }
    }

    public boolean borrowBook(String ISBN)
    {
        Book bookToBorrow = findBookByISBN(ISBN);
        if(bookToBorrow != null && bookToBorrow.getStatus() == BookStatus.AVAILABLE)
        {
            bookToBorrow.setStatus(BookStatus.BORROWED);
            System.out.println("Ati imprumutat cartea cu ISBN:" + ISBN);
            return true;
        }
        else {
            if (bookToBorrow == null) {
                System.out.println("Cartea nu exista");
            } else if (bookToBorrow.getStatus() == BookStatus.BORROWED){
                System.out.println("Cartea este momentan imprumutata de alt utilizator");
            }
        }
        return false;
    }

    public boolean returnBook(String ISBN)
    {
        Book bookToReturn = findBookByISBN(ISBN);
        if(bookToReturn != null)
        {
            bookToReturn.setStatus(BookStatus.AVAILABLE);
            System.out.println("Ati returnat cartea cu ISBN:" + ISBN);
            return true;
        }

        else {
            System.out.println("Cartea nu exista");
            return false;
        }
    }
}

