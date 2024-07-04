package com.example.reactive;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
public class BookControllerMockitoTest {

    @Mock
    private BookService bookService;

    @InjectMocks
    BookController bookController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findBookByIdOk() {
        var book = Book.builder().id(1).title("test title 1").description("test description 1").build();
        log.info("book: {}", book);

        when(bookService.findById(anyInt())).thenReturn(Mono.just(book));

        Mono<ResponseEntity<Book>> response = bookController.getBookById(1);
        response.subscribe(
                value -> {
                    var existBook = value.getBody();
                    log.info("exist book={}", existBook);
                    assertTrue(book.getId() == existBook.getId());
                    assertEquals(book.getTitle(), existBook.getTitle());
                });
    }

    @Test
    void findBookByIdErrorNotFound() {
        var book = Book.builder().id(1)
                .title("buku 1")
                .description("deskripsi dari buku pertama")
                .build();

        when(bookService.findById(anyInt())).thenReturn(
                Mono.error(new BookNotFoundException(String.format("Book not found ID:%s ", book.getId()))));

        Mono<ResponseEntity<Book>> response = bookController.getBookById(2);
        response.subscribe(
                value -> {
                    log.info("response={}", value);
                    assertTrue(value.getStatusCode().is4xxClientError());
                    assertTrue(value.getBody() == null);
                });
    }

    @Test
    void findAllBookOk() {
        var book1 = Book.builder()
                .id(1)
                .title("Judul buku pertama")
                .description("Deskripsi buku pertama")
                .build();
        var book2 = Book.builder()
                .id(2)
                .title("Judul buku kedua")
                .description("Deskripsi buku kedua")
                .build();

        when(bookService.findAll()).thenReturn(Flux.just(book1, book2));

        Flux<Book> response = bookController.getAllBooks(null);
        response.subscribe(
            value -> {
                log.info("response={}", value);
                // check the size
                assertEquals(2, value.getTitle());
            }
        );
    }
}