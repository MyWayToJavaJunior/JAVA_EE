package sample;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Shvarts on 23.11.2016.
 */
public class MySAXHandler extends DefaultHandler {

    boolean inAlbums = false, inAlbum = false, inTrack = false, inName = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
    {
        //System.out.println("START:");
        //System.out.println("uri = "  + uri);
        //System.out.println("qName = "  + qName);
        //System.out.println("local = "  + localName);
        //System.out.println("id=" + attributes.getValue("id"));
        for(int i = 0; i< attributes.getLength(); i++)
        {
            //System.out.println(attributes.getQName(i) + " = " + attributes.getValue(i));
        }

        switch(qName)
        {
            case "albums":
                inAlbums = true;
                break;
            case "album":
                inAlbum = true;
                break;
            case "track":
                inTrack = true;
                break;
            case "name":
                inName = true;
                break;
        }
        /*if(qName.equals("name"))
        {
            System.out.println("Название ... = ?");
        }*/

    }

    @Override
    public void endElement(String uri, String localName, String qName)
    {
        //System.out.println("END:");
        //System.out.println("uri = "  + uri);
        //System.out.println("qName = "  + qName);
        //System.out.println("local = "  + localName);

        switch(qName)
        {
            case "albums":
                inAlbums = false;
                break;
            case "album":
                inAlbum = false;
                break;
            case "track":
                inTrack = false;
                break;
            case "name":
                inName = false;
                break;
        }
    }

    @Override
    public void characters(char ch[], int start, int length)
    {
        /*System.out.println("CHARACTERS:");*/
        if(inName) {
            String s = new String(ch, start, length);
            if (inTrack)
                System.out.println("Трек называется " + s);
            else if (inAlbums && !inTrack && !inAlbum)
                System.out.println("Коллекция называется " + s);
            else if (inAlbum && !inTrack)
                System.out.println("Альбом называется " + s);
        }

    }

}
