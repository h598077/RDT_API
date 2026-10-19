package no.master.rdt.controller;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


/**
 * Controller class for REST API
 *
 * @author Biljan
 */
@CrossOrigin
@RestController
public class rdtController {
    /**
     * Get message from DTaaS
     *
     *
     *
     * @return String message
     *
     */
    @GetMapping("/test")
    public String getString() {
        return "Test communication";
    }

    private static final Path SHARED_DIR = Paths.get("/workspace/rdt");


    /**
     * Write to DTaaS
     *
     *
     *
     * @param body
     *
     */
    @PutMapping ("/write")
    public void writeFileToDTaaS(@RequestBody String body) throws IOException {
        //  Spring writes  that Jupyter will see

        Path file = SHARED_DIR.resolve("spring-output.txt");
        Files.writeString(file, body);

    }









}
