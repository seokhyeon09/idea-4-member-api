package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.dto.CreateMemberRequest;
import com.example.demo.dto.MemberResponse;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    // 회원 생성
    public MemberResponse create(CreateMemberRequest request){
        if(memberRepository.existByEmail(request.getEmail())){
            throw  new IllegalArgumentException("이미 사용중인 이메일 입니다.");
        }

        Member member = new Member(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );
        Member saved = memberRepository.save(member);
        return new MemberResponse(saved);
    }
}
