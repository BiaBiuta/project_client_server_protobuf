package org.example;




public interface ISampleRepository extends IRepository<Integer, Sample>{
     Sample findOneByCategoryAndAge(String category, String age_category);

}
