package pl.empik.zadanierekrutacyjne.users.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;
import pl.empik.zadanierekrutacyjne.users.services.exception.UserDoesNotExistException;
import pl.empik.zadanierekrutacyjne.users.services.responsesObjects.UserGitHubResponse;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class GitHubServiceImpl implements GitHubService {

    private final ObjectMapper mapper;

    public GitHubServiceImpl() {
        mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
    }

    @Override
    public UserGitHubResponse getGithubUserData(final String login) throws IOException, UserDoesNotExistException {
        return queryGitHubApi(login);
    }

    private UserGitHubResponse queryGitHubApi(final String login) throws IOException, UserDoesNotExistException {

        URL url = new URL(String.format("https://api.github.com/users/%s", login));

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("accept", "application/json");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream responseStream = connection.getInputStream();
            return mapper.readValue(responseStream, UserGitHubResponse.class);
        }

        throw new UserDoesNotExistException();
    }

}
