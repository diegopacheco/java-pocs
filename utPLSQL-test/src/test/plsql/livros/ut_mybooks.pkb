CREATE OR REPLACE PACKAGE BODY ut_mybooks_pkg
IS -- package body

-- Here is my test record.

   bookid      INTEGER       := 100;
   booknm      VARCHAR2 (30) := 'American History-Vol1';
   publishdt   DATE          := to_date('05-01-2002', 'dd-mm-yyyy');

/*  --------------------------------------------------
     UT_SETUP : setup the test data here. This is first
                procedure gets executed automatically
----------------------------------------------------- */
   PROCEDURE ut_setup
   IS
   BEGIN
      ut_teardown; -- drop the temp tables even though it should be there. Just extract caution

      -- "mybooks_part" table contains test record which we are going to test.
      -- I am using 8i syntax. Change needed for 8.0 databases
      EXECUTE IMMEDIATE 'create table mybooks_part as select * from mybooks where rownum < 1';
      EXECUTE IMMEDIATE 'insert into mybooks_part values (:bookid,:booknm,:publishdt)'
         USING bookid, booknm, publishdt;
   END;

/*  --------------------------------------------------
     UT_TEARDOWN : clean you data here. This is the last
                procedure gets executed automatically
----------------------------------------------------- */
   PROCEDURE ut_teardown
   IS
   BEGIN
      EXECUTE IMMEDIATE 'drop table mybooks_part'; -- Drop the temporary test table after the test

      DELETE FROM mybooks
            WHERE book_id = bookid; --Delete the test record after the test
   EXCEPTION
      WHEN OTHERS
      THEN
         NULL; -- Ignore if any errors. 
   END;

/*  ---------------------------------------------------------------------
                      FUNCTION mybooks_pkg.sel_book_func(
                           bookid IN NUMBER,
                      RETURN REFCURSOR

    Assertion methods used : EQ_REFC_TABLE, EQ_REFC_QUERY
/*  -------------------------------------------------------------------- */
   PROCEDURE ut_2_sel_book_func
   IS 
      proc_params   utplsql_util.utplsql_params;
   BEGIN
      -- Register the parameters
      -- IMPORTANT: The position starts with 0 for functions. For procedures it starts with 1
      utplsql_util.reg_out_param (0, 'REFCURSOR', proc_params);
      utplsql_util.reg_in_param (1, 100, proc_params);
      -- Test the sel_book_func function. It compares the refcursor with mybooks_part table.
      -- Here we expect the refcursor should return the records for the bookid=1. mybooks_part table
      -- has bookid=1 record in it which we setup in the ut_setup procedure.
      -- If rows matched then it results in SUCCESS otherwise FAILURE.
      -- If SUCCESS then sel_book_func fuction behaves as we expected.

      utassert.eq_refc_table (
         'sel_book_func-1',
         'mybooks_pkg.sel_book_func',
         proc_params,
         0,
         'mybooks_part'
      );
      -- Other ways to test this
      utassert.eq_refc_query (
         'sel_book_func-2',
         'mybooks_pkg.sel_book_func',
         proc_params,
         0,
         'select  * from mybooks_part'
      );
   END;

/*  ---------------------------------------------------------------------
                 PROCEDURE mybooks_pkg.sel_book_proc(
                           bookid       IN NUMBER,
                           mybooks_rec  OUT REFCURSOR)

    Assertion methods used : EQ_REFC_TABLE, EQ_REFC_QUERY
/*  -------------------------------------------------------------------- */
   PROCEDURE ut_3_sel_book_proc
   IS 
      proc_params   utplsql_util.utplsql_params;
   BEGIN
      -- This procedure I used this because I want to show how to handle the refcursor as OUT parameter
      -- Register the parameters
      -- IMPORTANT: The position starts with 0 for functions. For procedures it starts with 1
      utplsql_util.reg_in_param (1, 100, proc_params);
      utplsql_util.reg_out_param (2, 'REFCURSOR', proc_params);
      utassert.eq_refc_table (
         'sel_book_proc-1',
         'mybooks_pkg.sel_book_proc',
         proc_params,
         2,
         'mybooks_part'
      );
      -- Other ways to test this
      utassert.eq_refc_query (
         'sel_book_proc-2',
         'mybooks_pkg.sel_book_proc',
         proc_params,
         2,
         'select * from mybooks_part'
      );
   END;

