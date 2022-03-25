package com.pompeu.admin.member.service.Impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pompeu.admin.member.dao.MemberDao;
import com.pompeu.admin.member.service.MemberService;
import com.pompeu.domain.Member;

@Service
public class DefaultMemberService implements MemberService {

  /**
   * 회원 현황
   */
  @Autowired
  MemberDao memberDao;

  /**
   * 회원 현황
   */
  @Override
  public List<Integer> findCount() {
    return null;
  }

  /**
   * 회원 목록
   */
  @Override
  public List<Member> findAll() {
    return null;
  }

  /**
   * 회원 상세 조회
   */
  @Override
  public Member findByNo(int no) {
    return null;
  }

  /**
   * 회원 상세 구분 조회
   */
  @Override
  public Member findByMemberTypeNo(int no) {
    return null;
  }

  /**
   * 회원 상세 이름 조회
   */
  @Override
  public List<Member> findByName(String name) {
    return null;
  }

  /**
   * 회원 상세 휴대번호 조회
   */
  @Override
  public List<Member> findByphone(String phone) {
    return null;
  }

  /**
   * 회원 조건 조회
   */
  @Override
  public List<Map<String, Object>> srchMember(Member member) {
    return null;
  }

  @Override
  public int memberRegi(Member member) {
    return 0;
  }

  @Override
  public int countAll() {
    // TODO Auto-generated method stub
    return 0;
  }

}

