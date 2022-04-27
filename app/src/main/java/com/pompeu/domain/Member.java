package com.pompeu.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member implements UserDetails {


  final private String PREFIX = "ROLE_";

  int no;
  String name;
  String email;
  String phone;
  String nickName;
  int useCheck;
  Date loginDate;
  Date joinDate;
  Date modifyDate;
  String password;
  int snsNo;
  int memberTypeNo;
  int deleteType;
  String deleteDetail;
  String role;
  MemberType memberType;



  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> auth = new ArrayList<>();
    auth.add(new SimpleGrantedAuthority(PREFIX+getRole()));
    return auth;
  }
  @Override
  public String getUsername() {
    return getEmail();
  }


  //유저 아이디가 만료 되었는지(false=만료)
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }



  //유저 아이디가 Lock 걸렸는지(false=잠김)
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }


  //비밀번호가 만료 되었는지(false=만료)
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }


  //계정이 활성화 되었는지(false=비활성) 휴먼계정
  @Override
  public boolean isEnabled() {
    return true;
  }
}
