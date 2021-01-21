<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
</head>
<body>
<h1>CDA</h1>
<h2>Liste des switchs</h2>
<table class="table">
    <thead>
    <tr>
        <th>name</th>
        <th>fullName</th>
        <th>ip</th>
        <th>parent</th>
        <th>action</th>
    </tr>
    </thead>
    <tbody>
    <#list switchs as switch>
        <tr>
            <td>${switch.name}</td>
            <td>${switch.fullName}</td>
            <td>${switch.ip}</td>
            <td>${switch.parent}</td>
            <td><form method="post" action="/nagios">
                    <input type="hidden" name="name" value="${switch.name}">
                    <input type="hidden" name="fullName" value="${switch.fullName}">
                    <input type="hidden" name="ip" value="${switch.ip}">
                    <input type="hidden" name="parent" value="${switch.parent}">
                    <input type="submit" value="get Cfg">
                </form></td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>
