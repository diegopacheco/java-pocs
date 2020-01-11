import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.lettuce.core.Consumer;
import io.lettuce.core.RedisBusyException;
import io.lettuce.core.RedisClient;
import io.lettuce.core.StreamMessage;
import io.lettuce.core.XReadArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class RedisStreamMain{
    public static void main(String[] args) {
        RedisClient redisClient = RedisClient.create("redis://172.17.0.2:6379");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        send(syncCommands);
        read(syncCommands);

        connection.close();
        redisClient.shutdown();
    }

    private static void read(RedisCommands<String, String> syncCommands) {
        System.out.println("Reading messages... ");
        try {
            syncCommands.xgroupCreate( XReadArgs.StreamOffset.from("weather_sensor:wind", "0-0"), "application_1"  );
        }
        catch (RedisBusyException redisBusyException) {
            System.out.println( String.format("\t Group '%s' already exists","application_1"));
        }
        List<StreamMessage<String, String>> messages = syncCommands.xreadgroup(
                Consumer.from("application_1", "consumer_1"),
                XReadArgs.StreamOffset.lastConsumed("weather_sensor:wind")
        );
        if (!messages.isEmpty()) {
            System.out.println( messages );
        }
    }

    private static void send(RedisCommands<String, String> syncCommands) {
        Map<String, String> messageBody = new HashMap<>();
        messageBody.put("speed", "15");
        messageBody.put("direction","270");
        messageBody.put("sensor_ts",String.valueOf(System.currentTimeMillis()) );
        
        System.out.println("Sending messages... ");
        String messageId = syncCommands.xadd("weather_sensor:wind",messageBody);
        System.out.println( String.format("Message %s : %s posted", messageId, messageBody) );
    }
}