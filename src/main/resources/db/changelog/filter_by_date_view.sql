--liquibase formatted sql
--changeset sofia_krylova@epam.com:1

CREATE FUNCTION filter_by_date_view(fromDate date, toDate date)
RETURNS TABLE(product_name TEXT, number_of_complaints BIGINT)
AS
'SELECT product_name AS product_name,
-- received AS received,
count(CASE WHEN received > $1 AND received < $2 THEN 1 ELSE NULL END) AS number_of_complaints
FROM complaints
GROUP BY product_name
-- HAVING received < $1
ORDER BY number_of_complaints DESC'

LANGUAGE sql;