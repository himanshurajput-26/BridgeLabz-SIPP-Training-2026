SELECT 
    d.country_name, 
    d.date, 
    d.death_count, 
    v.vaccination_status,
    v.doses_administered
FROM 
    covid_deaths d
LEFT JOIN 
    covid_vaccines v ON d.country_id = v.country_id AND d.date = v.date;