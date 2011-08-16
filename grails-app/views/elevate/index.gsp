<html>
    <head>
        <title>Elevators demo app</title>
    </head>
    <body>

        <h1>Elevators demo app</h1>

        <g:if test="${elevators.size() > 0}">
        <table border="1">
        <tr>
            <th>Elevator</th>
            <th>Current floor</th>
            <th colspan="2">Options</th>
        </tr>
        <g:each var="elevator" in="${elevators}">
        <tr>
            <td>${elevator}</td>
            <td>${elevator.prettyState()}</td>
            <td>
                <!-- only valid transitions will be rendered as links -->
                <g:each var="nextState" in="${elevator._states.keySet()}">
                <gestate:change model="${elevator}" to="${nextState}" 
                    controller="elevate" action="move" id="${elevator.id}" params="${[to: nextState]}" />
                </g:each>
            </td>
            <td>
                <g:link action="delete" id="${elevator.id}">delete elevator</g:link>
            </td>
        </tr>
        </g:each>
        </table>
        </g:if>
        <g:else>
            Please create a new elevator to start.
        </g:else>
        
        <hr>
        
        <g:link controller="elevate" action="create">Create new elevator</g:link>

    </body>
</html>
