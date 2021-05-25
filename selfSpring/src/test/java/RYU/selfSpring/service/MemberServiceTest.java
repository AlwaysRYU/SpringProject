package RYU.selfSpring.service;

import RYU.selfSpring.domain.Member;
import RYU.selfSpring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    // ctl shift t 로 자동으로 만들 수 있다.
    // 테스트는 한글도 가능하다
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    //DI

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    // 끝나고나면 DB값을 날려줌.
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    //회원가입
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello..");

        //when
        Long saveID = memberService.join(member);

        //then
        Member findmember = memberService.findOne(saveID).get();
        Assertions.assertThat(member.getName()).isEqualTo(findmember.getName());
    }

    @Test
    public void 중복회원예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when crl alt v
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다..");
//        try{
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미존재하는 회원입니다..");
//        }
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}