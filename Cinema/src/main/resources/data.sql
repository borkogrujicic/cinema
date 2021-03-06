INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, datum, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic', '2020-06-21','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, datum, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic', '2020-06-21', 'KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, datum, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic', '2020-06-21', 'KORISNIK');


INSERT INTO tip (`id`, `naziv`) VALUES (1, '2D');
INSERT INTO tip (`id`, `naziv`) VALUES (2, '3D');
INSERT INTO tip (`id`, `naziv`) VALUES (3, '4D');

INSERT INTO sala (`id`, `naziv`) VALUES (1, 'Sala 1');
INSERT INTO sala (`id`, `naziv`) VALUES (2, 'Sala 2');
INSERT INTO sala (`id`, `naziv`) VALUES (3, 'Sala 3');

INSERT INTO sediste (`id`,  `sala_id`) VALUES (1, 1);
INSERT INTO sediste (`id`,  `sala_id`) VALUES (2, 1);
INSERT INTO sediste (`id`, `sala_id`) VALUES (3, 1);
INSERT INTO sediste (`id`,  `sala_id`) VALUES (4, 2);
INSERT INTO sediste (`id`,  `sala_id`) VALUES (5, 2);
INSERT INTO sediste (`id`,  `sala_id`) VALUES (6, 2);
INSERT INTO sediste (`id`,  `sala_id`) VALUES (7, 3);
INSERT INTO sediste (`id`,  `sala_id`) VALUES (8, 3);
INSERT INTO sediste (`id`, `sala_id`) VALUES (9, 3);
INSERT INTO sediste (`id`, `sala_id`) VALUES (10, 3);

INSERT INTO sala_tip (`sala_id`, `tip_id`) VALUES (1, 1);
INSERT INTO sala_tip (`sala_id`, `tip_id`) VALUES (1, 2);
INSERT INTO sala_tip (`sala_id`, `tip_id`) VALUES (2, 2);
INSERT INTO sala_tip (`sala_id`, `tip_id`) VALUES (3, 3);

INSERT INTO film (`id`, `distributer`, `glumci`, `godina_proizvodnje`, `naziv`, `opis`, `reziser`, `trajanje`, `zanrovi`, `zemlja_porekla`, deleted) VALUES (1, 'Universal', 'Brad Pitt, Leonardo Di Caprio', '2019', 'Once Upon a Time in Hollywood', 'Film', 'Quentin Tarantino', 120, 'Drama', 'USA', 0);
INSERT INTO film (`id`, `distributer`, `glumci`, `godina_proizvodnje`, `naziv`, `opis`, `reziser`, `trajanje`, `zanrovi`, `zemlja_porekla`, deleted) VALUES (2, 'Universal', 'Jamie Foxx', '2012', 'Django', 'Film', 'Quentin Tarantino', 120, 'Vestern', 'USA', 0);

INSERT INTO projekcija (`id`, `cena`, `datum_vreme`, `film_id`, `sala_id`, `tip_id`, deleted) VALUES (1, '250', '2022-06-21 20:00', 1, 1, 1, 0);
INSERT INTO projekcija (`id`, `cena`, `datum_vreme`, `film_id`, `sala_id`, `tip_id`, deleted) VALUES (2, '350', '2022-06-21 22:00', 2, 1, 2, 0);
INSERT INTO projekcija (`id`, `cena`, `datum_vreme`, `film_id`, `sala_id`, `tip_id`, deleted) VALUES (3, '350', '2022-06-22 22:00', 2, 2, 2, 0);

INSERT INTO karta (`id`, `datum`, `projekcija_id`) VALUES (1, '2020-06-20 20:00', 1);




