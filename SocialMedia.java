
import java.util.ArrayList;

public class SocialMedia {

    private String name;
    private int password;
    private ArrayList<String> post;
    private ArrayList<SocialMedia> connections;
    private ArrayList<String> connectionInvitations;

    public SocialMedia(String name, int password) {
        this.name = name;
        this.password = password;
        this.post = new ArrayList<>();
        this.connectionInvitations = new ArrayList<>();
        this.connections = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getPassword() {
        return this.password;
    }

    public ArrayList<String> getConnectionInvitations() {
        return this.connectionInvitations;
    }

    public ArrayList<SocialMedia> getConnectionsNumber() {
        return this.connections;
    }

    public void connectionsName() {
        for (SocialMedia connections : this.connections) {
            System.out.println("*" + connections.getName());
        }
    }

    public void addConnections(SocialMedia user) {
        this.connections.add(user);
    }

    public void home() {
        if (this.connections.isEmpty()) {
            System.out.println("Nothing to show on feed");
        } else {
            for (SocialMedia connections : this.connections) {
                System.out.println(connections);
            }
        }
    }

    public void newPost(String post) {
        this.post.add(post);
    }

    public void connectionInvitations(SocialMedia user) {
        String invitation = "*" + this.name + " has sent a invitation for connection";
        user.connectionInvitations.add(invitation);
    }

    public void printConnectionInvitations() {
        for (String invitations : this.connectionInvitations) {
            System.out.println(invitations);
        }
    }

    public String toString() {
        String posts = "";
        for (String post : this.post) {
            posts += "#" + this.name + "\n" + post + "\n";
        }
        return posts;
    }
}
