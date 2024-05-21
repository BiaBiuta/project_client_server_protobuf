package start;

import org.example.*;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/register")
@RestController
@CrossOrigin
public class CompetitionRegisterController {
    private ICompetitionServices serverProtoIml;
    public CompetitionRegisterController(ICompetitionServices serverProtoIml) {
        this.serverProtoIml = serverProtoIml;
    }
    @RequestMapping(method = RequestMethod.PUT)
    public Registration register(@RequestBody Child child, @RequestBody Sample sample) throws CompetitionException {
        return serverProtoIml.registerChild(child, sample);
    }
}
