package ng.com.createsoftware.manytomany.controller;

import ng.com.createsoftware.manytomany.dto.request.BookRequestDto;
import ng.com.createsoftware.manytomany.dto.response.BookResponseDto;
import ng.com.createsoftware.manytomany.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/add")
    public ResponseEntity<BookResponseDto> addBook(@RequestBody final BookRequestDto BookRequestDto){
        BookResponseDto bookResponseDto = bookService.addBook(BookRequestDto);
        return  new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<BookResponseDto> getBook(@PathVariable final Long id){
        BookResponseDto bookResponseDto  = bookService.getBookById(id);
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<BookResponseDto>> getBooks(){
        List<BookResponseDto> books = bookService.getBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookResponseDto> deleteBook(@PathVariable final Long id){
        BookResponseDto bookResponseDto = bookService.deleteBook(id);
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<BookResponseDto> editBook(@RequestBody final BookRequestDto bookRequestDto, @PathVariable final Long id){
        BookResponseDto bookResponseDto = bookService.editBook(id,bookRequestDto);
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
    }

    @PostMapping("/addCategory/{categoryId}/to/{bookId}")
    public ResponseEntity<BookResponseDto> addCategory(@PathVariable final Long categoryId, @PathVariable final Long bookId){
        BookResponseDto bookResponseDto = bookService.addCategoryToBook(bookId, categoryId);
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
    }

    @PostMapping("/removeCategory/{categoryId}/from/{bookId}")
    public ResponseEntity<BookResponseDto> removeCategory(@PathVariable final Long categoryId,@PathVariable final Long bookId){
        BookResponseDto bookResponseDto = bookService.removeCategoryFromBook(bookId, categoryId);
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
    }

    @PostMapping("/addAuthor/{authorId}/to/{bookId}")
    public ResponseEntity<BookResponseDto> addAuthor(@PathVariable final Long authorId,@PathVariable final Long bookId){
        BookResponseDto bookResponseDto = bookService.addAuthorToBook(bookId, authorId);
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
    }
    @PostMapping("/addAuthor/{authorId}/from/{bookId}")
    public ResponseEntity<BookResponseDto> removeAuthor(@PathVariable final Long authorId,@PathVariable final Long bookId){
        BookResponseDto bookResponseDto = bookService.deleteAuthorFromBook(bookId, authorId);
        return new ResponseEntity<>(bookResponseDto, HttpStatus.OK);
    }
}
