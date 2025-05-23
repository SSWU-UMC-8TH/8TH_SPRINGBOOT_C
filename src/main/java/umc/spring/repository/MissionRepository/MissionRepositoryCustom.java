package umc.spring.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.Mission;

public interface MissionRepositoryCustom {
    Page<Mission> findMyMissionsByStatus(Long memberId, Pageable pageable);
    Page<Mission> findAvailableMissionsByRegionId(Long regionId, Pageable pageable);
}
