repositories.remote << 'http://repo1.maven.org/maven2'

Java.classpath << 'org.jgroups:jgroups:jar:3.0.1.Final'

define 'jgroups-discoverability' do
  project.version = '1.0'
  package :jar
  
  compile.with 'org.jgroups:jgroups:jar:3.0.1.Final'
  test.with    'junit:junit:jar:4.9'
  run.using :main => "com.github.diegopacheco.sandbox.java.jgroups.SimpleChat"  
end
