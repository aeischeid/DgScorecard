<%@ page import="org.dg.Score" %>



<div class="fieldcontain ${hasErrors(bean: scoreInstance, field: 'notes', 'error')} ">
	<label for="notes">
		<g:message code="score.notes.label" default="Notes" />
		
	</label>
	<g:textField name="notes" value="${scoreInstance?.notes}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scoreInstance, field: 'course', 'error')} required">
	<label for="course">
		<g:message code="score.course.label" default="Course" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="course" name="course.id" from="${org.dg.Course.list()}" optionKey="id" required="" value="${scoreInstance?.course?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scoreInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="score.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${scoreInstance?.date}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: scoreInstance, field: 'inProgress', 'error')} ">
	<label for="inProgress">
		<g:message code="score.inProgress.label" default="In Progress" />
		
	</label>
	<g:checkBox name="inProgress" value="${scoreInstance?.inProgress}" />
</div>

<div class="fieldcontain ${hasErrors(bean: scoreInstance, field: 'player', 'error')} required">
	<label for="player">
		<g:message code="score.player.label" default="Player" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="player" name="player.id" from="${org.dg.User.list()}" optionKey="id" required="" value="${scoreInstance?.player?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: scoreInstance, field: 'score', 'error')} required">
	<label for="score">
		<g:message code="score.score.label" default="Score" />
		<span class="required-indicator">*</span>
	</label>
	<g:field type="number" name="score" required="" value="${fieldValue(bean: scoreInstance, field: 'score')}"/>
</div>

