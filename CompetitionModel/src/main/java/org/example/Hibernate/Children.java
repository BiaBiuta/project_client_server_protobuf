package org.example.Hibernate;

import java.util.Objects;

public class Children {
    //private int id;
    private Integer age;
    private String name;
    private Integer numberOfSamples;

//    //public int getId() {
//        return id;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfSamples() {
        return numberOfSamples;
    }

    public void setNumberOfSamples(Integer numberOfSamples) {
        this.numberOfSamples = numberOfSamples;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Children children = (Children) o;
        return  Objects.equals(age, children.age) && Objects.equals(name, children.name) && Objects.equals(numberOfSamples, children.numberOfSamples);
    }

    @Override
    public int hashCode() {
        return Objects.hash( age, name, numberOfSamples);
    }
}
