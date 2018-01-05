import java.util.LinkedList;
import java.util.List;

class BMISummary {
  LinkedList<String> under;
  LinkedList<String> healthy;
  LinkedList<String> over;
  LinkedList<String> obese;
  
  BMISummary(LinkedList<String> under,
             LinkedList<String> healthy,
             LinkedList<String> over,
             LinkedList<String> obese) {
    this.under = under;
    this.healthy = healthy;
    this.over = over;
    this.obese = obese;
  }
}