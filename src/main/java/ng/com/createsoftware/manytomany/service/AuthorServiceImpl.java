package ng.com.createsoftware.manytomany.service;

import ng.com.createsoftware.manytomany.dto.Mapper;
import ng.com.createsoftware.manytomany.dto.request.AuthorRequestDto;
import ng.com.createsoftware.manytomany.dto.response.AuthorResponseDto;
import ng.com.createsoftware.manytomany.model.Author;
import ng.com.createsoftware.manytomany.model.Zipcode;
import ng.com.createsoftware.manytomany.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AuthorServiceImpl implements   AuthorService{

    private final AuthorRepository authorRepository;
    private final ZipcodeService zipcodeService;

    public AuthorServiceImpl(AuthorRepository authorRepository, ZipcodeService zipcodeService) {
        this.authorRepository = authorRepository;
        this.zipcodeService = zipcodeService;
    }

    @Override
    public AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto) {
         Author author = new Author();
         author.setName(authorRequestDto.getName());
         if(authorRequestDto.getZipcodeId() == 0)
             throw new IllegalArgumentException("Author needs a zipcode");
         Zipcode zipcode = zipcodeService.getZipcode(authorRequestDto.getZipcodeId());
         author.setZipcode(zipcode);
         authorRepository.save(author);
         return Mapper.authorToAuthorResponseDto(author);
    }

    @Override
    public List<AuthorResponseDto> getAuthors() {
       List<Author> authors = StreamSupport
               .stream(authorRepository.findAll().spliterator(), false)
               .collect(Collectors.toList());
       return Mapper.authorsToAuthorResponseDtos(authors);
    }

    @Override
    public AuthorResponseDto getAuthorById(Long authorId) {
        return Mapper.authorToAuthorResponseDto(getAuthor(authorId));
    }

    @Override
    public Author getAuthor(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow(() ->
                new IllegalArgumentException("Author with Id: " + authorId + " could not be found"));


    }

    @Override
    public AuthorResponseDto deleteAuthor(Long authorId) {
         Author author = getAuthor(authorId);
         authorRepository.delete(author);
         return  Mapper.authorToAuthorResponseDto(author);
    }

    @Transactional
    @Override
    public AuthorResponseDto editAuthor(Long authorId, AuthorRequestDto authorRequestDto) {
        Author authorToEdit = getAuthor(authorId);
        authorToEdit.setName(authorRequestDto.getName());
        if(authorRequestDto.getZipcodeId() != 0){
            Zipcode zipcode = zipcodeService.getZipcode(authorRequestDto.getZipcodeId());
            authorToEdit.setZipcode(zipcode);
        }
        return Mapper.authorToAuthorResponseDto(authorToEdit);
    }

    @Transactional
    @Override
    public AuthorResponseDto addZipcodeToAuthor(Long authorId, Long zipcodeId) {
         Author author = getAuthor(authorId);
         Zipcode zipcode = zipcodeService.getZipcode(zipcodeId);
         if(Objects.nonNull(author.getZipcode()))
             throw new IllegalArgumentException("Author already has a zipcode");
         return Mapper.authorToAuthorResponseDto(author);
    }

    @Override
    public AuthorResponseDto deleteZipcodeFromAuthor(Long authorId) {
        Author author = getAuthor(authorId);
        author.setZipcode(null);
        return Mapper.authorToAuthorResponseDto(author);
    }
}
