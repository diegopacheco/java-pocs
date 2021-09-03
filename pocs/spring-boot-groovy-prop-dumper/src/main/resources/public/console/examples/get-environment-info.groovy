// Get Spring Boot environment information
def environment = applicationContext.getBean("environment")
println "Active profiles: ${environment.getActiveProfiles()}"
println "Application name: ${environment.getProperty('spring.application.name')}"
