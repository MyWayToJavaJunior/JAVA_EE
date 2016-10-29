package ru.sstu;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Files.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //fileOperations();

        /*Path relPath = Paths.get("123/abc");
        printPathInfo(relPath);

        if(relPath.isAbsolute()) System.out.println("Путь абсолютный");
        System.out.println("==================");
        Path absPath = relPath.toAbsolutePath();
        printPathInfo(absPath);*/

        /*try {
            Files.delete(relPath);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        /*Path grandParent = absPath.getParent().getParent();
        Path newFilePath = Paths.get(grandParent.toString(), "1.txt");*/
        /*try {
            Files.createFile(newFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //printPathInfo(grandParent);
        //Files.list().forEach((e)->e.toAbsolutePath());

        //fileInputOutput();

        stringsOperations();



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

        if(isDirectory(path))
            System.out.println( path + " - это папка");
        if(isRegularFile(path))
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
            deleteIfExists(p2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            createDirectory(p2);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path p3 = Paths.get("C:/Users/Shvarts/345/678/90");
        try {
            createDirectories(p3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path p4 = Paths.get("C:/Users/Shvarts/Java Projects/2.txt");
        try
        {
            deleteIfExists(p4);
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
        try {
            createFile(p4);
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
            copy(p3, p6);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Path p7 = Paths.get("C:/Users/Shvarts/Java Projects/123/90/678.txt");
        try {
            move(p5, p7);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Path p8 = Paths.get("C:/Users/Shvarts/Java Projects/321");
        try {
            move(p2,p8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fileInputOutput()
    {
        Path path1 = Paths.get("C:/Users/Shvarts/Java Projects/InputOutput/1.txt");

        Path path2 = Paths.get("C:/Users/Shvarts/Java Projects/InputOutput/1_1.txt");
        //Чтение
        List<String> lines = null;
        try {
            System.out.println("==============");
            System.out.println("==============");
            lines = Files.readAllLines(path1);
            for(String line : lines)
            {
                System.out.println(line);
            }
            System.out.println("Строк: " + lines.size());
            System.out.println("==============");
        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.add("adewgrgrgrgrg");

        try {
            Files.write(path2, lines, Charset.forName("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public static void stringsOperations()
    {
        Path path1 = Paths.get("C:/Users/Shvarts/Java Projects/InputOutput/1.txt");
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path1);


            String result = "";
            StringBuilder sb = new StringBuilder();


            for(String line : lines)
            {
                //System.out.println(line);
                //result+=line;
                sb.append(line).append('\n');
            }

            result = sb.toString();
            System.out.println(result);

            String newString = "Иван , Николай , Мария     , Александр ";

            String[] arrString = newString.split(",");
            for (String a:
                 arrString) {
                System.out.println(a.trim());
            }

            String s2 = "Samsung Galaxy 7, Samsung Galaxy Note, iPhone iPhone, Chinese Samsung Copy";
            String[] phones = s2.split(",");
            for (String phone:
                 phones) {
                System.out.println("--------");
                String phoneTrimmed = phone.trim();
                if(phoneTrimmed.startsWith("Samsung")) System.out.println("Samsung phone: " + phoneTrimmed);
                if(phoneTrimmed.contains("Copy")) System.out.println("Phone " + phoneTrimmed + " is a bad copy!");

                String phoneWithoutSpaces = phoneTrimmed.replace(' ', '_');
                System.out.println(phoneWithoutSpaces);

                System.out.println(phoneTrimmed.replace("iPhone", "XXX"));
                System.out.println(phoneTrimmed.replace("iPhone", ""));

                /*for(int i = 0; i < phoneTrimmed.length(); i++)
                {
                    System.out.println(phoneTrimmed.charAt(i));
                }*/

                System.out.println(phoneTrimmed.substring(1, 4));
                System.out.println(phoneTrimmed.toLowerCase());
                System.out.println(phoneTrimmed.toUpperCase());


            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
