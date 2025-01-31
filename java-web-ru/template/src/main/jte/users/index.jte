@import exercise.dto.users.UsersPage
@param UsersPage page
<html>
    <head>
        <title>Хекслет</title>
    </head>
    <body>
        @if(page.getUsers().isEmpty())
            <p>Пока не добавлено ни одного user</p>
        @else
            @for(var user : page.getUsers())
               <div>
                   <p>${user.getFirstName()}</p>
                   <p>${user.getLastName()}</p>
               </div>
            @endfor
        @endif
    </body>
</html>
