package pl.tostrowski.githubfetcher.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tostrowski.githubfetcher.model.GitRepo;
import pl.tostrowski.githubfetcher.service.FetcherService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/repository")
public class FetcherController {

    private final FetcherService fetcherService;

    public FetcherController(FetcherService fetcherService) {
        this.fetcherService = fetcherService;
    }

    @GetMapping
    public String index() {
        return "home";
    }

    @GetMapping("/userrepositories")
    public String getRepos(@RequestParam("username") String username, Model model) {
        List<GitRepo> gitRepos = fetcherService.get(username);
        System.out.println(gitRepos);
        if (!gitRepos.isEmpty()) {
            model.addAttribute("repos", gitRepos);
            model.addAttribute("siteTitle", gitRepos.get(0).getOwner() + " Repositories");
            return "repositories";
        }
        return "home";
    }

}
