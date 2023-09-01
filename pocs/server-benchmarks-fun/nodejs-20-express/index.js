const express = require('express')
const app = express()
const port = 3000
const crypto = require('crypto');

app.get('/', (req, res) => {
  const uuid = crypto.randomUUID();
  res.send(uuid);
})

app.listen(port, () => {
  console.log(`NodeJS 20 - Express, listening on port ${port}`)
})