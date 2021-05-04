package RYU.selfSpring.repository;

import RYU.selfSpring.domain.Member;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //테스트 이후 클리어 시켜줌 의존관계이면 안된다.
    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    public void test(){

    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        //꺼내기
        Member result = repository.findById(member.getId()).get();
        // 꺼낸거랑 같으면
        System.out.println("result = " + (result == member));

        Assertions.assertEquals(member, result);
        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(result);
        // alt + enter 로 줄일 수 있음.

    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();
        //이걸 2로 수정할 경우 오류가난다.
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
        //최종 개수가 3인지?
    }


}
