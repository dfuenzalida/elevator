<html>
<body>

<h1>Hello</h1>

State = ${elevator.state}

<gestate:change model="${elevator}" to="second" controller="elevate" action="index" />

<hr>

Unexistent state:
<gestate:change model="${elevator}" to="xxxyyyzzz" controller="elevate" action="index" />

<hr>

State not allowed:
<gestate:change model="${elevator}" to="fourth" controller="elevate" action="index" />


</body>
</html>
