package RYU.selfSpring;

import RYU.selfSpring.repository.JdbcMemberRepository;
import RYU.selfSpring.repository.MemberRepository;
import RYU.selfSpring.repository.MemoryMemberRepository;
import RYU.selfSpring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //Springbean을 등록할거라는 의미
    @Bean
    public MemberService memberService() {
        // 밑의 로직을 호출 하는 것.
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);

    }

}
