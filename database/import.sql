INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tallinn');
INSERT INTO public.city (id, name) VALUES (DEFAULT, 'Tartu');

INSERT INTO public.role (id, role_name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, role_name) VALUES (DEFAULT, 'driver');

INSERT INTO public."user" (id, role_id, username, password, status) VALUES (DEFAULT, 1, 'Admin1', '123', 'A');
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (DEFAULT, 1, 'Admin2', '123', 'A');
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (DEFAULT, 2, 'Juht1', '123', 'A');
INSERT INTO public."user" (id, role_id, username, password, status) VALUES (DEFAULT, 2, 'Juht2', '123', 'A');

INSERT INTO public.insurance (id, provider, phone_number) VALUES (DEFAULT, 'IisiMiisi', '12345');
INSERT INTO public.insurance (id, provider, phone_number) VALUES (DEFAULT, 'LiisiBriisi', '54321');

INSERT INTO public.van (id, model, plate_number, insurance_id, city_id, next_inspection, status) VALUES (DEFAULT, 'Renault Master', '123ABC', 1, 1, '2024-05-18', 'A');
INSERT INTO public.van (id, model, plate_number, insurance_id, city_id, next_inspection, status) VALUES (DEFAULT, 'Renault Master', '321BCA', 2, 2, '2024-05-18', 'A');
INSERT INTO public.van (id, model, plate_number, insurance_id, city_id, next_inspection, status) VALUES (DEFAULT, 'Citroen Jumper', '456XYZ', 1, 1, '2023-12-24', 'A');
INSERT INTO public.van (id, model, plate_number, insurance_id, city_id, next_inspection, status) VALUES (DEFAULT, 'Citroen Jumper', '654ZXY', 2, 2, '2023-12-24', 'A');

INSERT INTO public.driver (id, user_id, city_id, name, license, phone_number, status, van_id) VALUES (DEFAULT, 3, 1, 'Mati Une', 'ET123456', '56789012', 'A', 1);
INSERT INTO public.driver (id, user_id, city_id, name, license, phone_number, status, van_id) VALUES (DEFAULT, 4, 2, 'Anti Tiib', 'ET654321', '56123456', 'A', 2);

INSERT INTO public.mileage (id, van_id, date, km) VALUES (DEFAULT, 1, '2023-05-15', 50);
INSERT INTO public.mileage (id, van_id, date, km) VALUES (DEFAULT, 1, '2023-05-16', 100);
INSERT INTO public.mileage (id, van_id, date, km) VALUES (DEFAULT, 1, '2023-05-17', 150);
INSERT INTO public.mileage (id, van_id, date, km) VALUES (DEFAULT, 1, '2023-05-18', 200);
INSERT INTO public.mileage (id, van_id, date, km) VALUES (DEFAULT, 2, '2023-05-15', 100);
INSERT INTO public.mileage (id, van_id, date, km) VALUES (DEFAULT, 2, '2023-05-16', 200);
INSERT INTO public.mileage (id, van_id, date, km) VALUES (DEFAULT, 2, '2023-05-17', 300);
INSERT INTO public.mileage (id, van_id, date, km) VALUES (DEFAULT, 2, '2023-05-18', 400);

INSERT INTO public.maintenance (id, van_id, description, total_mileage, date, attachment, status) VALUES (DEFAULT, 1, 'TÜV', 12345, '2023-05-18', null, 'A');
INSERT INTO public.maintenance (id, van_id, description, total_mileage, date, attachment, status) VALUES (DEFAULT, 3, 'Õlivahetus + filtrid', 54321, '2023-01-17', null, 'A');

INSERT INTO public.message (id, text, receiver_user_id, sender_user_id, date_time, status) VALUES (DEFAULT, 'Test1', 3, 1, '2023-05-18 11:28:42.000000', 'R');
INSERT INTO public.message (id, text, receiver_user_id, sender_user_id, date_time, status) VALUES (DEFAULT, 'Test2', 1, 3, '2023-05-18 11:45:50.000000', 'S');