import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReceptionistTest {

    @Test
    void loadMembersFromFile() {
        Receptionist receptionist = new Receptionist();
        List<Member> members = receptionist.loadMembersFromFile();

        Member member = members.get(0);
        assertEquals("Alhambra Aromes",member.getName());
        assertEquals("7703021234",member.getPersonNummer());
        assertNotEquals("11111111",member.getPersonNummer());
        assertNotEquals("Martin Gripenstedt",member.getPersonNummer());


    }
}