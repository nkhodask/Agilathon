package com.demo.policy.policydetails.controller;

import com.demo.policy.policydetails.jpa.PolicyDetailsEntity;
import com.demo.policy.policydetails.service.FetchPolicyDetailsService;
import com.demo.policy.policydetails.service.FetchPolicyDetailsServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by b.mukeshlal.raghani on 6/12/2017.
 */
@RestController
@RequestMapping(value = "/policy")
public class PolicyController {

    @Autowired
    private FetchPolicyDetailsService fetchPolicyDetailsService;

    @ApiOperation(value = "Get Policy Details", nickname = "Get Policy Details")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
    @RequestMapping(value = "/retrieve/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PolicyDetailsEntity> fetchPolicyDetails(@PathVariable long id)
    {
        List<PolicyDetailsEntity> policyDetailsList = fetchPolicyDetailsService.fetchDetails(id);
        return policyDetailsList;
    }
}
