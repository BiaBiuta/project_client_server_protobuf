package start;

import org.example.CompetitionException;
import org.example.ICompetitionServices;
import org.example.Organizing;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/organizings")

public class CompetitionOrganizingController {
    private ICompetitionServices serverProtoIml;

    public CompetitionOrganizingController(ICompetitionServices serverProtoIml) {
        this.serverProtoIml = serverProtoIml;
    }
    @GetMapping("/{username}/{password}")
    public Organizing findOrganizing(@PathVariable String username, @PathVariable String password) throws CompetitionException, CompetitionException {
        return serverProtoIml.findOrganizing(username, password);
    }
    @PostMapping("/login")
    public Organizing login(@RequestBody Organizing org) throws CompetitionException {
        return serverProtoIml.login(org, null);
    }
    @PostMapping("/logout")
    public void logout(@RequestBody Organizing org) throws CompetitionException {
        serverProtoIml.logout(org, null);
    }



}
