package pl.empik.zadanierekrutacyjne.users.services;

import pl.empik.zadanierekrutacyjne.users.services.exception.UserDoesNotExistException;
import pl.empik.zadanierekrutacyjne.users.services.responsesObjects.UserGitHubResponse;

import java.io.IOException;

public interface GitHubService {
    UserGitHubResponse getGithubUserData(String login) throws IOException, UserDoesNotExistException;
}
