from flask import Flask
import time

app = Flask(__name__)

@app.route("/slow")
def hello_world():
    time.sleep(3)
    raise Exception("Sorry, I'm blowing this up !!!")