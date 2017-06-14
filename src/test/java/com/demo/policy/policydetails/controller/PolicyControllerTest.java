package com.demo.policy.policydetails.controller;

import com.demo.policy.policydetails.jpa.PolicyDetailsEntity;
import com.demo.policy.policydetails.service.FetchPolicyDetailsService;
import org.easymock.EasyMock;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.easymock.EasyMock.expect;

/**
 * Created by kunj.ashok.bhagtani on 6/13/2017.
 */
public class PolicyControllerTest extends EasyMockSupport {
    PolicyController policyController;

    private FetchPolicyDetailsService fetchPolicyDetailsService;

    @Before
    public void setUp()
    {
        policyController = new PolicyController();
        fetchPolicyDetailsService = createStrictMock(FetchPolicyDetailsService.class);
        ReflectionTestUtils.setField(policyController,"fetchPolicyDetailsService",fetchPolicyDetailsService);
    }

    @Test
    public void testFetchDetails()
    {
        PolicyDetailsEntity policyDetailsEntity = new PolicyDetailsEntity();
        policyDetailsEntity.setDuration(1);
        policyDetailsEntity.setPolicyName("abc");
        policyDetailsEntity.setPolicyNumber(1L);
        policyDetailsEntity.setPolicyType("Life Insurance");
        expect(fetchPolicyDetailsService.fetchDetails(1L)).andReturn(policyDetailsEntity);
        policyController.fetchPolicyDetails(1L);
    }

    @Test
    public void testFetchDetails_PolicyDetailsNull()
    {
        expect(fetchPolicyDetailsService.fetchDetails(1L)).andReturn(null);
        policyController.fetchPolicyDetails(1L);
    }

    @Test
    public void testDeletePolicyDetails()
    {
        policyController.deletePolicyDetails(1l);
    }

    @Test
    public void testAddPolicyDetails()
    {
        PolicyDetailsEntity policyDetailsEntity = new PolicyDetailsEntity();
        policyDetailsEntity.setDuration(1);
        policyDetailsEntity.setPolicyName("abc");
        policyDetailsEntity.setPolicyNumber(1L);
        policyDetailsEntity.setPolicyType("Life Insurance");
        policyController.addPolicyDetails(policyDetailsEntity);
    }
}
