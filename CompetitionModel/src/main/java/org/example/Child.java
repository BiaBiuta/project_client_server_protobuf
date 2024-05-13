package org.example;

//import jakarta.persistence.Column;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Entity;
import java.io.Serializable;

@Entity
@Table(name = "children")
public class Child extends GenericEntity<Integer> implements Serializable {
    private Integer age;
    private String name;
    private int numberOfSamples;
    public Child(String name, Integer age ) {
        this.name = name;
        this.age = age;
        this.numberOfSamples = 0;
    }
    public  Child(){
        this.name="";
        this.age=0;
        this.numberOfSamples=0;
    }

    public Child(String childId) {
        super();
    }
    @Column(name = "number_of_samples")
    public int getNumberOfSamples() {
        return numberOfSamples;
    }

    public void setNumberOfSamples(int numberOfSamples) {
        this.numberOfSamples = numberOfSamples;
    }
  @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
  @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
