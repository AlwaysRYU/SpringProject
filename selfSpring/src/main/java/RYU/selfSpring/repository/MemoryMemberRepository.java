package RYU.selfSpring.repository;

import RYU.selfSpring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;


    @Override
    public Member save(Member member) {
        member.setId(++sequence); //아이디에 세팅
        store.put(member.getId(), member); //맵에 저장
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        //스토어에서 꺼내기

        return Optional.ofNullable(store.get(id));

    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();

    }

    @Override
    public List<Member> findAll() {
        //list로 반환함 실무에서는 list로 많이 쓴다.
        return new ArrayList<>(store.values()) ;
    }


}
