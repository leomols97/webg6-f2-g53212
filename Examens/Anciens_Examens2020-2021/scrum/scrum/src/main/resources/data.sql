INSERT INTO Project (name, active) VALUES ('Othello', false);
INSERT INTO Project (name, active) VALUES ('Stratego', true);
INSERT INTO Project (name, active) VALUES ('EsiProgramme', true);

INSERT INTO Sprint (id, number, days, project_name) VALUES (1,1, 10,'Othello');
INSERT INTO Sprint (id, number, days, project_name) VALUES (2,2, 7,'Othello');
INSERT INTO Sprint (id, number, days, project_name) VALUES (3,3, 10,'Othello');
INSERT INTO Sprint (id, number, days, project_name) VALUES (4,1, 15,'Stratego');
INSERT INTO Sprint (id, number, days, project_name) VALUES (5,2, 15,'Stratego');
INSERT INTO Sprint (id, number, days, project_name) VALUES (6,1, 10,'EsiProgramme');
INSERT INTO Sprint (id, number, days, project_name) VALUES (7,2, 7,'EsiProgramme');
INSERT INTO Sprint (id, number, days, project_name) VALUES (8,3, 9,'EsiProgramme');
INSERT INTO Sprint (id, number, days, project_name) VALUES (9,4, 10,'EsiProgramme');

ALTER SEQUENCE sprint_seq restart with 100;

INSERT INTO Story (id, title, estimate, sprint_id) VALUES (1,'Plateau de jeu', 5, 1);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (2,'Algorithme de victoire', 3, 1);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (3,'Tests unitaires', 3, 1);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (4,'Inscription des joueurs', 6, 2);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (5,'Création IA', 7, 3);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (6,'Mise à jour de la vue', 5, 3);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (7,'Ajout des pièces', 3, 4);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (8,'Déplacements des pièces', 9, 4);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (9,'Aide utilisateurs', 12, 4);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (10,'Validation des coups', 5, 4);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (11,'Enregistrement des parties', 10, 5);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (12,'Reprendre une partie', 8, 5);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (13,'Pièces bonus', 7, 5);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (14,'Consultation étudiant', 8, 6);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (15,'Consultation programme', 7, 6);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (16,'Encodage des données', 5, 7);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (17,'Authentification', 4, 8);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (18,'Internationalisation', 5, 8);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (19,'Tests acceptances', 6, 8);
INSERT INTO Story (id, title, estimate, sprint_id) VALUES (20,'Mises à jours programmes', 5, 9);

ALTER SEQUENCE story_seq restart with 100;