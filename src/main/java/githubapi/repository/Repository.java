package githubapi.repository;

import com.fasterxml.jackson.core.type.TypeReference;
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

    private final String api = "https://42f96a0f-5170-43ab-8d49-5893096fa17b.mock.pstmn.io";

    public List<RepositoryResponse> getRepositories(String user) {
        List<RepositoryResponse> repositoryResponses = new ArrayList<>();
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(api + "/users/" + user + "/repos"))
                    .GET()
                    .build();
            HttpResponse response = HttpClient.newHttpClient().send(request,
                    HttpResponse.BodyHandlers.ofString());
            ObjectMapper objectMapper = new ObjectMapper();
            repositoryResponses = objectMapper
                    .reader()
                    .forType(new TypeReference<List<RepositoryResponse>>(){})
                    .readValue(response.body().toString());
        }
         catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return repositoryResponses;
    }
}
