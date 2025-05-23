package umc.spring.repository.MemberMissionRepository;

import umc.spring.domain.mapping.MemberMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberMissionRepositoryCustom {
    Page<MemberMission> findMissionsByMemberAndStatus(Long memberId, Pageable pageable);
}
