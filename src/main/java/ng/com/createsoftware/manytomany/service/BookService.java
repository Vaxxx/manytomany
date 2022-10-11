package ng.com.createsoftware.manytomany.service;

import ng.com.createsoftware.manytomany.dto.request.BookRequestDto;
import ng.com.createsoftware.manytomany.dto.response.BookResponseDto;
import ng.com.createsoftware.manytomany.model.Book;

import java.util.List;

public interface BookService {

    BookResponseDto addBook(BookRequestDto bookRequestDto);

    BookResponseDto getBookById(Long bookId);

    Book getBook(Long bookId);

    List<BookResponseDto> getBooks();

    BookResponseDto deleteBook(Long bookId);

     BookResponseDto editBook(Long bookId, BookRequestDto bookRequestDto);

     BookResponseDto addAuthorToBook(Long bookId, Long authorId);

     BookResponseDto deleteAuthorFromBook(Long bookId, Long authorId);

     BookResponseDto addCategoryToBook(Long bookId, Long categoryId);

     BookResponseDto  removeCategoryFromBook(Long bookId, Long categoryId);


}
