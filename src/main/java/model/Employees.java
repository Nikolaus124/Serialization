package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(as = Employees.class)

public class Employees implements Serializable {
    private int id;
    private String fn;
    private String ln;
    private String bd;
    private int licnumb;
    private String tel;

    public Employees() {
        super();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public Employees(int id, String fn, String ln, String bd, int licnumb, String tel) {
        this.id = id;
        this.fn = fn;
        this.ln = ln;
        this.bd = bd;
        this.licnumb = licnumb;
        this.tel = tel;
    }
    @Override
    public String toString() {
        return "ID=" + this.id + "\n"
                + "First Name=" + this.fn + "\n"
                + "Last Name=" + this.ln + "\n"
                + "Birth Date=" + this.bd + "\n"
                + "License Number=" + this.licnumb + "\n"
                + "Tel=" + this.tel + "\n";

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
        Employees e = (Employees) o;
        return (this == e);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fn.hashCode();
        result = 31 * result + ln.hashCode();
        result = 31 * result + bd.hashCode();
        result = 31 * result + licnumb;
        result = 31 * result + tel.hashCode();
        result = 31 * result + licnumb;
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

    public int getLicnumb() {
        return licnumb;
    }

    public void setLicnumb(int licnumb) {
        this.licnumb = licnumb;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
