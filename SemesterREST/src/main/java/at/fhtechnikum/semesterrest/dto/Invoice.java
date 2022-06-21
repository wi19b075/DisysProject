package at.fhtechnikum.semesterrest.dto;

import java.util.List;

public class Invoice {
    public int customerId;
    public String customerInfo;
    public List<Charging> chargings; // Es ist die Frage, ob die Liste mit den Ladevorgängen überhaupt hier gespeichert werden soll

    public Invoice(int customerId) {
        this.customerId = customerId;
        // und jetzt muss irgendwie die Info aus der Datenbank in das Invoice
    }

}
