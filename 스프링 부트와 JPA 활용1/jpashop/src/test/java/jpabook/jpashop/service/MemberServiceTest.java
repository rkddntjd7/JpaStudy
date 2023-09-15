package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Test
    public void 회원가입() {
        //given
        Member member = new Member();
        member.setName("kang");

        //when
        Long savedId = memberService.join(member);

        //then
        Assertions.assertEquals(member, memberRepository.findOne(savedId));
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("kang");

        Member member2 = new Member();
        member2.setName("kang");

        //when
        memberService.join(member1);
        memberService.join(member2); //예외 발생

        //then
        Assert.fail("예외 발생해야한다.");
    }

}