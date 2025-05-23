package umc.spring.repository.FoodCategoryRepository;

import umc.spring.domain.FoodCategory;
import java.util.Optional;

public interface FoodCategoryRepositoryCustom {
    Optional<FoodCategory> findByName(String name);
}