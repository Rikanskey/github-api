package githubapi.service;

import githubapi.dto.OwnerResponse;
import githubapi.dto.RepositoryResponse;
import githubapi.repository.Repository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

public class GithubServiceTest extends Assert{

    private final Repository repository = Mockito.mock(Repository.class);

    @Test
    public void createService(){
        GithubService githubService = new GithubService(repository);
        assertNotNull(githubService);
    }

    @Test
    public void getUserRepositoriesTest(){

        GithubService githubService = new GithubService(repository);
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
        List<RepositoryResponse> userRepositories = githubService.getUserRepositories("Rikanskey");
        assertEquals(2, userRepositories.size());
    }
}
