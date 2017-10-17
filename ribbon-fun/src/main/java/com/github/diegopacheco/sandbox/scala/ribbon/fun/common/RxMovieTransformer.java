package com.github.diegopacheco.sandbox.scala.ribbon.fun.common;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.reactivex.netty.channel.ContentTransformer;

import java.nio.charset.Charset;

public class RxMovieTransformer implements ContentTransformer<Movie> {
    public ByteBuf call(Movie movie, ByteBufAllocator byteBufAllocator) {
        byte[] bytes = movie.toString().getBytes(Charset.defaultCharset());
        ByteBuf byteBuf = byteBufAllocator.buffer(bytes.length);
        byteBuf.writeBytes(bytes);
        return byteBuf;
    }
}