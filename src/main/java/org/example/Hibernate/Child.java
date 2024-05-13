package org.example.Hibernate;

import java.util.Objects;

public class Child {
    private int id;
    private Integer age;
    private Object name;
    private Integer numberOfSamples;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
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
        Child child = (Child) o;
        return id == child.id && Objects.equals(age, child.age) && Objects.equals(name, child.name) && Objects.equals(numberOfSamples, child.numberOfSamples);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name, numberOfSamples);
    }
}
