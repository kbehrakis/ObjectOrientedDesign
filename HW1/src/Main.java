import tester.*;

public class Main {
  static Examples E = new Examples () ;

  public static void main(String[] args) {
    
    /* 
     These are all nonsense calls just designed to check that
     the correct class and interface names are defined and
     that methods have the expected input and output types.
     These are not checking for correct answers beyond types.
     */
    
    // dummy variables for the outputs
    boolean boolResult;
    IContestant contResult;
    
    // Create samples of each contestant, result, and match
    RugbyTeam rugbyTeamCheck = new RugbyTeam("WPI", "maroon", false, 4, 6);
    RoboticsTeam robotsTeamCheck = new RoboticsTeam("WPI","goat cheese", 7);
    RugbyResult rugbyResultCheck = new RugbyResult(10,15);
    RoboticsResult robotsResultCheck = new RoboticsResult(3,5,true,3,2,false);
    Match rugbyMatchCheck = new Match(rugbyTeamCheck, rugbyTeamCheck, rugbyResultCheck);
    Match robotsMatchCheck = new Match(robotsTeamCheck, robotsTeamCheck, robotsResultCheck);
    
    // Try calling all methods
    
    // isValid
    boolResult = ((IResult) rugbyResultCheck).isValid();
    boolResult = ((IResult) robotsResultCheck).isValid();
    
    // winner
    contResult = rugbyMatchCheck.winner(); 
    contResult = robotsMatchCheck.winner();
    
    // expectToBeat
    boolResult = ((IContestant) rugbyTeamCheck).expectToBeat(rugbyTeamCheck);
    boolResult = ((IContestant) robotsTeamCheck).expectToBeat(robotsTeamCheck);
    
    // underdogWon 
    boolResult = rugbyMatchCheck.underdogWon();
    boolResult = robotsMatchCheck.underdogWon();
    
     // Run the Examples class
    Tester.run(E);
  }
}