INSERT INTO eraktkendra.blood_bank (blood_bank_id, address, city) VALUES (1, 'Kota', 'Kota');
INSERT INTO eraktkendra.blood_bank (blood_bank_id, address, city) VALUES (2, 'Bhopal', 'Bhopal');
INSERT INTO eraktkendra.blood_bank (blood_bank_id, address, city) VALUES (3, 'Bangalore', 'Bangalore');

INSERT INTO eraktkendra.blood_record (blood_record_id, blood_type, cost_per_unit, quantity, bank_id) VALUES (1, 'A+', 11, 10, 1);
INSERT INTO eraktkendra.blood_record (blood_record_id, blood_type, cost_per_unit, quantity, bank_id) VALUES (2, 'A-', 11, 15, 1);
INSERT INTO eraktkendra.blood_record (blood_record_id, blood_type, cost_per_unit, quantity, bank_id) VALUES (3, 'A+', 23, 15, 2);
INSERT INTO eraktkendra.blood_record (blood_record_id, blood_type, cost_per_unit, quantity, bank_id) VALUES (4, 'A-', 21, 15, 2);
INSERT INTO eraktkendra.blood_record (blood_record_id, blood_type, cost_per_unit, quantity, bank_id) VALUES (5, 'A+', 12, 15, 3);
INSERT INTO eraktkendra.blood_record (blood_record_id, blood_type, cost_per_unit, quantity, bank_id) VALUES (6, 'A-', 12, 15, 3);
INSERT INTO eraktkendra.blood_record (blood_record_id, blood_type, cost_per_unit, quantity, bank_id) VALUES (7, 'B+', 13, 15, 1);
INSERT INTO eraktkendra.blood_record (blood_record_id, blood_type, cost_per_unit, quantity, bank_id) VALUES (8, 'B-', 11, 15, 1);
INSERT INTO eraktkendra.blood_record (blood_record_id, blood_type, cost_per_unit, quantity, bank_id) VALUES (9, 'B+', 13, 15, 2);
INSERT INTO eraktkendra.blood_record (blood_record_id, blood_type, cost_per_unit, quantity, bank_id) VALUES (10, 'B-', 14, 15, 2);

INSERT INTO eraktkendra.field_worker (worker_id, address, city, dob, email_id, first_name, gender, last_name, password, phone_number, pincode, title, blood_bank_id) VALUES (1, 'Bhopal', 'Bhopal', '2023-05-08', 'av@gmail.com', 'Aman', 'Male', 'Verma', '123', '8754985623', 875421, 'Mr.', 1);

INSERT INTO eraktkendra.blood_donation_record (donation_record_id, blood_bank_id, blood_type, date_of_donation, user_id) VALUES (1, 2, 'A+', '2023-05-08', 1);
INSERT INTO eraktkendra.blood_donation_record (donation_record_id, blood_bank_id, blood_type, date_of_donation, user_id) VALUES (2, 2, 'A+', '2023-05-08', 1);

INSERT INTO eraktkendra.user (user_id, address, blood_type, city, credit, dob, email_id, first_name, gender, last_name, password, phone_number, pincode, title) VALUES (1, 'Bangalore', 'A+', 'Bhopal', 0, '2023-05-08', 'vb@gmail.com', 'Vikrnath', 'Male', 'Bari', '123', '7020744562', 560100, 'Mr.');
INSERT INTO eraktkendra.user (user_id, address, blood_type, city, credit, dob, email_id, first_name, gender, last_name, password, phone_number, pincode, title) VALUES (2, 'Bhopal', 'A-', 'Bhopal', 0, '2023-05-08', 'as@gmail.com', 'Akanksha', 'Female', 'Shukla', '123', '7800598666', 425311, 'Mrs.');

