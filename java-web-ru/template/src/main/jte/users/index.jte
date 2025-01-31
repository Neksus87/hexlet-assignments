<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users List</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Users List</h1>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            @for (user : usersPage.getUsers()) {
                <tr>
                    <td>@user.getId()</td>
                    <td>@user.getFirstName() @user.getLastName()</td>
                    <td>@user.getEmail()</td>
                    <td><a href="/users/@user.getId()">View</a></td>
                </tr>
            }
        </tbody>
    </table>
</div>
</body>
</html>
