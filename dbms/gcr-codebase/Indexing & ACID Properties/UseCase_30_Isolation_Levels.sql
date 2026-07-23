-- Session 6, Use Case 30
-- Demonstrate dirty reads, non-repeatable reads, and phantom reads,
-- then prevent them with the right isolation level.
--
-- Assumption: vaccine_inventory(center_id, vaccine_name, doses_available)
-- and vaccine_distribution(center_id, vaccine_name, distribution_date)
-- already exist.

-- ------------------------------------------------------------
-- 1) Dirty read demo
-- ------------------------------------------------------------
-- Session A
SET SESSION TRANSACTION ISOLATION LEVEL READ UNCOMMITTED;
START TRANSACTION;
SELECT doses_available
FROM vaccine_inventory
WHERE center_id = 501 AND vaccine_name = 'Covishield';

-- Session B
START TRANSACTION;
UPDATE vaccine_inventory
SET doses_available = doses_available - 500
WHERE center_id = 501 AND vaccine_name = 'Covishield';
-- Do not commit yet.

-- Back to Session A
SELECT doses_available
FROM vaccine_inventory
WHERE center_id = 501 AND vaccine_name = 'Covishield';

-- Prevention: use READ COMMITTED or higher so uncommitted changes are not visible.

-- ------------------------------------------------------------
-- 2) Non-repeatable read demo
-- ------------------------------------------------------------
-- Session A
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
START TRANSACTION;
SELECT doses_available
FROM vaccine_inventory
WHERE center_id = 501 AND vaccine_name = 'Covishield';

-- Session B
START TRANSACTION;
UPDATE vaccine_inventory
SET doses_available = doses_available - 100
WHERE center_id = 501 AND vaccine_name = 'Covishield';
COMMIT;

-- Back to Session A
SELECT doses_available
FROM vaccine_inventory
WHERE center_id = 501 AND vaccine_name = 'Covishield';
COMMIT;

-- Prevention: use REPEATABLE READ so the same row value stays stable inside the transaction.

-- ------------------------------------------------------------
-- 3) Phantom read demo
-- ------------------------------------------------------------
-- Session A
SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
START TRANSACTION;
SELECT COUNT(*) AS distribution_count
FROM vaccine_distribution
WHERE center_id = 501;

-- Session B
START TRANSACTION;
INSERT INTO vaccine_distribution (
    distribution_id,
    center_id,
    vaccine_name,
    distribution_date
) VALUES (
    1002,
    501,
    'Covishield',
    '2026-07-23'
);
COMMIT;

-- Back to Session A
SELECT COUNT(*) AS distribution_count
FROM vaccine_distribution
WHERE center_id = 501;
COMMIT;

-- Prevention: use SERIALIZABLE when you need to block phantom rows for the same query range.

-- ------------------------------------------------------------
-- Recommended isolation settings
-- ------------------------------------------------------------
-- Dirty read prevention: READ COMMITTED
-- Non-repeatable read prevention: REPEATABLE READ
-- Phantom read prevention: SERIALIZABLE

