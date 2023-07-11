package pl.empik.zadanierekrutacyjne.users.controllers.mapper;

import pl.empik.zadanierekrutacyjne.users.controllers.dto.UserDTO;
import pl.empik.zadanierekrutacyjne.users.services.responsesObjects.UserGitHubResponse;

public class UserMapper {

    public UserDTO mapUserGithubResponseToUserDTO(UserGitHubResponse userGitHubResponse) {
        return UserDTO.builder()
                .id(userGitHubResponse.getId())
                .createdAt(userGitHubResponse.getCreatedAt())
                .avatarUrl(userGitHubResponse.getAvatarUrl())
                .login(userGitHubResponse.getLogin())
                .calculations(calculate(userGitHubResponse))
                .build();
    }


    private double calculate(UserGitHubResponse userGitHubResponse) {
        return userGitHubResponse.getFollowers() != 0 ? (double)  (6 / userGitHubResponse.getFollowers()) * (2 + userGitHubResponse.getPublicRepos()) : 0;
    }

}
