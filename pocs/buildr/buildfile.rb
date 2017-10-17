repositories.remote << 'http://repo1.maven.org/maven2'

define 'buildr-test' do
  project.version = '1.0'
  package :jar
  compile.with 'commons-cli:commons-cli:jar:1.2'
  test.with    'junit:junit:jar:4.9'
end

