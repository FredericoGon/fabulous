package com.store.fabulous.store;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "store")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class StoreEntity {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    public StoreEntity(StoreDTO store) {
        this.id = store.getId();
        this.name = store.getName();
    }

}
