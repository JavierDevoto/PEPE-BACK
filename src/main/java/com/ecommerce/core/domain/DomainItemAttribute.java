package com.ecommerce.core.domain;

import com.ecommerce.core.dto.AttributeType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "item_attributes")
public class DomainItemAttribute {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private AttributeType type;
    private String value;
    private String valueCode;
    @ManyToOne
    private DomainItem item;
    @ManyToOne
    private DomainItemVariant itemVariant;
}
