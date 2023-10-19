import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Receptionist {


    public List<Member> loadMembersFromFile() {
            List<Member> members = new ArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/Customers.txt"))) {
            String file;
            while ((file = reader.readLine()) != null) {
                String[] parts = file.split(", ");
                String personNummer = parts[0].trim();
                String name = parts[1].trim();
                LocalDate paymentDate = LocalDate.parse(reader.readLine().trim());

                members.add(new Member(name, personNummer, paymentDate));
            }
        } catch (IOException e) {
            System.out.println("Kunde inte läsa filen");
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("Okänt fel");
        }
        return members;

    }
    public void saveMemberToFile(Member member, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename,true))) {
            writer.write(member.getPersonNummer() + ", " + member.getName());
            writer.newLine();
            writer.write(LocalDate.now().toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Kunde inte skriva till filen");
            e.printStackTrace();
        }
        catch (Exception e){
            System.out.println("Okänt fel");
            e.printStackTrace();
        }
    }
    }

