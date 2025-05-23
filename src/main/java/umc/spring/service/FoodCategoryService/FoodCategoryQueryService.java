package umc.spring.service.FoodCategoryService;

import umc.spring.domain.FoodCategory;
import java.util.Optional;

public interface FoodCategoryQueryService {
    Optional<FoodCategory> getFoodCategoryByName(String name);
}