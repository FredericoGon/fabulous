package com.store.fabulous.store;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StoreDTO {

    private Long id;
    private String name;

    public StoreDTO(StoreEntity store) {
        this.id = store.getId();
        this.name = store.getName();
    }
}
