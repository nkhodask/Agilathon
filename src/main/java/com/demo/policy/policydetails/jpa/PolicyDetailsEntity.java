package com.demo.policy.policydetails.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by b.mukeshlal.raghani on 6/12/2017.
 */
@Entity
@Table(name = "policy_details", schema = "policy")
public class PolicyDetailsEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "policy_number", unique = true, nullable = false)
    private long policyNumber;
    @Column(name = "policy_name", nullable = false, length = 20)
    private String policyName;
    @Column(name = "policy_type", nullable = false, length = 500)
    private String policyType;
    @Column(name = "duration", nullable = false, length = 20)
    private int duration;

    public long getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(long policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
