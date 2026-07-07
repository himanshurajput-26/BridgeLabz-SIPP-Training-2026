SELECT 
    con.continent_name, 
    SUM(cc.death_count) AS total_deaths
FROM 
    covid_cases cc
INNER JOIN 
    continents con ON cc.continent_id = con.continent_id
GROUP BY 
    con.continent_name
ORDER BY 
    total_deaths DESC;