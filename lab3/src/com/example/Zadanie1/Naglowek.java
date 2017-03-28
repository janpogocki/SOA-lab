package com.example.Zadanie1;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Jan on 28.03.2017.
 */
public class Naglowek extends SimpleTagSupport {
    private String tresc_naglowka;
    private String wyrownanie_naglowka;
    private String kolor_tresci_akapitu;

    public void setTresc_naglowka(String tresc_naglowka) {
        this.tresc_naglowka = tresc_naglowka;
    }

    public void setWyrownanie_naglowka(String wyrownanie_naglowka) {
        this.wyrownanie_naglowka = wyrownanie_naglowka;
    }

    public void setKolor_tresci_akapitu(String kolor_tresci_akapitu) {
        this.kolor_tresci_akapitu = kolor_tresci_akapitu;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.println("<h1>" + tresc_naglowka + "</h1><p");

        if (!"".equals(wyrownanie_naglowka))
            out.println(" align=\"" + wyrownanie_naglowka + "\"");

        if (!"".equals(kolor_tresci_akapitu))
            out.println(" style=\"color: " + kolor_tresci_akapitu + "\"");

        out.println(">");
        getJspBody().invoke(out);
        out.println("</p>");
    }
}
