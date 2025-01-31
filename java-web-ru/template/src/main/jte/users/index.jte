@users: List<exercise.model.User>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User List</title>
</head>
<body>
<h1>User List</h1>
<table>
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    @for(user in users) {
        <tr>
            <td>@user.id</td>
            <td>@user.firstName</td>
            <td>@user.lastName</td>
            <td>@user.email</td>
            <td><a href="/users/@user.id">View</a></td>
        </tr>
    }
</table>
</body>
</html>
