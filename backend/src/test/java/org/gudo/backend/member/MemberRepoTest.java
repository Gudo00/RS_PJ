package org.gudo.backend.member;

import lombok.extern.log4j.Log4j2;
import org.gudo.backend.member.domain.Member;
import org.gudo.backend.member.domain.MemberRole;
import org.gudo.backend.member.repo.MemberRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
@Log4j2
public class MemberRepoTest {

    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void test() {

        for(int i = 0; i < 20; i++){

            Member member = Member.builder()
                    .mid("user" + i)
                    .mpw(passwordEncoder.encode("1111"))
                    .email("user" + i + "@gmail.com")
                    .build();

            member.addRole(MemberRole.USER);

            if(i > 10){
                member.addRole(MemberRole.ADMIN);
            }

            memberRepo.save(member);

        }//end for
    }

    @Test
    public void testSelectOne() {
        String mid = "user19";

        log.info(memberRepo.selectOne(mid));
    }

}