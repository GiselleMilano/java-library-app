package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner input = new Scanner(System.in);

        Integer optionSelected = 0;

        while (optionSelected != 5) {
            System.out.println("## Select One Option ##");
            System.out.println("1 - Save Book");
            System.out.println("2 - Get All Books");
            System.out.println("3 - Get A Book By Author");
            System.out.println("4 - Get A Book By Title");
            System.out.println("5 - Exit");
            System.out.print("Option: ");

            optionSelected = input.nextInt();

            switch (optionSelected) {
                case 1:
                    Scanner newinput = new Scanner(System.in);
                    Book book = new Book();

                    System.out.print("Title: ");
                    book.setTitle(newinput.nextLine());

                    System.out.print("Author: ");
                    book.setAuthor(newinput.nextLine());

                    System.out.print("Year: ");
                    book.setYear(newinput.nextInt());

                    library.saveBook(book);
                    break;
                case 2:
                    library.setBooks(library.getBooks());
                    System.out.println(library.toString());
                    break;
                case 3:
                    library.getBookByAuthor(null);
                    break;
                case 4:
                    library.getBookByTitle(null);
                    break;
            }
        }
        input.close();
    }
}