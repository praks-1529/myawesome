package com.myawesome.core.controllers;

import com.myawesome.core.constants.common.ProfileConstants;
import com.myawesome.core.models.retailer.CreateRetailerRequest;
import com.myawesome.core.models.retailer.RetailerExternalResponse;
import com.myawesome.core.models.retailer.RetailerExternalResponseList;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

public interface IRetailer {
    @ApiOperation(value = "Create a new retailer", notes = "", response = RetailerExternalResponse.class, tags = {"retailer",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "", response = RetailerExternalResponse.class),
    })
    @RequestMapping(value = ProfileConstants.PATH_PREFIX_BASE_PROFILE + ProfileConstants.PATH_PREFIX_BASE_RETAILER,
            produces = {"application/json"},
            consumes = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<RetailerExternalResponse> createRetailer(@ApiParam(value = "", required = true) @PathVariable("apiVersion") String apiVersion,
                                                            @ApiParam(value = "", required = true) @PathVariable("countryCode") String countryCode,
                                                            @RequestBody CreateRetailerRequest createRetailerRequest, HttpServletRequest request) throws Exception;

    @RequestMapping(value = ProfileConstants.PATH_PREFIX_BASE_PROFILE + ProfileConstants.PATH_PREFIX_BASE_RETAILER,
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<RetailerExternalResponse> getRetailer(@ApiParam(value = "", required = true) @PathVariable("apiVersion") String apiVersion,
                                                         @ApiParam(value = "", required = true) @PathVariable("countryCode") String countryCode,
                                                         @ApiParam(value = "", required = true) @RequestHeader("grx-auth") String grxAuth,
                                                         HttpServletRequest request);

    @RequestMapping(value = ProfileConstants.PATH_PREFIX_BASE_PROFILE + ProfileConstants.PATH_PREFIX_BASE_RETAILER + "/{retailerId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<RetailerExternalResponse> getRetailerById(@ApiParam(value = "", required = true) @PathVariable("apiVersion") String apiVersion,
                                                         @ApiParam(value = "", required = true) @PathVariable("countryCode") String countryCode,
                                                         @ApiParam(value = "", required = true) @RequestHeader("grx-auth") String grxAuth,
                                                         @ApiParam(value = "", required = true) @PathVariable("retailerId") String retailerId,
                                                         HttpServletRequest request);

    @RequestMapping(value = ProfileConstants.PATH_PREFIX_BASE_PROFILE + ProfileConstants.PATH_PREFIX_BASE_RETAILER + "/list",
            produces = {"application/json"},
            method = RequestMethod.GET)
    public ResponseEntity<RetailerExternalResponseList> getRetailerByPrefix(@ApiParam(value = "", required = true) @PathVariable("apiVersion") String apiVersion,
                                                                            @ApiParam(value = "", required = true) @PathVariable("countryCode") String countryCode,
                                                                            @ApiParam(value = "", required = true) @RequestHeader("grx-auth") String grxAuth,
                                                                            @ApiParam(value = "", required = true) @PathParam("query") String query,
                                                                            HttpServletRequest request);
}
