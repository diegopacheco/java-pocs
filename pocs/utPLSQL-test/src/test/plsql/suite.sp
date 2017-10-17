BEGIN

   utsuite.add ('All');
   
   -- Add two packages for testing
   utpackage.add (
      'All', 'betwnstr');
   utpackage.add (
      'All', 'mybooks_pkg');
   
END;
/
   
