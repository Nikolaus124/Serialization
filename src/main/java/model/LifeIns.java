package model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = LifeIns.Builder.class)

public class LifeIns extends Insurance{

    private int decl;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPOJOBuilder(withPrefix = "")

    public static class Builder extends Insurance.Builder<Builder> {
        private int decl;

        public Builder() {}

        public Builder Decl(int val) {
            decl = val;
            return this;
        }

        public LifeIns build() { return new LifeIns(this);

        }
    }
    protected LifeIns(Builder builder) {
        super(builder);
        decl = builder.decl;
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
        LifeIns e = (LifeIns) o;
        return (this == e);
    }

    @Override
    public String toString() {
        return "Number Of Declaration = " + this.decl;
    }

    @Override
    public int hashCode() {
        return decl;
    }

    public int getDecl() {
        return decl;
    }

    public void setDecl(int decl) {
        this.decl = decl;
    }

}
