package com.project.diet_rec.service;

import java.util.Collections;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.diet_rec.dto.SignupDto;
import com.project.diet_rec.entity.Authority;
import com.project.diet_rec.entity.Member;
import com.project.diet_rec.exception.DuplicateMemberException;
import com.project.diet_rec.exception.NotFoundMemberException;
import com.project.diet_rec.repository.MemberRepository;
import com.project.diet_rec.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
    
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public SignupDto signup(SignupDto signupDto) {
        if (memberRepository.findOneWithAuthoritiesByUsername(signupDto.getUsername()).orElse(null) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }

        Authority authority = Authority.builder()
                .authorityName("ROLE_USER")
                .build();

        Member member = Member.builder()
                .name(signupDto.getName())
                .nickname(signupDto.getNickname())
                .username(signupDto.getUsername())
                .password(passwordEncoder.encode(signupDto.getPassword()))
                .authorities(Collections.singleton(authority))
                .activated(true)
                .build();

        return SignupDto.from(memberRepository.save(member));
    }

    @Transactional(readOnly = true)
    public SignupDto getUserWithAuthorities(String username) {
        return SignupDto.from(memberRepository.findOneWithAuthoritiesByUsername(username).orElse(null));
    }

    @Transactional(readOnly = true)
    public SignupDto getMyUserWithAuthorities() {
        return SignupDto.from(
                SecurityUtil.getCurrentUsername()
                        .flatMap(memberRepository::findOneWithAuthoritiesByUsername)
                        .orElseThrow(() -> new NotFoundMemberException("Member not found"))
        );
    }
}
