package com.zadanie5;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlSelectOneRadio;
import java.io.Serializable;
import java.util.List;
import java.util.Random;

/**
 * Created by Jan on 05.04.2017.
 */

@SessionScoped
@ManagedBean
public class Zadanie5 implements Serializable {
    private String imie, email, kod, wiek, plec, wyksztalcenie, rozmiar, pytanie1, pytanie3, pytanie6, pytanie7, pytanie8, pytanie9;
    private List<String> pytanie2, pytanie4, pytanie5;
    private boolean subviewM, subviewW;
    private HtmlSelectOneRadio selectOneRadio;

    public String getRandomBaner(){
        Random random = new Random();
        int wylosowana = random.nextInt(1);
        return "b" + wylosowana + ".jpg";
    }

    public Zadanie5() {
        this.subviewM = false;
        this.subviewW = false;
    }

    public HtmlSelectOneRadio getSelectOneRadio() {
        return selectOneRadio;
    }

    public void setSelectOneRadio(HtmlSelectOneRadio selectOneRadio) {
        this.selectOneRadio = selectOneRadio;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getWiek() {
        return wiek;
    }

    public void setWiek(String wiek) {
        this.wiek = wiek;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getWyksztalcenie() {
        return wyksztalcenie;
    }

    public void setWyksztalcenie(String wyksztalcenie) {
        this.wyksztalcenie = wyksztalcenie;
    }

    public String getRozmiar() {
        return rozmiar;
    }

    public void setRozmiar(String rozmiar) {
        this.rozmiar = rozmiar;
    }

    public String getPytanie1() {
        return pytanie1;
    }

    public void setPytanie1(String pytanie1) {
        this.pytanie1 = pytanie1;
    }

    public String getPytanie3() {
        return pytanie3;
    }

    public void setPytanie3(String pytanie3) {
        this.pytanie3 = pytanie3;
    }

    public String getPytanie6() {
        return pytanie6;
    }

    public void setPytanie6(String pytanie6) {
        this.pytanie6 = pytanie6;
    }

    public String getPytanie7() {
        return pytanie7;
    }

    public void setPytanie7(String pytanie7) {
        this.pytanie7 = pytanie7;
    }

    public String getPytanie8() {
        return pytanie8;
    }

    public void setPytanie8(String pytanie8) {
        this.pytanie8 = pytanie8;
    }

    public String getPytanie9() {
        return pytanie9;
    }

    public void setPytanie9(String pytanie9) {
        this.pytanie9 = pytanie9;
    }

    public List<String> getPytanie2() {
        return pytanie2;
    }

    public void setPytanie2(List<String> pytanie2) {
        this.pytanie2 = pytanie2;
    }

    public List<String> getPytanie4() {
        return pytanie4;
    }

    public void setPytanie4(List<String> pytanie4) {
        this.pytanie4 = pytanie4;
    }

    public List<String> getPytanie5() {
        return pytanie5;
    }

    public void setPytanie5(List<String> pytanie5) {
        this.pytanie5 = pytanie5;
    }

    public boolean isSubviewM() {
        return subviewM;
    }

    public void setSubviewM(boolean subviewM) {
        this.subviewM = subviewM;
    }

    public boolean isSubviewW() {
        return subviewW;
    }

    public void setSubviewW(boolean subviewW) {
        this.subviewW = subviewW;
    }

    //////////

    public String sendData(){
        return "podsumowanie.xhtml";
    }

    public void renderAdditionalQuestions(){
        if ("mężczyzna".equals(getSelectOneRadio().getValue().toString())){
            subviewM = true;
            subviewW = false;
        }
        else {
            subviewM = false;
            subviewW = true;
        }
    }
}
