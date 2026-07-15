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
