package org.gudo.backend.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.gudo.backend.member.domain.Member;
import org.gudo.backend.member.dto.MemberDTO;
import org.gudo.backend.member.repo.MemberRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService  implements UserDetailsService {

    private final MemberRepo memberRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("loadUserByUsername: " + username);

        Member member = memberRepo.selectOne(username);

        if(member == null) {
            throw new UsernameNotFoundException(username);
        }

        MemberDTO memberDTO = new MemberDTO(member);

        return memberDTO;

    }
}