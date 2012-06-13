
<%@ page import="org.dg.Score" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'score.label', default: 'Score')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-score" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-score" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list score">
			
				<g:if test="${scoreInstance?.notes}">
				<li class="fieldcontain">
					<span id="notes-label" class="property-label"><g:message code="score.notes.label" default="Notes" /></span>
					
						<span class="property-value" aria-labelledby="notes-label"><g:fieldValue bean="${scoreInstance}" field="notes"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${scoreInstance?.course}">
				<li class="fieldcontain">
					<span id="course-label" class="property-label"><g:message code="score.course.label" default="Course" /></span>
					
						<span class="property-value" aria-labelledby="course-label"><g:link controller="course" action="show" id="${scoreInstance?.course?.id}">${scoreInstance?.course?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${scoreInstance?.date}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="score.date.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${scoreInstance?.date}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${scoreInstance?.inProgress}">
				<li class="fieldcontain">
					<span id="inProgress-label" class="property-label"><g:message code="score.inProgress.label" default="In Progress" /></span>
					
						<span class="property-value" aria-labelledby="inProgress-label"><g:formatBoolean boolean="${scoreInstance?.inProgress}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${scoreInstance?.player}">
				<li class="fieldcontain">
					<span id="player-label" class="property-label"><g:message code="score.player.label" default="Player" /></span>
					
						<span class="property-value" aria-labelledby="player-label"><g:link controller="user" action="show" id="${scoreInstance?.player?.id}">${scoreInstance?.player?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${scoreInstance?.score}">
				<li class="fieldcontain">
					<span id="score-label" class="property-label"><g:message code="score.score.label" default="Score" /></span>
					
						<span class="property-value" aria-labelledby="score-label"><g:fieldValue bean="${scoreInstance}" field="score"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${scoreInstance?.id}" />
					<g:link class="edit" action="edit" id="${scoreInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
