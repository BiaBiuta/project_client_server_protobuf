package org.example.protobuffprotocol;

import org.example.*;
import org.example.javaFiles.ChildDTO;
import org.example.javaFiles.OrganizingDTO;
import org.example.javaFiles.RegistrationDTO;
import org.example.javaFiles.SampleDTO;

import java.util.ArrayList;
import java.util.List;

public class DTOUtils {
    public static Organizing getFromDTO(OrganizingDTO orgdto) {
        String username = orgdto.getUsername();
        String password = orgdto.getPassword();
        if(orgdto.getId()!=""){
            Organizing org=new Organizing(username,password);
            org.setId(Integer.parseInt(orgdto.getId()));
            return org;

        }
//        String name = orgdto.getName();
        return new Organizing(username, password);
    }
//    public  static  OrganizingDTO getDTO(Organizing org){
//        String username=org.getUsername();
//        String password=org.getPassword();
//        String name=org.getName();
//
//        if(org.getId()!=null) {
//            String id=org.getId().toString();
//            return new OrganizingDTO(id, username, password);
//        }
//        else {
//            return new OrganizingDTO(username, password);
//        }
//    }
    public static Sample getFromDTO(SampleDTO sampleDTO) {
        String sampleCategory = sampleDTO.getSampleCategory();
        System.out.println(sampleCategory);
        String ageCategory = sampleDTO.getAgeCategory();
        System.out.println(sampleCategory);
        String id = sampleDTO.getId();
        Sample sam=new Sample(SampleCategory.fromString(sampleCategory), AgeCategory.fromString(ageCategory));
        if(id!="")
            sam.setId(Integer.parseInt(id));

        return sam;
    }
//    public static RegistrationDTO getDTO(Registration sample) {
//        String sampleId = sample.getSample().getId().toString();
//        String childId = sample.getChild().getId().toString();
//        return new RegistrationDTO(childId, sampleId,sample.getSample().getSampleCategory().getCategoryName(),sample.getSample().getAgeCategory().getCategoryName());
//    }
    public static Registration getFromDTO(RegistrationDTO sampleDTO) {
        Sample sampleId=new Sample(sampleDTO.getSampleId());
        if(sampleDTO.getSampleCategory()!="" && sampleDTO.getAgeCategory()!="") {
            sampleId.setSampleCategory(SampleCategory.fromString(sampleDTO.getSampleCategory()));
            sampleId.setAgeCategory(AgeCategory.fromString(sampleDTO.getAgeCategory()));
        }
            sampleId.setId(Integer.parseInt(sampleDTO.getSampleId()));
            Child childId=new Child (sampleDTO.getChildId());
            childId.setId(Integer.parseInt(sampleDTO.getChildId()));
            return new Registration(childId,sampleId);
    }
//    public static SampleDTO getDTO(Sample sample){
//        if(sample.getId()==null){
//            String sampleCategory=sample.getSampleCategory().getCategoryName();
//            String ageCategory=sample.getAgeCategory().getCategoryName();
//            return new SampleDTO(sampleCategory,ageCategory);
//        }
//        String id=sample.getId().toString();
//        if(sample.getSampleCategory()==null|| sample.getAgeCategory()==null){
//            return new SamplesDTO(id);
//        }
//        String sampleCategory=sample.getSampleCategory().getCategoryName();
//        String ageCategory=sample.getAgeCategory().getCategoryName();
//        return new SamplesDTO(id,sampleCategory,ageCategory);
//}
    public static Child getFromDTO(ChildDTO sampleDTO) {
        String id=sampleDTO.getId();
        String name = sampleDTO.getName();
        Child child;
        if (sampleDTO.getAge().isEmpty()) {
            return  new Child(name, 0);

        }
        int age = Integer. parseInt(sampleDTO.getAge());
            child= new Child(name, age);
        if(id!="")
            child.setId(Integer.parseInt(id));
        if(sampleDTO.getNumber()!="") {
            child.setNumberOfSamples(Integer.parseInt(sampleDTO.getNumber()));
        }
        else{
            child.setNumberOfSamples(0);
        }
        return child;
    }
//    public static  ChildDTO getDTO(Child sample){
//        String name=sample.getName();
//        String age=sample.getAge().toString();
//        String numberOfSamples=String.valueOf(sample.getNumberOfSamples());
//        if(sample.getId()==null)
//            return new ChildDTO(name,age,numberOfSamples);
//        String id=sample.getId().toString();
//        ChildDTO childDTO=new ChildDTO(id,name,age,numberOfSamples);
//        return childDTO;
//    }
    public static List<Sample> getFromDTOSamples(Iterable<SampleDTO> samplesDTO) {
        List<Sample> samples=new ArrayList<>();
        samplesDTO.forEach(s->samples.add(getFromDTO(s)));
        return samples;
    }
//    public static List <SampleDTO> getDTOSample(Iterable<Sample> samples) {
//        List<SampleDTO> sample=new ArrayList<>();
//        for (Sample s : samples) {
//            sample.add(getDTO(s));
//        }
//        return sample;
//    }
//    public static List <RegistrationDTO> getDTOReg(List<Registration> samples) {
//        List<RegistrationDTO> sample=new ArrayList<>();
//        for (int i=0;i<samples.size();i++)
//            sample.add(getDTO(samples.get(i)));
//        return sample;
//    }
//    public static List <ChildDTO> getDTOChild(List<Child> samples) {
//        List<ChildDTO> sample=new ArrayList<>();
//        for (int i=0;i<samples.size();i++)
//            sample.add(getDTO(samples.get(i)));
//        return sample;
//    }
    public static List<Child> getFromDTOChild(List<ChildDTO> samplesDTO) {
        List<Child> samples=new ArrayList<>();
        samplesDTO.forEach(s->samples.add(getFromDTO(s)));
        return samples;
    }


}
