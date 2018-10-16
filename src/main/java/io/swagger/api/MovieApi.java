
package io.swagger.api;

import io.swagger.annotations.*;
import io.swagger.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-10-16T15:03:10.316Z")

@Api(value = "movie", description = "the movie API")
public interface MovieApi {

    @ApiOperation(value = "Add a new movie to the store", nickname = "addMovie", notes = "", authorizations = {
            @Authorization(value = "moviestore_auth", scopes = {
                    @AuthorizationScope(scope = "write:movies", description = "modify movies in your account"),
                    @AuthorizationScope(scope = "read:movies", description = "read your movies")
            })
    }, tags={ "movie", })
    @ApiResponses(value = {
            @ApiResponse(code = 405, message = "Invalid input") })
    @RequestMapping(value = "/movie",
            produces = { "application/xml", "application/json" },
            consumes = { "application/json", "application/xml" },
            method = RequestMethod.POST)
    ResponseEntity<Void> addMovie(@ApiParam(value = "Movie object that needs to be added to the store" ,required=true )  @Valid @RequestBody Movie body);


    @ApiOperation(value = "Deletes a movie", nickname = "deleteMovie", notes = "", authorizations = {
            @Authorization(value = "moviestore_auth", scopes = {
                    @AuthorizationScope(scope = "write:movies", description = "modify movies in your account"),
                    @AuthorizationScope(scope = "read:movies", description = "read your movies")
            })
    }, tags={ "movie", })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Movie not found") })
    @RequestMapping(value = "/movie/{movieId}",
            produces = { "application/xml", "application/json" },
            method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteMovie(@ApiParam(value = "Movie id to delete",required=true) @PathVariable("movieId") Long movieId,@ApiParam(value = "" ) @RequestHeader(value="api_key", required=false) String apiKey);

    @ApiOperation(value = "Find movie by ID", nickname = "getMovieById", notes = "Returns a single movie", response = Movie.class, authorizations = {
            @Authorization(value = "api_key")
    }, tags={ "movie", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Movie.class),
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Movie not found") })
    @RequestMapping(value = "/movie/{movieId}",
            produces = { "application/xml", "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Movie> getMovieById(@ApiParam(value = "ID of movie to return",required=true) @PathVariable("movieId") Long movieId);


    @ApiOperation(value = "Update an existing movie", nickname = "updateMovie", notes = "", authorizations = {
            @Authorization(value = "moviestore_auth", scopes = {
                    @AuthorizationScope(scope = "write:movies", description = "modify movies in your account"),
                    @AuthorizationScope(scope = "read:movies", description = "read your movies")
            })
    }, tags={ "movie", })
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid ID supplied"),
            @ApiResponse(code = 404, message = "Movie not found"),
            @ApiResponse(code = 405, message = "Validation exception") })
    @RequestMapping(value = "/movie",
            produces = { "application/xml", "application/json" },
            consumes = { "application/json", "application/xml" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> updateMovie(@ApiParam(value = "Movie object that needs to be added to the store" ,required=true )  @Valid @RequestBody Movie body);


}
