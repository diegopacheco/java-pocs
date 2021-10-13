create sequence book_schema.book_seq start with 1 increment by 50
create table book_schema.book (id varchar(255) not null, author varchar(255), title varchar(255), primary key (id))
