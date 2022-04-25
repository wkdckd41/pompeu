package com.pompeu.login.dao;

import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.pompeu.domain.Member;

@Mapper
public interface UserDao {


  // 회원가입
  @Insert("INSERT INTO member( member_type_no, name, nickname, email, password, phone, role)values(1,#{name},#{nickName},#{email},#{password},#{phone},'USER')")
  @Options(useGeneratedKeys = true, keyColumn = "member_no", keyProperty = "no")
  int insertUser(Member member);

  // users 입력
  //  @Insert("INSERT INTO users(member_no, image, ex_type_no) values(#{memberNo}, ' ', ' ' ")
  //  int UsersAdd(Member member);

  //닉네임 중복체크
  @Select("SELECT COUNT(*) FROM member WHERE nickname = #{nickName}") 
  int nickNameCheck(String nickname);

  //이메일 중복체크
  @Select("SELECT COUNT(*) FROM member WHERE email = #{email}") 
  int emailCheck(String email);

  //권한 확인
  @Select("SELECT role FROM member where email = #{email}")
  String findRole(String email);


  //로그인
  @Select("SELECT * FROM member WHERE email = #{email}")
  // SELECT * FROM user WHERE email = 1?;
  Optional<Member> findByEmail(String email);




  // 아이디 비밀번호
  //  @Select("SELECT no, email, password, role FROM member where email=#{email} and password=#{password}")
  //  Member findByEmailAndPassword(String email, String password);


  // 로그인 시간
  @Update("UPDATE member SET login_date = CURRENT_TIMESTAMP() WHERE email = #{email}")
  int lastLoginDate(String email);

  // 회원 탈퇴
  @Update("UPDATE member SET use_check = '2' WHERE email = #{email} ")
  int deleteUser(String email);

  //  int insertOAuth2User(Member member);

}

