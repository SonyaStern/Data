--liquibase formatted sql
--changeset sofia_krylova@epam.com:1

create function filter_by_company(companyName text)
RETURNS TABLE(state_name TEXT, number_of_complaints BIGINT)
as
'WITH list AS (SELECT state_name, count(*) AS number_of_complaints
FROM complaints
WHERE company = $1 AND state_name IS NOT NULL
GROUP BY state_name)
SELECT * FROM list
--WHERE number_of_complaints > 700
GROUP BY list.state_name, list.number_of_complaints
ORDER BY number_of_complaints DESC
LIMIT 1'

LANGUAGE sql;