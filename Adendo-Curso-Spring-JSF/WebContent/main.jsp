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
				<h:outputLabel value="Capturar um Cão sem Sorte" />
				<h:panelGroup>
					<h:outputLabel id="nome" value="Nome do Cão:"  />
					<h:inputText   id="nomeTxt" value="#{carrocinhaBean.nome}" />
				</h:panelGroup>
				<h:panelGroup>
					<h:outputLabel id="raca" value="Raça do Cão :" />
					<h:inputText   id="racaTxt" value="#{carrocinhaBean.raca}" />
				</h:panelGroup>
				<h:panelGroup>
					<a4j:commandButton value="Catar o Cão agora!" action="#{carrocinhaBean.catar}" />
				</h:panelGroup>
			</h:panelGrid>
		</rich:panel>
	</h:form>
</f:view>
</body>
</html>