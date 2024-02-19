package com.firstapp.springwebapp.bootstraper;

import com.firstapp.springwebapp.domain.Author;
import com.firstapp.springwebapp.domain.Books;
import com.firstapp.springwebapp.domain.Publisher;
import com.firstapp.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.firstapp.springwebapp.repositories.AuthorRepository;
import com.firstapp.springwebapp.repositories.BookRepository;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PublisherRepository publisherRepository;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(PublisherRepository publisherRepository, AuthorRepository authorRepository, BookRepository bookRepository) {
        this.publisherRepository = publisherRepository;
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        Publisher publisher1 = new Publisher();
        Publisher publisher2 = new Publisher();
        Publisher publisher3 = new Publisher();
        Publisher publisher4 = new Publisher();
        Publisher publisher5 = new Publisher();
        publisher1.setName("nemira");
        publisher1.setAddress("Cali");
        publisher2.setName("rao");
        publisher2.setAddress("Buch");
        publisher3.setName("top100");
        publisher3.setAddress("Pari");
        publisher4.setName("litera");
        publisher4.setAddress("Barc");
        publisher5.setName("polirom");
        publisher5.setAddress("Port");
        publisherRepository.save(publisher1);
        publisherRepository.save(publisher2);
        publisherRepository.save(publisher3);
        publisherRepository.save(publisher4);
        publisherRepository.save(publisher5);

        Author author1 = new Author("Eric", "Evans");
        Books book1 = new Books("Domain Driven Design", "fg347gs");
        Books book2 = new Books("Latest crime", "gwg463g");
        Books book3 = new Books("Mermaids", "gh531hn");
        publisher1.getBooks().add(book1);
        book1.setPublisher(publisher1);
        book1.getAuthors().add(author1);
        author1.getBooks().add(book1);

        publisher2.getBooks().add(book2);
        book2.setPublisher(publisher2);
        book2.getAuthors().add(author1);
        author1.getBooks().add(book2);

        publisher2.getBooks().add(book3);
        book3.setPublisher(publisher2);
        book3.getAuthors().add(author1);
        author1.getBooks().add(book3);


        authorRepository.save(author1);
        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);

        Author author2 = new Author("John", "Newman");
        Books book4 = new Books("Last ship", "fjs352n");
        Books book5 = new Books("Last ship v2", "gt52gsb");
        Author author3 = new Author("Alex", "Oldman");
        Books book6 = new Books("Ove hombre", "fjg352n");
        Author author4 = new Author("Elsa", "Rosalia");
        Books book7 = new Books("Newland", "fjs3532s");

        publisher1.getBooks().add(book4);
        publisher1.getBooks().add(book5);
        book4.getAuthors().add(author2);
        book5.getAuthors().add(author2);
        book4.setPublisher(publisher1);
        book5.setPublisher(publisher1);
        author2.getBooks().add(book4);
        author2.getBooks().add(book5);

        publisher3.getBooks().add(book6);
        book6.getAuthors().add(author3);
        book6.setPublisher(publisher3);
        author3.getBooks().add(book6);

        publisher4.getBooks().add(book7);
        author4.getBooks().add(book7);
        book7.setPublisher(publisher4);
        book7.getAuthors().add(author4);

        authorRepository.save(author2);
        bookRepository.save(book4);
        bookRepository.save(book5);
        authorRepository.save(author3);
        bookRepository.save(book6);
        authorRepository.save(author4);
        bookRepository.save(book7);

        System.out.println("Started in Bootstrap ");
        System.out.println("Number of authors " + authorRepository.count());
        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Books book1 " + book1.toString());
        System.out.println("Books book4 " + book4.toString());
        for (Publisher publisher: publisherRepository.findAll()) {

            System.out.println("Number of " + publisher.getBooks().stream().count() + " book(s) added to the publisher " + publisher.getName());
        }

        System.out.println("Number of publishers " + publisherRepository.count());






    }


}
