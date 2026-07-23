-- Use Case 21
-- Create a view that returns the most recent confirmed cases, deaths,
-- and recoveries for each country.

CREATE OR REPLACE VIEW vw_latest_covid_data AS
SELECT
    c.country,
    c.`date`,
    c.confirmed,
    c.deaths,
    c.recovered
FROM covid_cases c
INNER JOIN (
    SELECT
        country,
        MAX(`date`) AS latest_date
    FROM covid_cases
    GROUP BY country
) latest
    ON latest.country = c.country
   AND latest.latest_date = c.`date`;

