package inflearn.study.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        Optional<UserVO> memberEntityWrapper = userDAO.findByUserId(userId);
        UserVO memberEntity = memberEntityWrapper.orElse(null);

        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_MEMBER"));

        return new User(memberEntity.getUserId(), memberEntity.getPassword(), authorities);
    }

    @Transactional
    @Override
    public String save(UserVO userVO) {

        // 비밀번호 암호화
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userVO.setPassword(passwordEncoder.encode(userVO.getPassword()));
        return userDAO.save(userVO).getUserId();
    }
}
