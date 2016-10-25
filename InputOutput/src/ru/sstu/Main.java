package ru.sstu;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //fileOperations();

        Path relPath = Paths.get("123/abc");
        printPathInfo(relPath);

        if(relPath.isAbsolute()) System.out.println("Путь абсолютный");
        System.out.println("==================");
        Path absPath = relPath.toAbsolutePath();
        printPathInfo(absPath);

        /*try {
            Files.delete(relPath);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        Path grandParent = absPath.getParent().getParent();
        Path newFilePath = Paths.get(grandParent.toString(), "1.txt");
        /*try {
            Files.createFile(newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        printPathInfo(grandParent);
        //Files.list().forEach((e)->e.toAbsolutePath());





        /*if(Files.isDirectory(path))
            System.out.println( path + " - это папка");
        if(Files.isRegularFile(path))
            System.out.println(path + " - это файл");*/

    }

    public static void printPathInfo(Path path)
    {
        System.out.println("toString: " + path.toString());
        System.out.println("getFileName: "+ path.getFileName());
        System.out.println("getName(0): "+ path.getName(0));
        System.out.println("getNameCount: "+ path.getNameCount());
        System.out.println("subpath(0,2): "+ path.subpath(0,2));
        System.out.println("getParent: "+ path.getParent());
        System.out.println("getRoot: "+ path.getRoot());

        if(Files.isDirectory(path))
            System.out.println( path + " - это папка");
        if(Files.isRegularFile(path))
            System.out.println(path + " - это файл");


    }

    public static void fileOperations()
    {
        Path p1 = Paths.get("C:/Users/Shvarts/Java Projects/1.txt");
        printPathInfo(p1);
        System.out.println("==============");
        Path p2 = Paths.get("C:/Users/Shvarts/Java Projects/123");
        printPathInfo(p2);

        try {
            Files.deleteIfExists(p2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.createDirectory(p2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path p3 = Paths.get("C:/Users/Shvarts/345/678/90");
        try {
            Files.createDirectories(p3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path p4 = Paths.get("C:/Users/Shvarts/Java Projects/2.txt");
        try
        {
            Files.deleteIfExists(p4);
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        try {
            Files.createFile(p4);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path p5 = Paths.get("C:/Users/Shvarts/Java Projects/123/678.txt");
        /*try {
            Files.copy(p4, p5);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Path p6 = Paths.get("C:/Users/Shvarts/Java Projects/123/90//");
        try {
            Files.copy(p3, p6);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path p7 = Paths.get("C:/Users/Shvarts/Java Projects/123/90/678.txt");
        try {
            Files.move(p5, p7);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path p8 = Paths.get("C:/Users/Shvarts/Java Projects/321");
        try {
            Files.move(p2,p8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
