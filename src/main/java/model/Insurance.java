package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.io.Serializable;

@JsonDeserialize(builder = Insurance.Builder.class)
@JsonIgnoreProperties(ignoreUnknown = true)

public class Insurance implements Serializable {

    private int idi;
    private int sn;
    private Customers cust;
    private Employees emp;
    private String instype;
    private String crd;
    private double term;
    private double amount;

    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder<T extends Builder<T>> {

        private int idi;
        private int sn;
        private Customers cust;
        private Employees emp;
        private String instype;
        private String crd;
        private double term;
        private double amount;

        public Builder() {
        }

        public T idi(int val) {
            idi = val;
            return (T) this;
        }

        public T sn(int val) {
            sn = val;
            return (T) this;
        }

        public T cust(Customers val) {
            cust = val;
            return (T) this;
        }

        public T emp(Employees val) {
            emp = val;
            return (T) this;
        }

        public T instype(String val) {
            instype = val;
            return (T) this;
        }

        public T crd(String val) {
            crd = val;
            return (T) this;
        }

        public T term(double val) {
            term = val;
            return (T) this;
        }

        public T amount(double val) {
            amount = val;
            return (T) this;
        }

        public Insurance build() {
            return new Insurance(this);
        }
    }

    protected Insurance(Builder<?> builder) {
        idi = builder.idi;
        sn = builder.sn;
        cust = builder.cust;
        emp = builder.emp;
        instype = builder.instype;
        crd = builder.crd;
        term = builder.term;
        amount = builder.amount;
    }

    @Override
    public String toString() {
        return "ID=" + this.idi + "\n"
                + "Serial Number=" + this.sn + "\n"
                + "Customer=" + this.cust.getFn() + " " + this.cust.getLn() + "\n"
                + "Employee=" + this.emp.getFn() + " " + this.emp.getLn() + "\n"
                + "Insurance Type=" + this.instype + "\n"
                + "Create Date=" + this.crd + "\n"
                + "Term=" + this.term + "\n"
                + "Amount=" + this.amount + "\n";

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
        Insurance e = (Insurance) o;
        return (this == e);
    }

    @Override
    public int hashCode() {
        int result = idi + sn;
        result = 31 * result + cust.hashCode();
        result = 31 * result + emp.hashCode();
        result = 31 * result + instype.hashCode();
        result = 31 * result + crd.hashCode();
        result = (int) (31 * result + term);
        result = (int) (31 * result + amount);
        return result;

    }


    public static void main(String[] args) {
        Customers cus = new Customers(1, "Peter", "Steven", "21-04-2001", 56464, "+38054123678", 656454);
        Employees emp = new Employees(1, "John", "Inc", "2017-1-25", 55448749, "+38054123678");
        //Insurance ins = new Insurance(1, 23423, cus, emp, "FULL", "21-09-2020", 1, 15600);
        //System.out.println(ins);
        //System.out.println(ins.hashCode());
    }
    public int getIdi() {
        return idi;
    }

    public void setIdi(int idi) {
        this.idi = idi;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public Customers getCust() {
        return cust;
    }

    public void setCust(Customers cust) {
        this.cust = cust;
    }

    public Employees getEmp() {
        return emp;
    }

    public void setEmp(Employees emp) {
        this.emp = emp;
    }

    public String getInstype() {
        return instype;
    }

    public void setInstype(String instype) {
        this.instype = instype;
    }

    public String getCrd() {
        return crd;
    }

    public void setCrd(String crd) {
        this.crd = crd;
    }

    public double getTerm() {
        return term;
    }

    public void setTerm(double term) {
        this.term = term;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

















