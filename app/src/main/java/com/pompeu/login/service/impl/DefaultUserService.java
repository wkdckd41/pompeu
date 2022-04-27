package com.pompeu.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pompeu.domain.Member;
import com.pompeu.login.dao.UserDao;
import com.pompeu.login.service.UserService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DefaultUserService implements UserService{

  @Autowired
  UserDao userDao;

  @Autowired
  private PasswordEncoder passwordEncoder;




  @Transactional
  @Override
  public int addMember(Member member) {
    //        String rawPassword = member.getPassword();
    //        String encPassword = passwordEncoder.encode(member.getPassword());
    //        member.setPassword(encPassword); 
    // 비밀번호 암호화
    if (userDao.emailCheck(member.getEmail()) != 1 || userDao.nickNameCheck(member.getNickName()) != 1) {
      member.setPassword(passwordEncoder.encode(member.getPassword()));
      userDao.insertUser(member);
      System.out.println(member.getNo());
      System.out.println("==========");
      userDao.usersAdd(member);
      return 1;
    }   else {
      return 0;
    }
  }


  @Transactional
  @Override
  public int addCreator(Member member) {
    if (userDao.emailCheck(member.getEmail()) != 1 || userDao.nickNameCheck(member.getNickName()) != 1) {
      member.setPassword(passwordEncoder.encode(member.getPassword()));
      userDao.insertCreator(member);
      System.out.println(member.getNo());
      System.out.println("==========");
      userDao.creatorAdd(member);
      return 1;
    }   else {
      return 0;
    }
  }




  @Override
  public int nickCheck(String nickname) {
    return userDao.nickNameCheck(nickname);
  }

  @Override
  public int emailCheck(String email) {
    return userDao.emailCheck(email);
  }


  @Override
  public String roleCheck(String email) {
    return userDao.findRole(email);
  }


  //  @Override
  //  public Member getMember(String email, String password) {
  //
  //
  //    //    Member member = userDao.findByEmailAndPassword(email, password);
  //
  //    return member;
  //  }

  //  @Override
  //  public Optional<Member> getEmail(String email) {
  //    return userDao.findByEmail(email);
  //  }

  @Override
  public int loginDate(String email) {
    return userDao.lastLoginDate(email);
  }



  @Override
  public int deleteUser(String email) {
    return userDao.deleteUser(email);
  }















}