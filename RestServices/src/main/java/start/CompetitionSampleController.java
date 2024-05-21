package start;

import org.example.CompetitionException;
import org.example.ICompetitionServices;
import org.example.Sample;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/samples")

public class CompetitionSampleController {
    private ICompetitionServices serverProtoIml;
    public CompetitionSampleController(ICompetitionServices serverProtoIml) {
        this.serverProtoIml = serverProtoIml;
    }

    @GetMapping("/{id}")
    public Sample findSampleById(@PathVariable Integer id) throws CompetitionException {
        return serverProtoIml.findSampleById(id);
    }
    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Sample createSample(@RequestBody Sample sample) throws CompetitionException {
        return serverProtoIml.createSample(sample);
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Sample updateSample(@RequestBody Sample sample) throws CompetitionException {
        return serverProtoIml.updateSample(sample);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Sample deleteSample(@RequestBody Sample sample) throws CompetitionException {
        return serverProtoIml.deleteSample(sample);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Sample> findAllSamples() throws CompetitionException {
        return serverProtoIml.findAllSamples();
    }

    @GetMapping(value = "/{ageCategory}/{desen}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Sample findSample(@PathVariable String ageCategory, @PathVariable String desen) throws CompetitionException {
        return serverProtoIml.findSample(ageCategory, desen);
    }

}
