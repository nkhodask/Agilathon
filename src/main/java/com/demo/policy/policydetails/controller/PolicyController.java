package com.demo.policy.policydetails.controller;

import com.demo.policy.policydetails.jpa.PolicyDetailsEntity;
import com.demo.policy.policydetails.service.FetchPolicyDetailsService;
import com.demo.policy.policydetails.service.FetchPolicyDetailsServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = PolicyDetailsEntity.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
    @RequestMapping(value = "/retrieve/{id}", method = RequestMethod.GET)
    @ApiParam( value = "Policy to look for", required = true )
    public ResponseEntity<Object> fetchPolicyDetails(@PathVariable long id)
    {
        ResponseEntity<Object> res;
        PolicyDetailsEntity policyDetails = fetchPolicyDetailsService.fetchDetails(id);
        if(policyDetails!=null)
        {
            res = new ResponseEntity<Object>(policyDetails,HttpStatus.OK);
            System.out.println("policyDetails = " + "   "+res+"   "+ policyDetails);
        }
        else
        {
            res = new ResponseEntity<Object>("No Such Policy", HttpStatus.NOT_FOUND);
            System.out.println("policyDetails = " + "   "+res+"   "+ policyDetails);
        }
        return res;
    }

    @ApiOperation(value = "Delete Policy", nickname = "Delete Policy")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = PolicyDetailsEntity.class),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
    @RequestMapping(value = "/deletePolicy/{id}", method = RequestMethod.DELETE)
    public void deletePolicyDetails(@PathVariable long id)
    {
        fetchPolicyDetailsService.deletePolicy(id);
    }

    @ApiOperation(value = "Add Policy", nickname = "Add Policy")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", responseContainer = "List"),
            @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Failure") })
    @RequestMapping(value = "/addPolicy", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE )
    public void addPolicyDetails(@RequestBody PolicyDetailsEntity policyDetailsEntity)
    {
        fetchPolicyDetailsService.addPolicy(policyDetailsEntity);
    }
}
