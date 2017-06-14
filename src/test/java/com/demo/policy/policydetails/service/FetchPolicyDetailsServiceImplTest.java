package com.demo.policy.policydetails.service;

import com.demo.policy.policydetails.jpa.FetchPolicyDetailsRepository;
import com.demo.policy.policydetails.jpa.PolicyDetailsEntity;
import org.easymock.EasyMockSupport;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.Assert.assertTrue;

/**
 * Created by b.mukeshlal.raghani on 6/12/2017.
 */
public class FetchPolicyDetailsServiceImplTest extends EasyMockSupport {
    private FetchPolicyDetailsServiceImpl fetchPolicyDetailsServiceImpl;

    private FetchPolicyDetailsRepository fetchPolicyDetailsRepository;

    @Before
    public void setUp()
    {
        fetchPolicyDetailsServiceImpl = new FetchPolicyDetailsServiceImpl();
        fetchPolicyDetailsRepository = createStrictMock(FetchPolicyDetailsRepository.class);
        ReflectionTestUtils.setField(fetchPolicyDetailsServiceImpl,"fetchPolicyDetailsRepository",fetchPolicyDetailsRepository);
    }

    @Test
    public void testFetchDetails()
    {
        fetchPolicyDetailsServiceImpl.fetchDetails(1L);
    }

    @Test
    public void testAddPolicy()
    {
        PolicyDetailsEntity policyDetailsEntity = new PolicyDetailsEntity();
        fetchPolicyDetailsServiceImpl.addPolicy(policyDetailsEntity);
    }

    @Test
    public void testDeletePolicy()
    {
        fetchPolicyDetailsServiceImpl.deletePolicy(1L);
    }
}
