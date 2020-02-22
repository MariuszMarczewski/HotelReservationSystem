INSERT INTO easement (id, name, price_pln) VALUES (nextval('easement_seq'), 'parking_lot', 50);
INSERT INTO easement (id, name, price_pln) VALUES (nextval('easement_seq'), 'breakfast', 60);
INSERT INTO easement (id, name, price_pln) VALUES (nextval('easement_seq'), 'washing', 30);
INSERT INTO easement (id, name, price_pln) VALUES (nextval('easement_seq'), 'spa', 100);
INSERT INTO easement (id, name, price_pln) VALUES (nextval('easement_seq'), 'ironing', 25);

INSERT INTO room (id, room_type, price) VALUES (nextval('room_seq'), 2, 250);
INSERT INTO room (id, room_type, price) VALUES (nextval('room_seq'), 2, 250);
INSERT INTO room (id, room_type, price) VALUES (nextval('room_seq'), 2, 250);
INSERT INTO room (id, room_type, price) VALUES (nextval('room_seq'), 3, 320);
INSERT INTO room (id, room_type, price) VALUES (nextval('room_seq'), 3, 320);
INSERT INTO room (id, room_type, price) VALUES (nextval('room_seq'), 3, 320);
INSERT INTO room (id, room_type, price) VALUES (nextval('room_seq'), 1, 180);
INSERT INTO room (id, room_type, price) VALUES (nextval('room_seq'), 1, 180);
INSERT INTO room (id, room_type, price) VALUES (nextval('room_seq'), 1, 180);

INSERT INTO guest (id, first_name, second_name, address, birth_date, phone_number) VALUES (nextval('guest_seq'), 'guest1', 'welcomed1', 'Warsaw', '1979-01-01', '666');
INSERT INTO guest (id, first_name, second_name, address, birth_date, phone_number) VALUES (nextval('guest_seq'), 'guest2', 'welcomed2', 'Cracow', '1983-01-01', '777');
INSERT INTO guest (id, first_name, second_name, address, birth_date, phone_number) VALUES (nextval('guest_seq'), 'guest3', 'welcomed3', 'Gdansk', '1988-01-01', '888');
INSERT INTO guest (id, first_name, second_name, address, birth_date, phone_number) VALUES (nextval('guest_seq'), 'guest4', 'welcomed4', 'Radom', '1986-01-01', '999');

INSERT INTO reservation (id, checkin_date, checkout_date, guest_id, room_id) VALUES (nextval('reservation_seq'), '2020-01-01', '2020-01-02', 1L, 1L);
INSERT INTO reservation (id, checkin_date, checkout_date, guest_id, room_id) VALUES (nextval('reservation_seq'), '2020-01-11', '2020-01-14', 2L, 5L);
INSERT INTO reservation (id, checkin_date, checkout_date, guest_id, room_id) VALUES (nextval('reservation_seq'), '2020-01-11', '2020-01-14', 3L, 5L);
INSERT INTO reservation (id, checkin_date, checkout_date, guest_id, room_id) VALUES (nextval('reservation_seq'), '2020-01-11', '2020-01-14', 4L, 5L);

insert into reservation_easements (reservation_id, easements_id) values (1L, 1L);
insert into reservation_easements (reservation_id, easements_id) values (1L, 2L);
insert into reservation_easements (reservation_id, easements_id) values (1L, 3L);
insert into reservation_easements (reservation_id, easements_id) values (2L, 2L);
insert into reservation_easements (reservation_id, easements_id) values (2L, 3L);
insert into reservation_easements (reservation_id, easements_id) values (2L, 4L);
insert into reservation_easements (reservation_id, easements_id) values (3L, 3L);
insert into reservation_easements (reservation_id, easements_id) values (3L, 4L);
insert into reservation_easements (reservation_id, easements_id) values (3L, 5L);

commit;

