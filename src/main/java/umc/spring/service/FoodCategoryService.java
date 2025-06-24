package umc.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.spring.domain.FoodCategory;
import umc.spring.repository.FoodCategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    // 여러 카테고리 id가 모두 존재하는지 확인하고, 없으면 예외 발생
    public List<FoodCategory> getFoodCategoriesOrThrow(List<Long> categoryIds) {
        return categoryIds.stream()
                .map(id -> foodCategoryRepository.findById(id)
                        .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                .collect(Collectors.toList());
    }

    // 모든 id가 존재하는지 boolean만 반환하는 메서드 (Validator에서 사용)
    public boolean existAllByIds(List<Long> ids) {
        return ids.stream().allMatch(foodCategoryRepository::existsById);
    }
}

