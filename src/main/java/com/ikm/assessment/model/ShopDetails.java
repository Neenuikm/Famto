package com.ikm.assessment.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@Builder
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "shop_details")
public class ShopDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID shopId;
    @Column(unique = true, nullable = false)
    private String registrationNumber;
    private String shopName;
    private String phoneNumber;
    private String ownerName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private CategoryDetails categoryDetails;
}
