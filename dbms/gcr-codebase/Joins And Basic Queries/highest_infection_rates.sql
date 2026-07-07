SELECT 
    country_name, 
    confirmed_cases, 
    population,
    ((confirmed_cases / population) * 100) AS infection_rate
FROM 
    country_stats
ORDER BY 
    infection_rate DESC;