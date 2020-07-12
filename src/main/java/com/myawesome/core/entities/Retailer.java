package com.myawesome.core.entities;

import com.myawesome.core.constants.enums.ProfileType;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

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
    String name;
    String storeName;
    Double latitude;
    Double longitude;
    String email;
    String phoneNumber;
    String gstin;
    String addressLine1;
    Boolean verified;
}
