package githubapi.repository;
import githubapi.dto.RepositoryResponse;
import org.junit.*;

import java.util.List;

public class RepositoryTest {

    @Test
    public void getRepositoriesTest() {
        Repository repository = new Repository();
        List<RepositoryResponse> repositoryResponses = repository.getRepositories("Rikanskey");
        Assert.assertEquals(2, repositoryResponses.size());
    }
}