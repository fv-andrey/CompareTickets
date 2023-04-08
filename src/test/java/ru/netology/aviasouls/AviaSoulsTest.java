package ru.netology.aviasouls;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.ticket.Ticket;
import ru.netology.comporator.TicketTimeComparator;

import java.util.Arrays;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Москва", "Владивосток", 32_000, 12_00, 19_30);
    Ticket ticket2 = new Ticket("Москва", "Владивосток", 31_500, 14_10, 21_00);
    Ticket ticket3 = new Ticket("Москва", "Владивосток", 30_150, 18_20, 1_00);
    Ticket ticket4 = new Ticket("Москва", "Владивосток", 29_999, 19_00, 2_40);
    Ticket ticket5 = new Ticket("Москва", "Владивосток", 33_100, 21_40, 4_35);
    Ticket ticket6 = new Ticket("Москва", "Владивосток", 28_850, 23_00, 6_10);
    Ticket ticket7 = new Ticket("Москва", "Владивосток", 27_299, 24_20, 6_50);

    @Test
    public void shouldSortByPriceInCompareToMethod() {

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        Arrays.sort(tickets);

        Ticket[] expected = {ticket7, ticket6, ticket4, ticket3, ticket2, ticket1, ticket5};
        Ticket[] actual = tickets;

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByPriceInSearchMethod() {
        AviaSouls souls = new AviaSouls();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);
        souls.add(ticket7);

        Ticket[] expected = {ticket7, ticket6, ticket4, ticket3, ticket2, ticket1, ticket5};
        Ticket[] actual = souls.search("Москва", "Владивосток");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortByFlightTimeInCompareMethod() {
        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7};
        Arrays.sort(tickets, comparator);

        Ticket[] expected = {ticket7, ticket3, ticket2, ticket5, ticket6, ticket1, ticket4};
        Ticket[] actual = tickets;

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortByFlightTimeInSearchAndSortByMethod() {
        AviaSouls souls = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();

        souls.add(ticket1);
        souls.add(ticket2);
        souls.add(ticket3);
        souls.add(ticket4);
        souls.add(ticket5);
        souls.add(ticket6);
        souls.add(ticket7);

        Ticket[] expected = {ticket7, ticket3, ticket2, ticket5, ticket6, ticket1, ticket4};
        Ticket[] actual = souls.searchAndSortBy("Москва", "Владивосток", comparator);

        Assertions.assertArrayEquals(expected, actual);
    }
}
