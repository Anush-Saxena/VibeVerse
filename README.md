# VibeVerse
## REST API


End points for the Sign In and Sign Up  

### POST Requests

#### /signUp  ->  For making the account of the user.

data structure recieved will be of json format.
format -

{
    "phoneNumber": "phoneNumber",
    "userName": "user name",
    "name": "Account holder's name",
    "dateOfBirth": "19/12/1002",
    "password": "Password"
}

#### /signIn  ->  For logging In

format -
#any one field can be given out of userName and phoneNumber
{
	"phoneNumber": "User phoneNumber",
 	"userName": "user name",
	"password": "password"
}

### PUT Requests

#### /update-info        ->   For updating the Info of the user.

format -

{
    "phoneNumber": "phoneNumber if you want to update",
    "userName": "user name",
    "name": "your name",
    "dateOfBirth": "19/12/1002",
    "password": "Password",
    "oldPassword": "Password"
}

#### /change-password   ->   For updating the Password.

format -

{
	"oldPassword": "Old Password",
	"newPassword": "New Password"
}

### DELETE Request

#### /delete             ->   For deleting the account.

format -

"Directly Type your Password"

#### /signOut            -> For Signing Out.

*No Format Required.*
