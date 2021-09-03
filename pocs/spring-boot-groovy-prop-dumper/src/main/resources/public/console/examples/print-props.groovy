// Get Spring Boot configs
def app = applicationContext.getBean("ApplicationContextProvider")
app.getAllConfigs()