package ng.com.createsoftware.manytomany.controller;

import ng.com.createsoftware.manytomany.dto.request.AuthorRequestDto;
import ng.com.createsoftware.manytomany.dto.request.ZipcodeRequestDto;
import ng.com.createsoftware.manytomany.dto.response.AuthorResponseDto;
import ng.com.createsoftware.manytomany.model.Author;
import ng.com.createsoftware.manytomany.model.Zipcode;
import ng.com.createsoftware.manytomany.repository.AuthorRepository;
import ng.com.createsoftware.manytomany.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/add")
     public ResponseEntity<AuthorResponseDto> addAuthor(@RequestBody final AuthorRequestDto authorRequestDto){
        AuthorResponseDto authorResponseDto = authorService.addAuthor(authorRequestDto);
        return  new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthor(@PathVariable final Long id){
        AuthorResponseDto authorResponseDto  = authorService.getAuthorById(id);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<AuthorResponseDto>> getAuthors(){
        List<AuthorResponseDto> authors = authorService.getAuthors();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<AuthorResponseDto> deleteAuthor(@PathVariable final Long id){
        AuthorResponseDto authorResponseDto = authorService.deleteAuthor(id);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<AuthorResponseDto> editAuthor(@RequestBody final AuthorRequestDto authorRequestDto, @PathVariable final Long id){
        AuthorResponseDto authorResponseDto = authorService.editAuthor(id,authorRequestDto);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

    @PostMapping("/addZipcode/{zipcodeId}/to/{authorId}")
    public ResponseEntity<AuthorResponseDto> addZipcode(@PathVariable final Long zipcodeId, @PathVariable final Long authorId){
        AuthorResponseDto authorResponseDto = authorService.addZipcodeToAuthor(zipcodeId, authorId);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

    @PostMapping("/removeZipcode/{zipcodeId}")
    public ResponseEntity<AuthorResponseDto> removeZipcode(@PathVariable final Long zipcodeId){
        AuthorResponseDto authorResponseDto = authorService.deleteZipcodeFromAuthor(zipcodeId);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }
}
