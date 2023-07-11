package pl.empik.zadanierekrutacyjne.users.services.responsesObjects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserGitHubResponse {

    private Long id;

    private String name;

    @JsonProperty("avatar_url")
    private String avatarUrl;

    private String type;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    private String login;

    private int followers;

    @JsonProperty("public_repos")
    private int publicRepos;

}
