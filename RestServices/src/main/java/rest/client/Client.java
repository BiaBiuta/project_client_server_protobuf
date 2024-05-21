package rest.client;

import org.example.Child;
import org.example.Sample;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.Callable;

public class Client {
    public static final String URL = "http://localhost:8080";

    private RestTemplate restTemplate = new RestTemplate();

    private <T> T execute(Callable<T> callable) {
        try {
            return callable.call();
        } catch (ResourceAccessException | HttpClientErrorException e) { // server down, resource exception
            throw new chat.services.rest.ServiceException(e);
        } catch (Exception e) {
            throw new chat.services.rest.ServiceException(e);
        }
    }

    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

    // Metode pentru operațiuni legate de copii
    public Child getByName(String name) {
        return execute(() -> restTemplate.exchange(URL + "/children/child/{name}", HttpMethod.GET, new HttpEntity<>(createHeaders()), Child.class, name).getBody());
    }

    public Child create(Child child) {
        return execute(() -> restTemplate.exchange(URL + "/children/child", HttpMethod.POST, new HttpEntity<>(child, createHeaders()), Child.class).getBody());
    }

    public void deleteChild(String id) {
        execute(() -> {
            restTemplate.exchange(URL + "/children/child/{id}", HttpMethod.DELETE, new HttpEntity<>(createHeaders()), Void.class, id);
            return null;
        });
    }

    // Metode pentru operațiuni legate de eșantioane (Samples)
    public int numberOfSamples(Sample sample) {
        return execute(() -> restTemplate.exchange(URL + "/samples?ageCategory={ageCategory}&desen={desen}", HttpMethod.GET, new HttpEntity<>(createHeaders()), Integer.class, sample.getAgeCategory(), sample.getSampleCategory()).getBody());
    }

    public Sample findSampleById(Integer id) {
        return execute(() -> restTemplate.exchange(URL + "/samples/{id}", HttpMethod.GET, new HttpEntity<>(createHeaders()), Sample.class, id).getBody());
    }

    public Sample createSample(Sample sample) {
        return execute(() -> restTemplate.exchange(URL + "/samples/create", HttpMethod.POST, new HttpEntity<>(sample, createHeaders()), Sample.class).getBody());
    }

    public Sample updateSample(Sample sample) {
        restTemplate.exchange(URL + "/samples/update", HttpMethod.PUT, new HttpEntity<>(sample, createHeaders()), Void.class);
        return sample;
    }

    public Sample deleteSample(Sample sample) {
        restTemplate.exchange(URL + "/samples/delete", HttpMethod.DELETE, new HttpEntity<>(sample, createHeaders()), Void.class);
        return sample;
    }

    public List<Sample> findAllSamples() {
        return execute(() -> restTemplate.exchange(URL + "/samples", HttpMethod.GET, new HttpEntity<>(createHeaders()), List.class).getBody());
    }
}
