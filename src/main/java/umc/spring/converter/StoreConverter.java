package umc.spring.converter;

import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

public class StoreConverter {

    public static StoreResponseDTO.CreateStoreResultDto toStoreResultDto(Store store) {
        return StoreResponseDTO.CreateStoreResultDto.builder()
                .storeId(store.getId())
                .regionId(store.getRegion().getId())
                .name(store.getName())
                .address(store.getAddress())
                .score(store.getScore())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreRequestDTO.CreateStoreDto request) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .build();
    }
}
