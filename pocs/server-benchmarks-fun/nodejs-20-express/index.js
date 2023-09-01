const express = require('express')
const app = express()
const port = 3000
const uuid = require('uuid');

const v4options = {
    random: [
      0x10, 0x91, 0x56, 0xbe, 0xc4, 0xfb, 0xc1, 0xea, 0x71, 0xb4, 0xef, 0xe1, 0x67, 0x1c, 0x58, 0x36,
    ],
  };

app.get('/', (req, res) => {
  res.send(uuid.v1(v4options))
})

app.listen(port, () => {
  console.log(`NodeJS 20 - Express, listening on port ${port}`)
})