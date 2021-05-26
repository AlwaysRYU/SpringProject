package RYU.selfSpring.service;

import RYU.selfSpring.domain.Member;
import RYU.selfSpring.repository.MemberRepository;
import RYU.selfSpring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }



    //회원 가입
    public Long join(Member member){
        //중복불가
        //Optional<Member> result = memberRepository.findByName(member.getName());
        //옵셔널반환 , 값이 있으면,
        validateDuplicateMember(member);
        //단축기 ctl alt m
        memberRepository.save(member);
        return member.getId();
        //지금은 아이디만
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다..");
                });
    }
    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberID) {
        return memberRepository.findById(memberID);
    }
}
