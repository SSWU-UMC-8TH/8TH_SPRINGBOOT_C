package umc.spring.repository.MemberMissionRepository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.domain.mapping.QMemberMission;
import umc.spring.domain.enums.MissionStatus;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<MemberMission> findMissionsByMemberAndStatus(Long memberId, Pageable pageable) {
        QMemberMission memberMission = QMemberMission.memberMission;

        BooleanExpression memberEq = memberMission.member.id.eq(memberId);
        BooleanExpression statusIn = memberMission.status.in(MissionStatus.CHALLENGING, MissionStatus.COMPLETED);

        List<MemberMission> results = queryFactory
                .selectFrom(memberMission)
                .where(memberEq.and(statusIn))
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long total = queryFactory
                .select(memberMission.count())
                .from(memberMission)
                .where(memberEq.and(statusIn))
                .fetchOne();

        return new PageImpl<>(results, pageable, total);
    }
}
