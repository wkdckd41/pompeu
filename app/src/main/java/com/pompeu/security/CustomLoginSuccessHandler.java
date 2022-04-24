package com.pompeu.security;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {
    log.info("로그인 성공");


    System.out.println(authentication.getPrincipal());

    HttpSession session = request.getSession();
    session.setMaxInactiveInterval(600); // session 최대 유효시간
    //    session.setAttribute("loginUser", authentication.getPrincipal());

    System.out.println(authentication.getAuthorities());


    //    List<String>role = new ArrayList<>();
    //    authentication.getAuthorities().forEach(authority -> {
    //      role.add(authority.getAuthority());
    //    });
    //    //    System.out.println(role.contains());
    //    //    //인증 권한이 어드민이면 어드민 페이지로 이동
    //    if (role.contains("ROLE_ADMIN")) {
    //      response.sendRedirect("/admin/main/admin-main.html");
    //      return;
    //    }else if (role.contains("ROLE_CREATOR")) {
    //      response.sendRedirect("/creator2/nouse/creator_original_form.html");
    //      return;
    //    }
    //    response.sendRedirect("/user/main/user-main.html");
    response.sendRedirect("/login/success");
  }
}
