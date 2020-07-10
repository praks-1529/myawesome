package com.myawesome.core.models.retailer;

import com.myawesome.core.constants.enums.City;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RetailerExternalResponse {
    String retailerId;
    String storeName;
    String addressLine1;
    City city;
    String zipCode;
    String state;
    String email;
    String phoneNumber;
    String gstin;
    Double latitude;
    Double longitude;
}
