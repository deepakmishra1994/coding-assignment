public class SendingMail {
    public static  void main(String[] args) {
        String[][] emails = {
                {"rahul@test.com", "rajat@test.com,rashmi@test.com,vinod@test.com"},
                {"vineet@test.com", "ajay@test.com,rajat@test.com,rahul@test.com"},
                {"vinod@test.com", "rahul@test.com,nitin@test.com,vineet@test.com"}
        };
        new MailSender().sendMail("rahul@test.com","Hi All, This is a message from Rahul ", emails);
        System.out.println();
        new MailSender().sendMail("vineet@test.com","Hi All, This is a message from Vineet ", emails);
        System.out.println();
        new MailSender().sendMail("vinod@test.com","Hi All, This is a message from Vinod ", emails);
    }
}
