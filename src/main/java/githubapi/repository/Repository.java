package githubapi.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import githubapi.dto.RepositoryResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Repository {

    private final String api;


    public List<RepositoryResponse> getRepositories(String user) {
        List<RepositoryResponse> repositoryResponses = new ArrayList<>();
        try {
            repositoryResponses = tryCreateHttpRequest(user);
        }
         catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
        return repositoryResponses;
    }

    public List<RepositoryResponse> tryCreateHttpRequest(String user)
            throws InterruptedException, IOException{
        return mappingResponse(sendGetRequestUserRepositories(user));
    }

    private HttpResponse<?> sendGetRequestUserRepositories(String user) throws InterruptedException, IOException {
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(api + "/users/" + user + "/repos"))
                .GET()
                .build();
        return HttpClient.newHttpClient().send(request,
                HttpResponse.BodyHandlers.ofString());
    }

    private List<RepositoryResponse> mappingResponse(HttpResponse<?> response) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return objectMapper
                .reader()
                .forType(new TypeReference<List<RepositoryResponse>>(){})
                .readValue(response.body().toString());
    }
}
