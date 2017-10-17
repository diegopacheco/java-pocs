<script language="Javascript">

	function sendRESTMessage(queueName,message) {
		try{
			var xmlHttpReq = false;
		    var self = this;

		    if (window.XMLHttpRequest) {
		        self.xmlHttpReq = new XMLHttpRequest();
		    }
		    else if (window.ActiveXObject) {
		        self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
		    }
	
		    var xmlMessage = "<xml><message>" + message + "</message></xml>";
		    var httpURL    = "message/" + queueName + "?type=queue&body=" + xmlMessage;
		    
		    self.xmlHttpReq.open('POST', httpURL, true);
		    self.xmlHttpReq.setRequestHeader("Content-Type", "text/xml")
		    	    
		    self.xmlHttpReq.onreadystatechange = function() {
		    	if(self.xmlHttpReq.readyState==4){
		    	   alert("Ajax call back " + self.xmlHttpReq.responseText );
		    	}
		    }
		    self.xmlHttpReq.send(null);
			alert("Message: " + message + " sent to queue: " + queueName);
		    
		}catch(e){
			alert("Error: " + e);
		}    
	}

	function receiveRESTMessage(queueName) {
		try{
			var xmlHttpReq = false;
		    var self = this;

		    if (window.XMLHttpRequest) {
		        self.xmlHttpReq = new XMLHttpRequest();
		    }
		    else if (window.ActiveXObject) {
		        self.xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
		    }
	
		    var httpURL    = "message/" + queueName + "?type=queue";
		    
		    self.xmlHttpReq.open('GET', httpURL, true);
		    self.xmlHttpReq.setRequestHeader("Content-Type", "text/xml")
		    	    
		    self.xmlHttpReq.onreadystatechange = function() {
		    	if(self.xmlHttpReq.readyState==4){
		    	   alert("Message Arrived: " + self.xmlHttpReq.responseText );
		    	}
		    }
		    self.xmlHttpReq.send(null);
    
		}catch(e){
			alert("Error: " + e);
		}    
	}
	
</script>
<html>
	<body>
		<table>
			<tr>
				<td><input id="txtMessage"  type="text"     value="Minha mensagem REST aqui!" size="30" ></td>
				<td><input type="button"    value="send"    onclick="js:sendRESTMessage('rest_queue',txtMessage.value);" /></td>
				<td><input type="button"    value="receive" onclick="js:receiveRESTMessage('rest_queue');" /></td>
			</tr>
		</table>		
	</body>
</html>
