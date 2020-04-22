create table if not exists "Author"
(
	"Id" serial not null
		constraint author_pk
			primary key,
	"Name" varchar not null,
	"FName" varchar
);

alter table "Author" owner to postgres;

create table if not exists "Publishers"
(
	"Id" serial not null
		constraint publishers_pk
			primary key,
	"Name" varchar not null,
	"Url" varchar
);

alter table "Publishers" owner to postgres;

create table if not exists "Books"
(
	"Id" serial not null
		constraint books_pk
			primary key,
	"Title" varchar not null,
	"Ibsn" varchar not null,
	"PublisherId" integer
		constraint books_publishers_id_fk
			references "Publishers"
				on delete cascade,
	"Price" double precision not null
);

alter table "Books" owner to postgres;

create unique index if not exists books_ibsn_uindex
	on "Books" ("Ibsn");

create table if not exists "BooksAuthors"
(
	"Id" serial not null
		constraint booksauthors_pk
			primary key,
	"BookId" integer not null
		constraint booksauthors_books_id_fk
			references "Books"
				on delete cascade,
	"AuthorId" integer not null
		constraint booksauthors_author_id_fk
			references "Author"
				on delete cascade,
	"SeqNo" integer
);

alter table "BooksAuthors" owner to postgres;

