-- Session 6, Use Case 27
-- Create a covering index to speed up top 10 countries by infection rate.
-- Assumption: the query reads Country and infection_rate from covid_cases.

-- This index can satisfy queries like:
-- SELECT Country, infection_rate
-- FROM covid_cases
-- ORDER BY infection_rate DESC
-- LIMIT 10;
CREATE INDEX idx_covid_cases_infection_rate_country
ON covid_cases (infection_rate DESC, Country);

