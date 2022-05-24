insert into Course (id, label, ects) values ('WEBG6', 'Developpement Web III', 5),
                                            ('MOBG6', 'Developpement mobile', 4),
                                            ('TEX6', 'Expression et Communication', 2);

insert into Student (matricule, name, genre, section) values (1, 'Léopold Mols', 0, 0),
                                                    (2, 'Olivier Dyck', 0, 0),
                                                   (3, 'Korray Kuthlu', 0, 0),
                                                   (4, 'Bruce Wayne', 0, 1),
                                                    (5, 'Selina Kyle', 1, 2); 

ALTER SEQUENCE my_seq restart 100;

insert into COURSE_STUDENTS(registered_courses_id, students_matricule) values ('WEBG6', 1);
insert into COURSE_STUDENTS(registered_courses_id, students_matricule) values ('MOBG6', 1);
insert into COURSE_STUDENTS(registered_courses_id, students_matricule) values ('TEX6', 1);

insert into COURSE_STUDENTS(registered_courses_id, students_matricule) values ('MOBG6', 2);
insert into COURSE_STUDENTS(registered_courses_id, students_matricule) values ('WEBG6', 2);
insert into COURSE_STUDENTS(registered_courses_id, students_matricule) values ('TEX6', 2);

insert into COURSE_STUDENTS(registered_courses_id, students_matricule) values ('MOBG6', 3);

insert into COURSE_STUDENTS(registered_courses_id, students_matricule) values ('WEBG6', 4); 


insert into User (username, password, enabled) values ('52006', '{noop}52006', true);
insert into Authority (id, username, authority) values (2, '52006', 'STUDENT');

