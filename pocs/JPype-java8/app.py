import jpype
from jpype.types import *
import jpype.imports

# Load a JVM process using JPype(JNI) - load a JAR
target = "/mnt/e35d88d4-42b9-49ea-bf29-c4c3b018d429/diego/git/diegopacheco/java-pocs/pocs/JPype-java8/target/"
jpype.addClassPath(target+"JPype-java8-1.0-SNAPSHOT.jar")
jpype.startJVM()

# Instanciate a class and call instance methods
calc = JClass('Calculator')()
result = calc.sum(JInt(1), JInt(2))
print(result)

# Call static methods on a class
Logger = JClass('Logger')
message = JString("Hello from Python!")
Logger.log(message)

jpype.shutdownJVM()