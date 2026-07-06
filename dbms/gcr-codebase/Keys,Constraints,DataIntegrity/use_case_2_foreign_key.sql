CREATE TABLE countries (
    Country VARCHAR(100) PRIMARY KEY,
    Continent VARCHAR(50),
    Population BIGINT
);

ALTER TABLE covid_cases
ADD CONSTRAINT FK_Country
FOREIGN KEY (Country)
REFERENCES countries(Country);