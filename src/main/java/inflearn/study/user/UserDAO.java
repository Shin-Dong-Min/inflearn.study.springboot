package inflearn.study.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAO extends JpaRepository<UserVO, String> {
    Optional<UserVO> findByUserId(String userId);
}
