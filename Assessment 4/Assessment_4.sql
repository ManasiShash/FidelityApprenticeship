CREATE TABLE Worker (
    WORKER_ID SERIAL PRIMARY KEY,
    FIRST_NAME VARCHAR(50) NOT NULL,
    LAST_NAME VARCHAR(50) NOT NULL,
    SALARY NUMERIC(15, 2) NOT NULL,
    JOINING_DATE DATE NOT NULL,
    DEPARTMENT VARCHAR(50) NOT NULL
);

CREATE TABLE Title (
    WORKER_REF_ID INT REFERENCES Worker(WORKER_ID),
    WORKER_TITLE VARCHAR(50) NOT NULL,
    AFFECTED_FROM DATE NOT NULL,
    PRIMARY KEY (WORKER_REF_ID, WORKER_TITLE)
);

CREATE TABLE Bonus (
    WORKER_REF_ID INT REFERENCES Worker(WORKER_ID),
    BONUS_AMOUNT NUMERIC(10, 2) NOT NULL,
    BONUS_DATE DATE NOT NULL,
    PRIMARY KEY (WORKER_REF_ID, BONUS_DATE)
);

INSERT INTO Worker (FIRST_NAME, LAST_NAME, SALARY, JOINING_DATE, DEPARTMENT) VALUES
('Monika', 'Arora', 100000, '2020-02-14', 'HR'),
('Niharika', 'Verma', 80000, '2011-02-14', 'Admin'),
('Vishal', 'Singhal', 300000, '2020-02-14', 'HR'),
('Amitabh', 'Singh', 500000, '2020-02-14', 'Admin'),
('Vivek', 'Bhati', 500000, '2011-06-14', 'Admin'),
('Vipul', 'Diwan', 200000, '2011-06-14', 'Account'),
('Satish', 'Kumar', 75000, '2020-01-14', 'Account'),
('Geetika', 'Chauhan', 90000, '2011-04-14', 'Admin');

select * from Worker;

INSERT INTO Title (WORKER_REF_ID, WORKER_TITLE, AFFECTED_FROM) VALUES
(1, 'Manager', '2016-02-20'),
(2, 'Executive', '2016-06-11'),
(8, 'Executive', '2016-06-11'),
(5, 'Manager', '2016-06-11'),
(4, 'Asst. Manager', '2016-06-11'),
(7, 'Executive', '2016-06-11'),
(6, 'Lead', '2016-06-11'),
(3, 'Lead', '2016-06-11');

select * from Title;

INSERT INTO Bonus (WORKER_REF_ID, BONUS_AMOUNT, BONUS_DATE) VALUES
(1, 5000, '2020-02-16'),
(2, 3000, '2011-06-16'),
(3, 4000, '2020-02-16'),
(4, 4500, '2020-02-16'),
(5, 3500, '2011-02-16'),
(6, 4500, '2020-02-16'),
(7, 3500, '2011-02-16');

select * from Bonus;

SELECT 
    w.FIRST_NAME, 
    w.SALARY, 
    t.WORKER_TITLE
FROM 
    Worker w
JOIN 
    Title t ON w.WORKER_ID = t.WORKER_REF_ID;

CREATE OR REPLACE FUNCTION get_worker_count(n INT)
RETURNS INTEGER AS $$
DECLARE
	nth_highest_salary INT;
BEGIN
	SELECT DISTINCT salary INTO nth_highest_salary 
	FROM Worker 
	ORDER BY salary DESC 
	OFFSET n-1 LIMIT 1;
	RETURN (SELECT COUNT(*) FROM Worker WHERE salary = nth_highest_salary);
END;
$$ LANGUAGE plpgsql;

SELECT get_worker_count(4);
SELECT get_worker_count(1);





