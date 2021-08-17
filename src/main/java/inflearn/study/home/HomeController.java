package inflearn.study.home;

import inflearn.study.user.UserService;
import inflearn.study.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ModelAndView homeView() {
        ModelAndView modelAndView = new ModelAndView("pages/home");
        return modelAndView;
    }

    @GetMapping("/login")
    public ModelAndView loginView() {
        ModelAndView modelAndView = new ModelAndView("pages/login");
        return modelAndView;
    }

    @GetMapping("/signup")
    public ModelAndView signupView() {
        ModelAndView modelAndView = new ModelAndView("pages/signup");
        return modelAndView;
    }

    @PostMapping("/signup")
    public String signup(UserVO userVO) {
        userService.save(userVO);
        return "redirect:/login";
    }

    @PreAuthorize("hasRole('ROLE_MEMBER')")
    @GetMapping("/user/info")
    public ModelAndView userInfoView() {
        ModelAndView modelAndView = new ModelAndView("pages/user_info");
        return modelAndView;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public ModelAndView adminView() {
        ModelAndView modelAndView = new ModelAndView("pages/admin");
        return modelAndView;
    }

    @GetMapping("/denied")
    public ModelAndView deniedView() {
        ModelAndView modelAndView = new ModelAndView("pages/denied");
        return modelAndView;
    }
}
