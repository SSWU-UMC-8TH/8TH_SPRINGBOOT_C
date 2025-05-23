package umc.spring.service.FoodCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.FoodCategory;
import umc.spring.repository.FoodCategoryRepository.FoodCategoryRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FoodCategoryQueryServiceImpl implements FoodCategoryQueryService {

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    public Optional<FoodCategory> getFoodCategoryByName(String name) {
        return foodCategoryRepository.findByName(name);
    }
}