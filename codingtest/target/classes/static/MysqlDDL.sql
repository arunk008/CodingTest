
DROP TABLE continent CASCADE;

CREATE TABLE continent
(
  continent_id INT,
  continent varchar(30)  PRIMARY KEY
);

DROP TABLE countries CASCADE;

CREATE TABLE countries
(
  countries_id INT PRIMARY KEY,
  name  varchar(30),
  flag  varchar(10),
  continent varchar(30)	
);


ALTER TABLE tbl_countries ADD FOREIGN KEY (continent) REFERENCES tbl_continent(continent);




