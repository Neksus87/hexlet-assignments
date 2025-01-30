<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Users</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-4">Users</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                @for (user in users.getUsers()) {
                    <tr>
                        <td>@user.getId()</td>
                        <td>@user.getName()</td>
                        <td><a href="/users/@user.getId()" class="btn btn-info">View</a></td>
                    </tr>
                }
            </tbody>
        </table>
    </div>
</body>
</html>
