package guru.springframework.spring5WebApp.bootstrap;

import guru.springframework.spring5WebApp.domain.Author;
import guru.springframework.spring5WebApp.domain.Book;
import guru.springframework.spring5WebApp.domain.Publisher;
import guru.springframework.spring5WebApp.repositories.AuthorRepository;
import guru.springframework.spring5WebApp.repositories.BookRepository;
import guru.springframework.spring5WebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("Toarch");
        publisher.setCity("Moscow");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        Author king = new Author("Steven", "King");
        Book darkTower = new Book("The Dark Tower", "111111");
        king.getBooks().add(darkTower);
        darkTower.getAuthors().add(king);

        darkTower.setPublisher(publisher);
        publisher.getBooks().add(darkTower);

        authorRepository.save(king);
        bookRepository.save(darkTower);
        publisherRepository.save(publisher);

        Author hemingue = new Author("Ernest", "Hemingue");
        Book oldManAndSea = new Book("The old man and sea", "222222");
        hemingue.getBooks().add(oldManAndSea);
        oldManAndSea.getAuthors().add(hemingue);

        oldManAndSea.setPublisher(publisher);
        publisher.getBooks().add(oldManAndSea);

        authorRepository.save(hemingue);
        bookRepository.save(oldManAndSea);
        publisherRepository.save(publisher);

        System.out.println("Spring app initialized");
        System.out.println("Books in repository: " + bookRepository.count());
        System.out.println("Publisher books amount: " + publisher.getBooks().size());
    }
}
