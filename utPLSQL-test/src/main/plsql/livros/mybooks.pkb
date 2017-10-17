CREATE OR REPLACE PACKAGE BODY mybooks_pkg AS

FUNCTION sel_book_func(bookid NUMBER) RETURN mybooks_rec IS
  rc mybooks_rec;
BEGIN
    OPEN rc FOR SELECT * FROM mybooks WHERE book_id = bookid;
    RETURN(rc);
END;

FUNCTION  sel_booknm(bookid NUMBER) RETURN VARCHAR2 IS
  booknm  VARCHAR2(30);
BEGIN
  SELECT book_nm INTO booknm FROM mybooks WHERE book_id = bookid;
  RETURN(booknm);
END;

PROCEDURE ins(bookid NUMBER, booknm VARCHAR2,publishdt DATE) IS
BEGIN
   INSERT INTO mybooks VALUES (bookid,booknm,publishdt);
   COMMIT;
END;

PROCEDURE upd(bookid NUMBER, booknm VARCHAR2,publishdt DATE) IS
BEGIN
   UPDATE mybooks SET book_nm=booknm, publish_dt=publishdt WHERE book_id = bookid;
   COMMIT;
END;

PROCEDURE del(bookid NUMBER) IS
BEGIN
   DELETE FROM mybooks WHERE book_id = bookid;
   COMMIT;
END;

PROCEDURE sel_book_proc(bookid NUMBER, rc OUT mybooks_rec) IS
BEGIN
    OPEN rc FOR SELECT * FROM mybooks WHERE book_id = bookid;
END;

END mybooks_pkg;
/
