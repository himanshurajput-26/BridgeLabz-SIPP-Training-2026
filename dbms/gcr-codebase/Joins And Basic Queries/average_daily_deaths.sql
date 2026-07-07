SELECT 
    date, 
    AVG(new_deaths) AS avg_daily_deaths
FROM 
    covid_deaths
GROUP BY 
    date
ORDER BY 
    date ASC;