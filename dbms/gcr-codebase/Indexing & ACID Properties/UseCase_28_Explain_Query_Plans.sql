-- Session 6, Use Case 28
-- Use EXPLAIN to analyze a complex JOIN query and spot missing indexes.
-- Assumption: the database has covid_cases, country_population, and vaccination_data tables.

EXPLAIN
SELECT
    cc.Country,
    cc.Date,
    cc.confirmed_cases,
    cp.population,
    vd.total_vaccinations
FROM covid_cases cc
JOIN country_population cp
    ON cc.Country = cp.Country
LEFT JOIN vaccination_data vd
    ON cc.Country = vd.Country
   AND cc.Date = vd.Date
WHERE cc.Date BETWEEN '2024-01-01' AND '2024-12-31'
  AND cc.Country IN ('India', 'United States', 'Brazil')
ORDER BY cc.Date DESC;

-- Suggested indexes based on the plan:
-- 1) covid_cases(Country, Date)
-- 2) country_population(Country)
-- 3) vaccination_data(Country, Date)
-- These indexes reduce full scans on the join and filter columns.

