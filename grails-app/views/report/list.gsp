
<%@ page import="com.cygnus.sys.rpt.Report" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'report.label', default: 'Report')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-report" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-report" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="reportCode" title="${message(code: 'report.reportCode.label', default: 'Report Code')}" />
					
						<g:sortableColumn property="reportFileName" title="${message(code: 'report.reportFileName.label', default: 'Report File Name')}" />
					
						<g:sortableColumn property="reportControllerName" title="${message(code: 'report.reportControllerName.label', default: 'Report Controller Name')}" />
					
						<th><g:message code="report.menuCode.label" default="Menu Code" /></th>
					
						<g:sortableColumn property="reportName" title="${message(code: 'report.reportName.label', default: 'Report Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${reportInstanceList}" status="i" var="reportInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${reportInstance.id}">${fieldValue(bean: reportInstance, field: "reportCode")}</g:link></td>
					
						<td>${fieldValue(bean: reportInstance, field: "reportFileName")}</td>
					
						<td>${fieldValue(bean: reportInstance, field: "reportControllerName")}</td>
					
						<td>${fieldValue(bean: reportInstance, field: "menuCode.menuCode")}</td>
					
						<td>${fieldValue(bean: reportInstance, field: "reportName")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${reportInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
