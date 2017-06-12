CREATE OR REPLACE SCHEMA policy;

CREATE TABLE policy.policy_details
(
    policy_number bigint NOT NULL,
    policy_name character varying(100) NOT NULL,
    policy_type character varying(100) NOT NULL,
    duration INTEGER NOT NULL
);
COMMIT;