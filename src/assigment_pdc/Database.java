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
public void dbsetup() {
        try {
            Statement statement = conn.createStatement();
            String tableName = "UserInfo";

            if (!checkTableExisting(tableName)) {
                statement.executeUpdate("CREATE TABLE " + tableName + " (userid VARCHAR(12), password VARCHAR(12), score INT)");
            }
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
