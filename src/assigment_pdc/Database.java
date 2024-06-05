// this going to be our database file 
// first lets connect the database
public class Database {
    
    Connection conn = null;
    String url = "jdbc:derby://localhost:1527/PDC_Project 2";
    String dbusername = "ella";
    String dbpassword = "doris";
    
    
    public Database() {
        try {
            conn = DriverManager.getConnection(url, dbusername, dbpassword);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
