ALTER TABLE covid_cases
ADD CONSTRAINT UQ_Country_Date
UNIQUE (Country, Date);