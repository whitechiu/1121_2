package test.project.a1121_2;

import android.util.Log;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by user on 2016/11/21.
 */

public class MyDataHandler extends DefaultHandler {

    boolean isTitle = false;
    boolean isItem = false;
    boolean isLink = false;
    ArrayList<String> titleList = new ArrayList<>();
    ArrayList<String> linkList = new ArrayList<>();
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if(qName.equals("title"))
        {
            isTitle = true;
        }
        if(qName.equals("item"))
        {
            isItem = true;
        }
        if(qName.equals("link"))
        {
            isLink = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(qName.equals("title"))
        {
            isTitle = false;
        }
        if(qName.equals("item"))
        {
            isItem = false;
        }
        if (qName.equals("link"))
        {
            isLink = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        if(isTitle && isItem)
        {
            String str = new String(ch).substring(start, start + length);
            Log.d("XML", str);
            titleList.add(str);
        }
        if(isLink && isItem)
        {
            String str = new String(ch).substring(start, start + length);
            linkList.add(str);
        }
    }
}
