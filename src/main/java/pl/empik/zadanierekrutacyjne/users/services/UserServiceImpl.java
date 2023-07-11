package pl.empik.zadanierekrutacyjne.users.services;

import org.springframework.stereotype.Service;
import pl.empik.zadanierekrutacyjne.users.repositories.UserRequestCountRepository;
import pl.empik.zadanierekrutacyjne.users.repositories.entity.UserRequestCount;
import pl.empik.zadanierekrutacyjne.users.services.exception.UserDoesNotExistException;
import pl.empik.zadanierekrutacyjne.users.services.responsesObjects.UserGitHubResponse;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRequestCountRepository userRequestCountRepository;
    private final GitHubService gitHubService;

    public UserServiceImpl(UserRequestCountRepository userRequestCountRepository, GitHubService gitHubService) {
        this.userRequestCountRepository = userRequestCountRepository;
        this.gitHubService = gitHubService;
    }

    @Transactional
    public UserGitHubResponse getUserGithubUserByLogin(final String login) throws IOException, UserDoesNotExistException {
        final UserGitHubResponse userGitHubResponse = gitHubService.getGithubUserData(login);
        Optional<UserRequestCount> userRequestCountOptional = userRequestCountRepository.findById(login);

        UserRequestCount userRequestCount;
        if (userRequestCountOptional.isPresent()) {
            userRequestCount = userRequestCountOptional.get();
            userRequestCount.setRequestCount(userRequestCount.getRequestCount() + 1);
        } else {
            userRequestCount = UserRequestCount.builder().requestCount(1).login(login).build();
        }
        userRequestCountRepository.save(userRequestCount);

        return userGitHubResponse;
    }
}
