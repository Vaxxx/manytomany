package ng.com.createsoftware.manytomany.service;

import ng.com.createsoftware.manytomany.dto.request.AuthorRequestDto;
import ng.com.createsoftware.manytomany.dto.response.AuthorResponseDto;
import ng.com.createsoftware.manytomany.model.Author;

import java.util.List;

public interface AuthorService {

    AuthorResponseDto addAuthor(AuthorRequestDto authorRequestDto);

    List<AuthorResponseDto> getAuthors();

    AuthorResponseDto getAuthorById(Long authorId);

    Author getAuthor(Long authorId);

    AuthorResponseDto deleteAuthor(Long authorId);

    AuthorResponseDto editAuthor(Long authorId, AuthorRequestDto authorRequestDto);

    AuthorResponseDto addZipcodeToAuthor(Long authorId, Long zipcodeId);

    public AuthorResponseDto deleteZipcodeFromAuthor(Long authorId);
}
