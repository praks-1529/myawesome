package com.myawesome.core.service.retailer;

import com.myawesome.core.constants.enums.ProfileType;
import com.myawesome.core.entities.Retailer;
import com.myawesome.core.models.retailer.RetailerExternalResponseList;
import com.myawesome.core.models.retailer.CreateRetailerRequest;
import com.myawesome.core.models.retailer.RetailerExternalResponse;
import com.myawesome.core.repository.RetailerRepository;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("retailerService")
public class RetailerService {

    private static final Logger logger = LoggerFactory.getLogger(RetailerService.class);

    @Autowired
    RetailerRepository retailerRepository;

    public RetailerExternalResponse createRetailer(CreateRetailerRequest createRetailerRequest) throws Exception {
        Retailer retailer = retailerRepository.findOneByPhoneNumber(createRetailerRequest.getPhoneNumber());
        if(retailer!=null){
            logger.info("Retailer already exists with name {}",retailer.getStoreName());
            return createUserExternalResponse(null);
        }
        retailer = Retailer.builder()
                .storeName(createRetailerRequest.getStoreName())
                .addressLine1(createRetailerRequest.getAddressLine1())
                .email(createRetailerRequest.getEmail())
                .phoneNumber(createRetailerRequest.getPhoneNumber())
                .gstin(createRetailerRequest.getGstin())
                .latitude(createRetailerRequest.getLatitude())
                .longitude(createRetailerRequest.getLongitude())
                .verified(false)
                .profileType(ProfileType.RETAILER)
                .build();
        retailer=retailerRepository.saveAndFlush(retailer);
        // Create and save a new retailer meta
        String password = StringUtils.isBlank(createRetailerRequest.getPassword()) ? "1234": createRetailerRequest.getPassword();
        return createUserExternalResponse(retailer);
    }

    public RetailerExternalResponse getRetailer(String userId){
        Retailer retailer = retailerRepository.findOneById(userId);
        if(retailer !=null){
            return createUserExternalResponse(retailer);
        }
        logger.info("User doesn't exists with id {}",userId);
        return null;
    }

    public RetailerExternalResponseList getRetailerByPrefix(String prefix){
        List<Retailer> retailers = null;
        if (StringUtils.isBlank(prefix)) {
            retailers = retailerRepository.findAllByStoreNameNotNull();
        } else {
            retailers = retailerRepository.findAllByStoreNameStartingWith(prefix);
        }
        RetailerExternalResponseList retailerExternalResponseList = new RetailerExternalResponseList();
        for (Retailer retailer: retailers) {
            retailerExternalResponseList.retailers.add(createUserExternalResponse(retailer));
        }
        return retailerExternalResponseList;
    }

    public Retailer getRetailerByPhoneNumber(String phoneNumber){
        Retailer retailer = retailerRepository.findOneByPhoneNumber(phoneNumber);
        if(retailer !=null){
            return retailer;
        }
        logger.info("User doesn't exists with id {}",phoneNumber);
        return null;
    }

    protected RetailerExternalResponse createUserExternalResponse (Retailer retailer) {
        if (retailer == null) {
            return RetailerExternalResponse.builder().build();
        }
        return RetailerExternalResponse.builder()
                .retailerId(retailer.getId())
                .storeName(retailer.getStoreName())
                .addressLine1(retailer.getAddressLine1())
                .email(retailer.getEmail())
                .phoneNumber(retailer.getPhoneNumber())
                .gstin(retailer.getGstin())
                .latitude(retailer.getLatitude())
                .longitude(retailer.getLongitude())
                .build();
    }
}
