package umc.spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.spring.domain.Mission;
import umc.spring.repository.MissionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public Page<Mission> getMyMissions(Long memberId, Pageable pageable) {
        return missionRepository.findMyMissionsByStatus(memberId, pageable);
    }

    @Override
    public Page<Mission> getAvailableMissions(Long regionId, Pageable pageable) {
        return missionRepository.findAvailableMissionsByRegionId(regionId, pageable);
    }
}
