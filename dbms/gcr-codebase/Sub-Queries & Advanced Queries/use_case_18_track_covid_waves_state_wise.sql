-- Use Case 18: Track COVID Waves - State-wise Analysis
SELECT
    c.state,
    c.date,
    c.confirmed_cases,
    CASE
        WHEN c.confirmed_cases = (
            SELECT MAX(c2.confirmed_cases)
            FROM covid_cases AS c2
            WHERE c2.state = c.state
        ) THEN 'Peak'
        ELSE 'Not Peak'
    END AS wave_status
FROM covid_cases AS c
WHERE c.state = 'Mumbai'
ORDER BY c.date;
