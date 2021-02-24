package com.github.diegopacheco.sandbox.java.cache.v3;

public class Main {

  public static void main(String args[]){
    LRUCache cache = new SimpleLRUCache();
    cache.put("one","Diego");
    sleep(1);
    cache.put("two","Melina");
    sleep(1);
    cache.put("three","Gandalfy");
    System.out.println("It works! size: " + cache.size() );
    System.out.println("One: " + cache.get("one"));
    System.out.println("Two: " + cache.get("two"));
    System.out.println("Three: " + cache.get("three"));

    cache.put("one","Diego");
    sleep(1);
    cache.put("two","Melina");
    System.out.println("One: " + cache.get("one"));
    System.out.println("Two: " + cache.get("two"));
    System.out.println("Three: " + cache.get("three"));
    System.out.println("It works! size: " + cache.size() );

    cache.get("one");
    sleep(1);
    cache.get("one");
    sleep(1);
    cache.get("one");
    sleep(1);
    cache.put("three","Gandalfy");
    System.out.println("One: " + cache.get("one"));
    System.out.println("Two: " + cache.get("two"));
    System.out.println("Three: " + cache.get("three"));
    System.out.println("It works! size: " + cache.size() );

  }

  private static void sleep(int time){
    try{
      Thread.sleep(time*1000L);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
}
