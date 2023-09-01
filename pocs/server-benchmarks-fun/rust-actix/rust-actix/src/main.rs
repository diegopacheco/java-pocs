use actix_web::{get, App, HttpResponse, HttpServer, Responder};
use uuid::Uuid;

#[get("/")]
async fn index() -> impl Responder {
    let uuid = Uuid::new_v4();
    HttpResponse::Ok().body(uuid.to_string())
}

#[actix_web::main]
async fn main() -> std::io::Result<()> {
    println!("Actix Server running {}", "8080");
    HttpServer::new(|| {
        App::new()
            .service(index)
    })
    .bind(("0.0.0.0", 8080))?
    .run()
    .await
}