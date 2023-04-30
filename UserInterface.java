
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Scanner scan;
    private ArrayList<User> user;
    private ArrayList<Messaging> messaging;

    public UserInterface(Scanner scan) {
        this.scan = scan;
        this.user = new ArrayList<>();
        this.messaging = new ArrayList<>();
    }

    public void start() {
        while (true) {
            System.out.println("\t\tWelcome\n->Log In\n->Sing Up\n->Exit");
            String logInSingUp = this.scan.nextLine();
            if (logInSingUp.equalsIgnoreCase("Exit")) {
                break;
            } else if (logInSingUp.equalsIgnoreCase("Log In")) {
                System.out.println("Name and Surname");
                String nameSurname = this.scan.nextLine();
                System.out.println("Password");
                int password = Integer.valueOf(this.scan.nextLine());
                if (searchForUser(nameSurname, password)) {
                    int index = findUserindex(nameSurname);
                    while (true) {
                        System.out.println("->1.Home\n->2.Search\n->3.Post"
                                + "\n->4.Connection Invitations\n->5.Messaging\n->6.Profile\n->7.Exit");
                        int choice = Integer.valueOf(scan.nextLine());
                        if (choice == 7) {
                            System.out.println("See you next time !!!");
                            break;
                        } else if (choice == 1) {
                            home(index);
                        } else if (choice == 2) {
                            search(index);
                        } else if (choice == 3) {
                            post(index);
                        } else if (choice == 4) {
                            connectionInvitations(index);
                        } else if (choice == 5) {
                            messaging(index);
                        } else if (choice == 6) {
                            profile(index);
                        }
                    }
                } else {
                    System.out.println("Your name or password is wrong try again");
                }
            } else if (logInSingUp.equalsIgnoreCase("Sing Up")) {
                singUp();

            }
        }
    }

    public void singUp() {
        System.out.println("Name and Surname");
        String nameSurname = this.scan.nextLine();
        System.out.println("Password");
        int password = Integer.valueOf(this.scan.nextLine());
        this.user.add(new User(nameSurname, password));
        System.out.println("You have successfuly sing up");
    }

    public void home(int index) {
        while (true) {
            this.user.get(index).home();
            System.out.println("Press enter to get back");
            String back = this.scan.nextLine();
            if (back.equalsIgnoreCase("")) {
                break;
            }
        }
    }

    public void search(int index) {
        while (true) {
            System.out.println("Search for users(Press enter to get back):");
            String search = this.scan.nextLine();
            if (search.equals("")) {
                break;
            } else if (searchForUser(search)) {
                int index2 = findUserindex(search);
                System.out.println(this.user.get(index2));
                System.out.println("Connect(Press enter to get back):");
                String choice = this.scan.nextLine();
                if (choice.equalsIgnoreCase("Connect")) {
                    this.user.get(index).addConnections(this.user.get(index2));
                    this.user.get(index).connectionInvitations(this.user.get(index2));
                    System.out.println("Connection request sent successfuly");
                }
            } else {
                System.out.println("No result found");
            }

        }
    }

    public void post(int index) {
        while (true) {
            System.out.println("Start a post(Press enter to get back)");
            String post = this.scan.nextLine();
            if (post.equals("")) {
                break;
            }
            this.user.get(index).newPost(post);
        }
    }

    public void connectionInvitations(int index) {
        if (this.user.get(index).getConnectionInvitations().isEmpty()) {
            System.out.println("No pending invitations");
        } else {
            while (true) {
                if (this.user.get(index).getConnectionInvitations().isEmpty()) {
                    System.out.println("No pending invitations");
                }else{
                    this.user.get(index).printConnectionInvitations();
                }
                    System.out.println("Type the name of the user you want to connect(Press enter to get back)");
                    String name = this.scan.nextLine();
                    if (name.equals("")) {
                        break;
                    } else if (searchForUser(name)) {
                        int index2 = findUserindex(name);
                        this.user.get(index).addConnections(this.user.get(index2));
                        this.user.get(index).removeConnectionInvitations(name);
                        System.out.println("The connection is made sucsesfully");
                    } else {
                        System.out.println("Type the name correctly");
                    }
                
            }
        }
    }


    public void messaging(int index) {
        while (true) {
            System.out.println("Connections List:");
            this.user.get(index).connectionsName();
            System.out.println("Start conversation(Press enter to get back)");
            String choice = this.scan.nextLine();
            if (choice.equals("")) {
                break;
            } else if (searchForUser(choice)) {
                int index2 = findUserindex(choice);
                if (findMessageHisory(this.user.get(index).getName(), this.user.get(index2).getName())) {
                    int index3 = findMessageIndex(this.user.get(index).getName(), this.user.get(index2).getName());
                    this.messaging.get(index3).printMessage();
                    while (true) {
                        System.out.println("Write a messagee (Press enter to get back)");
                        String message = this.scan.nextLine();
                        if (message.equals("")) {
                            break;
                        } else {
                            this.messaging.get(index3).addMessaging(this.user.get(index).getName(), message);
                            this.messaging.get(index3).printMessage();
                        }
                    }
                } else {
                    this.messaging.add(new Messaging(this.user.get(index).getName(), this.user.get(index2).getName()));
                    int index4 = findMessageIndex(this.user.get(index).getName(), this.user.get(index2).getName());
                    while (true) {
                        System.out.println("Write a message (Press enter to get back)");
                        String message = this.scan.nextLine();
                        if (message.equals("")) {
                            break;
                        } else {
                            this.messaging.get(index4).addMessaging(this.user.get(index).getName(), message);
                            this.messaging.get(index4).printMessage();
                        }
                    }
                }
            } else {
                System.out.println("Type the name correctly");
            }
        }
    }

    public void profile(int index) {
        while (true) {
            System.out.println(this.user.get(index));
            System.out.println("Total number of connections: " + this.user.get(index).getConnectionsNumber().size());
            System.out.println("(Press enter to get back)");
            String back = this.scan.nextLine();
            if (back.equals("")) {
                break;
            }
        }
    }

    public int findUserindex(String name) {
        int index = 0;
        for (int i = 0; i < this.user.size(); i++) {
            if (this.user.get(i).getName().equals(name)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean searchForUser(String name, int password) {
        for (User user : this.user) {
            if (user.getName().equals(name)
                    && user.getPassword() == password) {
                return true;
            }
        }
        return false;
    }

    public boolean searchForUser(String name) {
        for (User socialMedia : this.user) {
            if (socialMedia.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean findMessageHisory(String name, String name2) {
        for (Messaging messaging : this.messaging) {
            if (messaging.conversationHistory(name, name2)) {
                return true;
            }
        }
        return false;
    }

    public int findMessageIndex(String name, String name2) {
        int index = 0;
        for (int i = 0; i < this.messaging.size(); i++) {
            if (this.messaging.get(i).conversationHistory(name, name2)) {
                index = i;
            }
        }
        return index;

    }
}
