package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();
    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        Member memberA = new Member("kim", 20);
        Member memberB = new Member("jo", 30);

        Member saveMemberA = memberRepository.save(memberA);
        Member saveMemberB = memberRepository.save(memberB);

        Member findMemberA = memberRepository.findById(saveMemberA.getId());

        assertThat(findMemberA).isEqualTo(saveMemberA);
    }

    @Test
    void findAll() {
        Member memberA = new Member("kim", 20);
        Member memberB = new Member("jo", 30);

        memberRepository.save(memberA);
        memberRepository.save(memberB);

        List<Member> memberList = memberRepository.findAll();

        assertThat(memberList.size()).isEqualTo(2);
        assertThat(memberList).contains(memberA, memberB);
    }

}