package githubapi.service;

import githubapi.dto.RepositoryResponse;
import githubapi.repository.Repository;

import java.util.List;

public class GithubService {
    private final Repository repository;

    public GithubService(Repository repository) {
        this.repository = repository;
    }

    List<RepositoryResponse> getUserRepositories(String user){
        return repository.getRepositories(user);
    }
}
