insert into User (login, name) values ('52006', 'Dyck Olivier');


INSERT INTO Repository(id, name, USER_LOGIN) VALUES (1, 'WEBG6-Exercice-Examen', '52006'),
                                                (2, 'MOBG6-RottenApples', '52006');

INSERT INTO CommitE(id, date, message, REPOSITORY_ID) VALUES (1, '2022-05-15','First Exam', 1 ),
                                                            (2, '2022-05-16', 'Second Exam', 1),
                                                            (5, '2021-05-17', 'Third Exam', 1),
                                                            (3, '2022-05-06', 'First iteration', 2),
                                                           (4, '2022-05-07', 'Second Iteration', 2);

ALTER SEQUENCE my_seq restart 100;                                           

ALTER SEQUENCE my_seq2 restart 100;