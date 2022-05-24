INSERT INTO Student(number, name) VALUES (52006, 'Dyck Olivier'),
                                         (53048, 'Lamonica Giuliano');

INSERT INTO Task(id, description) VALUES (1, 'Acheter du lait'),
                                         (2, 'Terminer le projet mobile'),
                                         (3, 'Terminer de travailler web');


INSERT INTO STUDENT_TASKS(STUDENTS_NUMBER, TASKS_ID) VALUES (52006, 1),
                                                            (53048, 2),
                                                            (53048, 3);

ALTER SEQUENCE my_seq RESTART WITH 100;

INSERT INTO USER(username, password, enabled) VALUES ('52006', '{noop}52006', true);
INSERT INTO AUTHORITY(id, username, authority) VALUES (2, '52006', 'STUDENT');

INSERT INTO User(username, password, enabled) VALUES ('JLC', '{noop}jlc', true);
INSERT INTO Authority (id, username, authority) VALUES (3, 'JLC', 'PROF');

