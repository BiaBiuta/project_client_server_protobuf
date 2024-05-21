package org.example;

import org.example.AgeCategory;
import org.example.SampleCategory;

public record SampleResponse (
        Long id,
        SampleCategory sampleCategory,
        AgeCategory ageCategory){
}
