from('timer:tick?period=3s')
  .setBody().constant('Hello world from Camel K')
  .to('log:info')
