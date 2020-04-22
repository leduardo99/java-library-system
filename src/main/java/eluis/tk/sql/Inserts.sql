-- Author Inserts --
INSERT INTO "Author" VALUES (5698, 'Alexander', 'Christopher');
INSERT INTO "Author" VALUES (6299, 'Brooks', 'Frederick P.');
INSERT INTO "Author" VALUES (7927, 'Cormen', 'Thomas H.');
INSERT INTO "Author" VALUES (8549, 'Date', 'C. J.');
INSERT INTO "Author" VALUES (8527, 'Darwen', 'Hugh');
INSERT INTO "Author" VALUES (0938, 'Feiner', 'Steven K.');
INSERT INTO "Author" VALUES (0658, 'Flanagan', 'David');
INSERT INTO "Author" VALUES (0969, 'Foley', 'James D.');
INSERT INTO "Author" VALUES (1577, 'Gamma', 'Erich');
INSERT INTO "Author" VALUES (1520, 'Garfinkel', 'Simson');
INSERT INTO "Author" VALUES (2938, 'Hein', 'Trent R.');
INSERT INTO "Author" VALUES (2967, 'Helm', 'Richard');
INSERT INTO "Author" VALUES (2907, 'Hopcroft', 'John E.');
INSERT INTO "Author" VALUES (2512, 'Hughes', 'John F.');
INSERT INTO "Author" VALUES (3323, 'Ishikawa', 'Sara');
INSERT INTO "Author" VALUES (4928, 'Johnson', 'Ralph');
INSERT INTO "Author" VALUES (5528, 'Kahn', 'David');
INSERT INTO "Author" VALUES (5928, 'Kernighan', 'Brian');
INSERT INTO "Author" VALUES (5388, 'Kidder', 'Tracy');
INSERT INTO "Author" VALUES (5854, 'Knuth', 'Donald E.');
INSERT INTO "Author" VALUES (6933, 'Leiserson', 'Charles E.');
INSERT INTO "Author" VALUES (7947, 'Motwani', 'Rajeev');
INSERT INTO "Author" VALUES (8979, 'Nemeth', 'Evi');
INSERT INTO "Author" VALUES (2597, 'Raymond', 'Eric');
INSERT INTO "Author" VALUES (2347, 'Ritchie', 'Dennis');
INSERT INTO "Author" VALUES (2369, 'Rivest', 'Ronald R.');
INSERT INTO "Author" VALUES (3728, 'Schneier', 'Bruce');
INSERT INTO "Author" VALUES (3996, 'Seebass', 'Scott');
INSERT INTO "Author" VALUES (3366, 'Silverstein', 'Murray');
INSERT INTO "Author" VALUES (3898, 'Snyder', 'Garth');
INSERT INTO "Author" VALUES (3493, 'Stein', 'Clifford E.');
INSERT INTO "Author" VALUES (3496, 'Stoll', 'Clifford');
INSERT INTO "Author" VALUES (3425, 'Strassmann', 'Steven');
INSERT INTO "Author" VALUES (3429, 'Stroustrup', 'Bjarne');
INSERT INTO "Author" VALUES (5667, 'Ullman', 'Jeffrey D.');
INSERT INTO "Author" VALUES (6588, 'van Dam', 'Andries');
INSERT INTO "Author" VALUES (6633, 'Vlissides', 'John');
INSERT INTO "Author" VALUES (7933, 'Weise', 'Daniel');
-- Author Inserts --

-- Publishers Inserts --
INSERT INTO "Publishers" VALUES (0201, 'Addison-Wesley', 'www.aw-bc.com');
INSERT INTO "Publishers" VALUES (0471, 'John Wiley & Sons', 'www.wiley.com');
INSERT INTO "Publishers" VALUES (0262, 'MIT Press', 'mitpress.mit.edu');
INSERT INTO "Publishers" VALUES (0596, 'O''Reilly', 'www.ora.com');
INSERT INTO "Publishers" VALUES (019, 'Oxford University Press', 'www.oup.co.uk');
INSERT INTO "Publishers" VALUES (013, 'Prentice Hall', 'www.phptr.com');
INSERT INTO "Publishers" VALUES (0679, 'Random House', 'www.randomhouse.com');
INSERT INTO "Publishers" VALUES (07434, 'Simon & Schuster', 'www.simonsays.com');
-- Publishers Inserts --

