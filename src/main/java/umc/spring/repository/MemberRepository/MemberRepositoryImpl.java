package umc.spring.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Member;
import umc.spring.domain.QMember;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<Member> findActiveMemberByEmail(String email) {
        QMember member = QMember.member;
        return Optional.ofNullable(queryFactory
                .selectFrom(member)
                .where(
                        member.email.eq(email),
                        member.status.eq(umc.spring.domain.enums.MemberStatus.ACTIVE)
                )
                .fetchOne());
    }
}