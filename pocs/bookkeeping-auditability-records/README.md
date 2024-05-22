### Build 
```bash
./mvnw clean install 
```
### Result
```
SignUpEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, timestamp=null, eventDescription='User 1, signed up in the hotel website'}
DailyFeeEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, value=100.0, timestamp=2024-05-22T08:05:05.891938387Z, eventDescription='User 1, system, day 1, occur, charges 100$'}
RoomBookedEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, numberOfNights=null, room='M-1001', total=10000.0, timestamp=2024-05-22T08:05:05.901055989Z, eventDescription='User 1, book a master suite for 10 nights'}
RoomServiceOrderedEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, room='null', total=100.0, timestamp=2024-05-22T08:05:05.901618168Z, eventDescription='User 1, night 1, order a bottle of wine', service='Food/Drinks'}
DailyFeeEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, value=100.0, timestamp=2024-05-22T08:05:05.901713778Z, eventDescription='User 1, system, day 2, occur, charges 100$'}
RoomServiceOrderedEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, room='null', total=358.25, timestamp=2024-05-24T08:05:05.901786422Z, eventDescription='User 1, night 2, order caviar', service='Food/Drinks'}
DailyFeeEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, value=100.0, timestamp=2024-05-25T08:05:05.902196975Z, eventDescription='User 1, system, day 3, occur, charges 100$'}
RoomServiceOrderedEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, room='null', total=12.0, timestamp=2024-05-25T08:05:05.902260708Z, eventDescription='User 1, night 3, order french fries', service='Food/Drinks'}
DailyFeeEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, value=100.0, timestamp=2024-05-26T08:05:05.902385800Z, eventDescription='User 1, system, day 4, occur, charges 100$'}
RoomServiceOrderedEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, room='null', total=358.25, timestamp=2024-05-26T08:05:05.902447054Z, eventDescription='User 1, day 4, schedule a wake up call 8:00 for night 10', service='WakeUpCall'}
DailyFeeEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, value=100.0, timestamp=2024-05-27T08:05:05.902477889Z, eventDescription='User 1, system, day 5, occur, charges 100$'}
RoomServiceOrderedEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, room='null', total=150.0, timestamp=2024-05-27T08:05:05.902533633Z, eventDescription='User 1, day 5, ask for a late check out', service='LateCheckOut'}
DailyFeeEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, value=100.0, timestamp=2024-05-28T08:05:05.902606739Z, eventDescription='User 1, system, day 6, occur, charges 100$'}
RoomServiceOrderedEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, room='null', total=15.0, timestamp=2024-05-29T08:05:05.902676700Z, eventDescription='User 1, day 7, order extra towels', service='ExtraTowels'}
DailyFeeEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, value=100.0, timestamp=2024-05-29T08:05:05.902743645Z, eventDescription='User 1, system, day 7, occur, charges 100$'}
RoomServiceOrderedEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, room='null', total=300.0, timestamp=2024-05-29T08:05:05.902812705Z, eventDescription='User 1, day 7, extend the stay for 3 more days', service='ExtendReservation'}
DailyFeeEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, value=100.0, timestamp=2024-05-30T08:05:05.902879037Z, eventDescription='User 1, system, day 8, occur, charges 100$'}
DailyFeeEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, value=100.0, timestamp=2024-05-31T08:05:05.902941416Z, eventDescription='User 1, system, day 9, occur, charges 100$'}
DailyFeeEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, value=100.0, timestamp=2024-06-01T08:05:05.902996613Z, eventDescription='User 1, system, day 10, occur, charges 100$'}
CheckedOutEvent{userId=391a8fba-7b50-4966-a8aa-8e6004fb54ad, total=1000.0, timestamp=2024-06-01T08:05:05.903511971Z, eventDescription='User 1, checkout 10 PM, total 1000$', room='null'}
```

### Rationale

This poc show how we can create a simple Event-Driven bookkeeping system.
Such system uses a hotel as example. We are capturing all meaniful events the user do.
There are many applications for it such as:
* Analytics
* Fraud Detection
* Customer Marketing and pos-sales offerings
* Auditability for support troubleshooting

### Design

* Everything is event based
* Data is stored in memory for sake of POC but there is a great fit with Kafka or RabittMQ for instance.
* Event Storage could fit well in Cassandra or S3

### Tradeoffs

##### NoSQL

Having a bookkeeping system under a NoSQL database will scale and we can make it cost efficient.
However, unpredictable queries will be harder. Schema evolution is easier.

##### Relational

Relational db will be more expensive and harder to deal with historical data, will require archiving and some operations and automation.
However, to query unpredictable data will be easier. Schema evolution is harder.