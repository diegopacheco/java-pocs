package com.slackclone.auth;

import com.slackclone.user.User;
import com.slackclone.user.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE + 10)
public class AuthFilter extends OncePerRequestFilter {

    private final SessionRepository sessions;
    private final UserRepository users;

    public AuthFilter(SessionRepository sessions, UserRepository users) {
        this.sessions = sessions;
        this.users = users;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        if ("OPTIONS".equals(request.getMethod()) || isPublic(request.getRequestURI())) {
            chain.doFilter(request, response);
            return;
        }
        String token = bearerToken(request);
        if (token == null) {
            unauthorized(response);
            return;
        }
        Optional<Session> session = sessions.findByToken(token);
        if (session.isEmpty()) {
            unauthorized(response);
            return;
        }
        Optional<User> user = users.findById(session.get().userId());
        if (user.isEmpty()) {
            unauthorized(response);
            return;
        }
        request.setAttribute("authUser", AuthService.toAuthUser(user.get()));
        chain.doFilter(request, response);
    }

    private static boolean isPublic(String path) {
        return path.startsWith("/api/auth/") || path.startsWith("/media/") || !path.startsWith("/api/");
    }

    private static String bearerToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }

    private static void unauthorized(HttpServletResponse response) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.getWriter().write("{\"error\":\"unauthorized\"}");
    }
}
