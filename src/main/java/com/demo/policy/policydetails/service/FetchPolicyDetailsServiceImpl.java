package com.demo.policy.policydetails.service;

import com.demo.policy.policydetails.jpa.FetchPolicyDetailsRepository;
import com.demo.policy.policydetails.jpa.PolicyDetailsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by b.mukeshlal.raghani on 6/12/2017.
 */
@Component
public class FetchPolicyDetailsServiceImpl implements FetchPolicyDetailsService
{
    @Autowired
    private FetchPolicyDetailsRepository fetchPolicyDetailsRepository;

    @Override
    public PolicyDetailsEntity fetchDetails(long id) {
        return fetchPolicyDetailsRepository.findOneByPolicyNumber(id);
    }

    @Override
    public void addPolicy(PolicyDetailsEntity policyDetailsEntity) {
        fetchPolicyDetailsRepository.save(policyDetailsEntity);
    }

    @Override
    public void deletePolicy(long id) {
      fetchPolicyDetailsRepository.delete(id);
    }
}
