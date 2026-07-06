CREATE TABLE covid_cases (
    Country VARCHAR(100),
    Date DATE,
    Confirmed_Cases INT,
    Deaths INT,
    Recoveries INT,
    Last_Updated TIMESTAMP,
    PRIMARY KEY (Country, Date)
);