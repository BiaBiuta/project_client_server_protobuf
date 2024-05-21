package start;

import org.example.Child;
import org.example.CompetitionException;
import org.example.ICompetitionServices;
import org.example.Sample;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/children")
public class CompetitionChildController {
    private ICompetitionServices serverProtoIml;

    public CompetitionChildController(ICompetitionServices serverProtoIml) {
        this.serverProtoIml = serverProtoIml;
    }

    // Mapare pentru a găsi un copil după nume
    @GetMapping("/child/{name}")
    public Child findOneChild(@PathVariable String name) throws CompetitionException {
        return serverProtoIml.findChild(name);
    }


    // Mapare pentru crearea unui copil (POST în loc de GET)
    @PostMapping("/child")
    public Child createChild(@RequestBody Child child) throws CompetitionException {
        return serverProtoIml.saveChild(child.getName(), child.getAge());
    }

    // Mapare pentru înregistrarea unui copil și un sample
    @PostMapping("/child/register")
    public void registerOneChild(@RequestBody Child child, @RequestBody Sample sample) throws CompetitionException {
        serverProtoIml.registerChild(child, sample);
    }

    // Mapare pentru listarea copiilor pentru un sample
    @GetMapping("/child/sample")
    public List<Child> listChildrenSample(@RequestBody Sample sample) throws CompetitionException {
        return serverProtoIml.listChildrenForSample(sample);
    }
}
