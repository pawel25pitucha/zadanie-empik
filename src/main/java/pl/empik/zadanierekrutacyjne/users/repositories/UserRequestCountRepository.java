package pl.empik.zadanierekrutacyjne.users.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.empik.zadanierekrutacyjne.users.repositories.entity.UserRequestCount;

@Repository
public interface UserRequestCountRepository extends JpaRepository<UserRequestCount,String> {
//    @Modifying
//    @Query(value = "INSERT INTO UserRequestCount u (u.login, u.requestCount) values (:login, 1) ON DUPLICATE KEY UPDATE UserRequestCount u SET u.requestCount = u.requestCount + 1 WHERE u.login = :login")
//     void incrementUserRequestsCount(@Param("login") String login);
}
