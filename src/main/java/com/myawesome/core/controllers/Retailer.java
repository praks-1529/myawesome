package com.myawesome.core.controllers;

import com.myawesome.core.common.util.JWT;
import com.myawesome.core.constants.enums.ProfileType;
import com.myawesome.core.models.GenericUser;
import com.myawesome.core.models.retailer.CreateRetailerRequest;
import com.myawesome.core.models.retailer.RetailerExternalResponse;
import com.myawesome.core.service.retailer.RetailerService;
import com.myawesome.core.models.retailer.RetailerExternalResponseList;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

@Controller
public class Retailer implements IRetailer {
    @Autowired
    RetailerService retailerService;

    @Override
    public ResponseEntity<RetailerExternalResponse> createRetailer(@ApiParam(value = "", required = true) @PathVariable("apiVersion") String apiVersion,
                                                                   @ApiParam(value = "", required = true) @PathVariable("countryCode") String countryCode,
                                                                   @RequestBody CreateRetailerRequest createRetailerRequest, HttpServletRequest request) throws Exception {
        RetailerExternalResponse loginResponse = retailerService.createRetailer(createRetailerRequest);
        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
    }

    public ResponseEntity<RetailerExternalResponse> getRetailer(@ApiParam(value = "", required = true) @PathVariable("apiVersion") String apiVersion,
                                                                @ApiParam(value = "", required = true) @PathVariable("countryCode") String countryCode,
                                                                @ApiParam(value = "", required = true) @RequestHeader("grx-auth") String grxAuth,
                                                                HttpServletRequest request) {
        GenericUser user = JWT.verifyJwt(grxAuth);
        if (user == null || user.getProfileType() != ProfileType.RETAILER) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        RetailerExternalResponse retailerExternalResponse = retailerService.getRetailer(user.getId());
        return ResponseEntity.status(HttpStatus.OK).body(retailerExternalResponse);
    }

    public ResponseEntity<RetailerExternalResponse> getRetailerById(@ApiParam(value = "", required = true) @PathVariable("apiVersion") String apiVersion,
                                                             @ApiParam(value = "", required = true) @PathVariable("countryCode") String countryCode,
                                                             @ApiParam(value = "", required = true) @RequestHeader("grx-auth") String grxAuth,
                                                             @ApiParam(value = "", required = true) @PathVariable("retailerId") String retailerId,
                                                             HttpServletRequest request) {
        GenericUser user = JWT.verifyJwt(grxAuth);
//        if (user == null || user.getProfileType() != ProfileType.ADMIN) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
        RetailerExternalResponse retailerExternalResponse = retailerService.getRetailer(retailerId);
        return ResponseEntity.status(HttpStatus.OK).body(retailerExternalResponse);
    }

    public ResponseEntity<RetailerExternalResponseList> getRetailerByPrefix(@ApiParam(value = "", required = true) @PathVariable("apiVersion") String apiVersion,
                                                                            @ApiParam(value = "", required = true) @PathVariable("countryCode") String countryCode,
                                                                            @ApiParam(value = "", required = true) @RequestHeader("grx-auth") String grxAuth,
                                                                            @ApiParam(value = "", required = true) @PathParam("query") String query,
                                                                            HttpServletRequest request) {
        GenericUser user = JWT.verifyJwt(grxAuth);
//        if (user == null || user.getProfileType() != ProfileType.ADMIN) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
//        }
        RetailerExternalResponseList retailerExternalResponse = retailerService.getRetailerByPrefix(query);
        return ResponseEntity.status(HttpStatus.OK).body(retailerExternalResponse);
    }
}
