-- Use Case 25
-- Audit table plus BEFORE UPDATE trigger to log old and new values.

CREATE TABLE IF NOT EXISTS covid_cases_audit (
    audit_id INT AUTO_INCREMENT PRIMARY KEY,
    country VARCHAR(100) NOT NULL,
    case_date DATE NOT NULL,
    old_confirmed INT,
    new_confirmed INT,
    old_deaths INT,
    new_deaths INT,
    old_recovered INT,
    new_recovered INT,
    changed_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

DROP TRIGGER IF EXISTS trg_covid_cases_before_update;
DELIMITER $$

CREATE TRIGGER trg_covid_cases_before_update
BEFORE UPDATE ON covid_cases
FOR EACH ROW
BEGIN
    INSERT INTO covid_cases_audit (
        country,
        case_date,
        old_confirmed,
        new_confirmed,
        old_deaths,
        new_deaths,
        old_recovered,
        new_recovered,
        changed_at
    )
    VALUES (
        OLD.country,
        OLD.`date`,
        OLD.confirmed,
        NEW.confirmed,
        OLD.deaths,
        NEW.deaths,
        OLD.recovered,
        NEW.recovered,
        NOW()
    );
END$$

DELIMITER ;

