package com.compassuol.sp.challenge.msaddress.domain.address.jwt;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static com.compassuol.sp.challenge.msaddress.domain.address.jwt.JwtUtils.JWT_BEARER;
import static com.compassuol.sp.challenge.msaddress.domain.address.jwt.JwtUtils.getUsernameFromToken;

@Slf4j
@RequiredArgsConstructor
public class JwtAuthorizationFilter extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader(JwtUtils.JWT_AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith(JWT_BEARER)) {
            log.info("JWT Token is null, empty or not starting with 'Bearer'");
            filterChain.doFilter(request, response);
            return ;
        }

        String token = authHeader.substring(JWT_BEARER.length());

        if (!JwtUtils.isTokenValid(token)) {
            log.warn("JWT Token is invalid or expired");
            filterChain.doFilter(request, response);
            return;
        }

        String username = getUsernameFromToken(token);

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (JwtUtils.isTokenValid(token)) {
                PreAuthenticatedAuthenticationToken authToken = new PreAuthenticatedAuthenticationToken(token, null, null);
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }

}
