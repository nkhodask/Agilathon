package com.demo.policy.policydetails.service;

import com.demo.policy.policydetails.jpa.PolicyDetailsEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by b.mukeshlal.raghani on 6/12/2017.
 */
@Component
public interface FetchPolicyDetailsService {

    public PolicyDetailsEntity fetchDetails(long id);
    public void deletePolicy(long id);
    public void addPolicy(PolicyDetailsEntity policyDetailsEntity);
}
