package com.pompeu.admin.member.service.Impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.admin.member.dao.MemberDao;
import com.pompeu.admin.member.service.MemberService;
import com.pompeu.domain.Member;

@Service
public class DefaultMemberService implements MemberService{

  @Autowired
  MemberDao memberDao;

  @Override
  public List<Member> list() {
    return memberDao.findAll();
  }

  @Override
  public int add(Member member) {
    return memberDao.insert(member);
  }

  @Override
  public Member get(int no) {
    return memberDao.findByNo(no);
  }

  @Override
  public int update(Member member) {
    return memberDao.update(member);
  }


  @Override
  public int delete(int no) {
    return memberDao.delete(no);
  }

  @Override
  public List<Integer> findCount() {
    return memberDao.findCount();
  }

  @Override
  public List<Integer> findGoodbyeCount() {
    return memberDao.findGoodbyeCount();
  }

  @Override
  public List<Member> srchMember(Member member) {
    return memberDao.srchMember(member);
  }

  @Override
  public List<Member> srchGoodbyeMember(Member member) {
    return memberDao.srchGoodbyeMember(member);
  }

  @Override
  public List<Map<Object, Object>> getLecture(int no) {
    return memberDao.findUserLecture(no);
  }

  @Override
  public Member findGoodbyeReason(int no) {
    return memberDao.findGoodbyeReason(no);
  }

  @Override
  public List<Map<Object, Object>> creatorLecture(int no) {
    return memberDao.findCreatorLecture(no);
  }

  @Override
  public List<Map<Object, Object>> applyingLecture(int no) {
    return memberDao.findApplyingLecture(no);
  }





}