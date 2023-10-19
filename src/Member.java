import java.time.LocalDate;

public class Member {
    private String name;
    private String personNummer;
    private LocalDate date;
    public Member(String name, String personNummer,LocalDate date){
        this.name = name;
        this.personNummer = personNummer;
        this.date = date;

    }

    public String getName() {
        return name;
    }

    public String getPersonNummer() {
        return personNummer;
    }

    public LocalDate getDate() {
        return date;
    }

}
