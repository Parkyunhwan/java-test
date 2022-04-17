package me.yunan.javatest.member;

import me.yunan.javatest.domain.Member;
import me.yunan.javatest.domain.Study;

import java.util.Optional;

public interface MemberService {

    Optional<Member> findById(Long memberId);

    void validate(Long memberId);

    void notify(Study newstudy);

    void notify(Member member);
}
