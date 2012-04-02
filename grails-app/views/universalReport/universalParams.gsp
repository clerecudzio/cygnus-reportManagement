<fieldset class="report">
	<legend><g:message code="label.searchParams"/></legend>
	<g:render template="/templates/paramsForm" />
	<div class="fieldcontain" >
	<label for="dummy"></label>
	<g:actionSubmit class="save" action="showReport"
		value="${message(code: 'default.button.search.label', default: 'Search')}" />
	</div>
</fieldset>
