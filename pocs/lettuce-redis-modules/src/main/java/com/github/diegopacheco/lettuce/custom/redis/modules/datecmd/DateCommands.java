package com.github.diegopacheco.lettuce.custom.redis.modules.datecmd;

import io.lettuce.core.RedisFuture;
import io.lettuce.core.dynamic.Commands;
import io.lettuce.core.dynamic.annotation.Command;
import io.lettuce.core.dynamic.annotation.CommandNaming;
import io.lettuce.core.dynamic.annotation.CommandNaming.Strategy;

@CommandNaming(strategy=Strategy.DOT)
public interface DateCommands extends Commands {
	@Command("dp.DATE ?0")
	public RedisFuture<String> dpDate(String o);
}
