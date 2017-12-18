package com.github.diegopacheco.lettuce.custom.redis.modules.datecmd;

import io.lettuce.core.dynamic.Commands;
import io.lettuce.core.dynamic.annotation.CommandNaming;
import io.lettuce.core.dynamic.annotation.CommandNaming.Strategy;
import io.lettuce.core.output.StringListOutput;

@CommandNaming(strategy=Strategy.DOT)
public interface DateCommands extends Commands {
	//@Command("DP.DATE")
	public StringListOutput dpDate();
}
