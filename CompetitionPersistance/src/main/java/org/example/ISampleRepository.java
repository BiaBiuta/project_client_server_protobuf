package org.example;




public interface ISampleRepository extends IRepository<Integer, Sample>{
     Sample findOneByCategoryAndAge(String category, String age_category);
     Sample updateSample(Sample sample);
     Sample deleteSample(Sample sample);
}
