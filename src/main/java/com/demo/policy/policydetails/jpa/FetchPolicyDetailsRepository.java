package com.demo.policy.policydetails.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by b.mukeshlal.raghani on 6/12/2017.
 */
@Repository
public interface FetchPolicyDetailsRepository extends CrudRepository<PolicyDetailsEntity, Long>
{

    List<PolicyDetailsEntity> findByPolicyNumber(long apiAudId);

}