-- Books Inserts --
INSERT INTO "Books"  VALUES (0201964260, 'A Guide to the SQL Standard', '0-201-96426-0', '0201', 47.95);
INSERT INTO "Books"  VALUES (0195019199, 'A Pattern Language: Towns, Buildings, Construction', '0-19-501919-9', '019', 65.00);
INSERT INTO "Books"  VALUES (0471117099, 'Applied Cryptography', '0-471-11709-9', '0471', 60.00);
INSERT INTO "Books"  VALUES (0201848406, 'Computer Graphics: Principles and Practice', '0-201-84840-6', '0201', 79.99);
INSERT INTO "Books"  VALUES (0743411463, 'Cuckoo''s Egg', '0-7434-1146-3', '07434', 13.95);
INSERT INTO "Books"  VALUES (0201633612, 'Design Patterns', '0-201-63361-2', '0201', 54.99);
INSERT INTO "Books"  VALUES (0262032937, 'Introduction to Algorithms', '0-262-03293-7', '0262', 80.00);
INSERT INTO "Books"  VALUES (0201441241, 'Introduction to Automata Theory, Languages, and Computation', '0-201-44124-1', '0201', 105.00);
INSERT INTO "Books"  VALUES (0596000480, 'JavaScript: The Definitive Guide', '0-596-00048-0', '0596', 44.95);
INSERT INTO "Books"  VALUES (0201896834, 'The Art of Computer Programming vol. 1', '0-201-89683-4', '0201', 59.99);
INSERT INTO "Books"  VALUES (0201896842, 'The Art of Computer Programming vol. 2', '0-201-89684-2', '0201', 59.99);
INSERT INTO "Books"  VALUES (0201896850, 'The Art of Computer Programming vol. 3', '0-201-89685-0', '0201', 59.99);
INSERT INTO "Books"  VALUES (0131103628, 'The C Programming Language', '0-13-110362-8', '013', 42.00);
INSERT INTO "Books"  VALUES (0201700735, 'The C++ Programming Language', '0-201-70073-5', '0201', 64.99);
INSERT INTO "Books"  VALUES (0596001088, 'The Cathedral and the Bazaar', '0-596-00108-8', '0596', 16.95);
INSERT INTO "Books"  VALUES (0684831309, 'The Codebreakers', '0-684-83130-9', '07434', 70.00);
INSERT INTO "Books"  VALUES (0201835959, 'The Mythical Man-Month', '0-201-83595-9', '0201', 29.95);
INSERT INTO "Books"  VALUES (0679602615, 'The Soul of a New Machine', '0-679-60261-5', '0679', 18.95);
INSERT INTO "Books"  VALUES (1568842031, 'The UNIX Hater''s Handbook', '1-56884-203-1', '0471', 16.95);
INSERT INTO "Books"  VALUES (0130206016, 'UNIX System Administration Handbook', '0-13-020601-6', '013', 68.00);
-- Books Inserts --

-- Books Authors Inserts --
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201964260, 8549, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201964260, 8527, 2);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0195019199, 5698, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0195019199, 3323, 2);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0195019199, 3366, 3);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0471117099, 3728, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201848406, 0969, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201848406, 6588, 2);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201848406, 0938, 3);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201848406, 2512, 4);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0743411463, 3496, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201633612, 1577, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201633612, 2967, 2);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201633612, 4928, 3);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201633612, 6633, 4);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0262032937, 7927, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0262032937, 6933, 2);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0262032937, 2369, 3);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0262032937, 3493, 4);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201441241, 2907, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201441241, 5667, 2);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201441241, 7947, 3);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0596000480, 0658, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201896834, 5854, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201896842, 5854, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201896850, 5854, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0131103628, 5928, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0131103628, 2347, 2);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201700735, 3429, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0596001088, 2597, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0684831309, 5528, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0201835959, 6299, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0679602615, 5388, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (1568842031, 1520, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (1568842031, 7933, 2);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (1568842031, 3425, 3);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0130206016, 8979, 1);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0130206016, 3898, 2);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0130206016, 3996, 3);
INSERT INTO "BooksAuthors" ("BookId", "AuthorId", "SeqNo") VALUES (0130206016, 2938, 4);
-- Books Authors Inserts --