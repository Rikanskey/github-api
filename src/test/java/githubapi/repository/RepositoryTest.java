package githubapi.repository;
import githubapi.dto.RepositoryResponse;
import org.junit.*;

import java.util.List;

public class RepositoryTest {

    @Test
    public void getRepositoriesTest() {
        Repository repository = new Repository("https://42f96a0f-5170-43ab-8d49-5893096fa17b.mock.pstmn.io");
        List<RepositoryResponse> repositoryResponses = repository.getRepositories("Rikanskey");
        Assert.assertEquals(2, repositoryResponses.size());
    }

    @Test
    public void getRepositoriesGithubApiTest() {
        Repository repository = new Repository("https://api.github.com");
        List<RepositoryResponse> repositoryResponses = repository.getRepositories("Rikanskey");
        Assert.assertEquals(4, repositoryResponses.size());
    }
}