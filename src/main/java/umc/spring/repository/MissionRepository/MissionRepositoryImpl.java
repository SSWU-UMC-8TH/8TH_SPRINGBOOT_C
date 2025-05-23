package umc.spring.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import umc.spring.domain.*;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.QMemberMission;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<Mission> findMyMissionsByStatus(Long memberId, Pageable pageable) {
        QMission mission = QMission.mission;
        QMemberMission memberMission = QMemberMission.memberMission;

        BooleanBuilder condition = new BooleanBuilder()
                .and(memberMission.member.id.eq(memberId))
                .and(memberMission.status.in(MissionStatus.CHALLENGING, MissionStatus.COMPLETED));

        List<Mission> result = queryFactory
                .select(memberMission.mission)
                .from(memberMission)
                .join(memberMission.mission, mission).fetchJoin()
                .where(condition)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long total = queryFactory
                .select(memberMission.count())
                .from(memberMission)
                .where(condition)
                .fetchOne();

        return new PageImpl<>(result, pageable, total != null ? total : 0);
    }

    @Override
    public Page<Mission> findAvailableMissionsByRegionId(Long regionId, Pageable pageable) {
        QMission mission = QMission.mission;
        QStore store = QStore.store;

        List<Mission> result = queryFactory
                .selectFrom(mission)
                .join(mission.store, store).fetchJoin()
                .where(store.region.id.eq(regionId), mission.deadline.goe(LocalDate.now()))
                .orderBy(mission.deadline.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        Long total = queryFactory
                .select(mission.count())
                .from(mission)
                .join(mission.store, store)
                .where(store.region.id.eq(regionId), mission.deadline.goe(LocalDate.now()))
                .fetchOne();

        return new PageImpl<>(result, pageable, total != null ? total : 0);
    }
}
