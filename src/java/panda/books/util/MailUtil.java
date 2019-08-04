package panda.books.util;

import java.util.Map;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import panda.books.business.Book;
import panda.books.business.Customer;

/**
 *
 * @author Beverly Jean-Baptiste
 * 
 * Johns Hopkins University
 * Web Application Development with Java
 * Group project
 */
public class MailUtil {
    public static void sendMail(String to, String from,
            String subject, String body, boolean bodyIsHTML)
            throws MessagingException {
        
        // 1 - get a mail session
        Properties props = new Properties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", 465);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.quitwait", "false");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(true);

        // 2 - create a message
        Message message = new MimeMessage(session);
        message.setSubject(subject);
        if (bodyIsHTML) {
            message.setContent(body, "text/html");
        } else {
            message.setText(body);
        }

        // 3 - address the message
        Address fromAddress = new InternetAddress(from);
        Address toAddress = new InternetAddress(to);
        message.setFrom(fromAddress);
        message.setRecipient(Message.RecipientType.TO, toAddress);

        // 4 - send the message
        Transport transport = session.getTransport();
        transport.connect("javaweb2019@gmail.com", "webDevJava");
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
    
    public static String buildCheckoutMessage(Customer customer) {
        StringBuilder html = new StringBuilder();
        html.append("<h1 style=\"text-align: center\">Order Confirmation</h1><p>");
        html.append(customer.getFirstName());
        html.append(", your order has been placed. Here are the details of your order</p>");
        for (Map.Entry mapElement : customer.getOrder().getItems().entrySet()) {
            Book book = (Book) mapElement.getKey();
            double price = (int) mapElement.getValue() * book.getPrice();
            html.append("<tr><td>");
            html.append(book.getTitle());
            html.append("</td>");
            html.append("<td>");
            html.append(price);
            html.append("</td></tr>");
        }
        
        html.append("<tr><td>Total</td><td>");
        html.append(customer.getOrder().getTotalCost());
        html.append("</td></tr></table>");
        return html.toString();
    }
    
    public static String buildRegistrationMessage(Customer customer) {
        StringBuilder html = new StringBuilder();
        html.append("<h1 style=\"text-align: center\">Panda Books Registration</h1><p>");
        html.append(customer.getFirstName());
        html.append(", Thank you for registering with Panda Books.</p>");
        html.append("<p>Below is your login information<br/>Username: ");
        html.append(customer.getUserName());
        html.append("<br>Password: ");
        html.append(customer.getPassword());
        html.append("</p>");
        return html.toString();
    }
}
