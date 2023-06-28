# VibeVerse

Some imp points till now:
End points for the Sign In and Sign Up  ### REST API


POST Requests

/signUp  ->  For making the account of the user.

data structure recieved will be of json format.
format -

{
	"phoneNumber": "User phoneNumber",
	"userName": "Username",
	"password": "Password"
}

/signIn  ->  For logging In

format -

{
	"phoneNumber": "User phoneNumber",
	"password": "password"
}

PUT Requests

/update-info/{phoneNumber}        ->   For updating the Info of the user.

format -

{
	"phoneNumber": "User phoneNumber",
	"userName": "Username",
	"password": "Password",
	"oldpassword": "Old Password"
}

/change-password/{phoneNumber}    ->   For updating the Password.

format -

{
	"oldPassword": "Old Password",
	"newPassword": "New Password"
}

DELETE Request

/delete/{phoneNumber}             ->   For deleting the account.

format -

"Directly Type your Password"
