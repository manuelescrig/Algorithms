import java.util.*;
import java.lang.*;
import java.io.*;

/*
Implement a ticket system with queues.
*/

public class LinkedListGetMinPriority {

  public static class Ticket {
    String description;
    int priority;
    public Ticket(String description, int priority) {
      this.description = description;
      this.priority = priority;
    }
  }

  public static class TicketSystem {
    LinkedList<Ticket> queue = new LinkedList<Ticket>();
    LinkedList<Ticket> sorted = new LinkedList<Ticket>();

    public TicketSystem() {}

    public void add(String description, int priority) {
      Ticket ticket = new Ticket(description, priority);
      queue.add(ticket);
      if (sorted.isEmpty()) {
        sorted.add(ticket);
      } else {
        for (int i = 0; i < sorted.size(); i++) {
          Ticket t = sorted.get(i);
          if (t.priority > ticket.priority) {
            sorted.add(i, ticket);
            return;
          }
        }
        sorted.addLast(ticket);
      }
    }

    public Ticket getRegularTicket() {
      if (queue.isEmpty()) return null;
      Ticket ticket = queue.remove();
      sorted.remove(ticket);
      return ticket;
    }

    public Ticket getMinPriorityTicket() {
      if (queue.isEmpty()) return null;
      Ticket ticket = sorted.remove();
      queue.remove(ticket);
      return ticket;
    }
  }

  public static void main(String args[]) {
    TicketSystem tickets = new TicketSystem();
    tickets.add("Ticket 1", 5);
    tickets.add("Ticket 2", 4);
    tickets.add("Ticket 3", 3);
    tickets.add("Ticket 4", 6);
    tickets.add("Ticket 5", 7);
    tickets.add("Ticket 6", 8);
    tickets.add("Ticket 7", 2);
    System.out.println(tickets.getRegularTicket().description); // 1
    System.out.println(tickets.getRegularTicket().description); // 2
    System.out.println(tickets.getMinPriorityTicket().description); // 7
    System.out.println(tickets.getMinPriorityTicket().description); // 3
    System.out.println(tickets.getRegularTicket().description); // 4
    System.out.println(tickets.getMinPriorityTicket().description); // 5
    System.out.println(tickets.getMinPriorityTicket().description); // 6

  }
}
