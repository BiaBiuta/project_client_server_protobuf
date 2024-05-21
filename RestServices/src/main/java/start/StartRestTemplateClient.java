package start;

import org.example.AgeCategory;
import org.example.Child;
import org.example.Sample;
import org.example.SampleCategory;
import org.springframework.web.client.RestClientException;
import rest.client.Client;

import java.util.List;

public class StartRestTemplateClient {
    private final static Client client = new Client();

    public static void main(String[] args) {
        Child child = new Child("test2024", 13);
        Sample sample = new Sample(SampleCategory.ALTELE, AgeCategory.ANI_12_15); // Presupunând că aveți deja un obiect de tip Sample

        try {
            // Adaugă un nou copil
            System.out.println("Adding a new child: " + child);
            show(() -> System.out.println(client.create(child)));

            // Informații pentru un copil după nume
            System.out.println("\nInfo for child with name=Stefan");
            show(() -> System.out.println(client.getByName("Stefan")));

            // Adaugă un nou sample
            System.out.println("\nAdding a new sample: " + sample);
            Sample newSample =client.createSample(sample);
            show(() -> System.out.println(newSample.toString()));
            newSample.setAgeCategory(AgeCategory.ANI_6_8);
            System.out.println("Updated sample: " + client.updateSample(newSample));


            // Informații pentru un sample după ID
            System.out.println("\nInfo for sample with ID=1");
            show(() -> System.out.println(client.findSampleById(1).toString()));


            System.out.println("\nDeleting sample with "+ newSample.getId()+" ID");
            show(() -> client.deleteSample(newSample));


        } catch (RestClientException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    private static void show(Runnable task) {
        try {
            task.run();
        } catch (chat.services.rest.ServiceException e) {
            System.out.println("Service exception: " + e);
        }
    }
}
