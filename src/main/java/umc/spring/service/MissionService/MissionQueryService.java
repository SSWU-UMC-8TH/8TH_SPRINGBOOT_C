package umc.spring.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.spring.domain.Mission;

public interface MissionQueryService {
    Page<Mission> getMyMissions(Long memberId, Pageable pageable);
    Page<Mission> getAvailableMissions(Long regionId, Pageable pageable);
}