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
