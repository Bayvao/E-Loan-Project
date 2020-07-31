DROP DATABASE  IF EXISTS `bank_eloan`;

CREATE DATABASE  IF NOT EXISTS `bank_eloan`;
USE `bank_eloan`;

DROP TABLE IF EXISTS `property`;
CREATE TABLE `property` (
`property_id` bigint NOT NULL AUTO_INCREMENT,
`acres` int NOT NULL,
`land_value` bigint NOT NULL,
`produced_on_land` bigint NOT NULL,
`appraised_by` varchar(255) NOT NULL,
`valuation_date` date NOT NULL,
`field_representative` varchar(255) NOT NULL,
`property_country` varchar(255) NOT NULL,
`property_state` varchar(255) NOT NULL,
constraint `property_pk` PRIMARY KEY (`property_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `borrower`;
CREATE TABLE `borrower` (
`borrower_id` bigint NOT NULL AUTO_INCREMENT,
`borrower_name` varchar(255) NOT NULL,
`business_structure` varchar(255) NOT NULL,
`billing_indicator` varchar(255) NOT NULL,
`tax_indicator` varchar(255) NOT NULL,
`borrower_address` varchar(255) NOT NULL,
`borrower_contact_no` varchar(255) NOT NULL,
`borrower_email` varchar(255) NOT NULL,
constraint `borrower_pk` PRIMARY KEY (`borrower_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


DROP TABLE IF EXISTS `loan`;
CREATE TABLE `loan` (
`loan_id` bigint NOT NULL AUTO_INCREMENT,
`loan_type` varchar(50) NOT NULL,
`loan_amount` bigint NOT NULL,
`loan_date` date NOT NULL,
`property_id` bigint NOT NULL,
`borrower_id` bigint NOT NULL,
PRIMARY KEY (`loan_id`),
CONSTRAINT `loan_property_FK` FOREIGN KEY (`property_id`) REFERENCES `property` (`property_id`),
CONSTRAINT `loan_borrower_FK` FOREIGN KEY (`borrower_id`) REFERENCES `borrower` (`borrower_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

