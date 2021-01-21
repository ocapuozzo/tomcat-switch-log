<!DOCTYPE html>
<html>
<head>
    <title>Servlet Lifecycle</title>
</head>
<body><h1>Todos</h1>
<h2>Global</h2>
<ul>
    <#list todos as todo>
        <li>${todo}</li>
    </#list>
</ul>
<h2>Session</h2>
<ul>

    <#list todoSession as todo>
        <li>${todo}</li>
    </#list>
</ul>
<h1>Ajouter une tache</h1>

<form action="/todoft/affiche" method="post">
    <div>
        <label for="afaire">Todo :</label>
        <input type="text" id="afaire" name="afaire">
    </div>
    <button type="submit">Ajouter</button>
    <div>
        <input type="checkbox" id="globals" name="global" value="globals">
        <label for="globals">global</label>
    </div>

</form>


</body>
</html>