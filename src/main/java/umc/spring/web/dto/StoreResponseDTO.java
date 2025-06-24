package umc.spring.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class StoreResponseDTO {

    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreateStoreResultDto {
        Long storeId;
        Long regionId;
        String name;
        String address;
        Float score;
        LocalDateTime createdAt;
    }
}
