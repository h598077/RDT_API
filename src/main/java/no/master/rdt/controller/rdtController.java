package no.master.rdt.controller;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * Controller class for REST API
 *
 * @author Biljan
 */
@CrossOrigin
@RestController
public class rdtController {


    private static final Path SHARED_DIR = Paths.get("/workspace/rdt");


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


        Path file = SHARED_DIR.resolve("spring-output.txt");
        Files.writeString(file, body);

    }


    /**
     * Get all filenames from DTaaS
     *
     *
     *
     * @return String filenames
     *
     */
    @GetMapping("/names")
    public String getFileNames() throws IOException {

        List<String> fileNames;
        try (var paths = Files.list(SHARED_DIR)) {
            fileNames = paths
                    .map(path -> path.getFileName().toString())
                    .collect(Collectors.toList());
        }


        return String.join(",", fileNames);
    }








}
