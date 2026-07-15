-- Session 4: Sub-queries & Advanced Queries

-- Use Case 16: Find Countries with Above-Average Death Counts
SELECT location, max_total_deaths
FROM (
    SELECT location, MAX(total_deaths) AS max_total_deaths
    FROM covid_deaths
    WHERE continent IS NOT NULL
    GROUP BY location
) AS country_deaths
WHERE max_total_deaths > (
    SELECT AVG(max_total_deaths)
    FROM (
        SELECT location, MAX(total_deaths) AS max_total_deaths
        FROM covid_deaths
        WHERE continent IS NOT NULL
        GROUP BY location
    ) AS avg_source
)
ORDER BY max_total_deaths DESC;

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

-- Use Case 20: Find Countries Present in Deaths but Not Cases
SELECT DISTINCT location
FROM covid_deaths
WHERE continent IS NOT NULL
  AND location NOT IN (
      SELECT DISTINCT location
      FROM covid_cases
      WHERE location IS NOT NULL
  )
ORDER BY location;
