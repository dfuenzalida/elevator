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
                <g:each var="nextState" in="${elevator._states.keySet()}">
                <gestate:change model="${elevator}" to="${nextState}" 
                    controller="elevate" action="move" id="${elevator.id}" params="${[to: nextState]}" />
                </g:each>
            </td>
            <td>
                <a href="delete/${elevator.id}">delete elevator</a>
            </td>
        </tr>
        </g:each>
        </table>
        </g:if>
        <g:else>
            Please create a new elevator to start.
        </g:else>
        
        <hr>
        
        <a href="create">Create new elevator</a>

    </body>
</html>
