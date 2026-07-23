-- Session 6, Use Case 29
-- Atomic multi-statement transaction for vaccine data insertion.
-- Assumptions:
-- 1) vaccine_distribution stores the main distribution record.
-- 2) vaccine_stock stores inventory changes for the same distribution.
-- 3) The script should roll back if any statement fails.

DELIMITER //

DROP PROCEDURE IF EXISTS insert_vaccine_distribution_atomically//

CREATE PROCEDURE insert_vaccine_distribution_atomically()
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;

    START TRANSACTION;

    INSERT INTO vaccine_distribution (
        distribution_id,
        center_id,
        vaccine_name,
        doses_sent,
        distribution_date
    ) VALUES (
        1001,
        501,
        'Covishield',
        2000,
        '2026-07-23'
    );

    INSERT INTO vaccine_stock (
        stock_id,
        center_id,
        vaccine_name,
        doses_available,
        last_updated
    ) VALUES (
        9001,
        501,
        'Covishield',
        8000,
        '2026-07-23'
    );

    COMMIT;
END//

DELIMITER ;

-- Run the atomic insert.
CALL insert_vaccine_distribution_atomically();