/*  --------------------------------------------------
     EQ           : FUNCTION sel_booknm (
                      bookid IN NUMBER,
                    ) RETRUN VARCHAR2

    Assertion methods used : EQ
----------------------------------------------------- */
   PROCEDURE ut_4_sel_booknm
   IS
   BEGIN
      -- We expect "American History-Vol1 " from the sel_booknm(100) function.   
      utassert.eq ('sel_booknm-1', booknm, mybooks_pkg.sel_booknm (bookid)); -- Success
   END;

/*  --------------------------------------------------
                 PROCEDURE ins (
                      bookid IN NUMBER,
                      booknm IN VARCHAR2,
                      publishdt DATE
                 )

    Assertion methods used : EQ , EQTABCOUNT, EQQUERYVALUE, EQQUERY, THROWS
----------------------------------------------------- */
   PROCEDURE ut_1_ins
   IS
   BEGIN
      -- Call the INS function.
      mybooks_pkg.ins (bookid, booknm, publishdt);
      -- Check if the row inserted successfully
      utassert.eq ('ins-1-4', booknm, mybooks_pkg.sel_booknm (bookid));
      --Other ways to check row inserted successfully and many more ways
      utassert.eqqueryvalue (
         'ins-2',
         'select count(*) from mybooks where book_id=' || TO_CHAR (bookid),
         1
      );
      utassert.eqqueryvalue (
         'ins-3',
         'select book_nm from mybooks where book_id=' || bookid,
         booknm
      );
      utassert.eqquery (
         'ins-4',
         'select * from mybooks where book_id=' || bookid,
         'select * from mybooks_part'
      );
      -- Lets try the THROWS assertion method here.
      -- If I insert the same bookid again I should get PRIMARY KEY violation error (ERRORCODE=-1 in oracle)
      -- Here is the I am looking for "-1". If I get "-1" then SUCCESS otherwise FAIL
      utassert.throws (
         'ins-5',
         'mybooks_pkg.ins(' || bookid || ',''Something'',sysdate)',
         -1
      );
   END;

/*  --------------------------------------------------
                 PROCEDURE upd (
                      bookid IN NUMBER,
                      booknm IN VARCHAR2,
                      publishdt DATE
                 )

    Assertion methods used : EQ
----------------------------------------------------- */
   PROCEDURE ut_5_upd
   IS
   BEGIN
      booknm := 'American History-Vol2'; -- new values
      publishdt := to_date('06-01-2002', 'dd-mm-yyyy');
      -- Call the INS function.
      mybooks_pkg.upd (bookid, booknm, publishdt);
      -- Check if the row inserted successfully
      utassert.eq ('ut_upd-1', booknm, mybooks_pkg.sel_booknm (bookid));
   END;

/*  --------------------------------------------------
                 PROCEDURE del (
                      bookid IN NUMBER
                 )

    Assertion methods used : EQQUERY, THROWS
----------------------------------------------------- */
   PROCEDURE ut_6_del
   IS 
      ret_val   VARCHAR2 (30);
   BEGIN
      -- Call the DEL function.
      DBMS_OUTPUT.put_line ('Id=' || TO_CHAR (bookid));
      mybooks_pkg.del (bookid);
      -- Check if the row deleted successfully
      utassert.eqqueryvalue (
         'ut_del-1',
         'select count(*) from mybooks where book_id=100',
         0
      );

      -- Other ways to test
      --utassert.throws('ut_del-2','v_dummy := mybooks_pkg.sel_booknm(100)',100);  -- 100 is "NO DATA FOUND"

      -- here is another way
      BEGIN
         ret_val := mybooks_pkg.sel_booknm (100);
      EXCEPTION
         WHEN NO_DATA_FOUND
         THEN
            NULL;
         WHEN OTHERS
         THEN
            utassert.eq ('ut_del-3', 1, 2); -- Forced to fail 1<>2
      END;
   END;
END;
/
