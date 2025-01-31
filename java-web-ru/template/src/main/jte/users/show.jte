<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Details</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>User Details</h1>
    <div class="card">
        <div class="card-body">
            <h5 class="card-title">@userPage.getUser().getFirstName() @userPage.getUser().getLastName()</h5>
            <p class="card-text"><strong>ID:</strong> @userPage.getUser().getId()</p>
            <p class="card-text"><strong>Email:</strong> @userPage.getUser().getEmail()</p>
            <a href="/users" class="btn btn-primary">Back to list</a>
        </div>
    </div>
</div>
</body>
</html>
