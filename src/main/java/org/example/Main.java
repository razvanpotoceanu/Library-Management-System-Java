package org.example;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        int choice;
        do {
            System.out.println("\n---Meniu Biblioteca---\n");
            System.out.println("1. Adauga carte");
            System.out.println("2. Afiseaza toate cartile");
            System.out.println("3. Imprumuta o carte");
            System.out.println("4. Inapoiaza o carte");
            System.out.println("5. Sterge carte");
            System.out.println("0. Inchide");
            System.out.println("Alegeti un numar: ...");

            while (!scanner.hasNextInt()) {
                System.out.print("Try a number: ");
                scanner.next();
            }

            choice = scanner.nextInt();

            scanner.nextLine();

            switch(choice){
                case 1:

                    System.out.println("Introduceti titlul cartii: ");
                    String title = scanner.nextLine();
                    System.out.println("Introduceti autorul cartii: ");
                    String author = scanner.nextLine();
                    System.out.println("Introduceti ISBN-ul cartii: ");
                    String ISBN = scanner.nextLine();
                    Book newBook = new Book(title, author, ISBN, BookStatus.AVAILABLE);
                    library.addBook(newBook);
                    break;
                case 2:
                    library.displayAllBooks();
                    break;

                case 3:
                    System.out.println("Introduceti ISBN-ul cartii: ");
                    ISBN = scanner.nextLine();
                    library.borrowBook(ISBN);
                    break;

                case 4:
                    System.out.println("Introduceti ISBN-ul cartii: ");
                    ISBN = scanner.nextLine();
                    library.returnBook(ISBN);
                    break;

                case 5:
                    System.out.println("Introduceti ISBN-ul cartii: ");
                    ISBN = scanner.nextLine();
                    library.removeBookByISBN(ISBN);
                    break;

            }
        }while(choice != 0);
    }
}
