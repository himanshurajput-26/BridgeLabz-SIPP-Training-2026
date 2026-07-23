-- Session 6, Use Case 26
-- Create indexes on frequently searched columns in covid_cases.
-- Assumption: covid_cases already exists with columns Country and Date.

-- Composite index for queries filtering by country and date together.
CREATE INDEX idx_covid_cases_country_date
ON covid_cases (Country, Date);

-- Single-column index for queries that filter or sort only by Date.
CREATE INDEX idx_covid_cases_date
ON covid_cases (Date);

