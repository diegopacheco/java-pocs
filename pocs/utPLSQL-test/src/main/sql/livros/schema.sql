DROP TABLE mybooks;

CREATE TABLE mybooks (
  book_id 	NUMBER,
  book_nm	VARCHAR2(30),
  publish_dt    DATE
);

ALTER TABLE mybooks ADD CONSTRAINT mybooks_pk PRIMARY KEY (book_id);
