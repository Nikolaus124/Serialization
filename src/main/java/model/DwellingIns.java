package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = DwellingIns.Builder.class)

public class DwellingIns extends Insurance{
    private String typedw;
    private double square;


    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPOJOBuilder(withPrefix = "")

    public static class Builder extends Insurance.Builder<Builder> {
        private String typedw;
        private double square;

        public Builder() {}

        public Builder Typedw(String val) {
            typedw = val;
            return this;
        }

        public Builder Square(double val) {
            square = val;
            return this;
        }

        public DwellingIns build() { return new DwellingIns(this);

        }
    }
    protected DwellingIns(Builder builder) {
        super(builder);
        typedw = builder.typedw;
        square = builder.square;
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
        DwellingIns e = (DwellingIns) o;
        return (this == e);
    }

    @Override
    public String toString() {
        return "Type Dwelling = " + this.typedw + "\n"
                + "Square = " + this.square;
    }

    @Override
    public int hashCode() {
        int result = 31 * typedw.hashCode();
        result = (int)(31 * result + square);
        return result;

    }
    public String getTypedw() {
        return typedw;
    }

    public void setTypedw(String typedw) {
        this.typedw = typedw;
    }

    public double getSquare() {
        return square;
    }

    public void setSquare(double square) {
        this.square = square;
    }
}