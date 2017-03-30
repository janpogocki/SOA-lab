package com.example.Zadanie4;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jan on 30.03.2017.
 */
public class Koszyk {
    private HashMap<Integer, Integer> koszyk = new HashMap<>();

    public void addProduct(Integer id) {
        if(koszyk.containsKey(id)){
            int actualCount = koszyk.get(id);
            koszyk.put(id, actualCount+1);
        }
        else {
            koszyk.put(id, 1);
        }
    }

    public void deleteProduct(int idProduct) {
        if(!koszyk.containsKey(idProduct)){
            return;
        }
        else {
            int stanAktualny = koszyk.get(idProduct);
            if (stanAktualny >= 1) {
                int nowyStan = stanAktualny-1;
                if(nowyStan != 0){
                    koszyk.replace(idProduct, stanAktualny-1);
                }
                else {
                    koszyk.remove(idProduct);
                }
            }
        }
    }

    public int getSize() {
        int suma = 0;
        for(Map.Entry<Integer, Integer> element : koszyk.entrySet()){
            suma = suma+element.getValue();
        }

        return suma;
    }

    public int getSizeOfID(int id){
        if (koszyk.get(id) != null)
            return koszyk.get(id);
        else
            return 0;
    }

    public int getFinalPrice(){
        int suma = 0;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("D:\\Java\\SOA-lab\\lab3\\web\\produkty.xml"));

            NodeList elements = doc.getElementsByTagName("price");

            for(Map.Entry<Integer, Integer> element : koszyk.entrySet()){
                suma = suma+(element.getValue() * Integer.parseInt(elements.item(element.getKey()-1).getTextContent()));
            }
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }

        return suma;
    }
}
