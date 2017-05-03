package pl.agh.biblioteka.books;

import javax.xml.bind.annotation.*;

/**
 * Created by Jan on 20.04.2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "title", propOrder = {
        "value"
})
public class Title {
    @XmlValue
    protected String value;
    @XmlAttribute(name = "lang", required = true)
    protected String lang;

    public Title (){}
    public Title(String value, String lang){
        this.value=value;
        this.lang=lang;
    }

    public String getLang() {
        return lang;
    }

    public String getValue() {
        return value;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
