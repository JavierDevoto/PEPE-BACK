package com.ecommerce.core.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "item_variants")
public class DomainItemVariant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private BigDecimal price;
    private BigDecimal hardPrice;
    private Long availableQuantity;
    @ElementCollection
    private List<String> smallPictures;
    @ElementCollection
    private List<String> pictures;
    @ElementCollection
    private List<String> videos;
    @OneToMany(cascade=CascadeType.ALL)
    private List<DomainItemAttribute> variant;
    @OneToMany(cascade=CascadeType.ALL)
    private List<DomainItemAttribute> attributes;
    @ManyToOne
    private DomainItem item;
}
