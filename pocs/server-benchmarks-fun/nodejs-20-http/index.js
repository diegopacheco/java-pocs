const http = require('http');
const port = 3000;
const crypto = require('crypto');

const server = http.createServer((req, res) => {
  if (req.url === '/') {
    const uuid = crypto.randomUUID();
    res.writeHead(200, { 'Content-Type': 'text/plain' });
    res.end(uuid);
  } else {
    res.writeHead(404, { 'Content-Type': 'text/plain' });
    res.end('Not Found');
  }
});

server.listen(port, () => {
  console.log(`Node.js - HTTP server listening on port ${port}`);
});