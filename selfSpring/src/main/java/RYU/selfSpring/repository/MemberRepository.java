package RYU.selfSpring.repository;


import RYU.selfSpring.domain.Member;

import java.util.List;
import java.util.Optional;

//회원 객체를 저장하는 저장소
public interface MemberRepository {
    //기능
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
