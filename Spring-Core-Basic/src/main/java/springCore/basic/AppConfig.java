package springCore.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springCore.basic.discount.DiscountPolicy;
import springCore.basic.discount.RateDiscountPolicy;
import springCore.basic.member.MemberRepository;
import springCore.basic.member.MemberService;
import springCore.basic.member.MemberServiceImpl;
import springCore.basic.member.MemoryMemberRepository;
import springCore.basic.order.OrderService;
import springCore.basic.order.OrderServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
//        return null;
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
