// checks if groovy console works
def calendar = Calendar.getInstance()
def isFriday = calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY
println "Is it friday? ${isFriday ? 'Yes' : 'No'}"
