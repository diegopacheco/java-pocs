import crypto from "crypto"

const port = 3000

Bun.serve({
  port,
  fetch(req) {
    const url = new URL(req.url);
    if (url.pathname === "/") return new Response(crypto.randomUUID());
    console.log(`Bun, listening on port ${port}`)
    return new Response("404!");
  },
});