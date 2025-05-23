package umc.spring.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QReview;
import umc.spring.domain.Review;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Review> findReviewsByMemberId(Long memberId) {
        QReview review = QReview.review;
        return queryFactory
                .selectFrom(review)
                .where(review.member.id.eq(memberId))
                .orderBy(review._super.createdAt.desc())
                .fetch();
    }
}