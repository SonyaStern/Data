--liquibase formatted sql
--changeset sofia_krylova@epam.com:1

DROP TABLE IF EXISTS complaints;

create table complaints
(
	received date,
	product_name varchar(255),
	sub_product varchar(255),
	issue varchar(255),
	sub_issue varchar(255),
	narrative varchar(4500),
	public_response varchar(255),
	company varchar(255),
	state_name varchar(255),
	zip_code varchar(255),
	tags varchar(255),
	consent_provided varchar(255),
	submitted_via varchar(255),
	sent date,
	response_to_consumer varchar(255),
	timely_response varchar(255),
	consumer_disputed varchar(255),
	id bigint not null
		constraint complaint_pkey
			primary key
);
--rollback DROP TABLE complaints;