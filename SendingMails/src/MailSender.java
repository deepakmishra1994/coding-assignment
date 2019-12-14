import java.util.HashSet;
import java.util.Set;

public class MailSender {
    private Set<String> attemptedSet = new HashSet<>();
    public void sendMail(String emailAddress, String message, String[][] friendsArray) {
        for (int row = 0; row < friendsArray.length; row++) {
            for (int col = 0; col < friendsArray[row].length; col++) {
                if(friendsArray[row][col].equals(emailAddress)){
                    attemptedSet.add(friendsArray[row][col]);
                    String[] toEmails = friendsArray[row][col+1].split(",");
                    for(String friendEmail: toEmails)
                        if(!attemptedSet.contains(friendEmail)){
                            sendMail(friendEmail, message, friendsArray);
                            System.out.println("Email sent to: "+friendEmail+" Message: "+message);
                            attemptedSet.add(friendEmail);
                        }
                }
            }
        }
    }
}
