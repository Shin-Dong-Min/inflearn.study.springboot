package inflearn.study.user;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    String save(UserVO userVO);
}
