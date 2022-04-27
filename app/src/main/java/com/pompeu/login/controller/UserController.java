package com.pompeu.login.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pompeu.domain.Member;
import com.pompeu.login.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController 
public class UserController {

  // @Autowired
  // - 필드 선언부에 이 애노테이션을 붙여서 표시해 두면, 
  //   Spring Boot가 MemberController 객체를 만들 때 MemberDao 구현체를 찾아 자동으로 주입한다. 
  //
  @Autowired
  UserService userService;

  //  @Autowired
  //  PrincipalDetailService principalDetatilService;

  //  @Autowired
  //  private com.pompeu.security.jwt.JwtTokenProvider TokenProvider;


  // 회원가입
  @PostMapping("/user/join")
  public String joinMember(@RequestBody Member member) {
    log.info("user/join.....");
    if (userService.addMember(member) == 1) {
      return "success";
    } else {
      return "fail";
    }
  }

  @PostMapping("/user/joinCreator")
  public String joinCreator(@RequestBody Member member) {
    log.info("user/join.....");
    if (userService.addCreator(member) == 1) {
      return "success";
    } else {
      return "fail";
    }
  }


  // 닉네임 중복체크
  @RequestMapping("/user/nickcheck")
  public String nickNameChk( String nickname) {
    return (userService.nickCheck(nickname) == 1) ? "fail": "success"; 
  }


  // 이메일 중복체크
  @RequestMapping("/user/emailcheck")
  public String emailChk(String email) {
    return (userService.emailCheck(email) == 1) ? "fail": "success"; 
  }


  // 로그인 성공
  @RequestMapping("/login/success")
  public String loginSuccess(Authentication auth) {
    log.info("success...");
    System.out.println("success:" + auth.getAuthorities().toString() + "==========" + auth.getPrincipal());
    userService.loginDate(auth.getName());
    List<String>role = new ArrayList<>();
    auth.getAuthorities().forEach(authority -> {
      role.add(authority.getAuthority());
    });
    //    System.out.println(role.contains());
    //    //인증 권한이 어드민이면 어드민 페이지로 이동
    if (role.contains("ROLE_ADMIN")) {
      return "admin";
    }else if (role.contains("ROLE_CREATOR")) {
      return "creator";
    }
    return "user";
  }


  // 로그인 실패
  @RequestMapping("/login/fail")
  public String loginFail() {
    return "fail";
  }


  @RequestMapping("/login/getLoginUser")
  public String getLoginUser(@AuthenticationPrincipal Member member) {
    System.out.println(member.getNo());
    System.out.println(member.getEmail());
    if (member.getEmail() != null) {
      return "success";
    }
    return "fail";
  }



  //  @RequestMapping("/user/login")
  //  public String loginMember(String email) {
  //
  //
  //    return "확인";
  //  }


  //  @GetMapping("/test/login")
  //  public String testLogin(@RequestBody Authentication authentication,
  //      @AuthenticationPrincipal UserPrincipal userDetails) {
  //
  //    System.out.println("/test/login ========");
  //    UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
  //    System.out.println("authentication: " + userPrincipal.getUser());
  //
  //    //    System.out.println("userDetails: " + UserDetails.getUser());
  //    return "세션 정보 확인하기";
  //  }


  //  @GetMapping("/test/oauth/login")
  //  public String testOAuthLogin(@RequestBody Authentication authentication,
  //      @AuthenticationPrincipal OAuth2User oauth) {
  //
  //    System.out.println("/test/login ========");
  //    OAuth2User oauth2User = (OAuth2User) authentication.getPrincipal();
  //    System.out.println("authentication: " + oauth2User.getAttributes());
  //    System.out.println("oauth2User: " + oauth.getAttributes());
  //    return "OAuth 세션 정보 확인하기";
  //  }
  //
  //  // OAuth 로그인도 userPrincipal
  //  // 일반 로그인도 userPrincipal
  //  @GetMapping("/user")
  //  public String user(@AuthenticationPrincipal UserPrincipal userPrincipal) {
  //    System.out.println("userPrincipal: " + userPrincipal);
  //    return "user";
  //  }

  //  @PostMapping("/user/save")
  //  public String saveUserInfo(@RequestBody User user) {
  //      return SecurityService.InsertUser(user);
  //  }

  @RequestMapping("/user/delete")
  public Object deleteMember(String email) {
    return userService.deleteUser(email);
  }


}