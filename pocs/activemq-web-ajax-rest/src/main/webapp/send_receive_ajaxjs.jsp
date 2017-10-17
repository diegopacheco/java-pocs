<script type="text/javascript" src="javascript/amq.js"></script>
<script type="text/javascript">amq.uri='/activemq-web-ajax-rest-1.0-SNAPSHOT/amq';</script>
<script type="text/javascript">

	var messageHandler =
	{
	  rcvMessage: function(message)
	  {
		document.getElementById("divResposnseHandle").innerHTML = "Message arrived: <b>" + message.textContent + "</b>";
	  }
	};	
	amq.addListener("msghID","channel://js_ajax_queue",messageHandler.rcvMessage);	

	function sendActiveMQQueueMessage(msg){
		try{
			var xmlMessage = "<message><text>" + msg + "</text></message>";
			amq.sendMessage("channel://js_ajax_queue",xmlMessage);
			document.getElementById("divResposnse").innerHTML =  "ActiveMQ Ajax Client: message[" + msg + "] sent to *js_ajax_queue* ";	
		}catch(e){
			document.getElementById("divResposnse").innerHTML = "Error sending message to ActiveMQ. Error: " + e;	
		}
	}		
	
</script>
<html>
	<body>
		<table>
			<tr>
				<td>Message</td>
				<td><input type="text" id="txtMessage" size="20"></td>
				<td><input type="button" id="btnSendMessage" onclick="js:sendActiveMQQueueMessage(txtMessage.value)" value="Send"></td>
				<td><div id="divResposnse" ></div></td>
				<td><div id="divResposnseHandle" ></div></td>
			</tr>
			<tr>
				<td><div id="divResposnse" ></div></td>
			</tr>
			<tr>
				<td>
					<form id="form1">
						<input type="button" id="btnReceiveMessages" value="Receive Messages" onclick="js:amq._startPolling()" >
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>