package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.spring.validation.annotation.ExistRegions;

public class StoreRequestDTO {

    @Getter
    public static class CreateStoreDto {

        @ExistRegions
        @NotNull
        Long regionId;

        @NotBlank
        String name;

        @NotBlank
        String address;
    }

}
