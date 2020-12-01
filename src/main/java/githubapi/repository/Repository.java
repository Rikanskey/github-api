package githubapi.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import githubapi.dto.RepositoryResponse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    private final String api;

    public Repository(String api){
        this.api = api;
    }

    public List<RepositoryResponse> getRepositories(String user) {
        List<RepositoryResponse> repositoryResponses = new ArrayList<>();
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(api + "/users/" + user + "/repos"))
                    .GET()
                    .build();
            HttpResponse<?> response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            repositoryResponses = objectMapper
                    .reader()
                    .forType(new TypeReference<List<RepositoryResponse>>(){})
                    .readValue(response.body().toString());
        }
         catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return repositoryResponses;
    }
}
