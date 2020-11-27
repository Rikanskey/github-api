package githubapi.service;

import org.junit.Assert;
import org.junit.Test;

public class GithubServiceTest extends Assert{

    @Test
    public void createService(){
        GithubService githubService = new GithubService();
        assertNotNull(githubService);
    }
}
