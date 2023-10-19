import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class HuvudProgram {
    public static void main(String[] args) {
        Receptionist receptionist = new Receptionist();
        List<Member> members = receptionist.loadMembersFromFile();

        System.out.print("Skriv in namn eller personnummer: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        Member foundMember = null;
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(input) || member.getPersonNummer().equals(input)) {
                foundMember = member;
                break;
            }
        }
        if (foundMember == null) {
            System.out.println("Obehörig person");
        } else {
            if (foundMember.getDate().isAfter(LocalDate.now().minusYears(1))) {
                receptionist.saveMemberToFile(foundMember, "src/PTfil.txt");
            } else {
                receptionist.saveMemberToFile(foundMember, "src/ExMembers.txt");
            }
        }
    }
}