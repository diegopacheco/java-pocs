### Build 

```bash
./mvnw clean install 
```

### Result

```
/home/diego/.sdkman/candidates/java/23-amzn/bin/java --enable-preview -javaagent:/home/diego/.local/share/JetBrains/Toolbox/apps/intellij-idea-community-edition/lib/idea_rt.jar=38807 -Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 -Dsun.stderr.encoding=UTF-8 -classpath /home/diego/git/diegopacheco/java-pocs/pocs/java-23-eclipsestore/target/classes:/home/diego/.m2/repository/org/eclipse/store/storage-embedded/2.1.3/storage-embedded-2.1.3.jar:/home/diego/.m2/repository/org/eclipse/store/storage/2.1.3/storage-2.1.3.jar:/home/diego/.m2/repository/org/eclipse/store/afs-nio/2.1.3/afs-nio-2.1.3.jar:/home/diego/.m2/repository/org/eclipse/serializer/afs/2.1.3/afs-2.1.3.jar:/home/diego/.m2/repository/org/eclipse/serializer/base/2.1.3/base-2.1.3.jar:/home/diego/.m2/repository/org/eclipse/serializer/persistence-binary/2.1.3/persistence-binary-2.1.3.jar:/home/diego/.m2/repository/org/eclipse/serializer/persistence/2.1.3/persistence-2.1.3.jar:/home/diego/.m2/repository/org/slf4j/slf4j-api/2.0.9/slf4j-api-2.0.9.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-api/2.24.3/log4j-api-2.24.3.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-core/2.24.3/log4j-core-2.24.3.jar:/home/diego/.m2/repository/org/apache/logging/log4j/log4j-slf4j2-impl/2.24.3/log4j-slf4j2-impl-2.24.3.jar Main
2025-05-20 20:27:38 INFO  EmbeddedStorageFoundation:778 - Creating embedded storage manager
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive for type byte
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive for type boolean
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive for type short
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive for type char
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive for type int
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive for type float
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive for type long
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive for type double
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerClass for type class java.lang.Class
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerByte for type class java.lang.Byte
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerBoolean for type class java.lang.Boolean
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerShort for type class java.lang.Short
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerCharacter for type class java.lang.Character
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerInteger for type class java.lang.Integer
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerFloat for type class java.lang.Float
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerLong for type class java.lang.Long
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerDouble for type class java.lang.Double
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerVoid for type class java.lang.Void
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerObject for type class java.lang.Object
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerString for type class java.lang.String
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerStringBuffer for type class java.lang.StringBuffer
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerStringBuilder for type class java.lang.StringBuilder
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_byte for type class [B
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_boolean for type class [Z
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_short for type class [S
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_char for type class [C
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_int for type class [I
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_float for type class [F
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_long for type class [J
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_double for type class [D
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.math.BinaryHandlerBigInteger for type class java.math.BigInteger
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.math.BinaryHandlerBigDecimal for type class java.math.BigDecimal
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.io.BinaryHandlerFile for type class java.io.File
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerDate for type class java.util.Date
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerLocale for type class java.util.Locale
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerCurrency for type class java.util.Currency
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.regex.BinaryHandlerPattern for type class java.util.regex.Pattern
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.net.BinaryHandlerInetAddress for type class java.net.InetAddress
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.net.BinaryHandlerInet4Address for type class java.net.Inet4Address
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.net.BinaryHandlerInet6Address for type class java.net.Inet6Address
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.nio.file.BinaryHandlerPath for type interface java.nio.file.Path
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.net.BinaryHandlerInetSocketAddress for type class java.net.InetSocketAddress
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.net.BinaryHandlerURI for type class java.net.URI
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.net.BinaryHandlerURL for type class java.net.URL
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.time.BinaryHandlerZoneOffset for type class java.time.ZoneOffset
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.sql.BinaryHandlerSqlDate for type class java.sql.Date
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.sql.BinaryHandlerSqlTime for type class java.sql.Time
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.sql.BinaryHandlerSqlTimestamp for type class java.sql.Timestamp
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerOptionalInt for type class java.util.OptionalInt
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerOptionalLong for type class java.util.OptionalLong
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerOptionalDouble for type class java.util.OptionalDouble
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.types.BinaryHandlerStatelessConstant for type class java.util.Collections$UnmodifiableNavigableSet$EmptyNavigableSet
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.types.BinaryHandlerStatelessConstant for type class java.util.Collections$UnmodifiableNavigableMap$EmptyNavigableMap
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.types.BinaryHandlerStatelessConstant for type class java.util.Collections$ReverseComparator
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerVector for type class java.util.Vector
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerStack for type class java.util.Stack
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerHashtable for type class java.util.Hashtable
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerProperties for type class java.util.Properties
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerArrayList for type class java.util.ArrayList
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerHashSet for type class java.util.HashSet
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerHashMap for type class java.util.HashMap
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerWeakHashMap for type class java.util.WeakHashMap
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerLinkedList for type class java.util.LinkedList
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerTreeMap for type class java.util.TreeMap
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerTreeSet for type class java.util.TreeSet
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerIdentityHashMap for type class java.util.IdentityHashMap
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerLinkedHashMap for type class java.util.LinkedHashMap
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerLinkedHashSet for type class java.util.LinkedHashSet
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerPriorityQueue for type class java.util.PriorityQueue
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.concurrent.BinaryHandlerConcurrentHashMap for type class java.util.concurrent.ConcurrentHashMap
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.concurrent.BinaryHandlerConcurrentLinkedQueue for type class java.util.concurrent.ConcurrentLinkedQueue
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerCopyOnWriteArrayList for type class java.util.concurrent.CopyOnWriteArrayList
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerCopyOnWriteArraySet for type class java.util.concurrent.CopyOnWriteArraySet
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.types.BinaryHandlerSingletonStatelessEnum for type class java.util.Comparators$NaturalOrderComparator
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerArrayDeque for type class java.util.ArrayDeque
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.concurrent.BinaryHandlerConcurrentSkipListMap for type class java.util.concurrent.ConcurrentSkipListMap
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.concurrent.BinaryHandlerConcurrentSkipListSet for type class java.util.concurrent.ConcurrentSkipListSet
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.concurrent.BinaryHandlerConcurrentLinkedDeque for type class java.util.concurrent.ConcurrentLinkedDeque
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.reference.BinaryHandlerLazyDefault for type class org.eclipse.serializer.reference.Lazy$Default
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.types.BinaryHandlerGenericType for type class java.util.Optional
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerBulkList for type class org.eclipse.serializer.collections.BulkList
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerLimitList for type class org.eclipse.serializer.collections.LimitList
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerFixedList for type class org.eclipse.serializer.collections.FixedList
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerConstList for type class org.eclipse.serializer.collections.ConstList
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerEqBulkList for type class org.eclipse.serializer.collections.EqBulkList
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerHashEnum for type class org.eclipse.serializer.collections.HashEnum
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerConstHashEnum for type class org.eclipse.serializer.collections.ConstHashEnum
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerEqHashEnum for type class org.eclipse.serializer.collections.EqHashEnum
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerEqConstHashEnum for type class org.eclipse.serializer.collections.EqConstHashEnum
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerHashTable for type class org.eclipse.serializer.collections.HashTable
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerConstHashTable for type class org.eclipse.serializer.collections.ConstHashTable
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerEqHashTable for type class org.eclipse.serializer.collections.EqHashTable
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerEqConstHashTable for type class org.eclipse.serializer.collections.EqConstHashTable
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerSingleton for type class org.eclipse.serializer.collections.Singleton
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.util.BinaryHandlerSubstituterDefault for type class org.eclipse.serializer.util.Substituter$Default
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.lazy.BinaryHandlerLazyArrayList for type class org.eclipse.serializer.collections.lazy.LazyArrayList
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.lazy.BinaryHandlerLazyHashMap for type class org.eclipse.serializer.collections.lazy.LazyHashMap
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.lazy.BinaryHandlerLazyHashMapSegmentEntryList for type class org.eclipse.serializer.collections.lazy.LazyHashMap$LazyHashMapSegmentEntryList
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.lazy.BinaryHandlerLazyHashSet for type class org.eclipse.serializer.collections.lazy.LazyHashSet
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.reference.BinaryHandlerControlledLazy for type class org.eclipse.serializer.reference.ControlledLazyReference$Default
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerSetFromMap for type class java.util.Collections$SetFromMap
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.persistence.types.BinaryHandlerPersistenceRootsDefault for type class org.eclipse.serializer.persistence.types.PersistenceRoots$Default
2025-05-20 20:27:38 DEBUG PersistenceCustomTypeHandlerRegistry:135 - Registering type handler class org.eclipse.serializer.persistence.binary.org.eclipse.serializer.persistence.types.BinaryHandlerRootReferenceDefault for type class org.eclipse.serializer.persistence.types.PersistenceRootReference$Default
2025-05-20 20:27:38 INFO  PersistenceTypeHandlerManager:948 - Initializing type handler manager
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for [B: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_byte@600b0b7
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for [C: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_char@443dbe42
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for [D: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_double@1734f68
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for [F: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_float@5ed190be
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for [I: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_int@5bbc9f97
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for [J: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_long@41382722
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:269 - Created array type handler for [Ljava.lang.Object;: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArrayObject@3d4d3fe7
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for [S: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_short@51684e4a
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for [Z: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerNativeArray_boolean@38875e7d
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for boolean: org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive@d816dde
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for byte: org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive@6c451c9c
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for char: org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive@372b0d86
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for double: org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive@3113a37
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for float: org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive@4e9658b5
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for int: org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive@20312893
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.io.File: org.eclipse.serializer.persistence.binary.java.io.BinaryHandlerFile@c41709a
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.lang.Boolean: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerBoolean@54ec8cc9
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.lang.Byte: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerByte@5528a42c
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.lang.Character: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerCharacter@1a6f5124
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.lang.Class: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerClass@ec2bf82
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.lang.Double: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerDouble@6cc0bcf6
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.lang.Float: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerFloat@32f61a31
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.lang.Integer: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerInteger@669253b7
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.lang.Long: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerLong@51a06cbe
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.lang.Object: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerObject@49a64d82
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.lang.Short: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerShort@66d23e4a
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.lang.String: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerString@4d9d1b69
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.lang.StringBuffer: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerStringBuffer@251f7d26
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.lang.StringBuilder: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerStringBuilder@52d10fb8
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.lang.Void: org.eclipse.serializer.persistence.binary.java.lang.BinaryHandlerVoid@1fe8d51b
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.math.BigDecimal: org.eclipse.serializer.persistence.binary.java.math.BinaryHandlerBigDecimal@22680f52
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.math.BigInteger: org.eclipse.serializer.persistence.binary.java.math.BinaryHandlerBigInteger@39c11e6c
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.net.Inet4Address: org.eclipse.serializer.persistence.binary.java.net.BinaryHandlerInet4Address@503d56b5
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.net.Inet6Address: org.eclipse.serializer.persistence.binary.java.net.BinaryHandlerInet6Address@433ffad1
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.net.InetAddress: org.eclipse.serializer.persistence.binary.java.net.BinaryHandlerInetAddress@2575f671
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.net.InetSocketAddress: org.eclipse.serializer.persistence.binary.java.net.BinaryHandlerInetSocketAddress@ecf9fb3
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.net.URI: org.eclipse.serializer.persistence.binary.java.net.BinaryHandlerURI@30c0ccff
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.net.URL: org.eclipse.serializer.persistence.binary.java.net.BinaryHandlerURL@22db8f4
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.nio.file.Path: org.eclipse.serializer.persistence.binary.java.nio.file.BinaryHandlerPath@1d572e62
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.sql.Date: org.eclipse.serializer.persistence.binary.java.sql.BinaryHandlerSqlDate@46cf05f7
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.sql.Time: org.eclipse.serializer.persistence.binary.java.sql.BinaryHandlerSqlTime@7cd1ac19
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.sql.Timestamp: org.eclipse.serializer.persistence.binary.java.sql.BinaryHandlerSqlTimestamp@3caa4757
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.time.ZoneOffset: org.eclipse.serializer.persistence.binary.java.time.BinaryHandlerZoneOffset@1804f60d
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.ArrayDeque: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerArrayDeque@547e29a4
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.ArrayList: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerArrayList@238b521e
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:269 - Created generic type handler for java.util.Collections$EmptyList: org.eclipse.serializer.persistence.binary.types.BinaryHandlerStateless@2a2bb0eb
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:269 - Created generic type handler for java.util.Collections$EmptyMap: org.eclipse.serializer.persistence.binary.types.BinaryHandlerStateless@733037
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:269 - Created generic type handler for java.util.Collections$EmptySet: org.eclipse.serializer.persistence.binary.types.BinaryHandlerStateless@5167268
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.Collections$ReverseComparator: org.eclipse.serializer.persistence.binary.types.BinaryHandlerStatelessConstant@28c0b664
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.Collections$SetFromMap: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerSetFromMap@1af7f54a
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.Collections$UnmodifiableNavigableMap$EmptyNavigableMap: org.eclipse.serializer.persistence.binary.types.BinaryHandlerStatelessConstant@436390f4
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.Collections$UnmodifiableNavigableSet$EmptyNavigableSet: org.eclipse.serializer.persistence.binary.types.BinaryHandlerStatelessConstant@68ed96ca
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.Comparators$NaturalOrderComparator: org.eclipse.serializer.persistence.binary.types.BinaryHandlerSingletonStatelessEnum@3228d990
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.Currency: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerCurrency@50b8ae8d
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.Date: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerDate@51c929ae
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.HashMap: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerHashMap@29d2d081
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.HashSet: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerHashSet@58783f6c
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.Hashtable: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerHashtable@512d92b
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.IdentityHashMap: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerIdentityHashMap@7bdf6bb7
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.LinkedHashMap: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerLinkedHashMap@88d6f9b
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.LinkedHashSet: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerLinkedHashSet@475b7792
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.LinkedList: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerLinkedList@160c3ec1
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.Locale: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerLocale@4d0402b
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.Optional: org.eclipse.serializer.persistence.binary.types.BinaryHandlerGenericType@7577b641
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.OptionalDouble: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerOptionalDouble@3153ddfc
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.OptionalInt: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerOptionalInt@28a2a3e7
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.OptionalLong: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerOptionalLong@10b3df93
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.PriorityQueue: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerPriorityQueue@33a2499c
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.Properties: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerProperties@33c2bd
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.Stack: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerStack@3c321bdb
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.TreeMap: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerTreeMap@3abd581e
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.TreeSet: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerTreeSet@610db97e
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.Vector: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerVector@3fabf088
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.WeakHashMap: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerWeakHashMap@12f3afb5
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.concurrent.ConcurrentHashMap: org.eclipse.serializer.persistence.binary.java.util.concurrent.BinaryHandlerConcurrentHashMap@2c22a348
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.concurrent.ConcurrentLinkedDeque: org.eclipse.serializer.persistence.binary.java.util.concurrent.BinaryHandlerConcurrentLinkedDeque@74d7184a
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.concurrent.ConcurrentLinkedQueue: org.eclipse.serializer.persistence.binary.java.util.concurrent.BinaryHandlerConcurrentLinkedQueue@6831d8fd
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.concurrent.ConcurrentSkipListMap: org.eclipse.serializer.persistence.binary.java.util.concurrent.BinaryHandlerConcurrentSkipListMap@6b85300e
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.concurrent.ConcurrentSkipListSet: org.eclipse.serializer.persistence.binary.java.util.concurrent.BinaryHandlerConcurrentSkipListSet@5cbf9e9f
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.concurrent.CopyOnWriteArrayList: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerCopyOnWriteArrayList@5a2f016d
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.concurrent.CopyOnWriteArraySet: org.eclipse.serializer.persistence.binary.java.util.BinaryHandlerCopyOnWriteArraySet@3ad394e6
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for java.util.regex.Pattern: org.eclipse.serializer.persistence.binary.java.util.regex.BinaryHandlerPattern@42deb43a
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for long: org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive@3bb9efbc
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.BulkList: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerBulkList@3a7704c
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.ConstHashEnum: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerConstHashEnum@a23a01d
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.ConstHashTable: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerConstHashTable@7561db12
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.ConstList: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerConstList@24b52d3e
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:269 - Created generic type handler for org.eclipse.serializer.collections.Empty: org.eclipse.serializer.persistence.binary.types.BinaryHandlerStateless@6e9c413e
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:269 - Created generic type handler for org.eclipse.serializer.collections.EmptyTable: org.eclipse.serializer.persistence.binary.types.BinaryHandlerGenericType@33d05366
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:269 - Created generic type handler for org.eclipse.serializer.collections.EmptyTable$Keys: org.eclipse.serializer.persistence.binary.types.BinaryHandlerGenericType@70f43b45
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:269 - Created generic type handler for org.eclipse.serializer.collections.EmptyTable$Values: org.eclipse.serializer.persistence.binary.types.BinaryHandlerGenericType@2c282004
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.EqBulkList: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerEqBulkList@53bc1328
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.EqConstHashEnum: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerEqConstHashEnum@3c1e3314
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.EqConstHashTable: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerEqConstHashTable@78e16155
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.EqHashEnum: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerEqHashEnum@1968a49c
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.EqHashTable: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerEqHashTable@19868320
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.FixedList: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerFixedList@c20be82
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.HashEnum: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerHashEnum@622ef26a
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.HashTable: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerHashTable@5f577419
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.LimitList: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerLimitList@3d526ad9
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.Singleton: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.BinaryHandlerSingleton@3f3c966c
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.lazy.LazyArrayList: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.lazy.BinaryHandlerLazyArrayList@4102b1b1
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.lazy.LazyHashMap: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.lazy.BinaryHandlerLazyHashMap@3a71c100
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.lazy.LazyHashMap$LazyHashMapSegmentEntryList: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.lazy.BinaryHandlerLazyHashMapSegmentEntryList@f325091
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.collections.lazy.LazyHashSet: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.collections.lazy.BinaryHandlerLazyHashSet@77b325b3
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:269 - Created generic type handler for org.eclipse.serializer.hashing.XHashing$SingletonIdentityHashEqualator: org.eclipse.serializer.persistence.binary.types.BinaryHandlerStateless@7e8e8651
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:269 - Created generic type handler for org.eclipse.serializer.hashing.XHashing$SingletonKeyValueIdentityHashEqualator: org.eclipse.serializer.persistence.binary.types.BinaryHandlerStateless@271f18d3
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:269 - Created generic type handler for org.eclipse.serializer.hashing.XHashing$SingletonValueHashEqualator: org.eclipse.serializer.persistence.binary.types.BinaryHandlerStateless@61e3a1fd
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.persistence.types.PersistenceRootReference$Default: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.persistence.types.BinaryHandlerRootReferenceDefault@eadb475
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.persistence.types.PersistenceRoots$Default: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.persistence.types.BinaryHandlerPersistenceRootsDefault@315df4bb
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.reference.ControlledLazyReference$Default: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.reference.BinaryHandlerControlledLazy@25243bc1
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.reference.Lazy$Default: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.reference.BinaryHandlerLazyDefault@2e6ee0bc
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for org.eclipse.serializer.util.Substituter$Default: org.eclipse.serializer.persistence.binary.org.eclipse.serializer.util.BinaryHandlerSubstituterDefault@467f77a5
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerEnsurer:259 - Using predefined type handler for short: org.eclipse.serializer.persistence.binary.types.BinaryHandlerPrimitive@420bc288
2025-05-20 20:27:38 DEBUG MonitoringManager:170 - create MonitoringManager for storage: storage0
2025-05-20 20:27:38 INFO  EmbeddedStorageManager:245 - Starting embedded storage manager
2025-05-20 20:27:38 DEBUG MonitoringManager:178 - create MonitoringManager for storage: null
2025-05-20 20:27:38 DEBUG MonitoringManager:200 - Registered JMX bean org.eclipse.store:name=LazyReferenceManager
2025-05-20 20:27:38 INFO  StorageSystem:601 - Starting storage system
2025-05-20 20:27:38 DEBUG StorageStructureValidator:121 - Configured channel count matches to storage
2025-05-20 20:27:38 DEBUG StorageStructureValidator:128 - Channel directories are valid
2025-05-20 20:27:38 INFO  StorageStructureValidator:96 - Storage structure validated successfully.
2025-05-20 20:27:38 DEBUG MonitoringManager:200 - Registered JMX bean org.eclipse.store:storage=storage0,channel=channel-0,group=Entity cache
2025-05-20 20:27:38 DEBUG MonitoringManager:200 - Registered JMX bean org.eclipse.store:storage=storage0,channel=channel-0,group=housekeeping
2025-05-20 20:27:38 DEBUG MonitoringManager:200 - Registered JMX bean org.eclipse.store:storage=storage0,name=EntityCacheSummary
2025-05-20 20:27:38 DEBUG StorageChannel:440 - StorageChannel#0 started
2025-05-20 20:27:38 DEBUG StorageEntityCache:267 - Enlarged StorageEntityCache to 2 entries!
2025-05-20 20:27:38 DEBUG StorageEntityCache:267 - Enlarged StorageEntityCache to 4 entries!
2025-05-20 20:27:38 DEBUG StorageEntityCache:267 - Enlarged StorageEntityCache to 8 entries!
2025-05-20 20:27:38 DEBUG StorageEntityCache:267 - Enlarged StorageEntityCache to 16 entries!
2025-05-20 20:27:38 DEBUG StorageEntityCache:267 - Enlarged StorageEntityCache to 32 entries!
2025-05-20 20:27:38 DEBUG PersistenceTypeHandlerManager:944 - type handler manager already initialized
2025-05-20 20:27:38 DEBUG StorageEntityMarkMonitor:541 - StorageChannel#0 completed sweeping
2025-05-20 20:27:38 DEBUG PersistenceLiveStorerRegistry:89 - Thread[#32,Eclipse Serializer-StorageChannel-0,5,main] removed 0 idGroups with id <= 0.
2025-05-20 20:27:38 DEBUG StorageEntityMarkMonitor:462 - Storage GC completed hot phase #1 @ 1747798058969
2025-05-20 20:27:38 DEBUG MonitoringManager:200 - Registered JMX bean org.eclipse.store:storage=storage0,name=ObjectRegistry
2025-05-20 20:27:38 DEBUG StorageEntityMarkMonitor:541 - StorageChannel#0 completed sweeping
2025-05-20 20:27:38 DEBUG PersistenceLiveStorerRegistry:89 - Thread[#32,Eclipse Serializer-StorageChannel-0,5,main] removed 0 idGroups with id <= 1.
2025-05-20 20:27:38 DEBUG StorageEntityMarkMonitor:454 - Storage GC completed #1 @ 1747798058977
2025-05-20 20:27:38 DEBUG StorageChannel:626 - StorageChannel#0 loading 24 references
2025-05-20 20:27:38 DEBUG StorageChannel:626 - StorageChannel#0 loading 3 references
2025-05-20 20:27:38 INFO  EmbeddedStorageManager:257 - Embedded storage manager initialized
2025-05-20 20:27:38 DEBUG LazyReferenceManager$Default:677 - LazyReferenceManager started
2025-05-20 20:27:39 DEBUG MonitoringManager:200 - Registered JMX bean org.eclipse.store:storage=storage0,name=EmbeddedStorage
Hello World! @ Tue May 20 20:26:43 PDT 2025
2025-05-20 20:27:39 DEBUG PersistenceTypeHandlerManager:944 - type handler manager already initialized
2025-05-20 20:27:39 DEBUG BinaryStorer:430 - Store request: org.eclipse.serializer.persistence.types.PersistenceRootReference$Default@5e4fa1da()
2025-05-20 20:27:39 DEBUG BinaryStorer:656 - Registering 1000000000000000024: org.eclipse.serializer.persistence.types.PersistenceRootReference$Default@5e4fa1da()
2025-05-20 20:27:39 DEBUG BinaryStorer:482 - Storing     1000000000000000024: org.eclipse.serializer.persistence.types.PersistenceRootReference$Default@5e4fa1da()
2025-05-20 20:27:39 DEBUG BinaryStorer:656 - Registering 1000000000000000029: java.lang.String@6e91893()
2025-05-20 20:27:39 DEBUG BinaryStorer:482 - Storing     1000000000000000029: java.lang.String@6e91893()
2025-05-20 20:27:39 DEBUG BinaryStorer:430 - Store request: java.lang.String@6e91893()
2025-05-20 20:27:39 DEBUG BinaryStorer:560 - Committing 2 object(s)
2025-05-20 20:27:39 DEBUG DefaultObjectRegistry:1249 - Cleaned 0 gc entries
2025-05-20 20:27:39 DEBUG BinaryStorer:591 - Commit finished successfully
2025-05-20 20:27:39 DEBUG MonitoringManager:221 - Unregistered JMX bean org.eclipse.store:name=LazyReferenceManager
2025-05-20 20:27:39 INFO  StorageSystem:641 - Stopping storage system
2025-05-20 20:27:39 DEBUG MonitoringManager:221 - Unregistered JMX bean org.eclipse.store:storage=storage0,channel=channel-0,group=Entity cache
2025-05-20 20:27:39 DEBUG MonitoringManager:221 - Unregistered JMX bean org.eclipse.store:storage=storage0,channel=channel-0,group=housekeeping
2025-05-20 20:27:39 DEBUG MonitoringManager:221 - Unregistered JMX bean org.eclipse.store:storage=storage0,name=EntityCacheSummary
2025-05-20 20:27:39 DEBUG MonitoringManager:221 - Unregistered JMX bean org.eclipse.store:storage=storage0,name=ObjectRegistry
2025-05-20 20:27:39 DEBUG MonitoringManager:221 - Unregistered JMX bean org.eclipse.store:storage=storage0,name=EmbeddedStorage
2025-05-20 20:27:39 INFO  StorageSystem:649 - Storage system stopped
2025-05-20 20:27:40 DEBUG LazyReferenceManager$Default:717 - LazyReferenceManager stopped
2025-05-20 20:27:40 DEBUG StorageChannel:465 - StorageChannel#0 processing disabled
2025-05-20 20:27:40 DEBUG StorageChannel:501 - StorageChannel#0 stopped
2025-05-20 20:27:40 DEBUG StorageFileManager:1308 - Destroying all buffers explicitly!
```