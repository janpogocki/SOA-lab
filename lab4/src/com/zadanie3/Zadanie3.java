package com.zadanie3;

import javax.faces.bean.ManagedBean;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 * Created by Jan on 04.04.2017.
 */

@ManagedBean
public class Zadanie3 {
    private boolean disable;
    private String imie, nazwisko, wiek, plec, wojewodztwo;
    private HtmlCommandButton buttonSubmit;
    private HtmlSelectOneMenu selectOneMenu;

    public Zadanie3(){
        this.disable = false;
    }

    public boolean isDisable() {
        return disable;
    }

    public HtmlSelectOneMenu getSelectOneMenu() {
        return selectOneMenu;
    }

    public void setSelectOneMenu(HtmlSelectOneMenu selectOneMenu) {
        this.selectOneMenu = selectOneMenu;
    }

    public HtmlCommandButton getButtonSubmit() {
        return buttonSubmit;
    }

    public void setButtonSubmit(HtmlCommandButton buttonSubmit) {
        this.buttonSubmit = buttonSubmit;
    }

    public void setDisable(boolean disable){
        this.disable = disable;
    }

    public void activeButton(ValueChangeEvent e){
        if (!selectOneMenu.getValue().equals("0"))
            buttonSubmit.setDisabled(false);
        else
            buttonSubmit.setDisabled(true);
    }

    public void setWiek(String wiek) {
        this.wiek = wiek;
    }

    public String getWiek() {
        return wiek;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPlec() {
        return plec;
    }

    public void setPlec(String plec) {
        this.plec = plec;
    }

    public String getWojewodztwo() {
        return wojewodztwo;
    }

    public void setWojewodztwo(String wojewodztwo) {
        this.wojewodztwo = wojewodztwo;
    }

    public String sendData(){
        if (!wojewodztwo.equals("0"))
            return "podsumowanie.xhtml";

        return "blad.xhtml";
    }
}
