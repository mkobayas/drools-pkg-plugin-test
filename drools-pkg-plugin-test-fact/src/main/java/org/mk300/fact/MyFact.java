package org.mk300.fact;

import java.math.BigDecimal;
import java.math.BigInteger;

public class MyFact {

    private String name;
    private int age;
    private BigDecimal bigDecimal;
    private BigInteger bigInteger;
    
    private MyFact child;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public BigInteger getBigInteger() {
        return bigInteger;
    }

    public void setBigInteger(BigInteger bigInteger) {
        this.bigInteger = bigInteger;
    }

    public MyFact getChild() {
        return child;
    }

    public void setChild(MyFact child) {
        this.child = child;
    }
    
    
}
