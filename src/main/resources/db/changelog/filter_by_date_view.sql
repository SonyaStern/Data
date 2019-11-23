--liquibase formatted sql
--changeset sofia_krylova@epam.com:1

CREATE FUNCTION filter_by_date(fromDate date, toDate date, timelyResponse text, consumerDisputed text)
RETURNS TABLE(product_name TEXT, number_of_complaints BIGINT, number_of_complaints_with_timely_response BIGINT, number_of_complaints_disputed_by_customer BIGINT)
AS
'SELECT product_name AS product_name,
-- received AS received,
-- CASE WHEN received > $1 AND received < $2 THEN 1 ELSE NULL END
count(*) AS number_of_complaints,
count(CASE WHEN timely_response = $3 THEN 1 ELSE NULL END) AS number_of_complaints_with_timely_response,
count(CASE WHEN consumer_disputed = $4 THEN 1 ELSE NULL END) AS number_of_complaints_disputed_by_customer
FROM complaints
WHERE received > $1 AND received < $2
GROUP BY product_name
-- HAVING received < $1
ORDER BY number_of_complaints DESC'

LANGUAGE sql;