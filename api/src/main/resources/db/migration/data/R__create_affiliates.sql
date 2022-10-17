DELETE FROM affiliate;
DELETE FROM address;

INSERT INTO affiliate (id, code, national_number, first_name, last_name, email, phone_number, gender, birthdate) VALUES ('26757f72-45d1-4b81-a257-97d7febe73f0', '462535' ,'910717-385-95', 'Jérôme', 'De Puyt', 'depuytjerome@gmail.com', '+32485778854', 'MALE', '1991-07-17');
INSERT INTO address (id, street, street_number, city, postal_code, move_in_date, is_main, affiliate_id) VALUES ('e46e60e1-6b29-4212-b254-0f4a5a7e0f24', 'rue de Stimbert', '66', 'Tubize', '1480', '1991-07-17', true, '26757f72-45d1-4b81-a257-97d7febe73f0');
INSERT INTO address (id, street, street_number, city, postal_code, move_in_date, is_main, affiliate_id) VALUES ('123d4b4a-1ad0-4937-9a91-e3ab00041ade', 'Gajeong-ro', '15', 'Incheon', '1200', '2017-01-21', false, '26757f72-45d1-4b81-a257-97d7febe73f0');

INSERT INTO affiliate (id, code, national_number, first_name, last_name, email, phone_number, gender, birthdate) VALUES ('82a454db-6b37-4f26-89a2-65e7c4d5198c', '462536' ,'950717-896.32', 'Emilie', 'De Puyt', 'depuytjerome@gmail.com', '+32485778854', 'FEMALE', '1995-07-10');
INSERT INTO address (id, street, street_number, city, postal_code, move_in_date, is_main, affiliate_id) VALUES ('86edb41b-b339-46a7-8d8c-c765b40f91cd', 'rue de Stimbert', '33', 'Tubize', '1480', '2000-01-01', true, '82a454db-6b37-4f26-89a2-65e7c4d5198c');