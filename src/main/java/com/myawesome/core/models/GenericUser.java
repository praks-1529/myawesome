package com.myawesome.core.models;

import com.myawesome.core.constants.enums.ProfileType;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GenericUser {
    public String id;
    public ProfileType profileType;
    public String phoneNumber;
}