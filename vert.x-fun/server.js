var vertx = require('vertx');

vertx.createHttpServer().requestHandler(function(req) {
  req.response.end("Hello World!");
}).listen(8080, 'localhost');