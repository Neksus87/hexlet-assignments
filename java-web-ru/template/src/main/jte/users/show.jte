<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1 class="mt-4">User Details</h1>
        <div>
            <h2>@user.getUser().getName()</h2>
            <p>ID: @user.getUser().getId()</p>
            <a href="/users" class="btn btn-back">Back to list</a>
        </div>
    </div>
</body>
</html>
