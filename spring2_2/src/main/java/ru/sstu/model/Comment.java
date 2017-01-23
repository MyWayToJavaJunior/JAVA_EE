package ru.sstu.model;

import java.util.*;

/**
 * Created by Shvarts on 13.01.2017.
 */
public class Comment {
    public Comment()
    {
        gendersMap.put("M", "male");
        gendersMap.put("F", "female");
        gendersMap.put("U", "undefined");
    }

    public Comment(String author, String message)
    {
        this.author = author;
        this.message = message;
    }

    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    private String gender;


    public List<String> getGenders() {
        return genders;
    }

    private List<String> genders = Arrays.asList("M", "F", "U");


    public Map<String, String> getGendersMap() {
        return gendersMap;
    }

    private Map<String, String> gendersMap = new HashMap();


    public List<String> getLanguagesNames() {
        return languagesNames;
    }

    private List<String> languagesNames = Arrays.asList("Java", "C#", "C", "JavaScript");

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    private List<String> languages = new ArrayList<>();

}
