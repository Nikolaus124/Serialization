package model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(as = Customers.class )


public class Customers implements Serializable {
    private int id;
    private String fn;
    private String ln;
    private String bd;
    private int idcode;
    private String tel;
    private int idcard;

    public Customers() {
        super();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public Customers(int id, String fn, String ln, String bd, int idcode, String tel, int idcard) {
        this.id = id;
        this.fn = fn;
        this.ln = ln;
        this.bd = bd;
        this.idcode = idcode;
        this.tel = tel;
        this.idcard = idcard;
    }

    @Override
    public String toString() {
        return "ID=" + this.id + "\n"
                + "First Name=" + this.fn + "\n"
                + "Last Name=" + this.ln + "\n"
                + "Birth Date=" + this.bd + "\n"
                + "Identification Code=" + this.idcode + "\n"
                + "Tel=" + this.tel + "\n"
                + "ID Card=" + this.idcard + "\n";

    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        Customers e = (Customers) o;
        return (this == e);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fn.hashCode();
        result = 31 * result + ln.hashCode();
        result = 31 * result + bd.hashCode();
        result = 31 * result + idcode;
        result = 31 * result + tel.hashCode();
        result = 31 * result + idcard;
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getBd() {
        return bd;
    }

    public void setBd(String bd) {
        this.bd = bd;
    }

    public int getIdcode() {
        return idcode;
    }

    public void setIdcode(int idcode) {
        this.idcode = idcode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getIdcard() {
        return idcard;
    }

    public void setIdcard(int idcard) {
        this.idcard = idcard;
    }
}
