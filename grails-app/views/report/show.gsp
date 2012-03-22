
<%@ page import="com.cygnus.sys.rpt.Report" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'report.label', default: 'Report')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-report" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-report" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list report">
			
				<g:if test="${reportInstance?.reportCode}">
				<li class="fieldcontain">
					<span id="reportCode-label" class="property-label"><g:message code="report.reportCode.label" default="Report Code" /></span>
					
						<span class="property-value" aria-labelledby="reportCode-label"><g:fieldValue bean="${reportInstance}" field="reportCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reportInstance?.reportFileName}">
				<li class="fieldcontain">
					<span id="reportFileName-label" class="property-label"><g:message code="report.reportFileName.label" default="Report File Name" /></span>
					
						<span class="property-value" aria-labelledby="reportFileName-label"><g:fieldValue bean="${reportInstance}" field="reportFileName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reportInstance?.reportControllerName}">
				<li class="fieldcontain">
					<span id="reportControllerName-label" class="property-label"><g:message code="report.reportControllerName.label" default="Report Controller Name" /></span>
					
						<span class="property-value" aria-labelledby="reportControllerName-label"><g:fieldValue bean="${reportInstance}" field="reportControllerName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${reportInstance?.menuCode}">
				<li class="fieldcontain">
					<span id="menuCode-label" class="property-label"><g:message code="report.menuCode.label" default="Menu Code" /></span>
					
						<span class="property-value" aria-labelledby="menuCode-label"><g:link controller="STMenu" action="show" id="${reportInstance?.menuCode?.id}">${reportInstance?.menuCode?.menuCode}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${reportInstance?.reportName}">
				<li class="fieldcontain">
					<span id="reportName-label" class="property-label"><g:message code="report.reportName.label" default="Report Name" /></span>
					
						<span class="property-value" aria-labelledby="reportName-label"><g:fieldValue bean="${reportInstance}" field="reportName"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${reportInstance?.id}" />
					<g:link class="edit" action="edit" id="${reportInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
