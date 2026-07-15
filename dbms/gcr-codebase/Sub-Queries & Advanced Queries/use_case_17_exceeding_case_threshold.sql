-- Use Case 17: Identify Countries Exceeding Case Threshold
SELECT location, MAX(total_cases) AS max_confirmed_cases
FROM covid_cases
GROUP BY location
HAVING location IN (
    SELECT location
    FROM covid_cases
    GROUP BY location
    HAVING MAX(total_cases) > 1000000
)
ORDER BY max_confirmed_cases DESC;
