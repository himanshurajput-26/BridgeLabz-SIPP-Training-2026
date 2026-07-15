-- Use Case 19: Compare Vaccination Coverage
WITH country_vaccination AS (
    SELECT
        location,
        MAX(population) AS population,
        MAX(people_vaccinated) AS vaccinated
    FROM covid_deaths
    WHERE continent IS NOT NULL
    GROUP BY location
)
SELECT location, 'Vaccinated' AS coverage_type, vaccinated AS people_count
FROM country_vaccination
UNION ALL
SELECT location, 'Unvaccinated' AS coverage_type, population - vaccinated AS people_count
FROM country_vaccination
ORDER BY location, coverage_type;
