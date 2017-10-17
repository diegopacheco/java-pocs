<%@ page contentType="text/html; charset=Cp1252"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/a4j" prefix="a4j"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Cp1252" />
<title></title>
</head>
<body>
<f:view>
	<h:form>
		<rich:panel>
			<h:panelGrid>
				<h:outputLabel value="Cão que se deu mal" />
				<h:panelGroup>
					<h:outputLabel id="result"  value="Cão Capturado:"  />
					<h:outputLabel id="resuktValue" value="#{carrocinhaBean.resultado}" />
				</h:panelGroup>
			</h:panelGrid>
		</rich:panel>
	</h:form>
</f:view>
</body>
</html>