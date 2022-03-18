package pl.tostrowski.githubfetcher.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.tostrowski.githubfetcher.model.GitProfile;
import pl.tostrowski.githubfetcher.model.GitRepo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FetcherService {

    public List<GitRepo> get(String username){
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<GitProfile[]> exchange = restTemplate.exchange("https://api.github.com/users/" + username + "/repos",
                HttpMethod.GET,
                httpEntity,
                GitProfile[].class);

        if (exchange.getStatusCode() == HttpStatus.OK){
            List<GitRepo> repos = Stream.of(exchange.getBody()).map(gitProfile -> new GitRepo(
                    gitProfile.getName(),
                    gitProfile.getOwner().getLogin(),
                    gitProfile.getDescription(),
                    gitProfile.getCreatedAt(),
                    gitProfile.getStargazersCount(),
                    gitProfile.getLanguage(),
                    gitProfile.getHtmlUrl())).collect(Collectors.toList());
            return repos;
        }

        return null;
    }

}
