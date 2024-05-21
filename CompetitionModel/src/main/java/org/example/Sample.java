package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class Sample extends GenericEntity<Integer> implements Serializable {
    @JsonProperty("sampleCategory")
    private SampleCategory sampleCategory;
    @JsonProperty("ageCategory")
    private AgeCategory ageCategory;

    public Sample() {
        // Default constructor needed by Jackson
    }

    public Sample(String sampleId) {
        super();
    }

    public Sample(SampleCategory sampleCategory, AgeCategory ageCategory) {
        this.sampleCategory = sampleCategory;
        this.ageCategory = ageCategory;
    }

    public AgeCategory getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(AgeCategory ageCategory) {
        this.ageCategory = ageCategory;
    }

    public SampleCategory getSampleCategory() {
        return sampleCategory;
    }

    public void setSampleCategory(SampleCategory sampleCategory) {
        this.sampleCategory = sampleCategory;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "sampleCategory=" + sampleCategory +
                ", ageCategory=" + ageCategory +
                ", id=" + id +
                '}';
    }
}

