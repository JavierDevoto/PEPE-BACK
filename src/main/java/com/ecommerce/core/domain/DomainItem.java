package com.ecommerce.core.domain;

import com.ecommerce.core.dto.AttributeType;
import com.ecommerce.core.dto.ItemStatus;
import com.ecommerce.core.dto.ItemTag;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "items")
public class DomainItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private String subtitle;
    private BigDecimal price;
    private BigDecimal hardPrice;
    private Long availableQuantity;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    @OneToMany(cascade=CascadeType.ALL)
    private List<DomainItemAttribute> attributes;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<AttributeType> availableVariants;

    @OneToMany(cascade=CascadeType.ALL)
    private List<DomainItemVariant> variants;

    @ElementCollection
    private List<String> smallPictures;

    @ElementCollection
    private List<String> pictures;

    @ElementCollection
    private List<String> videos;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<ItemTag> tags;

    private String permalink;
    private LocalDateTime dateCreated;
    private LocalDateTime lastUpdated;
}
