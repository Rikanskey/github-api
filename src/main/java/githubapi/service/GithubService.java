package githubapi.service;

import githubapi.dto.RepositoryResponse;

import java.util.List;

public interface GithubService {
    List<RepositoryResponse> getUserRepositories(String user);
}
