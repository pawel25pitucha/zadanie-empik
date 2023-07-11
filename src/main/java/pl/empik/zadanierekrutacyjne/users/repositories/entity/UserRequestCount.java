package pl.empik.zadanierekrutacyjne.users.repositories.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "UserRequestCount")
@Table(name = "USER_REQUEST_COUNT")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestCount {
    @Id
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "REQUEST_COUNT")
    private int requestCount;
}
