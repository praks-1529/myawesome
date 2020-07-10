package com.myawesome.core.entities;

import com.myawesome.core.constants.enums.ProfileType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.neo4j.ogm.annotation.Property;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Retailer {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",
            strategy = "uuid")
    String id;
    @Enumerated(EnumType.STRING)
    ProfileType profileType;
    @Property
    String name;
    @Property
    String storeName;
    @Property
    Double latitude;
    @Property
    Double longitude;
    @Property
    String email;
    @Property
    String phoneNumber;
    @Property
    String gstin;
    @Property
    String addressLine1;
    @Property
    Boolean verified;
}
