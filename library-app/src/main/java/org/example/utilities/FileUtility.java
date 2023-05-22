package org.example.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Book;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Scanner;

public class FileUtility {
    public File getFileFromPath(String path) {
        File file = new File(path);

        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File created.");
                } else {
                    System.out.println("Error create file.");
                }
            } catch (IOException e) {
                System.out.println("Error create file: " + e.getMessage());
                return null;
            }
        }
        return file;
    }

    public List<Book> deserializeJson(File file) {
        String json = readFile(file);

        if (json != "") {
            Gson gson = new Gson();
            Type listBooksType = new com.google.gson.reflect.TypeToken<List<Book>>() {
            }.getType();

            return gson.fromJson(json, listBooksType);
        }else {
            return null;
        }
    }

    public String serializeJson(Book book) {
        File file = getFileFromPath("library.txt");
        List<Book> books = deserializeJson(file);

        if (books == null) {
            books = List.of(book);
        }else {
            books.add(book);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(books);
    }

    public String readFile(File file) {
        try {
            Scanner myReader = new Scanner(file);
            String content = "";

            while (myReader.hasNextLine()) {
                content = content + myReader.nextLine();
            }
            myReader.close();

            return content;
        }catch (IOException e) {
            System.out.println("An error occurred in readFile.");
            e.printStackTrace();
            return "";
        }
    }

    public String writeFile(String path, String json) {
        try (PrintWriter out = new PrintWriter(new FileWriter(path))) {
            out.write(json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
