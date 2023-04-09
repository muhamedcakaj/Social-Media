# Social-Media
The UserInterface class contains various methods that handle user actions such as sign up, log in, posting, searching for other users, sending connection invitations, messaging, etc.

The program creates instances of two classes, SocialMedia and Messaging, and stores them in ArrayLists. SocialMedia objects represent user accounts, while Messaging objects represent conversations between users.

The start() method provides the main menu options for the user to log in, sign up, or exit the application. If the user logs in, the program prompts for name and password to check if the user exists in the user ArrayList. If found, the program provides additional menu options for the user to perform various actions. If the user chooses to search for other users, the program prompts for the user's search term and returns a list of matching users. The user can then choose to send a connection invitation to any of the matching users. If the user has pending connection invitations, the program displays them and allows the user to accept or reject them.

The user can also create a new post, view their home feed, and view their profile information. They can also message their connections, and the program shows a history of previous conversations between them.
