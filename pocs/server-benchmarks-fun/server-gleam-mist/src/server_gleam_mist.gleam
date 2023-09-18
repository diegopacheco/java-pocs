import gleam/erlang/process
import handler.{handler}
import mist

pub fn main() {
  let assert Ok(_) = mist.serve(3000, mist.handler_func(handler.handler))
  process.sleep_forever()
}
