insert into books (title, author, isbn, published_year) values ('The Pragmatic Programmer', 'Andrew Hunt', '9780201616224', 1999) on conflict (isbn) do nothing;
insert into books (title, author, isbn, published_year) values ('Clean Code', 'Robert C. Martin', '9780132350884', 2008) on conflict (isbn) do nothing;
insert into books (title, author, isbn, published_year) values ('Effective Java', 'Joshua Bloch', '9780134685991', 2018) on conflict (isbn) do nothing;
insert into books (title, author, isbn, published_year) values ('Refactoring', 'Martin Fowler', '9780134757599', 2018) on conflict (isbn) do nothing;
insert into books (title, author, isbn, published_year) values ('Designing Data-Intensive Applications', 'Martin Kleppmann', '9781449373320', 2017) on conflict (isbn) do nothing;
insert into books (title, author, isbn, published_year) values ('Domain-Driven Design', 'Eric Evans', '9780321125217', 2003) on conflict (isbn) do nothing;
insert into books (title, author, isbn, published_year) values ('Spring in Action', 'Craig Walls', '9781617294945', 2018) on conflict (isbn) do nothing;
insert into books (title, author, isbn, published_year) values ('Java Concurrency in Practice', 'Brian Goetz', '9780321349606', 2006) on conflict (isbn) do nothing;
insert into books (title, author, isbn, published_year) values ('Working Effectively with Legacy Code', 'Michael Feathers', '9780131177055', 2004) on conflict (isbn) do nothing;
insert into books (title, author, isbn, published_year) values ('Release It!', 'Michael T. Nygard', '9781680502398', 2018) on conflict (isbn) do nothing;

