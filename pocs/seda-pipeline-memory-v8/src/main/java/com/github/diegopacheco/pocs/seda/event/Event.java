package com.github.diegopacheco.pocs.seda.event;

public class Event<T> {

    private final T content;
    private final EventMetadata metadata;

    public Event(T content, EventMetadata metadata) {
        this.content = content;
        this.metadata = metadata;
    }

    public Event(T content) {
        this.content = content;
        this.metadata = new EventMetadata();
    }

    public T getContent() {
        return content;
    }

    public EventMetadata getMetadata(){
        return metadata;
    }

    public Event<T> addStage(String stage){
        metadata.addStage(stage);
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
                "content=" + content +
                ", metadata=" + metadata +
                '}';
    }
}
