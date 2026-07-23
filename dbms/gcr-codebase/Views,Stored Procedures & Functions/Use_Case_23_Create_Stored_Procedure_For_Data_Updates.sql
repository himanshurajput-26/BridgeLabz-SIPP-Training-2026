-- Use Case 23
-- Stored procedure to update multiple covid statistics for a country/date.

DROP PROCEDURE IF EXISTS UpdateCovidStats;
DELIMITER $$

CREATE PROCEDURE UpdateCovidStats(
    IN p_country VARCHAR(100),
    IN p_case_date DATE,
    IN p_confirmed INT,
    IN p_deaths INT,
    IN p_recovered INT
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        RESIGNAL;
    END;

    START TRANSACTION;

    UPDATE covid_cases
    SET confirmed = p_confirmed,
        deaths = p_deaths,
        recovered = p_recovered
    WHERE country = p_country
      AND `date` = p_case_date;

    IF ROW_COUNT() = 0 THEN
        ROLLBACK;
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'No matching covid_cases row found for the given country and date.';
    END IF;

    COMMIT;
END$$

DELIMITER ;
