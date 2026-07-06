ALTER TABLE covid_cases
MODIFY Country VARCHAR(100) NOT NULL;

ALTER TABLE covid_cases
MODIFY Date DATE NOT NULL;

ALTER TABLE covid_cases
MODIFY Confirmed_Cases INT NOT NULL;

ALTER TABLE covid_cases
ADD CONSTRAINT CHK_Deaths
CHECK (Deaths <= Confirmed_Cases);