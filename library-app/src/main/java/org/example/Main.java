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

            Scanner switchInput = new Scanner(System.in);

            switch (optionSelected) {
                case 1:
                    Book book = new Book();

                    System.out.print("Title: ");
                    book.setTitle(switchInput.nextLine());
                    System.out.print("Author: ");
                    book.setAuthor(switchInput.nextLine());
                    System.out.print("Year: ");
                    book.setYear(switchInput.nextInt());

                    library.saveBook(book);
                    break;

                case 2:
                    library.setBooks(library.getBooks());
                    System.out.println(library.toString());
                    break;

                case 3:
                    System.out.print("Author: ");
                    System.out.println(library.getBookByAuthor(switchInput.nextLine()));
                    break;

                case 4:
                    System.out.print("Title: ");
                    System.out.println(library.getBookByTitle(switchInput.nextLine()));
                    break;
            }
        }
        input.close();
    }
}