//package com.pompeu.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import com.pompeu.domain.Member;
//import com.pompeu.login.dao.UserDao;
//import com.pompeu.security.service.PrincipalDetailService;
//
//

// // 로그인 아이디 비밀번호 확인 클래스
//@Component
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//
//
//
//  //  @Autowired
//  //  private UserPrincipal userPrincipal;
//
//  @Autowired
//  private  PrincipalDetailService principalDetailService;
//
//  @Autowired
//  private PasswordEncoder passwordEncoder;
//
//  @Override
//  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//
//    UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication; 
//    String email = token.getName();
//    String password = (String) token.getCredentials().toString();
//    Member member = (Member) principalDetailService.loadUserByUsername(authentication.getName().toString());
//
//    if (passwordEncoder.matches(password, member.getPassword()) == false) {
////      throw new BadCredentialsException(member.getUsername() + " 비밀번호를 확인해주세요.");
//    }
//    return new UsernamePasswordAuthenticationToken(user, password, member.getAuthorities());
//
//    //    String reqPassword = authentication.getCredentials().toString();
//    //    if(!passwordEncoder.matches(reqPassword, member.getPassword())) throw new BadCredentialsException("Not Found User");
//    //
//        return new UsernamePasswordAuthenticationToken(member.getUsername(), null, member.getAuthorities());
//  }
//
//  @Override
//  public boolean supports(Class<?> authentication) {
//    return true;
//  }
//
//
//
//
//
//}
