package githubapi.service;

import githubapi.dto.OwnerResponse;
import githubapi.dto.RepositoryResponse;
import githubapi.repository.Repository;
import githubapi.service.impl.GithubServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class GithubServiceTest extends Assert{

    private final Repository repository = Mockito.mock(Repository.class);

    @Test
    public void createService(){
        GithubServiceImpl githubServiceImpl = new GithubServiceImpl(repository);
        assertNotNull(githubServiceImpl);
    }

    @Test
    public void getUserRepositoriesTest(){

        GithubServiceImpl githubServiceImpl = new GithubServiceImpl(repository);
        Mockito.when(repository.getRepositories("Rikanskey")).thenReturn(Arrays.asList(
                RepositoryResponse
                   .builder()
                   .id(1L)
                   .name("B_tree")
                   .full_name("Rikanskey/B_tree")
                   .owner(OwnerResponse.builder().login("Rikanskey").id(1L).build())
                   .build(),
                RepositoryResponse
                        .builder()
                        .id(2L)
                        .name("CinemaSearch")
                        .full_name("Rikanskey/CinemaSearch")
                        .owner(OwnerResponse.builder().login("Rikanskey").id(1L).build())
                        .build()
      ));
        List<RepositoryResponse> userRepositories = githubServiceImpl.getUserRepositories("Rikanskey");
        assertEquals(2, userRepositories.size());
    }

    @Test
    public void getUserRepositoriesGithubApiTest(){
        GithubService githubServiceImpl = new GithubServiceImpl(new Repository("https://api.github.com"));
        List<RepositoryResponse> userRepositories = githubServiceImpl.getUserRepositories("vladimir-polyakov");
        assertEquals(10, userRepositories.size());
    }
}
