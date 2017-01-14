package ru.sstu.service;

import java.util.List;
import java.util.Random;

/**
 * Created by user on 09.01.2017.
 */
public class RandomValuesService {

    private Random r = new Random();
    private String characters = "abcdefghijklmnopqrstuvwxyz1234567890";

    public String randomString(int length)
    {
        StringBuilder sb = new StringBuilder();
        int charactersLength = characters.length();
        for(int i = 0; i < length; i++)
        {
            sb.append(characters.charAt(r.nextInt(charactersLength)));
        }
        return sb.toString();
    }

    public int randomInt(int fromInclusive, int toInclusive)
    {
        return fromInclusive + r.nextInt(toInclusive - fromInclusive + 1);
    }

    public String randomFromList(List<String> list)
    {
        return list.get(r.nextInt(list.size()));
    }
}