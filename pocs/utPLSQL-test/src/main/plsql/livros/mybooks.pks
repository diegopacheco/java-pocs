CREATE OR REPLACE PACKAGE mybooks_pkg AS

TYPE mybooks_rec IS REF CURSOR RETURN mybooks%ROWTYPE;

FUNCTION sel_book_func(bookid NUMBER) RETURN mybooks_rec;
PROCEDURE sel_book_proc(bookid NUMBER, rc OUT mybooks_rec);
FUNCTION  sel_booknm(bookid NUMBER) RETURN VARCHAR2;
PROCEDURE ins(bookid NUMBER, booknm VARCHAR2,publishdt DATE);
PROCEDURE upd(bookid NUMBER, booknm VARCHAR2,publishdt DATE);
PROCEDURE del(bookid NUMBER);

END;