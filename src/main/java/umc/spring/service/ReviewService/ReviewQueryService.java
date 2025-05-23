package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import java.util.List;

public interface ReviewQueryService {
    List<Review> getReviewsByMemberId(Long memberId);
}