package umc.spring.repository.FoodCategoryRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.QFoodCategory;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class FoodCategoryRepositoryImpl implements FoodCategoryRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Optional<FoodCategory> findByName(String name) {
        QFoodCategory foodCategory = QFoodCategory.foodCategory;
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(foodCategory)
                        .where(foodCategory.name.eq(name))
                        .fetchOne()
        );
    }
}