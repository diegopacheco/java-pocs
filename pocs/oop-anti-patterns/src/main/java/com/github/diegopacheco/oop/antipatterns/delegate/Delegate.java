package com.github.diegopacheco.oop.antipatterns.delegate;

/**
 * Delegate
 *
 * - What are we abstracting here? Nothing.
 * - What are we hiding? Nothing.
 * - What are we encapsulating? Nothing.
 * - What is the point of this?
 *
 */
public class Delegate {

    // consumer
    public class EmailDelegate{
        private EmailSender delegate;

        public EmailDelegate(EmailSender emailSender) {
            this.delegate = emailSender;
        }

        public void sendEmail(String email) {
            delegate.sendEmail(email);
        }
    }

    // provider
    public class EmailSender{
        public void sendEmail(String email) {
            System.out.println("Sending email to: " + email);
            // full logic to send email here
        }
    }

}
