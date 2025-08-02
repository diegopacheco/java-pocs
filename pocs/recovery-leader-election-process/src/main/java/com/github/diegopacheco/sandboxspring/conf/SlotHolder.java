package com.github.diegopacheco.sandboxspring.conf;

import org.springframework.stereotype.Component;
import java.util.UUID;

/**
 * This make sure that every instance of the spring boot app has a unique ID which is a slot.
 * Slot will be used to provide coordination between instances.
 * Slots will be generated everytime that the app goes up/down which is fine, they should have TTL to avoid
 * have orphan slots.
 *
 */
@Component
public class SlotHolder {

    private UUID slot = UUID.randomUUID();

    public UUID getSlot(){
        return slot;
    }

}
