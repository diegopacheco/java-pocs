package com.slackclone.user;

import com.slackclone.auth.AuthService;
import com.slackclone.auth.AuthUser;
import com.slackclone.auth.CurrentUser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository users;

    public UserController(UserRepository users) {
        this.users = users;
    }

    @GetMapping("/me")
    public AuthUser me(@CurrentUser AuthUser user) {
        return user;
    }

    @GetMapping
    public List<AuthUser> directory(@CurrentUser AuthUser user) {
        List<AuthUser> result = new ArrayList<>();
        for (User candidate : users.findAll()) {
            if (!candidate.id().equals(user.id())) {
                result.add(AuthService.toAuthUser(candidate));
            }
        }
        return result;
    }
}
