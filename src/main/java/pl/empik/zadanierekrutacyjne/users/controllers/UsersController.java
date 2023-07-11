package pl.empik.zadanierekrutacyjne.users.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.empik.zadanierekrutacyjne.users.controllers.dto.UserDTO;
import pl.empik.zadanierekrutacyjne.users.controllers.mapper.UserMapper;
import pl.empik.zadanierekrutacyjne.users.services.UserService;
import pl.empik.zadanierekrutacyjne.users.services.exception.UserDoesNotExistException;
import pl.empik.zadanierekrutacyjne.users.services.responsesObjects.UserGitHubResponse;

import java.io.IOException;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UsersController(UserService userService) {
        this.userService = userService;
        userMapper = new UserMapper();
    }

    @GetMapping("/{login}")
    public ResponseEntity<UserDTO> getUserData(@PathVariable(name = "login") String login) throws IOException, UserDoesNotExistException {
        UserGitHubResponse userGitHubResponse = userService.getUserGithubUserByLogin(login);
        return ResponseEntity.ok(userMapper.mapUserGithubResponseToUserDTO(userGitHubResponse));
    }
}
