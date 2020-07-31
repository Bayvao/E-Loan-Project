USE `bank_eloan`;

DROP TABLE IF EXISTS `loan_status`;
CREATE TABLE `loan_status` (
`status_id` bigint NOT NULL AUTO_INCREMENT,
`lid` bigint NOT NULL,
`approval_status` varchar(255) NOT NULL,
PRIMARY KEY (`status_id`),
CONSTRAINT `pending_loan_FK` FOREIGN KEY (`lid`) REFERENCES `loan` (`loan_id`)
);

DROP TABLE IF EXISTS `loan_acceptance`;
CREATE TABLE `loan_acceptance` (
`loan_number` bigint NOT NULL,
`regional_office` varchar(255) NOT NULL,
`sanctioned_date` date NOT NULL,
`sanctioning_offical` varchar(255) NOT NULL,
`loan_id` bigint NOT NULL,
PRIMARY KEY (`loan_number`),
CONSTRAINT `pending_loan_acceptance_FK` FOREIGN KEY (`loan_id`) REFERENCES `loan` (`loan_id`)
);

DROP TABLE IF EXISTS `loan_amortization`;
CREATE TABLE `loan_amortization` (
`amortization_id` bigint NOT NULL,
`loan_number` bigint NOT NULL,
`term_of_loan` bigint NOT NULL,
`repayment_start_date` date NOT NULL,
`loan_closure_date` date NOT NULL,
`interest_rate` float(12,1) NOT NULL,
`monthly_payment_amount` bigint NOT NULL,
PRIMARY KEY (`amortization_id`),
CONSTRAINT `pending_loan_amortization_FK` FOREIGN KEY (`loan_number`) REFERENCES `loan_acceptance` (`loan_number`)
);

DROP TABLE IF EXISTS `loan_payment`;
CREATE TABLE `loan_payment`(
`payment_id` bigint NOT NULL,
`loan_number` bigint NOT NULL,
`amount_repaid` bigint NOT NULL,
`mode_of_Payment` varchar(50) NOT NULL,
`cheque_or_draft_number` bigint NOT NULL,
`date_and_time_of_payment` datetime NOT NULL,
PRIMARY KEY (`payment_id`),
CONSTRAINT `loan_payment_FK` FOREIGN KEY (`loan_number`) REFERENCES `loan_acceptance` (`loan_number`)
);
