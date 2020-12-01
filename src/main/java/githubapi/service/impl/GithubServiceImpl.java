package githubapi.service.impl;

import githubapi.dto.RepositoryResponse;
import githubapi.repository.Repository;
import githubapi.service.GithubService;

import java.util.List;

public class GithubServiceImpl implements GithubService {
    private final Repository repository;

    public GithubServiceImpl(Repository repository) {
        this.repository = repository;
    }

    public List<RepositoryResponse> getUserRepositories(String user){
        return repository.getRepositories(user);
    }
}
