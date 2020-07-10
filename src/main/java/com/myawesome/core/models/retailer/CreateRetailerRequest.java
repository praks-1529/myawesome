package com.myawesome.core.models.retailer;

import com.myawesome.core.constants.enums.City;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateRetailerRequest {
    @NotNull
    String storeName;
    @NotNull
    City city;
    @NotNull
    String zipCode;
    @NotNull
    String state;
    @NotNull
    Double latitude;
    @NotNull
    Double longitude;
    @NotNull
    String password;
    String email;
    String phoneNumber;
    String gstin;
    String addressLine1;
}
