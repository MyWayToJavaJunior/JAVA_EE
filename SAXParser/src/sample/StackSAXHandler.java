package sample;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shvarts on 23.11.2016.
 */
public class StackSAXHandler extends DefaultHandler {

    private List<String> stack = new LinkedList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
    {
        System.out.println("Element found:" + qName);
        stack.add(qName);
        stack.forEach(System.out::println);
    }

    @Override
    public void endElement(String uri, String localName, String qName)
    {
        stack.remove(stack.size()-1);
    }

    @Override
    public void characters(char ch[], int start, int length)
    {
        String s = new String(ch, start, length);
        int size = stack.size();
        if(stack.get(size-1).equals("name")) {
            if (stack.get(size - 2).equals("albums"))
                System.out.println("Коллекция называется " + s);
            else if (stack.get(size - 2).equals("album"))
                System.out.println("Альбом называется " + s);
            else if (stack.get(size - 2).equals("track"))
                System.out.println("Трек называется " + s);
        }

    }
}
