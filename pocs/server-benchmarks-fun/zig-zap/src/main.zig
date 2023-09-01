const std = @import("std");
const zap = @import("zap");
const uuid = @import("uuid");

fn dispatch_routes(r: zap.SimpleRequest) void {
    // dispatch
    if (r.path) |the_path| {
        if (routes.get(the_path)) |foo| {
            foo(r);
            return;
        }
    }
    // or default: present menu
    r.sendBody(
        \\ <html>
        \\   <body>
        \\     <p><a href="/u">uuid</a></p>
        \\   </body>
        \\ </html>
    ) catch return;
}

fn to_string(bytes:[16]u8) [36]u8 {
     var buf: [36]u8 = undefined;
     const hex = "0123456789abcdef";
     const encoded_pos = [16]u8{ 0, 2, 4, 6, 9, 11, 14, 16, 19, 21, 24, 26, 28, 30, 32, 34 };
     buf[8] = '-';
     buf[13] = '-';
     buf[18] = '-';
     buf[23] = '-';
     inline for (encoded_pos, 0..) |i, j| {
        buf[i + 0] = hex[bytes[j] >> 4];
        buf[i + 1] = hex[bytes[j] & 0x0f];
     }
     return buf;
}

fn static_site(r: zap.SimpleRequest) void {
     const uuid1 = uuid.UUID.init();
     const string = to_string(uuid1.bytes);
    r.sendBody(&string) catch return;
}

fn setup_routes(a: std.mem.Allocator) !void {
    routes = std.StringHashMap(zap.SimpleHttpRequestFn).init(a);
    try routes.put("/u", static_site);
}

var routes: std.StringHashMap(zap.SimpleHttpRequestFn) = undefined;

pub fn main() !void {
    try setup_routes(std.heap.page_allocator);
    var listener = zap.SimpleHttpListener.init(.{
        .port = 3000,
        .on_request = dispatch_routes,
        .log = false,
    });
    try listener.listen();

    std.debug.print("Listening on 0.0.0.0:3000\n", .{});

    zap.start(.{
        .threads = 2,
        .workers = 2,
    });
}
