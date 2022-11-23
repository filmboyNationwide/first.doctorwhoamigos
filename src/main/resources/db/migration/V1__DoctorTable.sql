CREATE TABLE doctor (
    id UUID NOT NULL PRIMARY KEY,
    number VARCHAR(100) NOT NULL,
    actor VARCHAR(100) NOT NULL,
    startYear INT NOT NULL,
    endYear INT
)