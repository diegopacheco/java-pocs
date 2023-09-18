import mist
import gleam/http.{Get}
import gleam/http/response
import gleam/bit_builder
import gleam/http/request.{Request}
import mist/internal/handler
import ids/uuid
import gleam/bit_string

type MistService =
  fn(Request(mist.Body)) -> mist.Response

pub fn handler(req: Request(mist.Body)) -> mist.Response {
  
  let assert Ok(id) = uuid.generate_v4()
  
  case req.method, request.path_segments(req) {
    Get, ["uuid"] ->
      response.new(200)
      |> mist.bit_builder_response(bit_builder.from_string(id))
    _, _ ->
      response.new(404)
      |> mist.empty_response
  }
}
