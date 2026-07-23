-- Use Case 24
-- Create a reusable function to calculate recovery rate:
-- recovered / confirmed * 100

DROP FUNCTION IF EXISTS CalculateRecoveryRate;
DELIMITER $$

CREATE FUNCTION CalculateRecoveryRate(
    p_country VARCHAR(100),
    p_case_date DATE
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_confirmed INT DEFAULT 0;
    DECLARE v_recovered INT DEFAULT 0;

    SELECT
        COALESCE(confirmed, 0),
        COALESCE(recovered, 0)
    INTO v_confirmed, v_recovered
    FROM covid_cases
    WHERE country = p_country
      AND `date` = p_case_date
    LIMIT 1;

    IF v_confirmed = 0 THEN
        RETURN 0.00;
    END IF;

    RETURN ROUND((v_recovered / v_confirmed) * 100, 2);
END$$

DELIMITER ;
